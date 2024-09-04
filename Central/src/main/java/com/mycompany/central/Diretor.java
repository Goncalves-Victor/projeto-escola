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
String senha;

    public Diretor(String senha, String nome, String cpf, int idade, String naturalidade) {
        super(nome, cpf, idade, naturalidade);
        this.senha = senha;
    }
    
}
