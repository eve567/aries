package net.ufrog.aries.sample.provider;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-03-15
 * @since 0.1
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket customDocket() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("net.ufrog.aries.client")).build();
    }

    @Bean
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
