package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.ExcecaoControlador;
import controladores.LeitorControlador;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class CadastrarLeitor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCpf;
	CadastrarLeitor frameCadastrarLeitor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarLeitor frameCadastrarLeitor = new CadastrarLeitor();
					frameCadastrarLeitor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastrarLeitor() {
		setMaximumSize(new Dimension(2048, 2048));
		setMinimumSize(new Dimension(824, 510));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(141, 197, 62));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0};
		gbl_contentPane.rowHeights = new int[]{0};
		gbl_contentPane.columnWeights = new double[]{1.0};
		gbl_contentPane.rowWeights = new double[]{1.0};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {162, 393, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblTitulo = new JLabel("CADASTRAR LEITOR");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.gridwidth = 2;
		gbc_lblTitulo.insets = new Insets(30, 50, 60, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		panel.add(lblTitulo, gbc_lblTitulo);
		
		JButton botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BotoesPrincipais().setVisible(true);
			}
		});
		
		botaoVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_botaoVoltar = new GridBagConstraints();
		gbc_botaoVoltar.insets = new Insets(30, 0, 60, 5);
		gbc_botaoVoltar.gridx = 2;
		gbc_botaoVoltar.gridy = 0;
		panel.add(botaoVoltar, gbc_botaoVoltar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 50, 10, 5);
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 2;
		panel.add(lblNome, gbc_lblNome);
		
		txtNome = new JTextField();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.insets = new Insets(0, 0, 10, 50);
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 2;
		panel.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 50, 10, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 3;
		panel.add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.insets = new Insets(0, 0, 10, 50);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 3;
		panel.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblCPF = new GridBagConstraints();
		gbc_lblCPF.anchor = GridBagConstraints.EAST;
		gbc_lblCPF.insets = new Insets(0, 50, 10, 5);
		gbc_lblCPF.gridx = 0;
		gbc_lblCPF.gridy = 4;
		panel.add(lblCPF, gbc_lblCPF);
		
		txtCpf = new JTextField();
		GridBagConstraints gbc_txtCpf = new GridBagConstraints();
		gbc_txtCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCpf.insets = new Insets(0, 0, 10, 50);
		gbc_txtCpf.gridx = 1;
		gbc_txtCpf.gridy = 4;
		panel.add(txtCpf, gbc_txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = txtNome.getText();
				String email = txtEmail.getText();
				String cpf = txtCpf.getText();
				
				LeitorControlador controlador = new LeitorControlador();
				
				try {
					controlador.cadastrarLeitor(nome, cpf, email);
					JOptionPane.showMessageDialog(null, "O leitor foi cadastrado com sucesso.", "Success", JOptionPane.INFORMATION_MESSAGE);
				} catch (ExcecaoControlador e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.gridwidth = 2;
		gbc_btnCadastrar.insets = new Insets(20, 50, 60, 5);
		gbc_btnCadastrar.gridx = 0;
		gbc_btnCadastrar.gridy = 5;
		panel.add(btnCadastrar, gbc_btnCadastrar);
	}
}
