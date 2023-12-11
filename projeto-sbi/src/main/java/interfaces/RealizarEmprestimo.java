package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controladores.EmprestimoControlador;
import controladores.ExcecaoControlador;
import controladores.LivroControlador;
import modelos.EmprestimoModelo;
import modelos.LivroModelo;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class RealizarEmprestimo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIsbn;
	private JTextField txtCpf;
	private final LivroControlador livroControlador = new LivroControlador();
	private final JList listaLivros = new JList();

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
		
		List<LivroModelo> livros = new ArrayList<>();
		
		try {
			livros = livroControlador.buscarTodosOsLivros();
		} catch (ExcecaoControlador e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
			exc.printStackTrace();
		}
		
		DefaultListModel<LivroModelo> modeloJlist = new DefaultListModel();	
		modeloJlist.addAll(livros); 
		
		
		
		setMinimumSize(new Dimension(824, 510));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(141, 197, 62));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {180, 0, 0};
		gbl_contentPane.rowHeights = new int[] {0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(30, 5, 30, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		JList<LivroModelo> listaLivros = new JList<>(modeloJlist);
		listaLivros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(listaLivros);
		listaLivros.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index = listaLivros.getSelectedIndex();
				String isbn = modeloJlist.get(index).getIsbn();
				txtIsbn.setText(isbn);
			}
		});
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{162, 393, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabelEmprestimo = new JLabel("EMPRÉSTIMO");
		lblNewLabelEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabelEmprestimo.setAlignmentX(0.5f);
		GridBagConstraints gbc_lblNewLabelEmprestimo = new GridBagConstraints();
		gbc_lblNewLabelEmprestimo.gridwidth = 2;
		gbc_lblNewLabelEmprestimo.insets = new Insets(30, 50, 60, 5);
		gbc_lblNewLabelEmprestimo.gridx = 0;
		gbc_lblNewLabelEmprestimo.gridy = 0;
		panel.add(lblNewLabelEmprestimo, gbc_lblNewLabelEmprestimo);
		
		JButton btnNewButton = new JButton("VOLTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BotoesPrincipais().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(30, 0, 60, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabelISBN = new JLabel("ISBN DO LIVRO:");
		lblNewLabelISBN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabelISBN.setAlignmentX(0.5f);
		GridBagConstraints gbc_lblNewLabelISBN = new GridBagConstraints();
		gbc_lblNewLabelISBN.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelISBN.insets = new Insets(0, 50, 10, 5);
		gbc_lblNewLabelISBN.gridx = 0;
		gbc_lblNewLabelISBN.gridy = 1;
		panel.add(lblNewLabelISBN, gbc_lblNewLabelISBN);
		
		txtIsbn = new JTextField();
		txtIsbn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtIsbn.setColumns(10);
		GridBagConstraints gbc_txtIsbn = new GridBagConstraints();
		gbc_txtIsbn.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIsbn.insets = new Insets(0, 5, 10, 50);
		gbc_txtIsbn.gridx = 1;
		gbc_txtIsbn.gridy = 1;
		panel.add(txtIsbn, gbc_txtIsbn);
		
		JLabel lblNewLabelCPF = new JLabel("CPF DO LEITOR:");
		lblNewLabelCPF.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabelCPF.setAlignmentX(0.5f);
		GridBagConstraints gbc_lblNewLabelCPF = new GridBagConstraints();
		gbc_lblNewLabelCPF.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelCPF.insets = new Insets(0, 50, 100, 5);
		gbc_lblNewLabelCPF.gridx = 0;
		gbc_lblNewLabelCPF.gridy = 2;
		panel.add(lblNewLabelCPF, gbc_lblNewLabelCPF);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtCpf = new GridBagConstraints();
		gbc_txtCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCpf.insets = new Insets(0, 5, 100, 50);
		gbc_txtCpf.gridx = 1;
		gbc_txtCpf.gridy = 2;
		panel.add(txtCpf, gbc_txtCpf);
		
		JButton btnRealizarEmprstimo = new JButton("REALIZAR EMPRÉSTIMO");
		btnRealizarEmprstimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = txtIsbn.getText();
				String cpf = txtCpf.getText();
				
				EmprestimoControlador realizarEmprestimo = new EmprestimoControlador();
				
				try {
					realizarEmprestimo.realizarEmprestimo(isbn, cpf);
					JOptionPane.showMessageDialog(null,  "Empréstimo realizado com sucesso. \nVerifique a data de devolução na aba 'empréstimos'.", "Success", JOptionPane.INFORMATION_MESSAGE);
				} catch (ExcecaoControlador ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex2) {
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRealizarEmprstimo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRealizarEmprstimo.setAlignmentX(0.5f);
		GridBagConstraints gbc_btnRealizarEmprstimo = new GridBagConstraints();
		gbc_btnRealizarEmprstimo.gridwidth = 2;
		gbc_btnRealizarEmprstimo.insets = new Insets(0, 50, 20, 30);
		gbc_btnRealizarEmprstimo.gridx = 0;
		gbc_btnRealizarEmprstimo.gridy = 3;
		panel.add(btnRealizarEmprstimo, gbc_btnRealizarEmprstimo);
	}
}
