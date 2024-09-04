/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.central;
import java.util.*;
/**
 *
 * @author Joao
 */
public class Turma {
char identificador;
float notaMedia;
int qtAlunos;
private List<Aluno> alunos;
private List<Professor> professores;

    public Turma(char identificador, float notaMedia, int qtAlunos) {
       
        this.identificador = identificador;
        this.notaMedia = notaMedia;
        this.qtAlunos = qtAlunos;
       
    }

    public char getIdentificador() {
        return identificador;
    }

    public float getNotaMedia() {
        return notaMedia;
    }

  

    public int getQtAlunos() {
        return qtAlunos;
    }

    public void setNotaMedia(float notaMedia) {
        this.notaMedia = notaMedia;
    }



    public void setQtAlunos(int qtAlunos) {
        this.qtAlunos = qtAlunos;
    }
    
    public void addAlunos(Aluno a)
    {
    alunos.add(a);
    setQtAlunos(alunos.size());
    float soma = 0;
        for(int i=0; i<qtAlunos; i++)
        {
        soma = alunos.get(i).getNota() + soma;
        }
    setNotaMedia(soma/qtAlunos);
    }
    
    public void removeAlunos(String matricula)
    {
        for(int i=0; i< alunos.size(); i++)
        {
            if(matricula == alunos.get(i).getMatricula())
            {
            alunos.remove(i);
            }
        }
    setQtAlunos(alunos.size());
    float soma = 0;
        for(int i=0; i<qtAlunos; i++)
        {
        soma = alunos.get(i).getNota() + soma;
        }
    setNotaMedia(soma/qtAlunos);
    }
    



    
    
    
    
}
