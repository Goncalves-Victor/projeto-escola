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
 * Classe Aluno que herda da classe Pessoa
 * Representa um aluno com notas, presença, matrícula e outras informações.
 * Também permite a leitura e gravação de dados em um arquivo de texto.
 * @author Joao
 */
public class Aluno extends Pessoa {

    // Mapeia matérias para suas respectivas listas de notas (Float)
    private Map<String, List<Float>> notaMaterias;
    // Mapeia datas ou identificadores de aulas para a presença dos alunos (Float)
    private Map<String, Integer> presenca;
    private String matricula;
    private char turma;
    private String senha;

    // Variáveis estáticas para controlar a quantidade de alunos e a lista de alunos
    private static int qtde;
    private static List<Aluno> listaAlunos;

    // Bloco estático para inicializar variáveis estáticas
    static {
        qtde = 0;
        listaAlunos = new ArrayList<>();
    }

    // Construtor padrão
    public Aluno() {
        super();
        notaMaterias = new HashMap<>();
        presenca = new HashMap<>();
    }

    // Construtor que inicializa o aluno com informações fornecidas
    public Aluno(char turma, String nome, String cpf, String dataNascimento, String naturalidade, String senha) {
        super(nome, cpf, dataNascimento, naturalidade);
        qtde++;
        this.matricula = geraMatricula(qtde + "");
        this.turma = turma;
        this.senha = senha;
        notaMaterias = new HashMap<>();
        presenca = new HashMap<>();
        
    }

    // Adiciona um aluno à lista de alunos
    public void addAluno(Aluno a) {
        listaAlunos.add(a);
    }

    // Retorna as notas de uma matéria específica
    public List<Float> getNota(String materia) {
        return notaMaterias.get(materia);
    }

    public String getMatricula() {
        return matricula;
    }

    public String getSenha() {
        return senha;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public char getTurma() {
        return turma;
    }

    public void setPresenca(String materia) {
        presenca.put(materia, 0);
    }

    public Map<String, Integer> getPresenca() {
        return presenca;
    }

    public Integer getPresenca(String materia) {
        return presenca.get(materia);
    }

    public void Faltas(String materia) {
        presenca.put(materia, getPresenca(materia)+1);
    }

    public Map<String, List<Float>> getNotaMaterias() {
        return notaMaterias;
    }

    public void setNota(String materia, float nota, int i) {
        List<Float> a = notaMaterias.get(materia);
        if (a == null) {
            a = new ArrayList<>();
        }
        i = i - 1; 
        if (i < a.size()) {
            a.set(i, nota);
        } else {
            while (a.size() <= i) {
                a.add(0.0f); 
            }
            a.set(i, nota);
        }
        notaMaterias.put(materia, a);
    }

    public void setTurma(char turma) {
        this.turma = turma;
    }

    public void printAlunos() {
        for (Aluno aluno : listaAlunos) {
            // Imprime informações básicas do aluno
            System.out.println("Matrícula: " + aluno.getMatricula() + 
                               " - Nome: " + aluno.getNome() + 
                               " - Idade: " + aluno.getIdade() +
                               " - CPF: " + aluno.getCpf() + 
                               " - Data de Nascimento: " + aluno.getDataNascimento() +
                               " - Naturalidade: " + aluno.getNaturalidade() +
                               " - Turma: " + aluno.getTurma() +
                               " - Senha: " + aluno.getSenha());
    
            // Imprime as notas de todas as matérias
            System.out.println("Notas:");
            for (Map.Entry<String, List<Float>> entry : aluno.getNotaMaterias().entrySet()) {
                String materia = entry.getKey();
                List<Float> notas = entry.getValue();
                System.out.println("  Matéria: " + materia + " - Notas: " + notas.toString());
            }
    
            // Imprime as presenças para todas as matérias
            System.out.println("Presença:");
            for (Map.Entry<String, Integer> entry : aluno.getPresenca().entrySet()) {
                String materia = entry.getKey();
                Integer presenca = entry.getValue();
                System.out.println("  Matéria: " + materia + " - Presença: " + presenca);
            }
    
            // Adiciona uma linha em branco para separar os alunos
            System.out.println();
        }
    }

    // Gera um número de matrícula baseado na quantidade de alunos (qtde)
    private String geraMatricula(String n) {
        String matricula = "";
        for (int i = 0; i < 4 - n.length(); i++) {
            matricula = matricula + "0"; // Preenche com zeros à esquerda
        }
        matricula = matricula + n;
        return matricula;
    }

    // Salva os dados dos alunos em um arquivo de texto
    public void salvaData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data_txt/txtAlunos.txt", true))) {
            for (Map.Entry<String, List<Float>> entry : notaMaterias.entrySet()) {
                String materia = entry.getKey();
                List<Float> notas = entry.getValue();
                String notasString = notas.toString();
            }
            
            for (Map.Entry<String, Integer> entry : presenca.entrySet()) {
                String materiaPresenca = entry.getKey();
                Integer presencaValue = entry.getValue();
            }
            
            // Escreve todos os atributos, incluindo notas e presenças
            writer.println(matricula + "," + nome + "," + cpf + "," + dataNascimento + "," + naturalidade + "," + turma + "," + senha + "," 
                           + notaMaterias.toString() + "," + presenca.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    // Lê os dados dos alunos existentes no txt
    public void setupData() {
        File arquivo = new File("data_txt/txtAlunos.txt");
        try {
            if (arquivo.exists()) {
                try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    while ((linha = reader.readLine()) != null) {
                        String[] data = linha.split(","); // Divide os campos da linha
                        
                        // Cria um novo aluno e preenche os campos com os dados lidos
                        Aluno a = new Aluno();
                        a.matricula = data[0];
                        a.nome = data[1];
                        a.cpf = data[2];
                        a.dataNascimento = data[3];
                        a.naturalidade = data[4];
                        a.turma = data[5].charAt(0); // Turma é um caractere, então pegamos o primeiro char da string
                        a.senha = data[6];
                        
                        // Desserializa as notas
                        String notasString = data[7].replace("[", "").replace("]", ""); // Remove colchetes da string
                        String[] notasArray = notasString.split(", "); // Divide as notas
                        for (String materiaNotas : notasArray) {
                            String[] materiaNotaSplit = materiaNotas.split("="); // "matéria=[notas]"
                            String materia = materiaNotaSplit[0]; 
                            String[] notas = materiaNotaSplit[1].split(" ");
                            List<Float> listaNotas = new ArrayList<>();
                            for (String nota : notas) {
                                listaNotas.add(Float.parseFloat(nota)); // Converte cada nota para Float
                            }
                            a.notaMaterias.put(materia, listaNotas); // Adiciona as notas da matéria
                        }
    
                        // Desserializa as presenças
                        String presencaString = data[8].replace("{", "").replace("}", ""); // Remove chaves da string
                        String[] presencaArray = presencaString.split(", "); // Divide as presenças
                        for (String materiaPresenca : presencaArray) {
                            String[] materiaPresencaSplit = materiaPresenca.split("="); // "matéria=presença"
                            String materia = materiaPresencaSplit[0];
                            int presencaValue = Integer.parseInt(materiaPresencaSplit[1]);
                            a.presenca.put(materia, presencaValue); // Adiciona a presença da matéria
                        }
    
                        addAluno(a); // Adiciona o aluno à lista
                        qtde++; // Incrementa a quantidade de alunos
                    }
                }
            } else {
                arquivo.createNewFile(); // Cria o arquivo se ele não existir
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    // Verifica se a senha fornecida corresponde à senha do aluno
    public Boolean confereSenha(String Asenha) {
        return Asenha.equals(senha); 
    }
}