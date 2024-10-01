package com.mycompany.central;

import java.io.*;
import java.util.*;

public class Aluno extends Pessoa implements Data {

    protected static List<Aluno> listaAlunos = new ArrayList<>(); // Inicializando a lista
    private static int qtAluno = 0;
    private String matricula;
    private String turma;
    private double mensalidade; // Adicionando o atributo mensalidade

    static {
        qtAluno = 0;
    }

    public Aluno() {
        super();
    }

    public Aluno(String nome, String cpf, String dataNascimento, String naturalidade, String turma, double mensalidade, String telefone, String endereco) {
        super(nome, cpf, dataNascimento, naturalidade, telefone, endereco);
        this.turma = turma;
        this.mensalidade = mensalidade;
        qtAluno++;

        // Criação da matrícula com base na quantidade de alunos
        String sQtd = Integer.toString(qtAluno);
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < 4 - sQtd.length(); i++) {
            num.append("0");
        }
        num.append(qtAluno);
        this.matricula = num.toString();
        listaAlunos.add(this);
        // Criação do arquivo para o aluno
        salvaData(); // Salva os dados do aluno ao criar um novo
    }


    
    public static int getQtAluno() {
        return qtAluno;
    }
    
    public Aluno getAluno(int i) {
        if (i <= qtAluno) {
            return listaAlunos.get(i);
        } else {
            return null;
        }
    }
    
     
    public void setTurma(String turma){
        this.turma=turma;
    }

    public void setMensalidade(double mensalidade){
        this.mensalidade=mensalidade;
    }

    public String getTurma(){
        return this.turma;
    }
    
    protected static List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public String getMatricula(){
        return this.matricula;
    }

    protected double getMensalidade(){
        return this.mensalidade;
    }


    @Override
    public void setupData() {
        File pasta = new File("txtalunos");
        if (!pasta.exists()) {
            pasta.mkdir(); // Cria a pasta se não existir
        }

        // Lê todos os arquivos na pasta
        for (File arquivo : pasta.listFiles()) {
            if (arquivo.isFile() && arquivo.getName().endsWith(".txt")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                    String linha = reader.readLine();
                    if (linha != null) {
                        Aluno a = new Aluno();
                        String[] data = linha.split(",");
                        a.nome = data[0];
                        a.cpf = data[1];
                        a.dataNascimento = data[2];
                        a.naturalidade = data[3];
                        a.turma = data[4];
                        a.mensalidade = Double.parseDouble(data[5]);
                        a.telefone = data[6];
                        a.endereco = data[7];
                        a.matricula = arquivo.getName().replace(".txt", "");
                        listaAlunos.add(a);
                        qtAluno++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void salvaData() {
        File pasta = new File("txtalunos");
        if (!pasta.exists()) {
            pasta.mkdir(); // Cria a pasta se não existir
        }
    
        try (PrintWriter writer = new PrintWriter(new FileWriter(new File(pasta, matricula + ".txt"), false))) { // false para sobrescrever
            writer.println(nome + "," + cpf + "," + dataNascimento + "," + naturalidade + "," + turma + "," + mensalidade + "," + telefone + "," + endereco);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletData() {
        String nomeArquivo=this.matricula;
        File pasta = new File("txtAlunos");
        if (!pasta.exists()) {
            System.out.println("A pasta de funcionários não existe.");
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
