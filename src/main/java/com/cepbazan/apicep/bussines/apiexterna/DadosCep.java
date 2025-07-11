package com.cepbazan.apicep.bussines.apiexterna;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class DadosCep {


    private String rua;
    private String cep;
    private String bairro;
    private String estado;
    private String uf;

    @JsonAlias("logradouro")
    public String getRua() {
        return rua;
    }

    @JsonAlias("cep")
    public String getCep() {
        return cep;
    }

    @JsonAlias("bairro")
    public String getBairro() {
        return bairro;
    }

    @JsonAlias("estado")
    public String getEstado() {
        return estado;
    }

    @JsonAlias("uf")
    public String getUf() {
        return uf;
    }

    @Override
    public String toString() {
        return "DadosCep{" +
                "rua='" + rua + '\'' +
                ", cep='" + cep + '\'' +
                ", bairro='" + bairro + '\'' +
                ", estado='" + estado + '\'' +
                ", uf='" + uf + '\'' +
                '}';
    }
}
