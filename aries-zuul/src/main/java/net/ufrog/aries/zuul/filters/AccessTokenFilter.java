package net.ufrog.aries.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 3.0.0, 2018-04-25
 * @since 3.0.0
 */
public class AccessTokenFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccessTokenFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        Enumeration<String> eName = httpServletRequest.getHeaderNames();

        while (eName.hasMoreElements()) {
            String name = eName.nextElement();
            LOGGER.info("{}: {}", name, httpServletRequest.getHeader(name));
        }
        return true;
    }
}
