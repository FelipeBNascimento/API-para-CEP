package com.cepbazan.apicep.bussines;

import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CepDTO {


    private String rua;
    private String cep;
    private String bairro;
    private String estado;
    private String uf;
}
