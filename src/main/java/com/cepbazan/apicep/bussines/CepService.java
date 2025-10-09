package com.cepbazan.apicep.bussines;


import com.cepbazan.apicep.bussines.apiexterna.ConsumirApi;
import com.cepbazan.apicep.bussines.apiexterna.ConverterDados;
import com.cepbazan.apicep.bussines.apiexterna.DadosCep;
import com.cepbazan.apicep.bussines.converter.CepConverter;
import com.cepbazan.apicep.infraesctruture.entity.CepEntity;
import com.cepbazan.apicep.infraesctruture.exception.IdNaoEncontrado;
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


    public CepResponseDto criarEndereco(String cep) {

        String url_base = "https://viacep.com.br/ws/" + cep + "/json/";

        String consumido = consumir.obterDados(url_base);
        DadosCep dadosCep = converte.ObterDados(consumido, DadosCep.class);

        CepRequestDTO novoCep = CepRequestDTO.builder()

                .rua(dadosCep.getRua())
                .cep(dadosCep.getCep())
                .bairro(dadosCep.getBairro())
                .estado(dadosCep.getEstado())
                .uf(dadosCep.getUf())
                .build();

        CepEntity cepEntity = cepConverter.paraCepEntity(novoCep);
        CepEntity cepSalvo = repositorio.save(cepEntity);
        return cepConverter.paraCepREsponseDto(cepSalvo);
    }

    public CepResponseDto mostrarPeloId(Long id) {


        CepEntity cep =  repositorio.findById(id).orElseThrow(
                () -> new IdNaoEncontrado("Id não encontrado")
        );

       CepResponseDto cepDto = cepConverter.paraCepREsponseDto(cep);

       return cepDto;
    }



    public CepResponseDto atualizarCep(CepRequestDTO cep, Long id) {

        CepEntity cepNoBanco = repositorio.findById(id).orElseThrow(
                () -> new RuntimeException("Id não encontrado")
        );

        CepEntity cepAtualizado =  cepConverter.AtualizarCep(cepNoBanco, cep);

        CepEntity cepSalvo =  repositorio.saveAndFlush(cepAtualizado);

        return cepConverter.paraCepREsponseDto(cepSalvo);

    }

}
