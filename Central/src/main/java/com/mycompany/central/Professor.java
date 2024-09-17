/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.central;

import java.io.*;
import java.util.*;

/**
 *
 * @author Joao
 */
public class Professor extends Pessoa implements Data{
String senha;

static int qtProfessor = 0;
private String id;

    static{
        qtProfessor=0;
    }

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

    public void setupData(){
        File arquivo = new File("txtProfessores.txt");
        try {
            if (arquivo.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    while ((linha = reader.readLine()) != null) {
                        System.out.print(linha);
                        qtProfessor++;
                    }
                }
            } else {
                arquivo.createNewFile(); // Cria o arquivo se ele não existir
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvaData(){
        try (PrintWriter writer = new PrintWriter(new FileWriter("txtProfessores.txt", true))) {
            writer.println(id + "," + nome + "," + cpf + "," + dataNascimento + "," + naturalidade + senha + ",");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
