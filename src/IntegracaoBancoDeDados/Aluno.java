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

    List<Aluno> lista = new ArrayList<>();
    Class.forName("org.apache.derby.jdbc.ClientDriver");
    Connection c1 = DriverManager.getConnection(
            "jdbc:derby://localhost:1527/loja",
            "loja", "loja");
    Statement st = c1.createStatement();
    ResultSet r1 = st.executeQuery("SELECT * FROM ALUNO");
    while (r1.next()) {
            lista.add(new Aluno(
                    r1.getString("MATRICULA"),
                    r1.getString("NOME"),
                    r1.getInt("ENTRADA")
            ));
        }
    r1.close();
    st.close();
    c1.close();

}