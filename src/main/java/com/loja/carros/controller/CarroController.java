package com.loja.carros.controller;

import com.loja.carros.model.Carro;
import com.loja.carros.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("carros")
public class CarroController {

    @Autowired CarroService service;

    @GetMapping
    public ResponseEntity<List<Carro>> getAllCarros(){
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> getById(@PathVariable String id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Carro> saveCarro(@RequestBody Carro carro){
        return ResponseEntity.ok(service.salvar(carro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> updateCarro(@PathVariable String id, @RequestBody Carro carro){
        return ResponseEntity.ok(service.atualizar(id, carro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarro(@PathVariable String id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}