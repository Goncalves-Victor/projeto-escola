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

    public Pessoa(){}

    public Pessoa(String nome, String cpf, String nascimento, String naturalidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = nascimento;
        this.naturalidade = naturalidade;
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

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setIdade(String nascimento) {
        this.dataNascimento = nascimento;
    }
    

}
