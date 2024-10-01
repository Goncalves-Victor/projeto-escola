package com.mycompany.central;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class jifConsultaA extends javax.swing.JInternalFrame {

    private JTable table; // Tornar a tabela um atributo da classe

    public jifConsultaA() {
        initComponents();
        preencherTabela();
    }

    private void initComponents() {
        JLabel jLabel1 = new JLabel("Alunos");
        JButton jbVoltar = new JButton("Voltar");
        JButton jbSalvar = new JButton("Salvar");
        JButton jbExcluir = new JButton("Excluir"); // Novo botão de excluir

        jbVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                dispose();
            }
        });

        jbSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                for (int i = 0; i < model.getRowCount(); i++) {
                    Aluno aluno = Aluno.getListaAlunos().get(i);
                    aluno.setNome((String) model.getValueAt(i, 0));
                    aluno.setCpf((String) model.getValueAt(i, 1));
                    aluno.setDataNascimento((String) model.getValueAt(i, 2));
                    aluno.setNaturalidade((String) model.getValueAt(i, 3));
                    aluno.setTurma((String) model.getValueAt(i, 5)); // Assumindo que a turma está na coluna 5
                    aluno.setMensalidade((Double) model.getValueAt(i, 6));
                    aluno.setTelefone((String) model.getValueAt(i, 7));
                    aluno.setEndereco((String) model.getValueAt(i, 8));

                    // Salva os dados do aluno no arquivo
                    aluno.salvaData();
                }
                JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
            }
        });

        // Adiciona a ação ao botão de excluir
        jbExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) { // Verifica se uma linha está selecionada
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    String matricula = (String) model.getValueAt(selectedRow, 4); // Assumindo que a matrícula está na coluna 4
                    
                    // Remove o aluno da lista e apaga o arquivo
                    Aluno aluno = Aluno.getListaAlunos().get(selectedRow);
                    aluno.deletData(); // Chama a função para deletar o arquivo
                    Aluno.getListaAlunos().remove(selectedRow); // Remove o aluno da lista
                    model.removeRow(selectedRow); // Remove a linha da tabela

                    JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um aluno para excluir.");
                }
            }
        });

        // Tabela para exibir os alunos
        String[] columnNames = {"Nome", "CPF", "Data de Nascimento", "Naturalidade", "Matrícula", "Turma", "Mensalidade", "Telefone", "Endereço"};
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
        List<Aluno> listaAlunos = Aluno.getListaAlunos(); // Obtém a lista de alunos

        // Preenche a tabela com os dados dos alunos
        for (Aluno aluno : listaAlunos) {
            Object[] rowData = {
                aluno.getNome(),        
                aluno.getCpf(),         
                aluno.getDataNascimento(), 
                aluno.getNaturalidade(), 
                aluno.getMatricula(),   
                aluno.getTurma(),       
                aluno.getMensalidade(), 
                aluno.getTelefone(),    
                aluno.getEndereco()     
            };
            model.addRow(rowData); // Adiciona a linha na tabela
        }
    }
}
