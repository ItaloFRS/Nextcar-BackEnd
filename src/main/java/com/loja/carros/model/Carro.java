package com.loja.carros.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "carros")
@Data
public class Carro {
    @Id
    //Informações do carro
    private String id;
    private String marca;
    private String modelo;
    private String versao;
    private Integer km;
    private Integer ano;
    private Double preco;

    //Informações do vendedor
    private String nomeVendedor;
    private String emailContato;
    private String telefoneContato;

    private List<String> fotoBase64;
}