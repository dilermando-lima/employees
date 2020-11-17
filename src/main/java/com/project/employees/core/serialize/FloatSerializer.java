package com.project.employees.core.serialize;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class FloatSerializer extends JsonSerializer<Float> {

    @Override
    public void serialize(Float value, JsonGenerator gen, SerializerProvider serializers) throws IOException, JsonProcessingException {

    	  try {
    			gen.writeString(String.valueOf(value));
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
    }
}