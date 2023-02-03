package com.zhang.db.config;

import com.zhang.db.converter.IntegerCodeToEnumConverterFactory;
import com.zhang.db.converter.StringCodeToEnumConverterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhangjiwei
 * @Description TODO
 * @Date 2021/8/11 14:46
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(new IntegerCodeToEnumConverterFactory());
        registry.addConverterFactory(new StringCodeToEnumConverterFactory());
    }


//    @Override
//    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.stream().filter(converter->converter instanceof MappingJackson2HttpMessageConverter).forEach(converter->{
//            MappingJackson2HttpMessageConverter jsonConverter = (MappingJackson2HttpMessageConverter)converter;
//            CustomEnumSerializer customEnumSerializer = new CustomEnumSerializer();
//            SimpleModule simpleModule = new SimpleModule();
//            simpleModule.addSerializer(customEnumSerializer);
//            jsonConverter.getObjectMapper().registerModule(simpleModule);
//        });
//
//
//    }
}
