package net.ufrog.aries.sample.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-02-22
 * @since 0.1
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AriesSampleProviderApplication {

    /**
     * @param args argument array
     */
    public static void main(String[] args) {
        SpringApplication.run(AriesSampleProviderApplication.class, args);
    }
}
