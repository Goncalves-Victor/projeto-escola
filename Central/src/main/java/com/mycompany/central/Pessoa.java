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
int idade;
String naturalidade;

    public Pessoa(){}

    public Pessoa(String nome, String cpf, int idade, String naturalidade) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.naturalidade = naturalidade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    

}
