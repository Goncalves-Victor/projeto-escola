package com.mycompany.central;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class jifConsultaP extends javax.swing.JInternalFrame {

    private JTable table; // Tornar a tabela um atributo da classe

    public jifConsultaP() {
        initComponents();
        preencherTabela();
    }

    private void initComponents() {
        JLabel jLabel1 = new JLabel("Professores");
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
                    Professor professor = Professor.getListaProfessores().get(i);
                    professor.setId((String) model.getValueAt(i, 0)); 
                    professor.setNome((String) model.getValueAt(i, 1));
                    professor.setCpf((String) model.getValueAt(i, 2));
                    professor.setDataNascimento((String) model.getValueAt(i, 3));
                    professor.setNaturalidade((String) model.getValueAt(i, 4));
                    professor.setSalario((Double) model.getValueAt(i, 5));
                    professor.setTelefone((String) model.getValueAt(i, 6));
                    professor.setEndereco((String) model.getValueAt(i, 7));

                    // Salva os dados do professor no arquivo
                    professor.salvaData();
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
                    String id = (String) model.getValueAt(selectedRow, 0); // ID é agora a primeira coluna
                    
                    // Remove o professor da lista e apaga o arquivo
                    Professor professor = Professor.getListaProfessores().get(selectedRow);
                    professor.deletData(); // Chama a função para deletar o arquivo
                    Professor.getListaProfessores().remove(selectedRow); // Remove o professor da lista
                    model.removeRow(selectedRow); // Remove a linha da tabela

                    JOptionPane.showMessageDialog(null, "Professor excluído com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um professor para excluir.");
                }
            }
        });

        // Tabela para exibir os professores
        String[] columnNames = {"ID", "Nome", "CPF", "Data de Nascimento", "Naturalidade", "Salário", "Telefone", "Endereço"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Layout do JInternalFrame
        setLayout(new BorderLayout());
        add(jLabel1, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(jbSalvar); // Adiciona o botão salvar ao painel
        buttonPanel.add(jbExcluir); // Adiciona o botão excluir ao painel
        buttonPanel.add(jbVoltar); // Adiciona o botão voltar ao painel
        add(buttonPanel, BorderLayout.SOUTH);

        setBounds(0, 0, 800, 600);
    }

    private void preencherTabela() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        List<Professor> listaProfessores = Professor.getListaProfessores(); // Obtém a lista de professores

        // Preenche a tabela com os dados dos professores
        for (Professor professor : listaProfessores) {
            Object[] rowData = {
                professor.getId(),           // ID agora é a primeira coluna
                professor.getNome(),        
                professor.getCpf(),         
                professor.getDataNascimento(), 
                professor.getNaturalidade(), 
                professor.getSalario(),    
                professor.getTelefone(),    
                professor.getEndereco()     
            };
            model.addRow(rowData); // Adiciona a linha na tabela
        }
    }
}
