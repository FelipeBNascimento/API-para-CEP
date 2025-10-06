package com.cepbazan.apicep.bussines.converter;

import com.cepbazan.apicep.bussines.CepDTO;
import com.cepbazan.apicep.infraesctruture.entity.CepEntity;
import org.springframework.stereotype.Component;

@Component
public class CepConverter {

    public CepEntity paraCepEntity(CepDTO cepDTO){

        CepEntity cep = CepEntity.builder()

                .rua(cepDTO.getRua())
                .cep(cepDTO.getCep())
                .bairro(cepDTO.getBairro())
                .estado(cepDTO.getEstado())
                .uf(cepDTO.getUf())
                .build();

        return cep;
    }

    public CepDTO paraCepDTO(CepEntity cep){

        CepDTO cepDTO = CepDTO.builder()

                .rua(cep.getRua())
                .cep(cep.getCep())
                .bairro(cep.getBairro())
                .estado(cep.getEstado())
                .uf(cep.getUf())
                .build();

        return cepDTO;
    }
}
