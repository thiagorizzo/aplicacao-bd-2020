package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDeDados {
    
    private static Connection conexao;
    
    public static Connection retornaConexao() throws ClassNotFoundException, SQLException {
        
        if (conexao == null) {
            // 1) Carregar o Driver na Memória
           // obs: Driver ficará disponível no gerenciador de Drivers
           Class.forName("com.mysql.cj.jdbc.Driver");

           // 2) Conectar ao banco de dados
           // string conexao: ip + porta (configurações de conectividade)
           conexao =  DriverManager.getConnection("jdbc:mysql://localhost/teste?serverTimezone=UTC", "root", "");        
        }
     
       return conexao;
    }
    
    
    public static void FecharConexao() throws SQLException {
        if (conexao != null)
            conexao.close();
    }
}
