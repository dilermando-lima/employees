package com.project.employees;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.commons.lang3.StringUtils;

abstract class TestAux extends ConstAux{

    protected Map<String, Object> mapValues;
    public Gson gson;


		protected void setUp() {
            gson = new GsonBuilder().setPrettyPrinting().create();
			mapValues = new HashMap<String, Object>();
        }


        protected <T> T  getValue(String attr, Class<T> c){
            return c.cast(mapValues.get(attr));
        }

        protected String buildBodyJson(String... valueName){
            HashMap<String,Object> mapReturn = new HashMap<>();
             for (String name : valueName) {
                if( mapValues.containsKey(name) )
                    mapReturn.put(name, mapValues.get(name)  );
             }
             return gson.toJson(mapReturn);
        }

        protected String getValueLocalDateAsString(String attr, String format){
            return DateTimeFormatter.ofPattern(format).format( (LocalDate) mapValues.get(attr));
        }

        protected String  getValueAsString(String attr){
            return String.valueOf(mapValues.get(attr));
        }

        protected void setValue(String attr, Object value){
             mapValues.put(attr, value);
        }

        protected String generateEmail(String domain){
            if( domain == null ) domain = "email.com";
            return StringUtils.left(generateName(),10) + "@" + domain;
        }

        protected String generateEmail(){
            return generateEmail(null);
        }

        protected LocalDate generateLocaldate(long dateStart, long dateEnd){
            return Instant.ofEpochMilli( generatedLong(dateStart,	dateEnd) ).atZone(ZoneId.of("America/Sao_Paulo")).toLocalDate();
        }

        protected String generateLocaldateAsString(long dateStart, long dateEnd, String format){
           
            return DateTimeFormatter.ofPattern(format).format(generateLocaldate(dateStart,dateEnd));
        }

 
        protected String generateName(){
           return UUID.randomUUID().toString().replace("-", "");
        }

        protected double generatedDouble(int min, int max){
            return (Math.random() * (max - min + 1) + min); 
        }

        protected float generatedFloat(int min, int max){
            return (float)(Math.random() * (max - min + 1) + min); 
        }

        protected int generatedInt(int min, int max){
            return(int)(Math.random() * (max - min + 1) + min); 
        }
        protected long generatedLong(long min, long max){
            return(long)(Math.random() * (max - min + 1) + min); 
        }
        

}
