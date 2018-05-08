package net.ufrog.aries.common.exception;

import net.ufrog.aries.common.contract.Response;
import net.ufrog.common.spring.exception.ExceptionHandler;
import net.ufrog.common.spring.exception.ExceptionLogger;
import net.ufrog.common.spring.exception.ExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 3.0.0, 2018-04-13
 * @since 3.0.0
 */
@SuppressWarnings("unused")
public class AriesExceptionHandler implements ExceptionHandler<AriesException> {

    @Override
    public Boolean isType(Exception e) {
        return e.getClass() == AriesException.class;
    }

    @Override
    public ModelAndView handle(AriesException e, String requestType, String errorView, String partViewSuffix, View jsonView, ExceptionLogger exceptionLogger) {
        return ExceptionResolver.modelAndView(
                ExceptionResolver.REQUEST_TYPE_JSON,
                errorView,
                partViewSuffix,
                jsonView,
                ExceptionResolver.KEY_MODEL_EXCEPTION,
                new Response(e.getResultCode())
        );
    }
}
