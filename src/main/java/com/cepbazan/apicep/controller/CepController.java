package com.cepbazan.apicep.controller;


import com.cepbazan.apicep.bussines.CepDTO;
import com.cepbazan.apicep.bussines.CepService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity<CepDTO> mostrarpeloID(@RequestParam Long id) {


        return ResponseEntity.ok(service.mostrarPeloId(id));
    }

    @PostMapping("/{cep}")

    public ResponseEntity<CepDTO> criarCep(@PathVariable String cep) {

        CepDTO cepDto = service.criarEndereco(cep);

        return ResponseEntity.status(HttpStatus.CREATED).body(cepDto);
    }

    @PutMapping
    public ResponseEntity<CepDTO> atualizarCep(@RequestBody CepDTO cep, @RequestParam Long id){

        CepDTO cepDTO = service.atualizarCep(cep, id);

        return ResponseEntity.ok(cepDTO);
    }


}
