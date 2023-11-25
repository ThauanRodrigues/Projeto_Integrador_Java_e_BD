package Utilitarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connect {
    public static Connection GeraConexao(){
        Connection conexao = null;

        try{
            String url = "jdbc:mysql://localhost/AGENCIABANCO";
            String usuario = "aleehk";
            String senha = "inohavemoney";
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão realizada com sucesso");
        } catch (SQLException e) {
            System.out.println("Erro ao tebtar cibectar: "+ e.getMessage());
            conexao = null;
        }
        return conexao;
    }
}

