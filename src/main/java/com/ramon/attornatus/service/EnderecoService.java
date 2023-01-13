package com.ramon.attornatus.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramon.attornatus.model.Endereco;
import com.ramon.attornatus.repositories.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    EnderecoRepository enderecoRepository;

    public Endereco adicionaEndereco(Endereco endereco){
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> ListarEnderecos(){
        List<Endereco> lista = enderecoRepository.findAll();
        return lista
                .stream()
                .collect(Collectors.toList());
    }

    public Endereco buscaPorId(Long id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        return endereco.get();
    }
}