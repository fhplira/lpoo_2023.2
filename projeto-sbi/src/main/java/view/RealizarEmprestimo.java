package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;

public class RealizarEmprestimo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField formattedTextField1ISBNExemplar;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 824, 510));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(141, 197, 62));
		panel.setBounds(10, 11, 788, 449);
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabelEmprestimo = new JLabel("EMPRÉSTIMO");
		lblNewLabelEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabelEmprestimo = new GridBagConstraints();
		gbc_lblNewLabelEmprestimo.gridwidth = 8;
		gbc_lblNewLabelEmprestimo.insets = new Insets(20, 0, 5, 0);
		gbc_lblNewLabelEmprestimo.gridx = 0;
		gbc_lblNewLabelEmprestimo.gridy = 1;
		panel.add(lblNewLabelEmprestimo, gbc_lblNewLabelEmprestimo);
		
		JLabel lblNewLabelISBN = new JLabel("ISBN DO LIVRO:");
		lblNewLabelISBN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabelISBN = new GridBagConstraints();
		gbc_lblNewLabelISBN.insets = new Insets(100, 30, 30, 5);
		gbc_lblNewLabelISBN.gridx = 2;
		gbc_lblNewLabelISBN.gridy = 5;
		panel.add(lblNewLabelISBN, gbc_lblNewLabelISBN);
		
		
		
		formattedTextField1ISBNExemplar = new JFormattedTextField();
		formattedTextField1ISBNExemplar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_formattedTextField1ISBNExemplar = new GridBagConstraints();
		gbc_formattedTextField1ISBNExemplar.ipady = 10;
		gbc_formattedTextField1ISBNExemplar.gridwidth = 5;
		gbc_formattedTextField1ISBNExemplar.insets = new Insets(100, 5, 30, 30);
		gbc_formattedTextField1ISBNExemplar.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField1ISBNExemplar.gridx = 3;
		gbc_formattedTextField1ISBNExemplar.gridy = 5;
		panel.add(formattedTextField1ISBNExemplar, gbc_formattedTextField1ISBNExemplar);
		formattedTextField1ISBNExemplar.setColumns(10);
		
		JLabel lblNewLabelCPF = new JLabel("CPF DO LEITOR:");
		lblNewLabelCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabelCPF = new GridBagConstraints();
		gbc_lblNewLabelCPF.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelCPF.insets = new Insets(30, 30, 100, 5);
		gbc_lblNewLabelCPF.gridx = 2;
		gbc_lblNewLabelCPF.gridy = 8;
		panel.add(lblNewLabelCPF, gbc_lblNewLabelCPF);
		
		JFormattedTextField formattedTextFieldCPFDoLeitor = new JFormattedTextField();
		try {
			MaskFormatter mask = new MaskFormatter("###.###.###-##");
			mask.install(formattedTextFieldCPFDoLeitor);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Informe o CPF com apenas números", "Error", JOptionPane.ERROR_MESSAGE);
			
		}		
		formattedTextFieldCPFDoLeitor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_formattedTextFieldCPFDoLeitor = new GridBagConstraints();
		gbc_formattedTextFieldCPFDoLeitor.ipady = 10;
		gbc_formattedTextFieldCPFDoLeitor.gridwidth = 5;
		gbc_formattedTextFieldCPFDoLeitor.insets = new Insets(30, 5, 100, 30);
		gbc_formattedTextFieldCPFDoLeitor.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextFieldCPFDoLeitor.gridx = 3;
		gbc_formattedTextFieldCPFDoLeitor.gridy = 8;
		panel.add(formattedTextFieldCPFDoLeitor, gbc_formattedTextFieldCPFDoLeitor);
		
		JButton btnNewButtonRealizarEmprestimo = new JButton("REALIZAR EMPRÉSTIMO");
		btnNewButtonRealizarEmprestimo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_btnNewButtonRealizarEmprestimo = new GridBagConstraints();
		gbc_btnNewButtonRealizarEmprestimo.anchor = GridBagConstraints.EAST;
		gbc_btnNewButtonRealizarEmprestimo.insets = new Insets(0, 0, 20, 30);
		gbc_btnNewButtonRealizarEmprestimo.gridx = 7;
		gbc_btnNewButtonRealizarEmprestimo.gridy = 9;
		panel.add(btnNewButtonRealizarEmprestimo, gbc_btnNewButtonRealizarEmprestimo);
	}
}
