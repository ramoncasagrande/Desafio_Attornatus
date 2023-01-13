package com.ramon.attornatus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramon.attornatus.model.dto.EnderecoDto;
import com.ramon.attornatus.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public EnderecoDto novoEndereco(@RequestBody EnderecoDto enderecoDto){
        return enderecoService.adicionaEndereco(enderecoDto);
    }
    
    @GetMapping
    public List<EnderecoDto> listaEnderecos(){
        List<EnderecoDto> enderecos = enderecoService.ListarEnderecos();
        return enderecos;
    }

    @GetMapping("/{id}")
    public EnderecoDto consultaEndereco(@PathVariable Long id){
        return enderecoService.buscaPorId(id);
    }
}
