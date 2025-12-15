package com.loja.carros.repository;

import com.loja.carros.model.Carro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarroRepository extends MongoRepository<Carro, String> {
}