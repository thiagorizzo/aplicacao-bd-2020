package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Cliente;

public class ClienteRepository {
    
    Connection conexao;

    public ClienteRepository() throws ClassNotFoundException, SQLException {
        this.conexao = BancoDeDados.retornaConexao();
    }
    
    public void gravarCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = this.conexao.prepareStatement("INSERT INTO Cliente(nome, cpf) VALUES (?, ?)");
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCpf());
        
        int resultado = ps.executeUpdate();
    }
    
    public Cliente buscarClientePeloCodigo(int codigo) throws SQLException {
        PreparedStatement ps = this.conexao.prepareStatement("SELECT * FROM Cliente WHERE codigo = ?");
        ps.setInt(1, codigo);
        
        Cliente cliente = null;
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int _codigo = rs.getInt("codigo");
            String nome = rs.getString("nome");
            String cpf = rs.getString("cpf");
            
            cliente = new Cliente(_codigo, nome, cpf);
        }
        
        return cliente;
    }
    
    public Cliente buscarClientePeloCpf(String cpf) throws SQLException {
        PreparedStatement ps = this.conexao.prepareStatement("SELECT * FROM Cliente WHERE cpf = ?");
        ps.setString(1, cpf);
        
        Cliente cliente = null;
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int codigo = rs.getInt("codigo");
            String nome = rs.getString("nome");
            String _cpf = rs.getString("cpf");
            
            cliente = new Cliente(codigo, nome, _cpf);
        }
        
        return cliente;
    }
    
    public ArrayList<Cliente> buscarTodos() throws SQLException {
        PreparedStatement ps = this.conexao.prepareStatement("SELECT * FROM Cliente");
        
        int codigo;
        String nome;
        String cpf;
        
        ArrayList<Cliente> clientes = new ArrayList<>();
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            codigo = rs.getInt("codigo");
            nome = rs.getString("nome");
            cpf = rs.getString("cpf");
            
            clientes.add(new Cliente(codigo, nome, cpf));            
        }
              
        return clientes;
    }
    
    public void removerCliente(int codigo) {
        
    }
    
    public void atualizarCliente(Cliente cliente) {
        
    }
}
