package com.mycompany.central;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class jifConsultaF extends javax.swing.JInternalFrame {

    private JTable table; // Tornar a tabela um atributo da classe

    public jifConsultaF() {
        initComponents();
        preencherTabela();
    }

    private void initComponents() {
        JLabel jLabel1 = new JLabel("Funcionários");
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
                    Funcionario funcionario = Funcionario.getListaFuncionarios().get(i);
                    funcionario.setNome((String) model.getValueAt(i, 0));
                    funcionario.setCpf((String) model.getValueAt(i, 1));
                    funcionario.setDataNascimento((String) model.getValueAt(i, 2));
                    funcionario.setNaturalidade((String) model.getValueAt(i, 3));
                    funcionario.setEndereco((String) model.getValueAt(i, 4));
                    funcionario.setTelefone((String) model.getValueAt(i, 5));
                    funcionario.setCargo((String) model.getValueAt(i, 6));
                    funcionario.setSalario((Double) model.getValueAt(i, 7));
                    funcionario.setDataContratacao((String) model.getValueAt(i, 8));
                    funcionario.setTurno((String) model.getValueAt(i, 9));

                    // Salva os dados do funcionário no arquivo
                    funcionario.salvaData();
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
                    String id = (String) model.getValueAt(selectedRow, 10); // Assumindo que o ID está na coluna 10
                    
                    // Remove o funcionário da lista e apaga o arquivo
                    Funcionario funcionario = Funcionario.getListaFuncionarios().get(selectedRow);
                    funcionario.deletData(); // Chama a função para deletar o arquivo
                    Funcionario.getListaFuncionarios().remove(selectedRow); // Remove o funcionário da lista
                    model.removeRow(selectedRow); // Remove a linha da tabela

                    JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecione um funcionário para excluir.");
                }
            }
        });

        // Tabela para exibir os funcionários
        String[] columnNames = {"Nome", "CPF", "Data de Nascimento", "Naturalidade", "Endereço", "Telefone", "Cargo", "Salário", "Data de Contratação", "Turno", "ID"};
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
        List<Funcionario> listaFuncionarios = Funcionario.getListaFuncionarios(); // Obtém a lista de funcionários

        // Preenche a tabela com os dados dos funcionários
        for (Funcionario funcionario : listaFuncionarios) {
            Object[] rowData = {
                funcionario.getNome(),        
                funcionario.getCpf(),         
                funcionario.getDataNascimento(), 
                funcionario.getNaturalidade(), 
                funcionario.getEndereco(),   
                funcionario.getTelefone(),       
                funcionario.getCargo(), 
                funcionario.getSalario(), 
                funcionario.getDataContratacao(),
                funcionario.getTurno(),
                funcionario.getId()   // Assumindo que o ID é acessível através do método getId()
            };
            model.addRow(rowData); // Adiciona a linha na tabela
        }
    }
}
