package com.cepbazan.apicep.bussines;


import com.cepbazan.apicep.bussines.apiexterna.ConsumirApi;
import com.cepbazan.apicep.bussines.apiexterna.ConverterDados;
import com.cepbazan.apicep.bussines.apiexterna.DadosCep;
import com.cepbazan.apicep.bussines.converter.CepConverter;
import com.cepbazan.apicep.infraesctruture.entity.CepEntity;
import com.cepbazan.apicep.infraesctruture.repository.CepRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CepService {

    private final CepRepositorio repositorio;
    private final ConsumirApi consumir;
    private final ConverterDados converte;
    private final CepConverter cepConverter;


    public void apagarPeloId(Long id) {

        repositorio.deleteById(id);
    }


    public CepDTO criarEndereco(String cep) {

        String url_base = "https://viacep.com.br/ws/" + cep + "/json/";

        String consumido = consumir.obterDados(url_base);
        DadosCep dadosCep = converte.ObterDados(consumido, DadosCep.class);

        CepDTO novoCep = CepDTO.builder()

                .rua(dadosCep.getRua())
                .cep(dadosCep.getCep())
                .bairro(dadosCep.getBairro())
                .estado(dadosCep.getEstado())
                .uf(dadosCep.getUf())
                .build();

        CepEntity cepEntity = cepConverter.paraCepEntity(novoCep);
        CepEntity cepSalvo = repositorio.save(cepEntity);
        return cepConverter.paraCepDTO(cepEntity);
    }

    public CepDTO mostrarPeloId(Long id) {


        CepEntity cep =  repositorio.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado")
        );

       CepDTO cepDto = cepConverter.paraCepDTO(cep);

       return cepDto;
    }



    public CepDTO atualizarCep(CepDTO cep, Long id) {

        CepEntity cepNoBanco = repositorio.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado")
        );

        CepEntity cepAtualizado = CepEntity.builder()

                .rua(cep.getRua() != null ? cep.getRua() : cepNoBanco.getRua())
                .cep(cep.getCep() != null ? cep.getCep() : cepNoBanco.getCep())
                .bairro((cep.getBairro() != null ? cep.getBairro() : cepNoBanco.getBairro()))
                .estado(cep.getEstado() != null ? cep.getEstado() : cepNoBanco.getEstado())
                .uf(cep.getUf() != null ? cep.getUf() : cepNoBanco.getUf())
                .id(cepNoBanco.getId())
                .build();

        CepEntity cepSalvo =  repositorio.saveAndFlush(cepAtualizado);

        CepDTO cepDto = cepConverter.paraCepDTO(cepSalvo);

        return cepDto;

    }

}
