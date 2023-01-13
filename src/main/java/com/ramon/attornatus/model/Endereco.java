package com.ramon.attornatus.model;

import com.ramon.attornatus.model.dto.EnderecoDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name="endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String logradouro;
    private String cep;
    private Integer numero;
    private String cidade;

    @ManyToOne
    private Pessoa pessoa;

    public static Endereco converter(EnderecoDto enderecoDto){
        Endereco endereco = new Endereco();
        endereco.setLogradouro(enderecoDto.getLogradouro());
        endereco.setCep(enderecoDto.getCep());
        endereco.setNumero(enderecoDto.getNumero());
        endereco.setCidade(enderecoDto.getCidade());
        return endereco;
    }
    
}
