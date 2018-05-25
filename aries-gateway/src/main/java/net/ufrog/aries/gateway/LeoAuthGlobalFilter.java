package net.ufrog.aries.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 1.0.0, 2018-05-24
 * @since 1.0.0
 */
public class LeoAuthGlobalFilter implements GlobalFilter, Ordered {

    private static String X_LEO_APP_ID  = "X-LEO-App-Id";
    private static String X_LEO_TOKEN   = "X-LEO-Token";
    private static String X_LEO_USER_ID = "X-LEO-User-Id";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        HttpHeaders httpHeaders = exchange.getRequest().getHeaders();
        httpHeaders.entrySet().forEach(entry -> {
            System.out.println("============ key: " + entry);
            entry.getValue().forEach(System.out::println);
        });
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
