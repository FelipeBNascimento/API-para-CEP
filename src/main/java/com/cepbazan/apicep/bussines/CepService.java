package com.cepbazan.apicep.bussines;


import com.cepbazan.apicep.bussines.apiexterna.ConsumirApi;
import com.cepbazan.apicep.bussines.apiexterna.ConverterDados;
import com.cepbazan.apicep.bussines.apiexterna.DadosCep;
import com.cepbazan.apicep.infraesctruture.entity.CepEntity;
import com.cepbazan.apicep.infraesctruture.repository.CepRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CepService {

    private final CepRepositorio repositorio;
    private final ConsumirApi consumir;
    private final ConverterDados converte;


    public void apagarPeloId(Long id) {

        repositorio.deleteById(id);
    }


    public CepEntity criarEndereco(String cep) {

        String url_base = "https://viacep.com.br/ws/" + cep + "/json/";

        String consumido = consumir.obterDados(url_base);
        DadosCep dadosCep = converte.ObterDados(consumido, DadosCep.class);

        CepEntity novoCep = CepEntity.builder()

                .rua(dadosCep.getRua())
                .cep(dadosCep.getCep())
                .bairro(dadosCep.getBairro())
                .estado(dadosCep.getEstado())
                .uf(dadosCep.getUf())
                .build();

        return repositorio.saveAndFlush(novoCep);
    }

    public CepEntity mostrarPeloId(Long id) {

        return repositorio.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado"))
                ;
    }

    public CepEntity atualizarCep(CepEntity cep, Long id) {

        CepEntity cepNoBanco = mostrarPeloId(id);

        CepEntity cepAtualizado = CepEntity.builder()

                .rua(cep.getRua() != null ? cep.getRua() : cepNoBanco.getRua())
                .cep(cep.getCep() != null ? cep.getCep() : cepNoBanco.getCep())
                .bairro((cep.getBairro() != null ? cep.getBairro() : cepNoBanco.getBairro()))
                .estado(cep.getEstado() != null ? cep.getEstado() : cepNoBanco.getEstado())
                .uf(cep.getUf() != null ? cep.getUf() : cepNoBanco.getUf())
                .id(cepNoBanco.getId())

                .build();

        return repositorio.saveAndFlush(cepAtualizado);


    }

}
