package br.com.developer.infrastructure.converter;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import br.com.developer.application.util.DateUtil;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

    protected LocalDateDeserializer() {
        super(LocalDate.class);
    }

    @Override
    public LocalDate deserialize(final JsonParser parser, final DeserializationContext context) throws IOException {

        final String as = parser.readValueAs(String.class);
        System.out.println(as);
        final LocalDate localDate = DateUtil.toLocalDate(as);
        System.out.println(localDate);
        return localDate;
        // return LocalDate.parse(parser.readValueAs(String.class));
    }
}