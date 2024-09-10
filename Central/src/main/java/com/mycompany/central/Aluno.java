/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.central;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import javax.xml.crypto.Data;
/**
 *
 * @author Joao
 */

public class Aluno extends Pessoa implements Data{
static protected Map<String,List > notaMaterias;

    private int presenca;
    private String matricula;
    private char turma;
    private String senha;

    private static int qtde;
    private static List<Aluno> listaAlunos;

    static{
        qtde = 0;
        notaMaterias = new HashMap<>();
        listaAlunos=new ArrayList<>();
    }

    public Aluno() {super();}
        
    public Aluno(int presenca, char turma, String nome, String cpf, int idade, String naturalidade, String senha) {
        super(nome, cpf, idade, naturalidade);
        qtde++;
        this.presenca = presenca;
        this.matricula = geraMatricula(qtde+"");
        this.turma = turma;
        this.senha = senha;
    }
    
    public void addAluno(Aluno a){
        listaAlunos.add(a);
    }

    public List getNota(String materia) {
    List a = notaMaterias.get(materia);
    return a;
    }

    public String getMatricula() {
        return matricula;
    }

    public char getTurma() {
        return turma;
    }

    public int getPresenca() {
        return presenca;
    }

    public void setPresenca(int presenca) {
        this.presenca = presenca;
    }

    public void setNota(String materia, float nota, int i) { //String materia, float nota da prova, int qual prova.
        List <Float> a = null;
        i=i-1;
        a.add(i, nota);
        notaMaterias.put(materia, a);
    }

    public void setTurma(char turma) {
        this.turma = turma;
    }
    
    public void printAlunos(){
        for (Aluno aluno : listaAlunos) {
            System.out.println("Matricula: " + aluno.getMatricula() + " - Nome: " + aluno.getNome() + " - Idade: " + aluno.getIdade());
        }  
    }

    private String geraMatricula(String n){

        String matricula="";
        for(int i=0;i<4-n.length();i++){
            matricula=matricula+"0";
        }
        matricula=matricula+n;
        return matricula;
    }
    
    @Override
    public void salvaData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data_txt/txtAlunos.txt", true))) {
            writer.println(matricula + "," + nome + "," + idade); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setupData() {
        File arquivo = new File("data_txt/txtAlunos.txt");
        try {
            if (arquivo.exists()) {
                // Leitura do arquivo
                try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    while ((linha = reader.readLine()) != null) {
                        String[] data = linha.split(",");
                       
                        Aluno a = new Aluno();
                        a.matricula = data[0];
                        a.nome = data[1];
                        a.idade = data[2];
                        addAluno(a); 
                        qtde++;
                    }
                }
            } else {
                arquivo.createNewFile(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Boolean confereSenha(String Asenha)
    {
        if(Asenha == senha )
        {
        return true;
        }
    return false;
    }

}
