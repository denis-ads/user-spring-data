package br.com.developer.infrastructure.converter;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.UsesJava8;

import br.com.developer.application.util.DateUtil;

@UsesJava8
public final class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(final String source) {
        return DateUtil.toDate(source);
    }

}
