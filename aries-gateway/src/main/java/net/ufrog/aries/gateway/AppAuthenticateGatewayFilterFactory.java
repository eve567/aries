package net.ufrog.aries.gateway;

import net.ufrog.aries.common.contract.ListResponse;
import net.ufrog.common.Logger;
import net.ufrog.common.cache.Caches;
import net.ufrog.common.exception.ServiceException;
import net.ufrog.common.utils.Cryptos;
import net.ufrog.common.utils.Streams;
import net.ufrog.common.utils.Strings;
import net.ufrog.leo.client.AppClient;
import net.ufrog.leo.client.contracts.AppSecretResponse;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.MultiValueMap;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 2.0.0, 2018-07-04
 * @since 2.0.0
 */
public class AppAuthenticateGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {

    public static final String HEADER_CLIENT_APP_ID     = "X-Client-App-ID";
    public static final String HEADER_CLIENT_TIMESTAMP  = "X-Client-Timestamp";
    public static final String HEADER_CLIENT_ALGORITHM  = "X-Client-Algorithm";
    public static final String HEADER_CLIENT_TOKEN      = "X-Client-Token";
    public static final String HEADER_CLIENT_SIGN       = "X-Client-Sign";
    public static final String HEADER_LEO_USER_ID       = "X-Leo-User-ID";

    private static final String CACHE_APP_SECRET        = "app_secret";

    /** 应用业务客户端 */
    private final AppClient appClient;

    /**
     * 构造函数
     *
     * @param appClient 应用业务客户端
     */
    protected AppAuthenticateGatewayFilterFactory(AppClient appClient) {
        this.appClient = appClient;
    }

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            AriesServerWebExchangeDecorator ariesServerWebExchangeDecorator = new AriesServerWebExchangeDecorator(exchange);
            HttpStatus httpStatus = checkSign(ariesServerWebExchangeDecorator.getRequest());
            if (!HttpStatus.OK.equals(httpStatus)) {
                exchange.getResponse().setStatusCode(httpStatus);
                return exchange.getResponse().setComplete();
            } else {
                return chain.filter(ariesServerWebExchangeDecorator);
            }
        };
    }

    /**
     * 检查签名
     *
     * @param request 请求
     * @return 检查结果
     */
    private HttpStatus checkSign(ServerHttpRequest request) {
        //
        String uri = request.getURI().getPath();
        Map<String, String> mParam = getParams(request.getQueryParams());
        Map<String, String> mHeader = getHeaders(request.getHeaders());
        if (mHeader == null) {
            return HttpStatus.BAD_REQUEST;
        }

        //
        String body = getBody(request.getBody());
        String secret = getAppSecret(mHeader.get(HEADER_CLIENT_APP_ID));
        if (Strings.empty(secret)) {
            return HttpStatus.FORBIDDEN;
        }

        //
        String sign = sign(secret, uri, mHeader, mParam, body);
        if (!Strings.equals(sign, request.getHeaders().getFirst(HEADER_CLIENT_SIGN))) {
            return HttpStatus.UNAUTHORIZED;
        }
        return HttpStatus.OK;
    }

    /**
     * 获取请求参数映射表<br>
     * 请求参数只允许使用单数据的请求，多数据会被直接过滤
     *
     * @param params 请求参数
     * @return 处理后的请求参数映射表
     */
    private Map<String, String> getParams(MultiValueMap<String, String> params) {
        Map<String, String> map = new HashMap<>();
        params.forEach((k, v) -> map.put(k, v.get(0)));
        return map;
    }

    /**
     * 获取应用密钥
     *
     * @param appId 应用编号
     * @return 应用密钥
     */
    private String getAppSecret(String appId) {
        //noinspection unchecked
        Map<String, String> map = Optional.ofNullable(Caches.get(CACHE_APP_SECRET, Map.class)).orElseGet(() -> {
            ListResponse<AppSecretResponse> lrAppSecretResponse = appClient.readSecrets();
            Map<String, String> mAppSecret = new HashMap<>();

            lrAppSecretResponse.getContent().forEach(appSecretResponse -> mAppSecret.put(appSecretResponse.getId(), appSecretResponse.getSecret()));
            Caches.set(CACHE_APP_SECRET, mAppSecret);
            return mAppSecret;
        });
        return map.get(appId);
    }

    /**
     * 读取请求体内容
     *
     * @param fluxBody 请求体
     * @return 请求体
     */
    private String getBody(Flux<DataBuffer> fluxBody) {
        StringBuffer body = Strings.buffer();
        fluxBody.publishOn(Schedulers.immediate()).subscribe(dataBuffer -> {
            body.append(new String(Streams.toByteArray(dataBuffer.asInputStream()), Charset.forName("utf-8")));
            DataBufferUtils.release(dataBuffer);
        });
        return body.toString();
    }

    /**
     * 签名
     *
     * @param secret 密钥
     * @param uri 请求地址
     * @param headers 请求头信息
     * @param params 请求参数
     * @param body 请求体内容
     * @return 签名结果
     */
    private String sign(String secret, String uri, Map<String, String> headers, Map<String, String> params, String body) {
        StringBuilder content = Strings.builder();
        content.append(uri).append(params.isEmpty() ? "" : "?").append(mapToStr(params)).append("\n");
        content.append(mapToStr(headers)).append(Strings.empty(body) ? "" : "\n");
        content.append(body);

        String sign = Cryptos.hmacAndBase64(content.toString(), secret, Cryptos.HMACType.HMAC_SHA1);
        if (Logger.isTraceEnabled()) {
            Logger.trace("\n========== sign content ==========\n%s\n========== sign result ==========\n%s\n========== sign end ==========", content, sign);
        }
        return sign;
    }

    /**
     * 映射表转换字符串
     *
     * @param map 映射表
     * @return 转换后字符串
     */
    private String mapToStr(Map<String, String> map) {
        Map<String, String> treeMap = new TreeMap<>();
        map.forEach(treeMap::put);
        return Strings.join(treeMap, "=", "&", String::toLowerCase, (value) -> {
            try {
                return URLEncoder.encode(value, "utf-8");
            } catch (UnsupportedEncodingException e) {
                throw new ServiceException(e.getMessage(), e);
            }
        });
    }

    /**
     * 获取请求头信息映射表
     *
     * @param httpHeaders 请求头信息
     * @return 请求头信息映射表
     */
    private Map<String, String> getHeaders(HttpHeaders httpHeaders) {
        String appId = httpHeaders.getFirst(HEADER_CLIENT_APP_ID);
        String sign = httpHeaders.getFirst(HEADER_CLIENT_SIGN);
        String timestamp = httpHeaders.getFirst(HEADER_CLIENT_TIMESTAMP);
        String algorithm = httpHeaders.getFirst(HEADER_CLIENT_ALGORITHM);

        if (Logger.isTraceEnabled()) {
            Logger.trace("print all headers");
            httpHeaders.forEach((key, value) -> Logger.trace("header key: %s, value: %s", key, Strings.implode(value, ",")));
        } if (Strings.empty(appId) || Strings.empty(sign) || Strings.empty(timestamp) || Strings.empty(algorithm)) {
            return null;
        } else {
            Map<String, String> map = new HashMap<>();
            map.put(HEADER_CLIENT_APP_ID, appId);
            map.put(HEADER_CLIENT_TIMESTAMP, timestamp);
            map.put(HEADER_CLIENT_ALGORITHM, algorithm);
            return map;
        }
    }
}
