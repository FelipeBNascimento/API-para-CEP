package com.cepbazan.apicep.bussines.apiexterna;


public interface IConverterDados {

    <T> T ObterDados(String json, Class<T> classeDosDados);


}
