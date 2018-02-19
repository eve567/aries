package net.ufrog.aries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-02-18
 * @since 0.1
 */
@SpringBootApplication
@EnableEurekaServer
public class AriesServerApplication {

    /**
     * @param args argument array
     */
    public static void main(String[] args) {
        SpringApplication.run(AriesServerApplication.class, args);
    }
}
