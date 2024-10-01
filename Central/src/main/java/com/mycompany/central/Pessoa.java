/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.central;

/**
 *
 * @author Joao
 */
public class Pessoa {
String nome;
String cpf;
String dataNascimento;
String naturalidade;
String endereco;
String telefone;

    public Pessoa(){}

    public Pessoa(String nome, String cpf, String nascimento, String naturalidade, String telefone, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = nascimento;
        this.naturalidade = naturalidade;
        this.telefone = telefone;
        this.endereco = endereco;

    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getIdade() {
        return dataNascimento;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setIdade(String nascimento) {
        this.dataNascimento = nascimento;
    }


}
