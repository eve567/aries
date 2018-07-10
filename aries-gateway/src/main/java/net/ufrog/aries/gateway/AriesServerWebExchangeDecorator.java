package net.ufrog.aries.gateway;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebExchangeDecorator;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 2.0.0, 2018-07-05
 * @since 2.0.0
 */
public class AriesServerWebExchangeDecorator extends ServerWebExchangeDecorator {

    private final ServerHttpRequestDecorator serverHttpRequestDecorator;

    /**
     * @param delegate delegate
     */
    AriesServerWebExchangeDecorator(ServerWebExchange delegate) {
        super(delegate);
        this.serverHttpRequestDecorator = new AriesServerHttpRequestDecorator(delegate.getRequest());
    }

    @Override
    public ServerHttpRequest getRequest() {
        return serverHttpRequestDecorator;
    }
}
