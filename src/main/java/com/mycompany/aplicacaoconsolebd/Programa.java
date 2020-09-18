package com.mycompany.aplicacaoconsolebd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Cliente;
import repositorio.BancoDeDados;
import repositorio.ClienteRepository;

public class Programa {
    public static void main(String[] args) throws SQLException {
        
        Cliente c1 = new Cliente("Thiago Rizzo", "22314218811");

        ClienteRepository clienteRepository;
    
        try {
            clienteRepository = new ClienteRepository();
            clienteRepository.gravarCliente(c1);
            
            Cliente c2 = clienteRepository.buscarClientePeloCodigo(2);
            
            System.out.println("Cliente: " + c2.getCodigo() + " - " + c2.getNome() + " - " + c2.getCpf());
            
            ArrayList<Cliente> todosClientes = clienteRepository.buscarTodos();
            for(Cliente cliente : todosClientes) {
                System.out.println("Cliente: " + cliente.getCodigo() + " - " + cliente.getNome() + " - " + cliente.getCpf());
            }
            
        } catch (Exception ex) {
            System.out.println("Erro ao gravar cliente: " + ex.getMessage());
        }

        BancoDeDados.FecharConexao();
    }
}
