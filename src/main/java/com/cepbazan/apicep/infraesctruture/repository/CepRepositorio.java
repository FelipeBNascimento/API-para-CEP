package com.cepbazan.apicep.infraesctruture.repository;

import com.cepbazan.apicep.bussines.apiexterna.DadosCep;
import com.cepbazan.apicep.infraesctruture.entity.CepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CepRepositorio extends JpaRepository<CepEntity, Long> {



}
