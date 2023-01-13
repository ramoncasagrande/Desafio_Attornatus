package com.ramon.attornatus.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ramon.attornatus.model.Endereco;
import com.ramon.attornatus.model.Pessoa;
import com.ramon.attornatus.repositories.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EnderecoService enderecoService;

    public List<Pessoa> listarPessoas() {
        List<Pessoa> lista = pessoaRepository.findAll();
        return lista
                .stream()
                .collect(Collectors.toList());
    }

    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa buscaPorId(Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.get();
    }

    public Pessoa editarPessoa(Long id, Pessoa novaPessoa) {
        Optional<Pessoa> pessoaEditada = pessoaRepository.findById(id);
        pessoaEditada.get().setNome(novaPessoa.getNome());
        pessoaEditada.get().setDataNascimento(novaPessoa.getDataNascimento());
        return pessoaEditada.get();
    }

    public Pessoa AdicionaEnderecoAPessoa(Long pessoaId, Long enderecoId){
        Optional<Pessoa> pessoa = pessoaRepository.findById(pessoaId);
        Endereco endereco = enderecoService.buscaPorId(enderecoId);
        pessoa.get().adicionaEndereco(endereco);
        return pessoa.get();
    }

}
