package br.com.developer.infrastructure.converter;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;

import br.com.developer.application.util.DateUtil;

public class DataConverter {

    @ReadingConverter
    public enum StringToDateConverter implements Converter<String, Date> {
        INSTANCE;

        @Override
        public Date convert(final String source) {
            if (source == null) {
                return null;
            }
            return DateUtil.toDate(source);// new
                                           // LocalDate(source.getTime());
        }

    }

    @WritingConverter
    public enum DateToStringConverter implements Converter<Date, String> {
        INSTANCE;

        @Override
        public String convert(final Date source) {
            if (source == null) {
                return null;
            }
            // final DateTimeFormatter formatter =
            // DateTimeFormatter.ofPattern("dd/MM/yyyy");
            // final String formattedString = source.format(formatter);
            // return formattedString;

            final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
            return sdf.format(source);
        }

    }

}
