package com.mycompany.central;

import java.io.*;
import java.util.*;

public class Funcionario extends Pessoa implements Data {
    private String cargo;
    private double salario;
    private String dataContratacao;
    private String turno;
    protected static List<Funcionario> listaFuncionarios = new ArrayList<>(); // Lista de funcionários
    private static int qtFuncionario;
    private String id;

    public Funcionario() {
        super();
    }

    static{
        qtFuncionario=0;
    }

    public Funcionario(String nome, String cpf, String dataNascimento, String naturalidade, String endereco, String telefone, 
                       String cargo, double salario, String dataContratacao, String turno) {
        super(nome, cpf, dataNascimento, naturalidade, telefone, endereco);
        this.cargo = cargo;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.turno = turno;
        qtFuncionario++;
        String sQtd = Integer.toString(qtFuncionario);
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < 4 - sQtd.length(); i++) {
            num.append("0");
        }
        num.append(qtFuncionario);
        this.id = num.toString();
        listaFuncionarios.add(this);
        salvaData(); // Salva os dados do funcionário ao criar um novo
    }
    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }

    public String getTurno() {
        return turno;
    }

    public String getId() {
        return id;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public static List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }
    // Método para carregar dados de funcionários a partir de arquivos de texto
    @Override
    public void setupData() {
        File pasta = new File("txtFuncionarios");
        if (!pasta.exists()) {
            pasta.mkdir(); // Cria a pasta se não existir
        }

        // Lê todos os arquivos na pasta
        for (File arquivo : pasta.listFiles()) {
            if (arquivo.isFile() && arquivo.getName().endsWith(".txt")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                    String linha = reader.readLine();
                    if (linha != null) {
                        Funcionario f = new Funcionario();
                        String[] data = linha.split(",");
                        
                        if (data.length >= 10) {  // Verifica se o arquivo contém todas as informações
                            f.nome = data[0];
                            f.cpf = data[1];
                            f.dataNascimento = data[2];
                            f.naturalidade = data[3];
                            f.endereco = data[4];
                            f.telefone = data[5];
                            f.cargo = data[6];
                            f.salario = Double.parseDouble(data[7]);
                            f.dataContratacao = data[8];
                            f.turno = data[9];
                            f.id = arquivo.getName().replace(".txt", "");
                            listaFuncionarios.add(f);
                            qtFuncionario++;
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

    // Método para salvar os dados de um funcionário em um arquivo de texto
    @Override
    public void salvaData() {
        File pasta = new File("txtFuncionarios");
        if (!pasta.exists()) {
            pasta.mkdir(); // Cria a pasta se não existir
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(new File(pasta, id + ".txt"), false))) {
            writer.println(nome + "," + cpf + "," + dataNascimento + "," + naturalidade + "," + endereco + "," + telefone + 
                           "," + cargo + "," + salario + "," + dataContratacao + "," + turno);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Método para deletar o arquivo de dados de um funcionário
    @Override
    public void deletData() {
        String arquivoNome=this.id;
        File pasta = new File("txtFuncionarios");
        File arquivo = new File(pasta, arquivoNome + ".txt");
        
        if (arquivo.exists()) {
            if (arquivo.delete()) {
                System.out.println("Arquivo " + arquivoNome + ".txt deletado com sucesso.");
            } else {
                System.out.println("Erro ao deletar o arquivo " + arquivoNome + ".txt.");
            }
        } else {
            System.out.println("Arquivo " + arquivoNome + ".txt não encontrado.");
        }
    }
}
