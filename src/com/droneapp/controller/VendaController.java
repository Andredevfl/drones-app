package com.droneapp.controller;

import database.ClienteDAO;
import com.droneapp.model.Cliente;
import javax.swing.*;

public class VendaController {

    private ClienteDAO clienteDAO;

    public VendaController() {
        clienteDAO = new ClienteDAO();
    }

    // Método que será chamado quando o cliente clicar em "Finalizar Compra"
    public void finalizarCompra(String nome, String cpf, String cep) {
        Cliente cliente = new Cliente(0, nome, cpf, cep); // O id será gerado automaticamente
        clienteDAO.criarCliente(cliente);
        JOptionPane.showMessageDialog(null, "Compra finalizada com sucesso!");
    }
}