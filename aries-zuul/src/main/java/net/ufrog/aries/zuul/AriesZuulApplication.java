package net.ufrog.aries.zuul;

import net.ufrog.aries.zuul.filters.AccessTokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 3.0.0, 2018-04-25
 * @since 3.0.0
 */
@SpringCloudApplication
@EnableZuulProxy
public class AriesZuulApplication {

    /**
     * @param args argument array
     */
    public static void main(String[] args) {
        SpringApplication.run(AriesZuulApplication.class, args);
    }

    @Bean
    public AccessTokenFilter accessTokenFilter() {
        return new AccessTokenFilter();
    }
}
