package com.cepbazan.apicep.bussines.converter;

import com.cepbazan.apicep.bussines.CepRequestDTO;
import com.cepbazan.apicep.bussines.CepResponseDto;
import com.cepbazan.apicep.infraesctruture.entity.CepEntity;
import org.springframework.stereotype.Component;

@Component
public class CepConverter {

    public CepEntity paraCepEntity(CepRequestDTO cepDTO) {

        return CepEntity.builder()

                .rua(cepDTO.getRua())
                .cep(cepDTO.getCep())
                .bairro(cepDTO.getBairro())
                .estado(cepDTO.getEstado())
                .uf(cepDTO.getUf())
                .build();

    }

    public CepRequestDTO paraCepRequestDTO(CepEntity cep) {

        return CepRequestDTO.builder()

                .rua(cep.getRua())
                .cep(cep.getCep())
                .bairro(cep.getBairro())
                .estado(cep.getEstado())
                .uf(cep.getUf())
                .build();


    }

    public CepResponseDto paraCepREsponseDto(CepEntity cepEntity) {

        return CepResponseDto.builder()

                .id(cepEntity.getId())
                .rua(cepEntity.getRua())
                .cep(cepEntity.getCep())
                .bairro(cepEntity.getBairro())
                .estado(cepEntity.getEstado())
                .uf(cepEntity.getUf())
                .build();


    }

    public CepEntity AtualizarCep(CepEntity cepEntity, CepRequestDTO cepRequestDTO) {

        return CepEntity.builder()

                .id(cepEntity.getId())
                .rua(cepRequestDTO.getRua() != null ? cepRequestDTO.getRua() : cepEntity.getRua())
                .cep(cepRequestDTO.getCep() != null ? cepRequestDTO.getCep() : cepEntity.getCep())
                .bairro(cepRequestDTO.getBairro() != null ? cepRequestDTO.getBairro() : cepEntity.getBairro())
                .estado(cepRequestDTO.getEstado() != null ? cepRequestDTO.getEstado() : cepEntity.getEstado())
                .uf(cepRequestDTO.getUf() != null ? cepRequestDTO.getUf() : cepEntity.getUf())
                .build();
    }
}
