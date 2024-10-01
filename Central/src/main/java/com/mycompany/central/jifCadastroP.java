package com.mycompany.central;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class jifCadastroP extends javax.swing.JInternalFrame {

    public jifCadastroP() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        NovoAction novoAction = new NovoAction();
        LimparAction limparAction = new LimparAction();
        VoltarAction voltarAction = new VoltarAction();
        SalvarAction salvarAction = new SalvarAction();

        jLabel1 = new javax.swing.JLabel();
        jtfNatu = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfCpf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfIdade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfTelefone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfEndereco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfSalario = new javax.swing.JTextField();

        jbVoltar = new javax.swing.JButton();
        jbSalvar = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbNovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Professor");
        getContentPane().setLayout(null);

        // Nome
        jLabel2.setText("Nome");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 20, 90, 16);
        getContentPane().add(jtfNome);
        jtfNome.setBounds(20, 40, 180, 22);

        // CPF
        jLabel3.setText("CPF");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 60, 80, 16);
        getContentPane().add(jtfCpf);
        jtfCpf.setBounds(20, 80, 180, 22);

        // Data de Nascimento
        jLabel4.setText("Data de Nascimento");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 100, 120, 16);
        getContentPane().add(jtfIdade);
        jtfIdade.setBounds(20, 120, 180, 22);

        // Naturalidade
        jLabel1.setText("Naturalidade");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 140, 110, 16);
        getContentPane().add(jtfNatu);
        jtfNatu.setBounds(20, 160, 180, 22);

        // Telefone
        jLabel5.setText("Telefone");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 180, 110, 16);
        getContentPane().add(jtfTelefone);
        jtfTelefone.setBounds(20, 200, 180, 22);

        // Endereço
        jLabel6.setText("Endereço");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 220, 110, 16);
        getContentPane().add(jtfEndereco);
        jtfEndereco.setBounds(20, 240, 180, 22);

        // Salário
        jLabel7.setText("Salário");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 260, 110, 16);
        getContentPane().add(jtfSalario);
        jtfSalario.setBounds(20, 280, 180, 22);

        // Botões
        jbVoltar.setText("Voltar");
        jbVoltar.addActionListener(voltarAction);
        getContentPane().add(jbVoltar);
        jbVoltar.setBounds(390, 350, 75, 23);

        jbSalvar.setText("Salvar");
        jbSalvar.addActionListener(salvarAction);
        getContentPane().add(jbSalvar);
        jbSalvar.setBounds(390, 310, 75, 23);

        jbLimpar.setText("Limpar");
        jbLimpar.addActionListener(limparAction);
        getContentPane().add(jbLimpar);
        jbLimpar.setBounds(70, 350, 75, 23);

        jbNovo.setText("Novo");
        jbNovo.addActionListener(novoAction);
        getContentPane().add(jbNovo);
        jbNovo.setBounds(70, 310, 72, 23);

        setBounds(0, 0, 548, 432);
    }

    private class VoltarAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            dispose();
        }
    }

    private class LimparAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            limparCampos();
        }
    }

    private class NovoAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            limparCampos();
        }
    }

    private class SalvarAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String nome = jtfNome.getText();
            String cpf = jtfCpf.getText();
            String dataNascimento = jtfIdade.getText();
            String naturalidade = jtfNatu.getText();
            String telefone = jtfTelefone.getText();
            String endereco = jtfEndereco.getText();
            double salario = 0;

            try {
                salario = Double.parseDouble(jtfSalario.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Salário inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validação básica dos campos
            if (nome.isEmpty() || cpf.isEmpty() || dataNascimento.isEmpty() || naturalidade.isEmpty() || telefone.isEmpty() || endereco.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Criar o objeto Professor e salvar
            Professor professor = new Professor("", nome, cpf, dataNascimento, naturalidade, salario, telefone, endereco);

            JOptionPane.showMessageDialog(null, "Professor salvo com sucesso!");
            limparCampos();
        }
    }

    private void limparCampos() {
        jtfNome.setText("");
        jtfCpf.setText("");
        jtfIdade.setText("");
        jtfNatu.setText("");
        jtfTelefone.setText("");
        jtfEndereco.setText("");
        jtfSalario.setText("");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new jifCadastroP().setVisible(true);
        });
    }

    // Variáveis de declaração
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JButton jbVoltar;
    private javax.swing.JTextField jtfCpf;
    private javax.swing.JTextField jtfIdade;
    private javax.swing.JTextField jtfNatu;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfTelefone;
    private javax.swing.JTextField jtfEndereco;
    private javax.swing.JTextField jtfSalario;
}
