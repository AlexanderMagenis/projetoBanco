package br.com.contabancaria.padronizado.dao;


import br.com.contabancaria.padronizado.dao.model.Pessoa;

import java.sql.Date;
import java.util.List;
public interface PessoaDao {

    List<Pessoa> buscarPessoas();
    Pessoa buscarPessoaPorId(Long id);
    Pessoa buscarPessoaPorNome(String nome);
    Pessoa buscarPessoaPorDataNascimento(Date data);
}

