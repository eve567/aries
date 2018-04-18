package net.ufrog.aries.sample.consumer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import net.ufrog.aries.sample.client.SampleClient;
import net.ufrog.aries.sample.client.fallbacks.SampleClientFallbackFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-02-22
 * @since 0.1
 */
@SpringBootApplication(scanBasePackageClasses = {AriesSampleConsumerApplication.class, SampleClientFallbackFactory.class})
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses = SampleClient.class)
@EnableHystrix
public class AriesSampleConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AriesSampleConsumerApplication.class, args);
    }

    @Bean
    @SuppressWarnings("Duplicates")
    public HttpMessageConverter jsonConverter() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        List<MediaType> lMediaType = new ArrayList<>();

        lMediaType.add(new MediaType("application", "json"));
        lMediaType.add(new MediaType("text", "javascript"));

        fastJsonConfig.setSerializerFeatures(SerializerFeature.BrowserCompatible, SerializerFeature.DisableCircularReferenceDetect);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(lMediaType);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        return fastJsonHttpMessageConverter;
    }
}
