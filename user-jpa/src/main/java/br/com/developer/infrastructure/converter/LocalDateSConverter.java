package br.com.developer.infrastructure.converter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

import br.com.developer.application.util.DateUtil;

@Component
public class LocalDateSConverter {

    /**
     * Reading {@link Converter} parses {@link Date} from
     * {@link org.apache.solr.common.SolrDocument} to {@link LocalDateTime}
     *
     * @author Christoph Strobl
     *
     */
    @ReadingConverter
    public enum StringToLocalDateConverter implements Converter<String, LocalDate> {
        INSTANCE;

        @Override
        public LocalDate convert(final String source) {
            if (source == null) {
                return null;
            }
            return DateUtil.toLocalDate(source);// new
            // LocalDate(source.getTime());
        }

    }

    /**
     * Writing {@link Converter} converts {@link LocalDateTime} to {@link Date}
     * so it can be used within {@link org.apache.solr.common.SolrInputDocument}
     *
     * @author Christoph Strobl
     *
     */
    @WritingConverter
    public enum LocalDateToStringConverter implements Converter<LocalDate, String> {
        INSTANCE;

        @Override
        public String convert(final LocalDate source) {
            if (source == null) {
                return null;
            }
            final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR"));
            final String formattedString = source.format(formatter);
            return formattedString;

        }

    }

}
