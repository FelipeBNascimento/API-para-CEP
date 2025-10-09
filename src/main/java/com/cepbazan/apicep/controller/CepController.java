package com.cepbazan.apicep.controller;


import com.cepbazan.apicep.bussines.CepRequestDTO;
import com.cepbazan.apicep.bussines.CepResponseDto;
import com.cepbazan.apicep.bussines.CepService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/cep")
public class CepController {

    private final CepService service;

    @DeleteMapping
    public ResponseEntity<Void> deletarPeloId(@RequestParam Long id) {

        service.apagarPeloId(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<CepResponseDto> mostrarpeloID(@RequestParam Long id) {


        return ResponseEntity.ok(service.mostrarPeloId(id));
    }

    @PostMapping()

    public ResponseEntity<CepResponseDto> criarCep(@RequestParam String cep) {

        CepResponseDto cepResponseDto = service.criarEndereco(cep);

        return ResponseEntity.status(HttpStatus.CREATED).body(cepResponseDto);
    }

    @PutMapping
    public ResponseEntity<CepResponseDto> atualizarCep(@RequestBody CepRequestDTO cep,
                                                       @RequestParam Long id){

        CepResponseDto cepDTO = service.atualizarCep(cep, id);

        return ResponseEntity.ok(cepDTO);
    }


}
