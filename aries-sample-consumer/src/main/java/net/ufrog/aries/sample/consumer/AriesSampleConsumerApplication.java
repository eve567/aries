package net.ufrog.aries.sample.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-02-22
 * @since 0.1
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class AriesSampleConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AriesSampleConsumerApplication.class, args);
    }
}
