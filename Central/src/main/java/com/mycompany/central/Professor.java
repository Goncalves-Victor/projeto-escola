/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.central;


/**
 *
 * @author Joao
 */
public class Professor extends Pessoa{
String senha;

static int qtProfessor = 0;



    public Professor(String senha, String nome, String cpf, String dataNascimento, String naturalidade) {
        super(nome, cpf, dataNascimento, naturalidade);
       
        this.senha = senha;
        qtProfessor++;
    }
    
    public static int getQtProfessor() {
        return qtProfessor;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }


    
    
}
