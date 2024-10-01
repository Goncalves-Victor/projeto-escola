/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.central;

/**
 *
 * @author ice
 */
public class Diretor extends Pessoa{
    private String senha;
    private double salario;

    public Diretor(String senha, String nome, String cpf, String dataDascimento, String naturalidade, String telefone, String endereco) {
        super(nome, cpf, dataDascimento, naturalidade, telefone, endereco);
        this.senha = senha;
    }
    
}
