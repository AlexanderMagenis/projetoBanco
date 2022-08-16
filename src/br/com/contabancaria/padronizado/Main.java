package br.com.contabancaria.padronizado;

import br.com.contabancaria.padronizado.dao.PessoaDao;
import br.com.contabancaria.padronizado.dao.impl.PessoaDaoImpl;
import br.com.contabancaria.padronizado.dao.model.Pessoa;

import java.sql.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Main principal = new Main();

        PessoaDao pessoaDao = new PessoaDaoImpl();

        principal.listagemPessoas(pessoaDao);

        principal.filtrarPessoaPorId(pessoaDao);

        principal.filtrarPessoaPorNome(pessoaDao);

        principal.filtrarPessoaDataNascimento(pessoaDao);

    }


    public void filtrarPessoaPorId(PessoaDao pessoaDao) {
        Long id = 3L;
        Pessoa pessoa = pessoaDao.buscarPessoaPorId(id);

        System.out.println(" -------- UNICA PESSOA ----- ");
        if(pessoa != null) {
            System.out.println( pessoa.getId() + " -  " + pessoa.getNome()  +  pessoa.getDataNascimento());
        }
    }

    public void listagemPessoas(PessoaDao pessoaDAO) {
        List<Pessoa> Pessoas = pessoaDAO.buscarPessoas();
        imprimir(Pessoas);
    }

    public static void imprimir(List<Pessoa> pessoas) {
        for (Pessoa pessoa : pessoas) {
            System.out.println( pessoa.getId() + " -  " +  pessoa.getNome()  +  pessoa.getDataNascimento());
        }
    }
    public void filtrarPessoaPorNome(PessoaDao pessoaDao) {
        String nome = "Alexander";
        Pessoa pessoa = pessoaDao.buscarPessoaPorNome(nome);

        System.out.println(" -------- UNICA PESSOA ----- ");
        if(pessoa != null) {
            System.out.println( pessoa.getId() + " -  " + pessoa.getNome()  +  pessoa.getDataNascimento());
        }
    }
    public void filtrarPessoaDataNascimento(PessoaDao pessoaDao){
        Date data_nascimento = Date.valueOf("2009-04-01");
        Pessoa pessoa = pessoaDao.buscarPessoaPorDataNascimento(data_nascimento);

        System.out.println(" -------- UNICA PESSOA ----- ");
        if(pessoa != null) {
            System.out.println( pessoa.getId() + " -  " + pessoa.getNome()  +  pessoa.getDataNascimento());
        }
    }
}

