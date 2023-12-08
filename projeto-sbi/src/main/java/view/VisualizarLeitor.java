package view;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.ExcecaoControlador;
import controladores.LeitorControlador;

import javax.swing.JScrollPane;
import modelos.LeitorModelo;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VisualizarLeitor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCpf;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEmprestimosAtivos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarLeitor frame = new VisualizarLeitor();
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
	public VisualizarLeitor() {
		final LeitorControlador controlador = new LeitorControlador();
		final JButton btnEditarDados = new JButton("Editar dados");
		final JButton btnAtualizarDados = new JButton("Atualizar dados");
		final String cpf = txtCpf.getText();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 689, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(141, 197, 62));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{151, 474, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 373, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Visualizar Leitores");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 4;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BotoesPrincipais().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnVoltar = new GridBagConstraints();
		gbc_btnVoltar.insets = new Insets(0, 0, 5, 0);
		gbc_btnVoltar.gridx = 3;
		gbc_btnVoltar.gridy = 1;
		contentPane.add(btnVoltar, gbc_btnVoltar);
		
		JLabel lblCpf = new JLabel("Digite o CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.anchor = GridBagConstraints.EAST;
		gbc_lblCpf.insets = new Insets(0, 0, 20, 5);
		gbc_lblCpf.gridx = 0;
		gbc_lblCpf.gridy = 2;
		contentPane.add(lblCpf, gbc_lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtCpf = new GridBagConstraints();
		gbc_txtCpf.insets = new Insets(0, 0, 20, 5);
		gbc_txtCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCpf.gridx = 1;
		gbc_txtCpf.gridy = 2;
		contentPane.add(txtCpf, gbc_txtCpf);
		txtCpf.setColumns(10);
		
		JButton btnBuscarLeitor = new JButton("Buscar Leitor");
		btnBuscarLeitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LeitorModelo leitor = controlador.buscarLeitorPorCpf(cpf);
					
					txtNome.setText(leitor.getNome());
					txtEmail.setText(leitor.getEmail());
					txtEmprestimosAtivos.setText("" + leitor.getEmprestimo());
					
					btnEditarDados.setEnabled(true);
					
				} catch (ExcecaoControlador e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
					exc.printStackTrace();
				}
				
			}
		});
		btnBuscarLeitor.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnBuscarLeitor = new GridBagConstraints();
		gbc_btnBuscarLeitor.insets = new Insets(0, 0, 20, 5);
		gbc_btnBuscarLeitor.gridx = 1;
		gbc_btnBuscarLeitor.gridy = 3;
		contentPane.add(btnBuscarLeitor, gbc_btnBuscarLeitor);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 10, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 4;
		contentPane.add(lblNome, gbc_lblNome);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.insets = new Insets(0, 0, 10, 5);
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 4;
		contentPane.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 10, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 5;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.anchor = GridBagConstraints.NORTH;
		gbc_txtEmail.insets = new Insets(0, 0, 10, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 5;
		contentPane.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblEmprestimos = new JLabel("Empréstimos ativos:");
		lblEmprestimos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblEmprestimos = new GridBagConstraints();
		gbc_lblEmprestimos.anchor = GridBagConstraints.EAST;
		gbc_lblEmprestimos.insets = new Insets(0, 0, 100, 5);
		gbc_lblEmprestimos.gridx = 0;
		gbc_lblEmprestimos.gridy = 6;
		contentPane.add(lblEmprestimos, gbc_lblEmprestimos);
		
		txtEmprestimosAtivos = new JTextField();
		txtEmprestimosAtivos.setEditable(false);
		txtEmprestimosAtivos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtEmprestimosAtivos = new GridBagConstraints();
		gbc_txtEmprestimosAtivos.insets = new Insets(0, 0, 100, 5);
		gbc_txtEmprestimosAtivos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmprestimosAtivos.gridx = 1;
		gbc_txtEmprestimosAtivos.gridy = 6;
		contentPane.add(txtEmprestimosAtivos, gbc_txtEmprestimosAtivos);
		txtEmprestimosAtivos.setColumns(10);
		
		btnEditarDados.setEnabled(false);
		btnEditarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					txtNome.setEditable(true);
					txtEmail.setEditable(true);
					btnAtualizarDados.setEnabled(true);
			}
		});
		btnEditarDados.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnEditarDados = new GridBagConstraints();
		gbc_btnEditarDados.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditarDados.gridx = 0;
		gbc_btnEditarDados.gridy = 7;
		contentPane.add(btnEditarDados, gbc_btnEditarDados);
		
		btnAtualizarDados.setEnabled(false);
		btnAtualizarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = txtEmail.getText();
				String nome = txtNome.getText();
				
				try {
					LeitorModelo leitor = controlador.buscarLeitorPorCpf(cpf);
					if(!email.isBlank()) {
						controlador.atualizarEmailLeitor(leitor, email);
					}
					if(!nome.isBlank()) {
						controlador.atualizarNomeLeitor(leitor, nome);
					}
				} catch (ExcecaoControlador e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
					exc.printStackTrace();
				}
				
			}
		});
		btnAtualizarDados.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnAtualizarDados = new GridBagConstraints();
		gbc_btnAtualizarDados.gridwidth = 2;
		gbc_btnAtualizarDados.insets = new Insets(0, 0, 5, 5);
		gbc_btnAtualizarDados.gridx = 2;
		gbc_btnAtualizarDados.gridy = 7;
		contentPane.add(btnAtualizarDados, gbc_btnAtualizarDados);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		
	
	}
}
