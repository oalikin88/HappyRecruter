package ru.ibs.trainee.happyrecruter.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateDeseriallizer extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.mm.yyyy");

        LocalDate localDate = null;
        localDate = LocalDate.parse(p.getText(), formatter);

        return localDate;
    }
}
