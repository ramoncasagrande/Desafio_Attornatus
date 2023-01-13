package com.ramon.attornatus.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ramon.attornatus.model.Endereco;
import com.ramon.attornatus.model.Pessoa;

import lombok.Data;

@Data
public class PessoaDto {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private List<Endereco> enderecos = new ArrayList<>();

    public static PessoaDto converter(Pessoa pessoa){
        PessoaDto pessoaDto = new PessoaDto();
        pessoaDto.setId(pessoa.getId());
        pessoaDto.setNome(pessoa.getNome());
        pessoaDto.setDataNascimento(pessoa.getDataNascimento());
        pessoaDto.setEnderecos(pessoa.getEnderecos());
        return pessoaDto;
    }
    
}
