package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.EmprestimoControlador;
import controladores.ExcecaoControlador;
import controladores.LeitorControlador;
import modelos.LeitorModelo;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VisualizarEmprestimo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEmpretimoCpf;
	private JTextField textField_6NomeLeitor;
	private JTextField textField_CpfLeitor;
	private JTextField textField_ISBNLivro1;
	private JTextField textField_TituloLivro;
	private JTextField textFieldDataEmprestimo1;
	private JTextField textFielDataDevolucao1;
	private JTextField textFieldDiasAtrasados1;
	private JTextField textField_ISBN2;
	private JTextField textFieldTituloLivro2;
	private JTextField textFieldDataEmprestimo2;
	private JTextField textFieldDataDevolucao2;
	private JTextField textFieldDiasAtrasados2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarEmprestimo frame = new VisualizarEmprestimo();
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
	public VisualizarEmprestimo() {
		
		LeitorControlador leitorControlador = new LeitorControlador();
		EmprestimoControlador emprestimoControlador = new EmprestimoControlador();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 490);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(141, 197, 62));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{35, 761, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{137, 0, 0, 10, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 4;
		gbc_panel.gridheight = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnNewButton = new JButton("VOLTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BotoesPrincipais().setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(10, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JLabel viasualizarEmprestimos = new JLabel("Visualizar Emprestimo");
		viasualizarEmprestimos.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_viasualizarEmprestimos = new GridBagConstraints();
		gbc_viasualizarEmprestimos.insets = new Insets(15, 0, 5, 0);
		gbc_viasualizarEmprestimos.anchor = GridBagConstraints.SOUTH;
		gbc_viasualizarEmprestimos.gridwidth = 13;
		gbc_viasualizarEmprestimos.gridx = 0;
		gbc_viasualizarEmprestimos.gridy = 1;
		panel.add(viasualizarEmprestimos, gbc_viasualizarEmprestimos);
		
		JLabel JlabelBuascarCPF = new JLabel("Buscar emprestimo por CPF:");
		GridBagConstraints gbc_JlabelBuascarCPF = new GridBagConstraints();
		gbc_JlabelBuascarCPF.gridwidth = 2;
		gbc_JlabelBuascarCPF.anchor = GridBagConstraints.SOUTHEAST;
		gbc_JlabelBuascarCPF.insets = new Insets(0, 0, 5, 5);
		gbc_JlabelBuascarCPF.gridx = 0;
		gbc_JlabelBuascarCPF.gridy = 2;
		panel.add(JlabelBuascarCPF, gbc_JlabelBuascarCPF);
		
		textFieldEmpretimoCpf = new JTextField();
		textFieldEmpretimoCpf.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_textFieldEmpretimoCpf = new GridBagConstraints();
		gbc_textFieldEmpretimoCpf.anchor = GridBagConstraints.SOUTH;
		gbc_textFieldEmpretimoCpf.gridwidth = 2;
		gbc_textFieldEmpretimoCpf.insets = new Insets(15, 0, 5, 5);
		gbc_textFieldEmpretimoCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmpretimoCpf.gridx = 2;
		gbc_textFieldEmpretimoCpf.gridy = 2;
		panel.add(textFieldEmpretimoCpf, gbc_textFieldEmpretimoCpf);
		textFieldEmpretimoCpf.setColumns(10);
		
		JButton btnBuscarEmprestimo = new JButton("BUSCAR");
		btnBuscarEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpfLeitor = textFieldEmpretimoCpf.getText();
				
				try {
					LeitorModelo leitor = leitorControlador.buscarLeitorPorCpf(cpfLeitor);
					textField_6NomeLeitor.setText(leitor.getNome());
					textField_CpfLeitor.setText(leitor.getCpf());
				
				} catch (ExcecaoControlador e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnBuscarEmprestimo = new GridBagConstraints();
		gbc_btnBuscarEmprestimo.anchor = GridBagConstraints.WEST;
		gbc_btnBuscarEmprestimo.gridwidth = 2;
		gbc_btnBuscarEmprestimo.insets = new Insets(15, 0, 5, 5);
		gbc_btnBuscarEmprestimo.gridx = 4;
		gbc_btnBuscarEmprestimo.gridy = 2;
		panel.add(btnBuscarEmprestimo, gbc_btnBuscarEmprestimo);
		
		JLabel lblNewLabelNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNewLabelNome = new GridBagConstraints();
		gbc_lblNewLabelNome.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelNome.gridx = 0;
		gbc_lblNewLabelNome.gridy = 4;
		panel.add(lblNewLabelNome, gbc_lblNewLabelNome);
		
		textField_6NomeLeitor = new JTextField();
		textField_6NomeLeitor.setEditable(false);
		textField_6NomeLeitor.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_textField_6NomeLeitor = new GridBagConstraints();
		gbc_textField_6NomeLeitor.gridwidth = 2;
		gbc_textField_6NomeLeitor.insets = new Insets(0, 0, 5, 25);
		gbc_textField_6NomeLeitor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6NomeLeitor.gridx = 1;
		gbc_textField_6NomeLeitor.gridy = 4;
		panel.add(textField_6NomeLeitor, gbc_textField_6NomeLeitor);
		textField_6NomeLeitor.setColumns(10);
		
		JLabel lblNewLabel_1CpfLeitor = new JLabel("CPF:");
		GridBagConstraints gbc_lblNewLabel_1CpfLeitor = new GridBagConstraints();
		gbc_lblNewLabel_1CpfLeitor.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1CpfLeitor.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_1CpfLeitor.gridx = 3;
		gbc_lblNewLabel_1CpfLeitor.gridy = 4;
		panel.add(lblNewLabel_1CpfLeitor, gbc_lblNewLabel_1CpfLeitor);
		
		textField_CpfLeitor = new JTextField();
		textField_CpfLeitor.setEditable(false);
		textField_CpfLeitor.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_textField_CpfLeitor = new GridBagConstraints();
		gbc_textField_CpfLeitor.gridwidth = 6;
		gbc_textField_CpfLeitor.insets = new Insets(0, 0, 5, 5);
		gbc_textField_CpfLeitor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_CpfLeitor.gridx = 4;
		gbc_textField_CpfLeitor.gridy = 4;
		panel.add(textField_CpfLeitor, gbc_textField_CpfLeitor);
		textField_CpfLeitor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ISBN:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(30, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 5;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_ISBNLivro1 = new JTextField();
		textField_ISBNLivro1.setEditable(false);
		textField_ISBNLivro1.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_textField_ISBNLivro1 = new GridBagConstraints();
		gbc_textField_ISBNLivro1.gridwidth = 2;
		gbc_textField_ISBNLivro1.insets = new Insets(30, 0, 5, 5);
		gbc_textField_ISBNLivro1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_ISBNLivro1.gridx = 1;
		gbc_textField_ISBNLivro1.gridy = 5;
		panel.add(textField_ISBNLivro1, gbc_textField_ISBNLivro1);
		textField_ISBNLivro1.setColumns(10);
		
		JLabel lblNewLabel_TituloLivro = new JLabel("Título:");
		GridBagConstraints gbc_lblNewLabel_TituloLivro = new GridBagConstraints();
		gbc_lblNewLabel_TituloLivro.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_TituloLivro.insets = new Insets(30, 10, 5, 5);
		gbc_lblNewLabel_TituloLivro.gridx = 3;
		gbc_lblNewLabel_TituloLivro.gridy = 5;
		panel.add(lblNewLabel_TituloLivro, gbc_lblNewLabel_TituloLivro);
		
		textField_TituloLivro = new JTextField();
		textField_TituloLivro.setEditable(false);
		textField_TituloLivro.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_textField_TituloLivro = new GridBagConstraints();
		gbc_textField_TituloLivro.gridwidth = 6;
		gbc_textField_TituloLivro.insets = new Insets(30, 0, 5, 5);
		gbc_textField_TituloLivro.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_TituloLivro.gridx = 4;
		gbc_textField_TituloLivro.gridy = 5;
		panel.add(textField_TituloLivro, gbc_textField_TituloLivro);
		textField_TituloLivro.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Data do empréstimo:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textFieldDataEmprestimo1 = new JTextField();
		textFieldDataEmprestimo1.setEditable(false);
		textFieldDataEmprestimo1.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_textFieldDataEmprestimo1 = new GridBagConstraints();
		gbc_textFieldDataEmprestimo1.gridwidth = 2;
		gbc_textFieldDataEmprestimo1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDataEmprestimo1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDataEmprestimo1.gridx = 1;
		gbc_textFieldDataEmprestimo1.gridy = 6;
		panel.add(textFieldDataEmprestimo1, gbc_textFieldDataEmprestimo1);
		textFieldDataEmprestimo1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Data da devolução:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 20, 5, 5);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 6;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textFielDataDevolucao1 = new JTextField();
		textFielDataDevolucao1.setEditable(false);
		textFielDataDevolucao1.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_textFielDataDevolucao1 = new GridBagConstraints();
		gbc_textFielDataDevolucao1.gridwidth = 6;
		gbc_textFielDataDevolucao1.insets = new Insets(0, 0, 5, 5);
		gbc_textFielDataDevolucao1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFielDataDevolucao1.gridx = 4;
		gbc_textFielDataDevolucao1.gridy = 6;
		panel.add(textFielDataDevolucao1, gbc_textFielDataDevolucao1);
		textFielDataDevolucao1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Dias atrasados:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textFieldDiasAtrasados1 = new JTextField();
		textFieldDiasAtrasados1.setEditable(false);
		textFieldDiasAtrasados1.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_textFieldDiasAtrasados1 = new GridBagConstraints();
		gbc_textFieldDiasAtrasados1.gridwidth = 2;
		gbc_textFieldDiasAtrasados1.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDiasAtrasados1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDiasAtrasados1.gridx = 1;
		gbc_textFieldDiasAtrasados1.gridy = 7;
		panel.add(textFieldDiasAtrasados1, gbc_textFieldDiasAtrasados1);
		textFieldDiasAtrasados1.setColumns(10);
		
		JButton btnDevolverLivro1 = new JButton("DEVOLVER");
		GridBagConstraints gbc_btnDevolverLivro1 = new GridBagConstraints();
		gbc_btnDevolverLivro1.insets = new Insets(0, 0, 5, 5);
		gbc_btnDevolverLivro1.gridx = 5;
		gbc_btnDevolverLivro1.gridy = 7;
		panel.add(btnDevolverLivro1, gbc_btnDevolverLivro1);
		
		JLabel lblNewLabelIsbnLivro2 = new JLabel("ISBN:");
		GridBagConstraints gbc_lblNewLabelIsbnLivro2 = new GridBagConstraints();
		gbc_lblNewLabelIsbnLivro2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelIsbnLivro2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelIsbnLivro2.gridx = 0;
		gbc_lblNewLabelIsbnLivro2.gridy = 9;
		panel.add(lblNewLabelIsbnLivro2, gbc_lblNewLabelIsbnLivro2);
		
		textField_ISBN2 = new JTextField();
		textField_ISBN2.setBackground(new Color(141, 197, 62));
		textField_ISBN2.setEditable(false);
		GridBagConstraints gbc_textField_ISBN2 = new GridBagConstraints();
		gbc_textField_ISBN2.gridwidth = 2;
		gbc_textField_ISBN2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_ISBN2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_ISBN2.gridx = 1;
		gbc_textField_ISBN2.gridy = 9;
		panel.add(textField_ISBN2, gbc_textField_ISBN2);
		textField_ISBN2.setColumns(10);
		
		JLabel lblNewLabelTituloLivro2 = new JLabel("Título:");
		GridBagConstraints gbc_lblNewLabelTituloLivro2 = new GridBagConstraints();
		gbc_lblNewLabelTituloLivro2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelTituloLivro2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelTituloLivro2.gridx = 3;
		gbc_lblNewLabelTituloLivro2.gridy = 9;
		panel.add(lblNewLabelTituloLivro2, gbc_lblNewLabelTituloLivro2);
		
		textFieldTituloLivro2 = new JTextField();
		textFieldTituloLivro2.setEditable(false);
		textFieldTituloLivro2.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_textFieldTituloLivro2 = new GridBagConstraints();
		gbc_textFieldTituloLivro2.gridwidth = 6;
		gbc_textFieldTituloLivro2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTituloLivro2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTituloLivro2.gridx = 4;
		gbc_textFieldTituloLivro2.gridy = 9;
		panel.add(textFieldTituloLivro2, gbc_textFieldTituloLivro2);
		textFieldTituloLivro2.setColumns(10);
		
		JLabel lblNewLabelDataEmprestimo2 = new JLabel("Data do emprétimo:");
		GridBagConstraints gbc_lblNewLabelDataEmprestimo2 = new GridBagConstraints();
		gbc_lblNewLabelDataEmprestimo2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelDataEmprestimo2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelDataEmprestimo2.gridx = 0;
		gbc_lblNewLabelDataEmprestimo2.gridy = 10;
		panel.add(lblNewLabelDataEmprestimo2, gbc_lblNewLabelDataEmprestimo2);
		
		textFieldDataEmprestimo2 = new JTextField();
		textFieldDataEmprestimo2.setEditable(false);
		textFieldDataEmprestimo2.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_textFieldDataEmprestimo2 = new GridBagConstraints();
		gbc_textFieldDataEmprestimo2.gridwidth = 2;
		gbc_textFieldDataEmprestimo2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDataEmprestimo2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDataEmprestimo2.gridx = 1;
		gbc_textFieldDataEmprestimo2.gridy = 10;
		panel.add(textFieldDataEmprestimo2, gbc_textFieldDataEmprestimo2);
		textFieldDataEmprestimo2.setColumns(10);
		
		JLabel lblNewLabelDataDevolucao2 = new JLabel("Data da devolução:");
		GridBagConstraints gbc_lblNewLabelDataDevolucao2 = new GridBagConstraints();
		gbc_lblNewLabelDataDevolucao2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelDataDevolucao2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelDataDevolucao2.gridx = 3;
		gbc_lblNewLabelDataDevolucao2.gridy = 10;
		panel.add(lblNewLabelDataDevolucao2, gbc_lblNewLabelDataDevolucao2);
		
		textFieldDataDevolucao2 = new JTextField();
		textFieldDataDevolucao2.setEditable(false);
		textFieldDataDevolucao2.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_textFieldDataDevolucao2 = new GridBagConstraints();
		gbc_textFieldDataDevolucao2.gridwidth = 6;
		gbc_textFieldDataDevolucao2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDataDevolucao2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDataDevolucao2.gridx = 4;
		gbc_textFieldDataDevolucao2.gridy = 10;
		panel.add(textFieldDataDevolucao2, gbc_textFieldDataDevolucao2);
		textFieldDataDevolucao2.setColumns(10);
		
		JLabel lblNewLabelDiasAtrasados2 = new JLabel("Dias atrasados:");
		GridBagConstraints gbc_lblNewLabelDiasAtrasados2 = new GridBagConstraints();
		gbc_lblNewLabelDiasAtrasados2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelDiasAtrasados2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabelDiasAtrasados2.gridx = 0;
		gbc_lblNewLabelDiasAtrasados2.gridy = 11;
		panel.add(lblNewLabelDiasAtrasados2, gbc_lblNewLabelDiasAtrasados2);
		
		textFieldDiasAtrasados2 = new JTextField();
		textFieldDiasAtrasados2.setEditable(false);
		textFieldDiasAtrasados2.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_textFieldDiasAtrasados2 = new GridBagConstraints();
		gbc_textFieldDiasAtrasados2.gridwidth = 2;
		gbc_textFieldDiasAtrasados2.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldDiasAtrasados2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDiasAtrasados2.gridx = 1;
		gbc_textFieldDiasAtrasados2.gridy = 11;
		panel.add(textFieldDiasAtrasados2, gbc_textFieldDiasAtrasados2);
		textFieldDiasAtrasados2.setColumns(10);
		
		JButton btnDevolverLivro2 = new JButton("DEVOLVER");
		GridBagConstraints gbc_btnDevolverLivro2 = new GridBagConstraints();
		gbc_btnDevolverLivro2.insets = new Insets(0, 0, 5, 5);
		gbc_btnDevolverLivro2.gridx = 5;
		gbc_btnDevolverLivro2.gridy = 11;
		panel.add(btnDevolverLivro2, gbc_btnDevolverLivro2);
		
		
		
		
		
		
		
		
		
	
		
		
	}

}
