package com.mycompany.central;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class jifConsultaT extends javax.swing.JInternalFrame {

    private JTable table; // Tabela como atributo da classe

    public jifConsultaT() {
        initComponents();
        preencherTabela(); // Método para preencher a tabela
    }

    private void initComponents() {
        JLabel jLabel1 = new JLabel("Turmas");
        JButton jbVoltar = new JButton("Voltar");
        JButton jbSalvar = new JButton("Salvar");
        JButton jbExcluir = new JButton("Excluir");

        jbVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                dispose(); // Fecha a janela
            }
        });

        jbSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    Turma turma = Turma.getListaTurmas().get(i);
                    turma.setId((String) model.getValueAt(i, 0));
                    turma.setProfessorResponsavel((String) model.getValueAt(i, 1));
                    turma.setAnoLetivo((String) model.getValueAt(i, 2));
                    turma.setCapacidadeMaxima((Integer) model.getValueAt(i, 3));

                    // Salva os dados da turma no arquivo
                    turma.salvaData();
                }
                JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
            }
        });

        jbExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) { // Verifica se uma linha está selecionada
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    String turmaId = (String) model.getValueAt(selectedRow, 0); // Assumindo que o ID está na coluna 0
                    
                    // Remove a turma da lista e apaga o arquivo
                    Turma turma = Turma.getListaTurmas().get(selectedRow);
                    turma.deletData(); // Chama a função para deletar o arquivo
                    Turma.getListaTurmas().remove(selectedRow); // Remove a turma da lista
                    model.removeRow(selectedRow); // Remove a linha da tabela

                    JOptionPane.showMessageDialog(null, "Turma excluída com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione uma turma para excluir.");
                }
            }
        });

        // Tabela para exibir as turmas
        String[] columnNames = {"ID", "Professor Responsável", "Ano Letivo", "Capacidade Máxima", "Qt Alunos", "Renda"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Layout do JInternalFrame
        setLayout(new BorderLayout());
        add(jLabel1, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(jbSalvar);
        buttonPanel.add(jbExcluir);
        buttonPanel.add(jbVoltar);
        add(buttonPanel, BorderLayout.SOUTH);

        setBounds(0, 0, 800, 600);
    }

    private void preencherTabela() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        List<Turma> listaTurmas = Turma.getListaTurmas(); // Obtém a lista de turmas

        // Preenche a tabela com os dados das turmas
        for (Turma turma : listaTurmas) {
            Object[] rowData = {
                turma.getId(),
                turma.getProfessorResponsavel(),
                turma.getAnoLetivo(),
                turma.getCapacidadeMaxima(),
                turma.getQtAlunos(), // Exibe a quantidade de alunos
                turma.getRenda()
            };
            model.addRow(rowData); // Adiciona a linha na tabela
        }
    }
}
