package com.project.employees.core.serialize;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class FloatDeserializer extends JsonDeserializer<Float> {
    @Override
    public Float deserialize(JsonParser arg0, DeserializationContext arg1) throws IOException, JsonProcessingException {
        
        try {
            return  Float.valueOf(arg0.getText());
        } catch (Exception e) {
            return null;
        }
    }

}
