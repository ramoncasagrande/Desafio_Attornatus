package com.ramon.attornatus.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramon.attornatus.exception.PessoaNaoEncontradaException;
import com.ramon.attornatus.model.Endereco;
import com.ramon.attornatus.model.Pessoa;
import com.ramon.attornatus.model.dto.EnderecoDto;
import com.ramon.attornatus.model.dto.PessoaDto;
import com.ramon.attornatus.repositories.PessoaRepository;

import jakarta.transaction.Transactional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaDto> listarPessoas() {
        List<Pessoa> pessoas = pessoaRepository.findAll();
        return pessoas
                .stream()
                .map(PessoaDto::converter)
                .collect(Collectors.toList());
    }

    public PessoaDto criarPessoa(PessoaDto pessoaDto) {
        Pessoa pessoa = pessoaRepository.save(Pessoa.converter(pessoaDto));
        return PessoaDto.converter(pessoa);
    }

    public PessoaDto buscaPorId(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            return PessoaDto.converter(pessoa.get());
        }
        throw new PessoaNaoEncontradaException(id);
    }

    public Pessoa editarPessoa(Long id, Pessoa pessoa) {
        Optional<Pessoa> pessoaEditada = pessoaRepository.findById(id);
        if (pessoaEditada.isPresent()) {
            pessoaEditada.get().setNome(pessoa.getNome());
            pessoaEditada.get().setDataNascimento(pessoa.getDataNascimento());
            pessoaRepository.save(pessoaEditada.get());
            return pessoaEditada.get();
        }
        throw new PessoaNaoEncontradaException(id);
    }

    @Transactional
    public Pessoa AdicionaEnderecoAPessoa(Long pessoaId, EnderecoDto enderecoDto) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
        if (pessoa.isPresent()) {
            pessoa.get().adicionaEndereco(Endereco.converter(enderecoDto));
            return pessoa.get();
        }
        throw new PessoaNaoEncontradaException(pessoaId);
    }

}
