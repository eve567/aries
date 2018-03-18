package net.ufrog.aries.hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-03-13
 * @since 0.1
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableDiscoveryClient
public class AriesHystrixDashboardApplication {

    /**
     * @param args arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(AriesHystrixDashboardApplication.class, args);
    }
}
