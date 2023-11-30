package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;

public class BotoesPrincipais extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 510);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(141, 197, 62));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton botaoTodosOsLivros = new JButton("Visualizar Livros");
		botaoTodosOsLivros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botaoTodosOsLivros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoTodosOsLivros.setBounds(275, 95, 224, 36);
		contentPane.add(botaoTodosOsLivros);
		
		JButton botaoCadastrarLivro = new JButton("Cadastrar Livro");
		botaoCadastrarLivro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botaoCadastrarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BotoesPrincipais botoesPrincipais = new BotoesPrincipais();
				botoesPrincipais.dispose();
				botoesPrincipais.setVisible(false);
				new CadastrarLivro().setVisible(true);
			}
		});
		botaoCadastrarLivro.setBounds(275, 153, 224, 36);
		contentPane.add(botaoCadastrarLivro);
		
		JButton botaoCadastrarLeitor = new JButton("Cadastrar Leitor");
		botaoCadastrarLeitor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botaoCadastrarLeitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		botaoCadastrarLeitor.setBounds(275, 211, 224, 36);
		contentPane.add(botaoCadastrarLeitor);
		
		JButton botaoRealizarEmprestimo = new JButton("Realizar Emprestimo");
		botaoRealizarEmprestimo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botaoRealizarEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BotoesPrincipais botoesPrincipais = new BotoesPrincipais();
				botoesPrincipais.dispose();
				botoesPrincipais.setVisible(false);
				new RealizarEmprestimo().setVisible(true);
			}
		});
		botaoRealizarEmprestimo.setBounds(275, 328, 224, 36);
		contentPane.add(botaoRealizarEmprestimo);

		
		JButton botaoLivroExemplares = new JButton("Controle de Exemplares");
		botaoLivroExemplares.setFont(new Font("Tahoma", Font.PLAIN, 13));
		botaoLivroExemplares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BotoesPrincipais botoesPrincipais = new BotoesPrincipais();
				botoesPrincipais.dispose();
				botoesPrincipais.setVisible(false);
				new ControleExemplares().setVisible(true);
			}
		});
		botaoLivroExemplares.setBounds(275, 385, 224, 36);
		contentPane.add(botaoLivroExemplares);
		
		JLabel tituloMenu = new JLabel("MENU");
		tituloMenu.setFont(new Font("Tahoma", Font.BOLD, 30));
		tituloMenu.setBounds(334, 22, 101, 48);
		contentPane.add(tituloMenu);
		
		
		JButton btnNewButton = new JButton("Visualizar Leitor");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(275, 270, 224, 36);
		contentPane.add(btnNewButton);
		
		
	JButton botaoSair = new JButton("Sair");
	botaoSair.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		botaoSair.setForeground(new Color(255, 0, 0));
		botaoSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BotoesPrincipais botoesPrincipais = new BotoesPrincipais();
				botoesPrincipais.dispose();
				botoesPrincipais.setVisible(false);
				new LoginBibliotecario().setVisible(true);
			}
		});
		botaoSair.setBounds(725, 11, 57, 36);
		contentPane.add(botaoSair);
		
		
	}

}
