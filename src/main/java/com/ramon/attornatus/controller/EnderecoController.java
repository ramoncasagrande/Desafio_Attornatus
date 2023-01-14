package com.ramon.attornatus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramon.attornatus.model.dto.EnderecoDto;
import com.ramon.attornatus.service.EnderecoService;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/pessoa/{id}")
    public List<EnderecoDto> listaEnderecosPessoa(@PathVariable Long id){
        List<EnderecoDto> enderecos = enderecoService.ListarEnderecosPessoa(id);
        return enderecos;
    }
}
