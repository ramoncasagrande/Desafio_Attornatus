package com.ramon.attornatus.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramon.attornatus.model.Pessoa;
import com.ramon.attornatus.repositories.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listarTodas(){
        List<Pessoa> lista = pessoaRepository.findAll();
        return lista
                .stream()
                .collect(Collectors.toList());
    }
}
