package com.ramon.attornatus.model.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ramon.attornatus.model.Pessoa;

import lombok.Data;

@Data
public class PessoaDto {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private List<EnderecoDto> enderecosDto = new ArrayList<>();

    public static PessoaDto converter(Pessoa pessoa){
        PessoaDto pessoaDto = new PessoaDto();
        pessoaDto.setId(pessoa.getId());
        pessoaDto.setNome(pessoa.getNome());
        pessoaDto.setDataNascimento(pessoa.getDataNascimento());
        pessoaDto.setEnderecosDto(pessoa.getEnderecos().stream().map(EnderecoDto::converter).collect(Collectors.toList()));
        return pessoaDto;
    }
    
}
