package com.ramon.attornatus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ramon.attornatus.model.Pessoa;
import com.ramon.attornatus.service.PessoaService;

@RestController
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    
    @GetMapping("/pessoas")
    public List<Pessoa> listaPessoas(){
        List<Pessoa> pessoas = pessoaService.listarTodas();
        return pessoas;
    }

    @PostMapping("/pessoas")
    public Pessoa novaPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.criar(pessoa);
    }
}
