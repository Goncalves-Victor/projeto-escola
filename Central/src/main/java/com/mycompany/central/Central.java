/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.central;
import javax.swing.JOptionPane;
import java.util.*;
/**
 *
 * @author Joao
 */
public class Central {
    


static protected Map<String,String> relacaoMaterias = new HashMap<>();


    static public Professor adicionarProfessor(){
       String senha; 
       String nome;
       String cpf; 
       String idade; double idadee;
       String naturalidade;
       
        nome = JOptionPane.showInputDialog("Digite o nome do professor");
        cpf = JOptionPane.showInputDialog("Digite o cpf deste");
        idade = JOptionPane.showInputDialog("Digite a idade");
        naturalidade = JOptionPane.showInputDialog("Digite a naturalidade(cidade)");
        senha = JOptionPane.showInputDialog("Digite uma senha para este");
        idadee = Double.parseDouble(idade);
        Professor e = new Professor(senha, nome, cpf, (int)idadee, naturalidade);
    
        return e;
    }
    
    static public Disciplina adicionarDisciplina(){
        String nome;
        String cHoraria; double chora;
        String horaElocal;
        
        nome = JOptionPane.showInputDialog("Digite o nome da nova disciplina");
        cHoraria = JOptionPane.showInputDialog("Digite a carga horaria da nova disciplina em horas");
        horaElocal = JOptionPane.showInputDialog("Digite a hora e o local da disciplina");
        chora = Double.parseDouble(cHoraria);
        Professor a = adicionarProfessor();
        relacaoMaterias.put(a.getSenha(), nome);
        Disciplina e = new Disciplina(nome,(int)chora, horaElocal, a);
        return e;
    }
    
    
    public static void main(String[] args) {
    //Turma a,b;
 
    //Turma a = new Turma('A',0, "Gleiph", "Segunda-quarta 16:00 as 18:00", 0, "123","Matematica" ,"Gleiph" , "12345678-96", 45, "Rio pomba");
    //Turma b = new Turma('B',0, "Gabriel", "Terca-quarta 10:00 a 12:00 e 16:00 a 18:00", 0, "abc", "Literatura","Gabriel", "14785269-32", 28, "Juiz de fora");
    Disciplina a = adicionarDisciplina();
        System.out.println("Hello World!");
    }
}
