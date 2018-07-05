package net.ufrog.aries.gateway;

import net.ufrog.leo.client.AppClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 3.0.0, 2018-05-14
 * @since 3.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class AriesGatewayApplication {

    /**
     * @param args argument array
     */
    public static void main(String[] args) {
        SpringApplication.run(AriesGatewayApplication.class, args);
    }

    @Bean
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public AppAuthenticateGatewayFilterFactory appAuthenticateGatewayFilterFactory(AppClient appClient) {
        return new AppAuthenticateGatewayFilterFactory(appClient);
    }
}
