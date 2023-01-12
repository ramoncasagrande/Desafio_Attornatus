package com.ramon.attornatus.service;

import java.util.List;
import java.util.Optional;
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

    public Pessoa criar(Pessoa pessoa){
        Pessoa novaPessoa = pessoaRepository.save(pessoa);
        return novaPessoa;
    }

    public Pessoa buscaPorId(Long id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.get();
    }

    public Pessoa editar(Pessoa novaPessoa, Long id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()){
            pessoa.get().setNome(novaPessoa.getNome());
            pessoa.get().setDataNascimento(novaPessoa.getDataNascimento());
            pessoa.get().setEndereco(novaPessoa.getEndereco());
            return pessoa.get();
        }
        return null;
    }

}
