package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controladores.EmprestimoControlador;
import controladores.ExcecaoControlador;
import modelos.EmprestimoModelo;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.Dimension;

public class RealizarEmprestimo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField1ISBNExemplar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RealizarEmprestimo frame = new RealizarEmprestimo();
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
	public RealizarEmprestimo() {
		setMinimumSize(new Dimension(824, 510));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 510);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(141, 197, 62));
		contentPane.setBorder(new EmptyBorder(5, 5, 824, 510));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(141, 197, 62));
		panel.setBounds(10, 11, 788, 449);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{180, 0, 180, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabelEmprestimo = new JLabel("EMPRÉSTIMO");
		lblNewLabelEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabelEmprestimo = new GridBagConstraints();
		gbc_lblNewLabelEmprestimo.insets = new Insets(50, 0, 40, 5);
		gbc_lblNewLabelEmprestimo.gridx = 1;
		gbc_lblNewLabelEmprestimo.gridy = 0;
		panel.add(lblNewLabelEmprestimo, gbc_lblNewLabelEmprestimo);
		
		JLabel lblNewLabelISBN = new JLabel("ISBN DO LIVRO:");
		lblNewLabelISBN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabelISBN = new GridBagConstraints();
		gbc_lblNewLabelISBN.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelISBN.insets = new Insets(0, 30, 30, 5);
		gbc_lblNewLabelISBN.gridx = 0;
		gbc_lblNewLabelISBN.gridy = 1;
		panel.add(lblNewLabelISBN, gbc_lblNewLabelISBN);
		
		
		
		textField1ISBNExemplar = new JTextField();
		textField1ISBNExemplar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_textField1ISBNExemplar = new GridBagConstraints();
		gbc_textField1ISBNExemplar.ipady = 10;
		gbc_textField1ISBNExemplar.insets = new Insets(0, 5, 30, 30);
		gbc_textField1ISBNExemplar.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField1ISBNExemplar.gridx = 1;
		gbc_textField1ISBNExemplar.gridy = 1;
		panel.add(textField1ISBNExemplar, gbc_textField1ISBNExemplar);
		textField1ISBNExemplar.setColumns(10);
		
		JLabel lblNewLabelCPF = new JLabel("CPF DO LEITOR:");
		lblNewLabelCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabelCPF = new GridBagConstraints();
		gbc_lblNewLabelCPF.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelCPF.insets = new Insets(0, 30, 100, 5);
		gbc_lblNewLabelCPF.gridx = 0;
		gbc_lblNewLabelCPF.gridy = 2;
		panel.add(lblNewLabelCPF, gbc_lblNewLabelCPF);
		/*
		 * try { MaskFormatter mask = new MaskFormatter("###.###.###-##");
		 * mask.install(formattedTextFieldCPFDoLeitor); } catch (ParseException e) {
		 * JOptionPane.showMessageDialog(null, "Informe o CPF com apenas números",
		 * "Error", JOptionPane.ERROR_MESSAGE);
		 * 
		 * }
		 */		
		
		JTextField textFieldCPFDoLeitor = new JTextField();
		textFieldCPFDoLeitor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_textFieldCPFDoLeitor = new GridBagConstraints();
		gbc_textFieldCPFDoLeitor.ipady = 10;
		gbc_textFieldCPFDoLeitor.insets = new Insets(0, 5, 100, 30);
		gbc_textFieldCPFDoLeitor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCPFDoLeitor.gridx = 1;
		gbc_textFieldCPFDoLeitor.gridy = 2;
		panel.add(textFieldCPFDoLeitor, gbc_textFieldCPFDoLeitor);
		
		JButton btnNewButtonRealizarEmprestimo = new JButton("Realizar Empréstimo");
		btnNewButtonRealizarEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String isbn = textField1ISBNExemplar.getText();
				String cpf = textFieldCPFDoLeitor.getText();
				
				EmprestimoControlador realizarEmprestimo = new EmprestimoControlador();
				
				try {
					realizarEmprestimo.fazerEmprestimo(isbn, cpf);
					JOptionPane.showMessageDialog(null,  "Empréstimo realizado com sucesso. \nVerifique a data de devolução na aba 'empréstimos'.", "Success", JOptionPane.INFORMATION_MESSAGE);
				} catch (ExcecaoControlador ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex2) {
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButtonRealizarEmprestimo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_btnNewButtonRealizarEmprestimo = new GridBagConstraints();
		gbc_btnNewButtonRealizarEmprestimo.insets = new Insets(0, 0, 20, 30);
		gbc_btnNewButtonRealizarEmprestimo.gridx = 1;
		gbc_btnNewButtonRealizarEmprestimo.gridy = 3;
		panel.add(btnNewButtonRealizarEmprestimo, gbc_btnNewButtonRealizarEmprestimo);
	}
}
