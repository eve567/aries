package net.ufrog.aries.common.contract;

import feign.hystrix.FallbackFactory;
import net.ufrog.common.Logger;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 3.0.0, 2018-04-20
 * @since 3.0.0
 */
public abstract class ClientFallbackFactory<T> implements FallbackFactory<T> {

    /** 端错误回调实例 */
    private T clientFallback;

    /** 是否第一次调用<br>第一次调用为框架底层测试调用，不做任何处理 */
    private Boolean isFirst = Boolean.TRUE;

    /**
     * 获取客户端错误回调实例
     *
     * @return 客户端错误回调实例
     */
    public abstract T getClientFallback();

    @Override
    public T create(Throwable throwable) {
        if (clientFallback == null) {
            clientFallback = getClientFallback();
        } if (isFirst) {
            Logger.info("it's the first time call [%s] fallback.", clientFallback.getClass().getName());
            isFirst = Boolean.FALSE;
        } else {
            Logger.error(throwable.getMessage(), throwable);
        }
        return clientFallback;
    }
}
