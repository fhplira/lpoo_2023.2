package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controladores.BibliotecarioControlador;
import controladores.ExcecaoControlador;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class LoginBibliotecario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginBibliotecario frame = new LoginBibliotecario();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(141, 197, 62));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(202, 11, 404, 448);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{50, 206, 50, 0};
		gbl_panel.rowHeights = new int[]{108, 0, 50, 50, 50, 50, 64, 64, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblBemVindo = new JLabel("Bem-vindo!");
		lblBemVindo.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_lblBemVindo = new GridBagConstraints();
		gbc_lblBemVindo.insets = new Insets(0, 0, 5, 5);
		gbc_lblBemVindo.gridx = 1;
		gbc_lblBemVindo.gridy = 0;
		panel.add(lblBemVindo, gbc_lblBemVindo);
		
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
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
		gbc_lblSenha.anchor = GridBagConstraints.WEST;
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
				
				String emailBibliotecario = textEmail.getText();
				char[] senhaBibliotecario = passwordField.getPassword();
				String senha = String.valueOf(senhaBibliotecario);
				
				BibliotecarioControlador controlador = new BibliotecarioControlador();
				
				try {
					controlador.login(emailBibliotecario, senha);
				} catch (ExcecaoControlador e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2){
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				LoginBibliotecario loginBibliotecario = new LoginBibliotecario();
				loginBibliotecario.dispose();
				BotoesPrincipais botoesPrincipais = new BotoesPrincipais();
				botoesPrincipais.setVisible(true);
			}
		});
		
		
		GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEntrar.gridx = 1;
		gbc_btnEntrar.gridy = 6;
		panel.add(btnEntrar, gbc_btnEntrar);
	}
}
