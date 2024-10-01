package com.mycompany.central;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Turma implements Data {
    private String id;
    private String professorResponsavel; // (id-nome)
    private String anoLetivo;
    private int capacidadeMaxima;
    private int qtAlunos; // Agora apenas armazena a quantidade de alunos
    private double renda;
    private static int qtTurmas; // Contador de turmas

    private static List<Turma> listaTurmas;

    static {
        listaTurmas = new ArrayList<>();
        qtTurmas = 0;
    }

    // Construtor padrão
    public Turma(String professorResponsavel, String anoLetivo, int capacidadeMaxima) {
        this.professorResponsavel = professorResponsavel;
        this.anoLetivo = anoLetivo;
        this.capacidadeMaxima = capacidadeMaxima;
        this.qtAlunos = 0; // Inicializa a quantidade de alunos como 0
        this.renda = 0;

        // Incrementa o contador e cria um ID para a turma
        qtTurmas++;

        // Criação da matrícula com base na quantidade de alunos
        String sQtd = Integer.toString(qtTurmas);
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < 4 - sQtd.length(); i++) {
            num.append("0");
        }
        num.append(qtTurmas);
        this.id = num.toString();

        listaTurmas.add(this); // Adiciona turma à lista
        this.salvaData(); // Salva os dados da turma ao criar um novo
    }

    public Turma() {
    }

    // Método para adicionar aluno à turma
    public boolean adicionarAluno() {
        if (qtAlunos < capacidadeMaxima) {
            qtAlunos++; // Aumenta a quantidade de alunos
            return true;
        }
        return false;
    }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfessorResponsavel() {
        return professorResponsavel;
    }

    public static List<Turma> getListaTurmas() {
        return listaTurmas;
    }

    public void setProfessorResponsavel(String professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public String getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(String anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public int getQtAlunos() {
        return qtAlunos; // Retorna a quantidade de alunos
    }

    public double getRenda() {
        return renda;
    }

    // Implementação do método setupData
    @Override
public void setupData() {
    File pasta = new File("txtTurmas");
    if (!pasta.exists()) {
        pasta.mkdir(); // Cria a pasta se não existir
    }

    // Lê todos os arquivos na pasta
    for (File arquivo : pasta.listFiles()) {
        if (arquivo.isFile() && arquivo.getName().endsWith(".txt")) {
            try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                String linha = reader.readLine();
                if (linha != null) {
                    Turma t = new Turma(); // Cria uma nova instância de Turma
                    String[] data = linha.split(",");
                    t.id = data[0]; // Preenche o ID
                    t.professorResponsavel = data[1]; // Preenche o professor responsável
                    t.anoLetivo = data[2]; // Preenche o ano letivo
                    t.capacidadeMaxima = Integer.parseInt(data[3]); // Preenche a capacidade máxima
                    t.qtAlunos = Integer.parseInt(data[4]); // Preenche a quantidade de alunos
                    
                    listaTurmas.add(t); // Adiciona a turma à lista
                    qtTurmas++; // Incrementa a quantidade de turmas
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Erro ao converter número: " + e.getMessage());
            }
        }
    }
}


    // Implementação do método salvaData
    @Override
    public void salvaData() {
        File pasta = new File("txtTurmas");
        if (!pasta.exists()) {
            pasta.mkdir(); // Cria a pasta se não existir
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(new File(pasta, id + ".txt"), false))) {
            writer.println(id + "," + professorResponsavel + "," + anoLetivo + "," + capacidadeMaxima + "," + qtAlunos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletData() {
        String nomeArquivo = this.id;
        File pasta = new File("txtTurmas");
        if (!pasta.exists()) {
            System.out.println("A pasta de turmas não existe.");
            return;
        }

        File arquivo = new File(pasta, nomeArquivo + ".txt");
        if (arquivo.exists()) {
            if (arquivo.delete()) {
                System.out.println("Arquivo " + nomeArquivo + " deletado com sucesso.");
            } else {
                System.out.println("Falha ao deletar o arquivo " + nomeArquivo);
            }
        } else {
            System.out.println("Arquivo " + nomeArquivo + " não encontrado.");
        }
    }
}
