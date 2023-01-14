package com.ramon.attornatus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ramon.attornatus.model.Pessoa;
import com.ramon.attornatus.model.dto.EnderecoDto;
import com.ramon.attornatus.model.dto.PessoaDto;
import com.ramon.attornatus.service.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    
    @PostMapping
    public PessoaDto novaPessoa(@RequestBody PessoaDto pessoaDto){
        return pessoaService.criarPessoa(pessoaDto);
    }

    @PutMapping("/{id}")
    public PessoaDto editaPessoa(@PathVariable Long id, @RequestBody PessoaDto pessoaDto){
        Pessoa pessoa = pessoaService.editarPessoa(id, Pessoa.converter(pessoaDto));
        return PessoaDto.converter(pessoa);
    }

    @GetMapping("/{id}")
    public PessoaDto consultaPessoa(@PathVariable Long id){
        return pessoaService.buscaPorId(id);
    }

    @GetMapping
    public List<PessoaDto> listaPessoas(){
        List<PessoaDto> pessoas = pessoaService.listarPessoas();
        return pessoas;
    }

    @PostMapping("/{pessoaId}/endereco")
    public PessoaDto criaEnderecoParaPessoa(@PathVariable Long pessoaId, @RequestBody EnderecoDto enderecoDto){
        Pessoa pessoa = pessoaService.AdicionaEnderecoAPessoa(pessoaId, enderecoDto);
        return PessoaDto.converter(pessoa);
    }
}
