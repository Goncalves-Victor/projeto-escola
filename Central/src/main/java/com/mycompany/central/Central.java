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
       String dataNascimento;
       String naturalidade;
       
        nome = JOptionPane.showInputDialog("Digite o nome do professor");
        cpf = JOptionPane.showInputDialog("Digite o cpf deste");
        dataNascimento = JOptionPane.showInputDialog("Digite a data de nascimento (XX/XX/XXXX)");
        naturalidade = JOptionPane.showInputDialog("Digite a naturalidade(cidade)");
        senha = JOptionPane.showInputDialog("Digite uma senha para este");
        Professor e = new Professor(senha, nome, cpf, dataNascimento, naturalidade);
    
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
    //Disciplina a = adicionarDisciplina();

        Aluno a =new Aluno();
        a.setupData();
        a.getAluno(0);
        System.out.print(a);
        
        // Aluno aluno1 = new Aluno('A', "Primeiro", "123456789", "01/01/2000", "Juiz de Fora", "senha123");
        // Aluno aluno2 = new Aluno('B', "Segundo", "987654321", "02/02/2001", "Rio de Janeiro", "senha456");

        // // Adiciona algumas notas para as matérias de cada aluno
        // aluno1.setNota("Matemática", 8.5f, 1);
        // aluno1.setNota("Matemática", 7.0f, 2);
        // aluno1.setNota("Português", 9.0f, 1);

        // aluno2.setNota("Matemática", 6.5f, 1);
        // aluno2.setNota("História", 8.0f, 1);

        // aluno1.setPresenca("Matemática");  
        // aluno1.setPresenca("Português");   

        // aluno2.setPresenca("Matemática");  
        // aluno2.setPresenca("História");    

        // // Salva os dados dos alunos em um arquivo de texto
        // aluno1.salvaData();
        // aluno2.salvaData();

        // // Imprime os dados dos alunos para verificação
        // aluno1.printAlunos();
        // aluno2.printAlunos();
      
    }
}
