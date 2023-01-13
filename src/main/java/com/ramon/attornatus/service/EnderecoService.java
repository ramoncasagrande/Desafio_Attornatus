package com.ramon.attornatus.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramon.attornatus.model.Endereco;
import com.ramon.attornatus.model.dto.EnderecoDto;
import com.ramon.attornatus.repositories.EnderecoRepository;

@Service
public class EnderecoService {
    
    @Autowired
    EnderecoRepository enderecoRepository;

    public EnderecoDto adicionaEndereco(EnderecoDto enderecoDto){
        Endereco endereco = enderecoRepository.save(Endereco.converter(enderecoDto));
        return EnderecoDto.converter(endereco);
    }

    public List<EnderecoDto> ListarEnderecos(){
        List<Endereco> enderecos = enderecoRepository.findAll();
        return enderecos
                .stream()
                .map(EnderecoDto::converter)
                .collect(Collectors.toList());
    }

    public EnderecoDto buscaPorId(Long id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        return EnderecoDto.converter(endereco.get()) ;
    }
}