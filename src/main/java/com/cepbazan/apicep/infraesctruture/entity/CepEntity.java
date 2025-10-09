package com.cepbazan.apicep.infraesctruture.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "Endereços")
public class CepEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "rua")
    private String rua;

    @Column(name = "cep", length = 9)
    private String cep;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "estado")
    private String estado;

    @Column(name="uf", length = 2)
    private String uf;
}
