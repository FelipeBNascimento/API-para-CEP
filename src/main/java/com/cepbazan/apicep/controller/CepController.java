package com.cepbazan.apicep.controller;


import com.cepbazan.apicep.bussines.CepService;
import com.cepbazan.apicep.infraesctruture.entity.CepEntity;
import lombok.AllArgsConstructor;
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
    public ResponseEntity<CepEntity> mostrarpeloID(@RequestParam Long id) {


        return ResponseEntity.ok(service.mostrarPeloId(id));
    }

    @PostMapping("/{cep}")

    public ResponseEntity<Void> criarCep(@PathVariable String cep) {

        service.criarEndereco(cep);

        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarCep(@RequestBody CepEntity cep, @RequestParam Long id){

        service.atualizarCep(cep, id);

        return ResponseEntity.ok().build();
    }


}
