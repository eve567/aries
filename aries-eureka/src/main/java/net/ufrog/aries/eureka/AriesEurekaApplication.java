package net.ufrog.aries.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-02-19
 * @since 0.1
 */
@SpringBootApplication
@EnableEurekaServer
public class AriesEurekaApplication {

    /**
     * @param args argument array
     */
    public static void main(String[] args) {
        SpringApplication.run(AriesEurekaApplication.class, args);
    }
}
