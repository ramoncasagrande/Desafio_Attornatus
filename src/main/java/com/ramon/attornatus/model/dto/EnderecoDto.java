package com.ramon.attornatus.model.dto;

import com.ramon.attornatus.model.Endereco;

import lombok.Data;

@Data
public class EnderecoDto {
    
    private Long id;
    private String logradouro;
    private String cep;
    private Integer numero;
    private String cidade;


public static EnderecoDto converter(Endereco endereco){
    EnderecoDto enderecoDto = new EnderecoDto();
    enderecoDto.setId(endereco.getId());
    enderecoDto.setLogradouro(endereco.getLogradouro());
    enderecoDto.setCep(endereco.getCep());
    enderecoDto.setNumero(endereco.getNumero());
    enderecoDto.setCidade(endereco.getCidade());
    return enderecoDto;
}
}
