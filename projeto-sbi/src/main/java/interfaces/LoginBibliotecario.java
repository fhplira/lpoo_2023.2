package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import controladores.BibliotecarioControlador;
import controladores.ExcecaoControlador;
import dados.ExcecaoDados;
import dados.ConexaoDados;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;


public class LoginBibliotecario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textEmail;
	private static ConexaoDados execucaoScript = new ConexaoDados();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginBibliotecario frame = new LoginBibliotecario();
					execucaoScript.criarBancoDados();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginBibliotecario() {
		setMaximumSize(new Dimension(2048, 2048));
		setMinimumSize(new Dimension(824, 510));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 510);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(824, 510));
		contentPane.setMaximumSize(new Dimension(2048, 2048));
		contentPane.setBackground(new Color(141, 197, 62));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{202, 272, 202, 0};
		gbl_contentPane.rowHeights = new int[]{448, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);




		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.weighty = 1.0;
		gbc_panel.weightx = 1.0;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;


		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{50, 206, 50, 0};
		gbl_panel.rowHeights = new int[]{59, 44, 44, 44, 44, 44, 44, 59};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel.setLayout(gbl_panel);

		JLabel lblBemVindo = new JLabel("Bem-vindo!");
		lblBemVindo.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_lblBemVindo = new GridBagConstraints();
		gbc_lblBemVindo.anchor = GridBagConstraints.SOUTH;
		gbc_lblBemVindo.insets = new Insets(0, 0, 5, 5);
		gbc_lblBemVindo.gridx = 1;
		gbc_lblBemVindo.gridy = 0;
		panel.add(lblBemVindo, gbc_lblBemVindo);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 2;
		panel.add(lblEmail, gbc_lblEmail);

		textEmail = new JTextField();
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textEmail.gridx = 1;
		gbc_textEmail.gridy = 3;
		panel.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 13));
		GridBagConstraints gbc_lblSenha = new GridBagConstraints();
		gbc_lblSenha.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblSenha.gridx = 1;
		gbc_lblSenha.gridy = 4;
		panel.add(lblSenha, gbc_lblSenha);

		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 5;
		panel.add(passwordField, gbc_passwordField);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String email = textEmail.getText();
				char[] senhaBibliotecario = passwordField.getPassword();
				String senha = String.valueOf(senhaBibliotecario);

				BibliotecarioControlador bibliotecario = new BibliotecarioControlador();

				try {
					bibliotecario.login(email, senha);
					dispose();
					new BotoesPrincipais().setVisible(true);

				} catch (ExcecaoControlador e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2){
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
				}


			}
		});


		GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.anchor = GridBagConstraints.SOUTH;
		gbc_btnEntrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEntrar.gridx = 1;
		gbc_btnEntrar.gridy = 6;
		panel.add(btnEntrar, gbc_btnEntrar);
	}

	/*public void criarBancoDados() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}


		String url = "jdbc:mysql://localhost:3306/";
		String usuario = "root";
		String senha = "root";


		try (Connection con = DriverManager.getConnection(url, usuario, senha); 
				Statement stmt = con.createStatement()) {

			String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS sib";
			try (Statement statement = con.createStatement()) {
				statement.executeUpdate(createDatabaseQuery);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Erro ao criar o banco de dados");
		} 

		try (Connection con = DriverManager.getConnection(url + "sib", usuario, senha); 
				Statement stmt = con.createStatement()) {

			InputStream inputStream = getClass().getResourceAsStream("/bd/sib-database.sql");
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			StringBuilder script = new StringBuilder();

			String linha;

			while ((linha = reader.readLine()) != null) {
				script.append(linha).append("\n");
			}

			String scriptSQL = script.toString();

			String[] queries = scriptSQL.split(";");

			try {
				for (String querie : queries) {
					if (!querie.trim().isEmpty()) {
						stmt.execute(querie);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Erro ao inserir dados no banco de dados");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}*/



}