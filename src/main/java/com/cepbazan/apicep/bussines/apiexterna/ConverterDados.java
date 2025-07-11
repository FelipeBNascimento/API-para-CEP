package com.cepbazan.apicep.bussines.apiexterna;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ConverterDados implements IConverterDados{


    private ObjectMapper mapear = new ObjectMapper();


    @Override
    public <T> T ObterDados(String json, Class<T> classeDosDados) {
        try {
            return mapear.readValue(json, classeDosDados);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
