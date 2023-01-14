package com.ramon.attornatus.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramon.attornatus.exception.PessoaNaoEncontradaException;
import com.ramon.attornatus.model.Endereco;
import com.ramon.attornatus.model.Pessoa;
import com.ramon.attornatus.model.dto.EnderecoDto;
import com.ramon.attornatus.repositories.EnderecoRepository;
import com.ramon.attornatus.repositories.PessoaRepository;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    public List<EnderecoDto> ListarEnderecosPessoa(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            List<Endereco> enderecos = pessoa.get().getEnderecos();
            return enderecos
                    .stream()
                    .map(EnderecoDto::converter)
                    .collect(Collectors.toList());
        }
        throw new PessoaNaoEncontradaException(id);
    }
}