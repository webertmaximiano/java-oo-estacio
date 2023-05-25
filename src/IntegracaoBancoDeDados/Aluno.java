package IntegracaoBancoDeDados;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Aluno {
    public String matricula;
    public String nome;
    public int ano;

    public Aluno() throws SQLException { }

    public Aluno(String matricula, String nome, int ano) throws SQLException {
        this.matricula = matricula;
        this.nome = nome;
        this.ano = ano;
    }

}