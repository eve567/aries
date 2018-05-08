package net.ufrog.aries.sample.client;

import net.ufrog.aries.sample.client.fallbackfactories.SampleClientFallbackFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 3.0.0, 2018-05-07
 * @since 3.0.0
 */
@EnableFeignClients(basePackageClasses = SampleClient.class)
@ComponentScan(basePackageClasses = SampleClientFallbackFactory.class)
@ConditionalOnMissingClass("net.ufrog.aries.sample.provider.SampleController")
public class AriesSampleClientConfiguration {
}
