package com.mycompany.central;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class jifCadastroA extends javax.swing.JInternalFrame {

    private JTextField jtNome, jtCpf, jtIdade, jtNatu, jtTurma, jtMensalidade, jtTelefone, jtEndereco;
    private JButton jbVoltar, jbNovo, jbLimpar, jbSalvar;

    public jifCadastroA() {
        initComponents();
        setClosable(true);
    }

    private void initComponents() {
        JLabel jLabel1 = new JLabel("CPF");
        JLabel jLabel2 = new JLabel("Idade");
        JLabel jLabel3 = new JLabel("Naturalidade");
        JLabel jLabel4 = new JLabel("Nome");
        JLabel jLabel5 = new JLabel("Turma");
        JLabel jLabel6 = new JLabel("Mensalidade");
        JLabel jLabel7 = new JLabel("Telefone");
        JLabel jLabel8 = new JLabel("Endereço");

        jtCpf = new JTextField();
        jtNome = new JTextField();
        jtNatu = new JTextField();
        jtIdade = new JTextField();
        jtTurma = new JTextField();
        jtMensalidade = new JTextField();
        jtTelefone = new JTextField();
        jtEndereco = new JTextField();

        jbVoltar = new JButton("Voltar");
        jbNovo = new JButton("Novo");
        jbLimpar = new JButton("Limpar");
        jbSalvar = new JButton("Salvar");

        ActionSalvar actionSalvar = new ActionSalvar();
        ActionNovo actionNovo = new ActionNovo();
        ActionLimpar actionLimpar = new ActionLimpar();
        ActionVoltar actionVoltar = new ActionVoltar();

        setTitle("Cadastro Aluno");
        getContentPane().setLayout(null);

        // Labels e campos de entrada
        jLabel1.setBounds(50, 160, 50, 20);
        jLabel2.setBounds(50, 80, 70, 20);
        jLabel3.setBounds(50, 120, 100, 20);
        jLabel4.setBounds(50, 40, 70, 20);
        jLabel5.setBounds(50, 200, 90, 20);
        jLabel6.setBounds(50, 240, 90, 20);
        jLabel7.setBounds(50, 280, 90, 20);  // "Telefone" label
        jLabel8.setBounds(50, 320, 90, 20);  // "Endereço" label

        jtCpf.setBounds(50, 180, 240, 25);
        jtNome.setBounds(50, 60, 240, 25);
        jtNatu.setBounds(50, 140, 240, 25);
        jtIdade.setBounds(50, 100, 240, 25);
        jtTurma.setBounds(50, 220, 240, 25);
        jtMensalidade.setBounds(50, 260, 240, 25);
        jtTelefone.setBounds(50, 300, 240, 25);  // Campo "Telefone"
        jtEndereco.setBounds(50, 340, 240, 25);  // Campo "Endereço"

        // Botões
        jbVoltar.setBounds(390, 380, 72, 23);
        jbNovo.setBounds(70, 380, 72, 23);
        jbLimpar.setBounds(70, 420, 72, 23);
        jbSalvar.setBounds(390, 420, 72, 23);

        jbVoltar.addActionListener(actionVoltar);
        jbNovo.addActionListener(actionNovo);
        jbLimpar.addActionListener(actionLimpar);
        jbSalvar.addActionListener(actionSalvar);

        // Adicionando os componentes
        getContentPane().add(jLabel1);
        getContentPane().add(jLabel2);
        getContentPane().add(jLabel3);
        getContentPane().add(jLabel4);
        getContentPane().add(jLabel5);
        getContentPane().add(jLabel6);
        getContentPane().add(jLabel7);
        getContentPane().add(jLabel8);
        getContentPane().add(jtCpf);
        getContentPane().add(jtNome);
        getContentPane().add(jtNatu);
        getContentPane().add(jtIdade);
        getContentPane().add(jtTurma);
        getContentPane().add(jtMensalidade);
        getContentPane().add(jtTelefone);
        getContentPane().add(jtEndereco);
        getContentPane().add(jbVoltar);
        getContentPane().add(jbNovo);
        getContentPane().add(jbLimpar);
        getContentPane().add(jbSalvar);

        setBounds(0, 0, 581, 500);
    }

    private class ActionLimpar implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            jtNome.setText("");
            jtCpf.setText("");
            jtIdade.setText("");
            jtNatu.setText("");
            jtTurma.setText("");
            jtMensalidade.setText("");
            jtTelefone.setText("");
            jtEndereco.setText("");
        }
    }

    private class ActionVoltar implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            dispose();
        }
    }

    private class ActionSalvar implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String nome = jtNome.getText();
            String cpf = jtCpf.getText();
            String dataNascimento = jtIdade.getText();
            String naturalidade = jtNatu.getText();
            String turma = jtTurma.getText();
            String telefone = jtTelefone.getText();
            String endereco = jtEndereco.getText();
            double mensalidade;

            try {
                mensalidade = Double.parseDouble(jtMensalidade.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Mensalidade inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Criar o objeto Aluno e salvar
            Aluno aluno = new Aluno(nome, cpf, dataNascimento, naturalidade, turma, mensalidade, telefone, endereco);

            JOptionPane.showMessageDialog(null, "Aluno salvo com sucesso!");
            limparCampos();
        }
    }

    private class ActionNovo implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            jtNome.setText("");
            jtCpf.setText("");
            jtIdade.setText("");
            jtNatu.setText("");
            jtTurma.setText("");
            jtMensalidade.setText("");
            jtTelefone.setText("");
            jtEndereco.setText("");
        }
    }

    private void limparCampos() {
        jtNome.setText("");
        jtCpf.setText("");
        jtIdade.setText("");
        jtNatu.setText("");
        jtTurma.setText("");
        jtMensalidade.setText("");
        jtTelefone.setText("");
        jtEndereco.setText("");
    }
}
