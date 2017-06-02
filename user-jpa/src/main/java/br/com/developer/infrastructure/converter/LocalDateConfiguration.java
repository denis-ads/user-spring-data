package br.com.developer.infrastructure.converter;

import java.time.LocalDate;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;

@Configuration
public class LocalDateConfiguration {

    // @Resource(name = "defaultConversionService")
    private GenericConversionService conversionService;

    @PostConstruct
    public void init() {
        conversionService = (GenericConversionService) DefaultConversionService.getSharedInstance();
        conversionService.addConverter(String.class, LocalDate.class, new StringToLocalDateConverter());
    }

    // @Bean
    // public StringToLocalDateConverter stringToLocalDateConverter() {
    // final StringToLocalDateConverter string2MongoUserConverter = new
    // StringToLocalDateConverter();
    // conversionService.addConverter(string2MongoUserConverter);
    // return string2MongoUserConverter;
    // }
}
