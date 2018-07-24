package net.ufrog.aries.gateway;

import io.netty.buffer.UnpooledByteBufAllocator;
import net.ufrog.common.Logger;
import net.ufrog.common.utils.Streams;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.NettyDataBufferFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.nio.charset.Charset;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 2.0.0, 2018-07-04
 * @since 2.0.0
 */
public class AriesServerHttpRequestDecorator extends ServerHttpRequestDecorator {

    /** 是否为首次调用 */
    private Boolean isFirst = Boolean.TRUE;

    /** 二进制数据流 */
    private byte[] bytes;

    /**
     * 构造函数
     *
     * @param delegate delegate
     */
    public AriesServerHttpRequestDecorator(ServerHttpRequest delegate) {
        super(delegate);
    }

    @Override
    public Flux<DataBuffer> getBody() {
        if (isFirst) {
            isFirst = Boolean.FALSE;
            return super.getBody().publishOn(Schedulers.immediate()).map(this::cache);
        } else {
            return Flux.just(getDataBuffer());
        }
    }

    /**
     * @param dataBuffer 数据流
     * @return 缓存之后的数据流
     */
    private DataBuffer cache(DataBuffer dataBuffer) {
        bytes = Streams.toByteArray(dataBuffer.asInputStream());
        if (Logger.isTraceEnabled()) Logger.trace("cache body: %s", new String(bytes, Charset.forName("utf-8")));
        DataBufferUtils.release(dataBuffer);
        return getDataBuffer();
    }

    /**
     * @return 缓存并重新封装的数据流
     */
    private DataBuffer getDataBuffer() {
        NettyDataBufferFactory nettyDataBufferFactory = new NettyDataBufferFactory(new UnpooledByteBufAllocator(false));
        return nettyDataBufferFactory.wrap((bytes == null) ? new byte[0] : bytes);
    }
}
