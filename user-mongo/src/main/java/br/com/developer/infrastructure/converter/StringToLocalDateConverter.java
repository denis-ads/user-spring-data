package br.com.developer.infrastructure.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

//@UsesJava8
//@Component
public class StringToLocalDateConverter implements Converter<String, LocalDate> {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public StringToLocalDateConverter() {
        super();
        // TODO Auto-generated constructor stub
    }

    public StringToLocalDateConverter(final String dateFormat) {
        this.formatter = DateTimeFormatter.ofPattern(dateFormat);
    }

    @Override
    public LocalDate convert(final String source) {
        return LocalDate.parse(source, formatter);
        // return DateUtil.toLocalDate(source);
    }

}
