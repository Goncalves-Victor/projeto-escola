package com.mycompany.central;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class Principal extends javax.swing.JFrame {
    private Escola escola;

    public Principal() {
        initComponents();
        // Inicialmente ocultar a barra de menu
        setJMenuBar(null);
        // Inicializar a escola e exibir suas informações
        escola = new Escola();
        exibirInformacoesEscola();
        // Chamar o método de login
        login();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jdLogin = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmiProfessor = new javax.swing.JMenu();
        jmiFuncionario = new javax.swing.JMenu();
        cadastrarP = new javax.swing.JMenuItem();
        consultarP = new javax.swing.JMenuItem();
        cadastrarF = new javax.swing.JMenuItem();
        consultarF = new javax.swing.JMenuItem();
        jmAluno = new javax.swing.JMenu();
        cadastrarA = new javax.swing.JMenuItem();
        consultarDadosA = new javax.swing.JMenuItem();
        jmTurma = new javax.swing.JMenu(); // Menu para Turmas
        cadastrarT = new javax.swing.JMenuItem(); // Item para cadastrar turma
        consultarT = new javax.swing.JMenuItem(); // Item para consultar turma

        // Labels para exibir informações da escola
        jLabelSalarios = new javax.swing.JLabel("Salários:");
        jLabelMensalidades = new javax.swing.JLabel("Mensalidades:");
        jLabelValorSalarios = new javax.swing.JLabel(); // Valor dos salários
        jLabelValorMensalidades = new javax.swing.JLabel(); // Valor das mensalidades

        // Botão para atualizar as informações
        jbAtualizar = new javax.swing.JButton("Atualizar");

        // Aumentar a fonte dos labels
        Font font = new Font("Arial", Font.BOLD, 16);
        jLabelSalarios.setFont(font);
        jLabelMensalidades.setFont(font);
        jLabelValorSalarios.setFont(font);
        jLabelValorMensalidades.setFont(font);
        jbAtualizar.setFont(font);

        // Ações
        ActionCadastrarP actionCadastrarP = new ActionCadastrarP();
        ActionCadastrarF actionCadastrarF = new ActionCadastrarF();
        ActionCadastrarA actionCadastrarA = new ActionCadastrarA();
        ActionCadastrarT actionCadastrarT = new ActionCadastrarT();
        ActionConsultaA actionConsultaA = new ActionConsultaA();
        ActionConsultaP actionConsultaP = new ActionConsultaP();
        ActionConsultaF actionConsultaF = new ActionConsultaF();
        ActionConsultaT actionConsultaT = new ActionConsultaT(); // Ação para consulta de turma

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Escola");
        getContentPane().setLayout(null);

        // Adicionar componentes para exibir informações da escola
        jLabelSalarios.setBounds(20, 20, 150, 25);
        jLabelValorSalarios.setBounds(180, 20, 200, 25);
        
        jLabelMensalidades.setBounds(20, 60, 150, 25);
        jLabelValorMensalidades.setBounds(180, 60, 200, 25);

        // Adicionar o botão "Atualizar"
        jbAtualizar.setBounds(400, 40, 120, 30);
        jbAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarValores(); // Atualiza os valores da escola
                exibirInformacoesEscola(); // Atualiza os valores das informações na interface
            }
        });

        jdLogin.add(jLabelSalarios);
        jdLogin.add(jLabelValorSalarios);
        jdLogin.add(jLabelMensalidades);
        jdLogin.add(jLabelValorMensalidades);
        jdLogin.add(jbAtualizar); // Adiciona o botão ao painel

        getContentPane().add(jdLogin);
        jdLogin.setBounds(0, 0, 1120, 720);

        // Menu de Professores
        jmiProfessor.setText("Professor");
        cadastrarP.setText("Cadastrar");
        cadastrarP.addActionListener(actionCadastrarP);
        jmiProfessor.add(cadastrarP);

        consultarP.setText("Consultar");
        consultarP.addActionListener(actionConsultaP);
        jmiProfessor.add(consultarP);
        jMenuBar1.add(jmiProfessor);

        // Menu de Alunos
        jmAluno.setText("Aluno");
        cadastrarA.setText("Cadastrar");
        cadastrarA.addActionListener(actionCadastrarA);
        jmAluno.add(cadastrarA);

        consultarDadosA.setText("Consultar");
        consultarDadosA.addActionListener(actionConsultaA);
        jmAluno.add(consultarDadosA);
        jMenuBar1.add(jmAluno);

        // Menu de Funcionários
        jmiFuncionario.setText("Funcionários");
        cadastrarF.setText("Cadastrar");
        cadastrarF.addActionListener(actionCadastrarF);
        jmiFuncionario.add(cadastrarF);

        consultarF.setText("Consultar");
        consultarF.addActionListener(actionConsultaF);
        jmiFuncionario.add(consultarF);
        jMenuBar1.add(jmiFuncionario);

        // Menu de Turmas
        jmTurma.setText("Turmas");
        cadastrarT.setText("Cadastrar");
        cadastrarT.addActionListener(actionCadastrarT);
        jmTurma.add(cadastrarT);

        consultarT.setText("Consultar");
        consultarT.addActionListener(actionConsultaT);
        jmTurma.add(consultarT);
        jMenuBar1.add(jmTurma);

        setJMenuBar(jMenuBar1);
        setBounds(0, 0, 1120, 720);
    }

    private void atualizarValores() {
        // Atualiza os valores da escola, recarregando os valores de mensalidades e salários
        escola = new Escola(); // Recria a instância da escola para recalcular os valores
    }

    private void exibirInformacoesEscola() {
        jLabelValorSalarios.setText(String.format("R$ %.2f", escola.getValSalarios()));
        jLabelValorMensalidades.setText(String.format("R$ %.2f", escola.getValMensalidades()));
    }

    private void login() {
        // Diálogo de login
        JPanel panel = new JPanel();
        JLabel labelUser = new JLabel("Usuário:");
        JLabel labelPass = new JLabel("Senha:");
        JTextField userField = new JTextField(15);
        JPasswordField passField = new JPasswordField(15);

        panel.add(labelUser);
        panel.add(userField);
        panel.add(labelPass);
        panel.add(passField);

        int option = JOptionPane.showConfirmDialog(this, panel, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            // Verifica as credenciais
            if ("admin".equals(user) && "123".equals(pass)) {
                setJMenuBar(jMenuBar1); // Exibe a barra de menus
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos.", "Erro de Login", JOptionPane.ERROR_MESSAGE);
                System.exit(0); // Encerra o aplicativo se as credenciais estiverem incorretas
            }
        } else {
            System.exit(0); // Encerra o aplicativo se o usuário cancelar
        }
    }

    private class ActionCadastrarF implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            jifCadastroF obj = new jifCadastroF(); // Certifique-se de que essa classe está definida
            jdLogin.add(obj);
            obj.setVisible(true);
        }
    }

    private class ActionCadastrarP implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            jifCadastroP obj = new jifCadastroP(); // Certifique-se de que essa classe está definida
            jdLogin.add(obj);
            obj.setVisible(true);
        }
    }

    private class ActionCadastrarA implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            jifCadastroA obj = new jifCadastroA(); // Certifique-se de que essa classe está definida
            jdLogin.add(obj);
            obj.setVisible(true);
        }
    }

    private class ActionCadastrarT implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            jifCadastroT obj = new jifCadastroT(); // Certifique-se de que essa classe está definida
            jdLogin.add(obj);
            obj.setVisible(true);
        }
    }

    private class ActionConsultaA implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            jifConsultaA obj = new jifConsultaA(); // Certifique-se de que essa classe está definida
            jdLogin.add(obj);
            obj.setVisible(true);
        }
    }

    private class ActionConsultaP implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            jifConsultaP obj = new jifConsultaP(); // Certifique-se de que essa classe está definida
            jdLogin.add(obj);
            obj.setVisible(true);
        }
    }

    private class ActionConsultaF implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            jifConsultaF obj = new jifConsultaF(); // Certifique-se de que essa classe está definida
            jdLogin.add(obj);
            obj.setVisible(true);
        }
    }

    private class ActionConsultaT implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            jifConsultaT obj = new jifConsultaT(); // Certifique-se de que essa classe está definida
            jdLogin.add(obj);
            obj.setVisible(true);
        }
    }

    public static void main(String args[]) {
        // Inicialização dos dados
    
        Professor p = new Professor();
        p.setupData();

        Aluno a = new Aluno();
        a.setupData();

        Funcionario f = new Funcionario();
        f.setupData();

        Turma t = new Turma();
        t.setupData();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new Principal().setVisible(true));
    }

    // Variáveis de instância
    private javax.swing.JDesktopPane jdLogin;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmiProfessor;
    private javax.swing.JMenu jmiFuncionario;
    private javax.swing.JMenu jmAluno;
    private javax.swing.JMenu jmTurma;
    private javax.swing.JMenuItem cadastrarP;
    private javax.swing.JMenuItem consultarP;
    private javax.swing.JMenuItem cadastrarF;
    private javax.swing.JMenuItem consultarF;
    private javax.swing.JMenuItem cadastrarA;
    private javax.swing.JMenuItem consultarDadosA;
    private javax.swing.JMenuItem cadastrarT; // Item para cadastrar turma
    private javax.swing.JMenuItem consultarT; // Item para consultar turma
    private javax.swing.JLabel jLabelSalarios;
    private javax.swing.JLabel jLabelMensalidades;
    private javax.swing.JLabel jLabelValorSalarios;
    private javax.swing.JLabel jLabelValorMensalidades;
    private javax.swing.JButton jbAtualizar; // Botão para atualizar informações
}
