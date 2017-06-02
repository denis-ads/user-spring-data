package br.com.developer.infrastructure.converter;

import java.time.LocalDate;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * https://gist.github.com/Cepr0/ef0f2d2f1630a24dcbf3bec89a4bcccd
 * @author 2102148048
 *
 */
@Configuration
public class RestConfig extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureConversionService(ConfigurableConversionService conversionService) {
        conversionService.addConverter(String.class, LocalDate.class, LocalDate::parse);
        super.configureConversionService(conversionService);
    }
}