package com.mycompany.central;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class jifCadastroF extends javax.swing.JInternalFrame {

    private JTextField txtNome, txtCpf, txtDataNascimento, txtNaturalidade, txtEndereco, txtTelefone, txtCargo, txtSalario, txtDataContratacao, txtTurno;
    private JButton jbVoltar, jbNovo, jbLimpar, jbSalvar;

    public jifCadastroF() {
        setTitle("Cadastro de Funcionário");
        setSize(600, 550);
        setResizable(true);
        setClosable(true);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(50, 40, 100, 25);
        add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(150, 40, 200, 25);
        add(txtNome);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(50, 80, 100, 25);
        add(lblCpf);

        txtCpf = new JTextField();
        txtCpf.setBounds(150, 80, 200, 25);
        add(txtCpf);

        JLabel lblDataNascimento = new JLabel("Data Nascimento:");
        lblDataNascimento.setBounds(50, 120, 120, 25);
        add(lblDataNascimento);

        txtDataNascimento = new JTextField();
        txtDataNascimento.setBounds(150, 120, 200, 25);
        add(txtDataNascimento);

        JLabel lblNaturalidade = new JLabel("Naturalidade:");
        lblNaturalidade.setBounds(50, 160, 100, 25);
        add(lblNaturalidade);

        txtNaturalidade = new JTextField();
        txtNaturalidade.setBounds(150, 160, 200, 25);
        add(txtNaturalidade);

        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(50, 200, 100, 25);
        add(lblEndereco);

        txtEndereco = new JTextField();
        txtEndereco.setBounds(150, 200, 200, 25);
        add(txtEndereco);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(50, 240, 100, 25);
        add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(150, 240, 200, 25);
        add(txtTelefone);

        JLabel lblCargo = new JLabel("Cargo:");
        lblCargo.setBounds(50, 280, 100, 25);
        add(lblCargo);

        txtCargo = new JTextField();
        txtCargo.setBounds(150, 280, 200, 25);
        add(txtCargo);

        JLabel lblSalario = new JLabel("Salário:");
        lblSalario.setBounds(50, 320, 100, 25);
        add(lblSalario);

        txtSalario = new JTextField();
        txtSalario.setBounds(150, 320, 200, 25);
        add(txtSalario);

        JLabel lblDataContratacao = new JLabel("Data Contratação:");
        lblDataContratacao.setBounds(50, 360, 120, 25);
        add(lblDataContratacao);

        txtDataContratacao = new JTextField();
        txtDataContratacao.setBounds(150, 360, 200, 25);
        add(txtDataContratacao);

        JLabel lblTurno = new JLabel("Turno:");
        lblTurno.setBounds(50, 400, 100, 25);
        add(lblTurno);

        txtTurno = new JTextField();
        txtTurno.setBounds(150, 400, 200, 25);
        add(txtTurno);

        jbSalvar = new JButton("Salvar");
        jbSalvar.setBounds(400, 100, 120, 30);
        jbSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                salvarFuncionario();
            }
        });
        add(jbSalvar);

        jbLimpar = new JButton("Limpar");
        jbLimpar.setBounds(400, 150, 120, 30);
        jbLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                limparCampos();
            }
        });
        add(jbLimpar);

        jbNovo = new JButton("Novo");
        jbNovo.setBounds(400, 200, 120, 30);
        jbNovo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                limparCampos();
            }
        });
        add(jbNovo);

        jbVoltar = new JButton("Voltar");
        jbVoltar.setBounds(400, 250, 120, 30);
        jbVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });
        add(jbVoltar);
    }

    private void salvarFuncionario() {
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String dataNascimento = txtDataNascimento.getText();
        String naturalidade = txtNaturalidade.getText();
        String endereco = txtEndereco.getText();
        String telefone = txtTelefone.getText();
        String cargo = txtCargo.getText();
        String dataContratacao = txtDataContratacao.getText();
        String turno = txtTurno.getText();
        double salario;

        try {
            salario = Double.parseDouble(txtSalario.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Salário inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Criar o objeto Funcionario e salvar
        Funcionario funcionario = new Funcionario(nome, cpf, dataNascimento, naturalidade, telefone, endereco, cargo, salario, dataContratacao, turno);
        Funcionario.getListaFuncionarios().add(funcionario);

        JOptionPane.showMessageDialog(this, "Funcionário salvo com sucesso!");
        limparCampos();
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCpf.setText("");
        txtDataNascimento.setText("");
        txtNaturalidade.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");
        txtCargo.setText("");
        txtSalario.setText("");
        txtDataContratacao.setText("");
        txtTurno.setText("");
    }
}
