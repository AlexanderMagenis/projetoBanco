package br.com.contabancaria.simple;

import java.util.ArrayList;
import java.util.Date;

public class Pessoa {
    private int id;
    private String nome;
    private Date dataNascimento;
    private static ArrayList<Object> dadosUsuarios = new ArrayList<>();
    public Pessoa(int id, String nome, Date dataNascimento){
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;

}
    public void registrarUsuario(int id,String nome,Date dataNascimento) {
        dadosUsuarios.add(id);
        dadosUsuarios.add(nome);
        dadosUsuarios.add(dataNascimento);

    }
    public void imprimirLista(){
        for(int i = 0; i<dadosUsuarios.size();i++){
            System.out.println(dadosUsuarios.get(i));
        }
}
}
