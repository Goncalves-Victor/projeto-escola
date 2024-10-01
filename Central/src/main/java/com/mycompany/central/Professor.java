package com.mycompany.central;

import java.io.*;
import java.util.*;

public class Professor extends Pessoa implements Data {

    protected static List<Professor> listaProfessores = new ArrayList<>(); 
    private String senha;
    private static int qtProfessor = 0;
    private String id;
    private double salario; 

    static {
        qtProfessor = 0;
    }

    public Professor() {
        super();
    }

    public Professor(String senha, String nome, String cpf, String dataNascimento, String naturalidade, double salario, String telefone, String endereco) {
        super(nome, cpf, dataNascimento, naturalidade, telefone, endereco);
        this.senha = senha;
        this.salario = salario;
        qtProfessor++;

        // Criação do ID com base na quantidade de professores
        String sQtd = Integer.toString(qtProfessor);
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < 4 - sQtd.length(); i++) {
            num.append("0");
        }
        num.append(qtProfessor);
        this.id = num.toString();
        listaProfessores.add(this);
        salvaData(); 
    }

    public void setId(String id){
        this.id=id;
    }

    public static int getQtProfessor() {
        return qtProfessor;
    }

    public static List<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public double getSalario(){
        return this.salario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha(){
        return this.senha;
    }

    public String getId() {
        return id;
    }

    public void setSalario(double salario){
        this.salario = salario;
    }

    @Override
    public void setupData() {
        File pasta = new File("txtProfessores");
        if (!pasta.exists()) {
            pasta.mkdir(); // Cria a pasta se não existir
        }

        // Lê todos os arquivos na pasta
        for (File arquivo : pasta.listFiles()) {
            if (arquivo.isFile() && arquivo.getName().endsWith(".txt")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                    String linha = reader.readLine();
                    if (linha != null) {
                        Professor p = new Professor();
                        String[] data = linha.split(",");
                        
                        // Assegura que a linha contém a quantidade esperada de dados
                        if (data.length >= 8) {
                            p.nome = data[0];
                            p.cpf = data[1];
                            p.dataNascimento = data[2];
                            p.naturalidade = data[3];
                            p.senha = data[4];
                            p.salario = Double.parseDouble(data[5]);
                            p.telefone = data[6];
                            p.endereco = data[7];
                            p.id = arquivo.getName().replace(".txt", "");
                            listaProfessores.add(p);
                            qtProfessor++;
                        } else {
                            System.out.println("Erro: dados insuficientes no arquivo " + arquivo.getName());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void salvaData() {
        File pasta = new File("txtProfessores");
        if (!pasta.exists()) {
            pasta.mkdir(); // Cria a pasta se não existir
        }
        
        try (PrintWriter writer = new PrintWriter(new FileWriter(new File(pasta, id + ".txt")))) {
            writer.println(nome + "," + cpf + "," + dataNascimento + "," + naturalidade + "," + senha + "," + salario + "," + telefone + "," + endereco);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void deletData() {
        String nomeArquivo = this.id;
        File pasta = new File("txtProfessores"); // Corrigido para o nome correto da pasta
        if (!pasta.exists()) {
            System.out.println("A pasta de professores não existe.");
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
