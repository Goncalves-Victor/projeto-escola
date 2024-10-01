package com.mycompany.central;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class jifCadastroT extends JInternalFrame {
    private JTextField txtProfessor;    // Campo para o nome do professor responsável
    private JTextField txtAnoLetivo;    // Campo para o ano letivo
    private JTextField txtCapacidade;    // Campo para a capacidade máxima
    private JButton btnSalvar;           // Botão para salvar a turma

    public jifCadastroT() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Cadastro de Turma");
        setSize(400, 250);
        setClosable(true);
        setResizable(true);
        setLayout(null);

        JLabel lblProfessor = new JLabel("Professor:");
        lblProfessor.setBounds(30, 60, 100, 25);
        add(lblProfessor);

        txtProfessor = new JTextField();
        txtProfessor.setBounds(150, 60, 200, 25);
        add(txtProfessor);

        JLabel lblAnoLetivo = new JLabel("Ano Letivo:");
        lblAnoLetivo.setBounds(30, 100, 100, 25);
        add(lblAnoLetivo);

        txtAnoLetivo = new JTextField();
        txtAnoLetivo.setBounds(150, 100, 200, 25);
        add(txtAnoLetivo);

        JLabel lblCapacidade = new JLabel("Capacidade:");
        lblCapacidade.setBounds(30, 140, 100, 25);
        add(lblCapacidade);

        txtCapacidade = new JTextField();
        txtCapacidade.setBounds(150, 140, 200, 25);
        add(txtCapacidade);

        btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(150, 180, 100, 25);
        add(btnSalvar);

        btnSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Cria a turma usando os dados dos campos
                    Turma turma = new Turma(
                        txtProfessor.getText(),
                        txtAnoLetivo.getText(),
                        Integer.parseInt(txtCapacidade.getText())
                    );

                    JOptionPane.showMessageDialog(null, "Turma salva com sucesso!");
                    dispose(); 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Capacidade deve ser um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
