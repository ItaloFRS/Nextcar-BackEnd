package com.loja.carros.service;

import com.loja.carros.model.Carro;
import com.loja.carros.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarroService {

    @Autowired
    CarroRepository repository;

    public List<Carro> listarTodos() { return repository.findAll(); }

    public Carro buscarPorId(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Carro não encontrado"));
    }

    public Carro salvar(Carro carro) { return repository.save(carro); }

    public Carro atualizar(String id, Carro dados) {
        Carro carro = buscarPorId(id);

        carro.setMarca(dados.getMarca());
        carro.setModelo(dados.getModelo());
        carro.setVersao(dados.getVersao());
        carro.setAno(dados.getAno());
        carro.setKm(dados.getKm());
        carro.setPreco(dados.getPreco());
        carro.setNomeVendedor(dados.getNomeVendedor());
        carro.setTelefoneContato(dados.getTelefoneContato());
        carro.setEmailContato(dados.getEmailContato());

        // Só atualiza foto se vier uma nova
        if (dados.getFotoBase64() != null && !dados.getFotoBase64().isEmpty()) {
            carro.setFotoBase64(dados.getFotoBase64());
        }
        return repository.save(carro);
    }

    public void deletar(String id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}