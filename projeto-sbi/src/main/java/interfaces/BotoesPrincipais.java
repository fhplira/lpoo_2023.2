package interfaces;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import controladores.EmprestimoControlador;
import dados.ConexaoDados;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;

public class BotoesPrincipais extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static ConexaoDados metodoDeDados = new ConexaoDados();
	BotoesPrincipais frameBotoesPrincipais;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BotoesPrincipais frameBotoesPrincipais = new BotoesPrincipais();
					frameBotoesPrincipais.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BotoesPrincipais() {
		setMinimumSize(new Dimension(824, 510));
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 510);
		contentPane = new JPanel();
		contentPane.setFocusable(true);
		
		InputMap inputMap = contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK), "inserirDados");
        
        ActionMap actionMap = contentPane.getActionMap();
        actionMap.put("inserirDados", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                metodoDeDados.inserirDadosNoSistema();
            }
        });
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(141, 197, 62));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{275, 224, 226, 57, 0};
		gbl_contentPane.rowHeights = new int[]{59, 30, 36, 36, 36, 36, 36, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel tituloMenu = new JLabel("MENU");
		tituloMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_tituloMenu = new GridBagConstraints();
		gbc_tituloMenu.insets = new Insets(35, 0, 5, 5);
		gbc_tituloMenu.gridx = 1;
		gbc_tituloMenu.gridy = 0;
		contentPane.add(tituloMenu, gbc_tituloMenu);


		JButton botaoSair = new JButton("Sair");
		botaoSair.setFont(new Font("Tahoma", Font.BOLD, 13));

		botaoSair.setForeground(new Color(255, 0, 0));
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginBibliotecario().setVisible(true);
			}
		});
		GridBagConstraints gbc_botaoSair = new GridBagConstraints();
		gbc_botaoSair.anchor = GridBagConstraints.NORTHWEST;
		gbc_botaoSair.insets = new Insets(20, 0, 5, 10);
		gbc_botaoSair.gridx = 3;
		gbc_botaoSair.gridy = 0;
		contentPane.add(botaoSair, gbc_botaoSair);


		JButton botaoLivroExemplares = new JButton("Controle de Exemplares");
		botaoLivroExemplares.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botaoLivroExemplares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new ControleExemplares().setVisible(true);
			}
		});

		JButton botaoRealizarEmprestimo = new JButton("Realizar Empréstimo");
		botaoRealizarEmprestimo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botaoRealizarEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RealizarEmprestimo().setVisible(true);
			}
		});


		JButton btnNewButton = new JButton("Visualizar Leitor");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VisualizarLeitor().setVisible(true);
			}
		});

		JButton botaoCadastrarLeitor = new JButton("Cadastrar Leitor");
		botaoCadastrarLeitor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botaoCadastrarLeitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CadastrarLeitor().setVisible(true);

			}
		});

		JButton botaoCadastrarLivro = new JButton("Cadastrar Livro");
		botaoCadastrarLivro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botaoCadastrarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new CadastrarLivro().setVisible(true);
			}
		});

		JButton botaoTodosOsLivros = new JButton("Visualizar Livros");
		botaoTodosOsLivros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botaoTodosOsLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VisualizarLivros().setVisible(true);
			}
		});
		GridBagConstraints gbc_botaoTodosOsLivros = new GridBagConstraints();
		gbc_botaoTodosOsLivros.weightx = 1.0;
		gbc_botaoTodosOsLivros.fill = GridBagConstraints.BOTH;
		gbc_botaoTodosOsLivros.insets = new Insets(0, 0, 20, 5);
		gbc_botaoTodosOsLivros.gridx = 1;
		gbc_botaoTodosOsLivros.gridy = 2;
		contentPane.add(botaoTodosOsLivros, gbc_botaoTodosOsLivros);
		GridBagConstraints gbc_botaoCadastrarLivro = new GridBagConstraints();
		gbc_botaoCadastrarLivro.fill = GridBagConstraints.BOTH;
		gbc_botaoCadastrarLivro.insets = new Insets(0, 0, 20, 5);
		gbc_botaoCadastrarLivro.gridx = 1;
		gbc_botaoCadastrarLivro.gridy = 3;
		contentPane.add(botaoCadastrarLivro, gbc_botaoCadastrarLivro);
		GridBagConstraints gbc_botaoCadastrarLeitor = new GridBagConstraints();
		gbc_botaoCadastrarLeitor.fill = GridBagConstraints.BOTH;
		gbc_botaoCadastrarLeitor.insets = new Insets(0, 0, 20, 5);
		gbc_botaoCadastrarLeitor.gridx = 1;
		gbc_botaoCadastrarLeitor.gridy = 4;
		contentPane.add(botaoCadastrarLeitor, gbc_botaoCadastrarLeitor);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 20, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 5;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		GridBagConstraints gbc_botaoRealizarEmprestimo = new GridBagConstraints();
		gbc_botaoRealizarEmprestimo.fill = GridBagConstraints.BOTH;
		gbc_botaoRealizarEmprestimo.insets = new Insets(0, 0, 20, 5);
		gbc_botaoRealizarEmprestimo.gridx = 1;
		gbc_botaoRealizarEmprestimo.gridy = 6;
		contentPane.add(botaoRealizarEmprestimo, gbc_botaoRealizarEmprestimo);
		GridBagConstraints gbc_botaoLivroExemplares = new GridBagConstraints();
		gbc_botaoLivroExemplares.fill = GridBagConstraints.BOTH;
		gbc_botaoLivroExemplares.insets = new Insets(0, 0, 20, 5);
		gbc_botaoLivroExemplares.gridx = 1;
		gbc_botaoLivroExemplares.gridy = 7;
		contentPane.add(botaoLivroExemplares, gbc_botaoLivroExemplares);

		JButton botaoVisualizarEmprestimo = new JButton("Visualizar Empréstimos");
		botaoVisualizarEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VisualizarEmprestimos().setVisible(true);
			}
		});

		botaoVisualizarEmprestimo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_botaoVisualizarEmprestimo = new GridBagConstraints();
		gbc_botaoVisualizarEmprestimo.fill = GridBagConstraints.HORIZONTAL;
		gbc_botaoVisualizarEmprestimo.insets = new Insets(0, 0, 0, 5);
		gbc_botaoVisualizarEmprestimo.gridx = 1;
		gbc_botaoVisualizarEmprestimo.gridy = 8;
		contentPane.add(botaoVisualizarEmprestimo, gbc_botaoVisualizarEmprestimo);


	}

}
