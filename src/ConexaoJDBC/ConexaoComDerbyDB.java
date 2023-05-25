package ConexaoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoComDerbyDB {
    public static void main(String[] args) {
        try {
            // Passo 1 Instanciar a classe do driver de conexão.
            Class.forName("org.apache.derby.jdbc.ClientDriver");

            // Passo 2 Obter uma conexão (Connection) a partir da Connection String, usuário e senha.
            Connection c1 = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/escola",
                    "escola", "escola");

            // Passo 3 Instanciar um executor de SQL (Statement).
            Statement st = c1.createStatement();

            // Passo 4 Executar os comandos DML (linguagem de manipulação de dados).
            st.executeUpdate(
                    "INSERT INTO ALUNO VALUES('E2018.5004','DENIS',2018)");

            st.close();
            c1.close();

            System.out.println("Inserção realizada com sucesso!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
