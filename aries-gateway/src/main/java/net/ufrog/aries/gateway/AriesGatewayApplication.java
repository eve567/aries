package net.ufrog.aries.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 3.0.0, 2018-05-14
 * @since 3.0.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AriesGatewayApplication {

    /**
     * @param args argument array
     */
    public static void main(String[] args) {
        SpringApplication.run(AriesGatewayApplication.class, args);
    }
}
