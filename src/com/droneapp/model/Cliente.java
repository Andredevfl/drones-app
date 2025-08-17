package com.droneapp.model;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String cep;
    
    public Cliente(int id, String nome, String cpf, String cep) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cep = cep;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}