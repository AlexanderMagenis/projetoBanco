package br.com.contabancaria.simple;

import java.sql.*;
import java.util.Date;

public class Principal {

        static final String DB_URL = "jdbc:mysql://localhost/banco";
        static final String USER = "root";
        static final String PASS = "Alex01@3#4%!mx";

        public static void main(String[] args) {


            // Open a connection
          /*  try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
            ) {
                String sql = "CREATE DATABASE BANCO";
                String sql_table = "CREATE TABLE BANCO.USUARIO(\n"+"  id INT AUTO_INCREMENT PRIMARY KEY,\n"+
                        "   nome VARCHAR(255) NOT NULL,\n"+
                        "   data_nascimento DATE\n"+
                        ") ENGINE=INNODB;";
                stmt.executeUpdate(sql);
                stmt.executeUpdate(sql_table);*/
            Pessoa pessoa = null;

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement stmt = conn.createStatement();
            ) {

                String sql_DB = "select * from usuario";
                ResultSet rs = stmt.executeQuery(sql_DB);

                while (rs.next()) {

                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    Date dataNascimento = rs.getDate("data_nascimento");

                    //Display values
                    System.out.println("ID: " + id);
                    System.out.println(", Nome: " + nome);
                    System.out.println(", Data Nascimento: " + dataNascimento);

                    pessoa = new Pessoa(id, nome, dataNascimento);
                    pessoa.registrarUsuario(id, nome, dataNascimento);

                }

                System.out.println("Database criado com sucesso");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            pessoa.imprimirLista();
        }

    }

