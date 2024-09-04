/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.central;

/**
 *
 * @author Joao
 */
public class Aluno extends Pessoa{
float nota;
int presenca;
String matricula;
char turma;
String senha;

    public Aluno(float nota,int presenca, String matricula, char turma, String nome, String cpf, int idade, String naturalidade, String senha) {
        super(nome, cpf, idade, naturalidade);
        this.nota = nota;
        this.presenca = presenca;
        this.matricula = matricula;
        this.turma = turma;
        this.senha = senha;
    }

    public float getNota() {
        return nota;
    }

    public String getMatricula() {
        return matricula;
    }

    public char getTurma() {
        return turma;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public void setTurma(char turma) {
        this.turma = turma;
    }

}
