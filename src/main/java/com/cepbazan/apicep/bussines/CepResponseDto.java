package com.cepbazan.apicep.bussines;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CepResponseDto {

    private Long id;
    private String rua;
    private String cep;
    private String bairro;
    private String estado;
    private String uf;
}
