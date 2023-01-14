package com.ramon.attornatus.exception;

import java.text.MessageFormat;

public class PessoaNaoEncontradaException extends RuntimeException {

    public PessoaNaoEncontradaException(long id){
        super(MessageFormat.format("Não foi possível encontrar a Pessoa com id: {0}", id));
    }
    
}
