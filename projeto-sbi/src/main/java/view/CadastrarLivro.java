package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;

public class CadastrarLivro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarLivro frame = new CadastrarLivro();
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
	public CadastrarLivro() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 824, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 824, 510));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVisualizarLivros = new JButton("Visualizar Livros:");
		btnVisualizarLivros.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnVisualizarLivros.setBounds(10, 103, 156, 39);
		contentPane.add(btnVisualizarLivros);
		
		JButton btnLeitor = new JButton("Leitor");
		btnLeitor.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLeitor.setBounds(10, 167, 156, 39);
		contentPane.add(btnLeitor);
		
		JButton btnBuscarLivro = new JButton("Buscar Livro");
		btnBuscarLivro.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBuscarLivro.setBounds(10, 228, 156, 39);
		contentPane.add(btnBuscarLivro);
		
		JButton btnCadastrarLeitor = new JButton("Cadastrar Leitor");
		btnCadastrarLeitor.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCadastrarLeitor.setBounds(10, 293, 156, 39);
		contentPane.add(btnCadastrarLeitor);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setBounds(191, 11, 607, 449);
		contentPane.add(panelCadastro);
		GridBagLayout gbl_panelCadastro = new GridBagLayout();
		gbl_panelCadastro.columnWidths = new int[]{0, 0, 0};
		gbl_panelCadastro.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCadastro.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelCadastro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelCadastro.setLayout(gbl_panelCadastro);
		
		JLabel lblTitle = new JLabel("CADASTRAR LIVRO:");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 2;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 0;
		panelCadastro.add(lblTitle, gbc_lblTitle);
		
		JLabel lblISBN = new JLabel("ISBN:");
		lblISBN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblISBN = new GridBagConstraints();
		gbc_lblISBN.insets = new Insets(0, 0, 5, 5);
		gbc_lblISBN.anchor = GridBagConstraints.EAST;
		gbc_lblISBN.gridx = 0;
		gbc_lblISBN.gridy = 1;
		panelCadastro.add(lblISBN, gbc_lblISBN);
		
		JFormattedTextField txtISBN = new JFormattedTextField();
		txtISBN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtISBN = new GridBagConstraints();
		gbc_txtISBN.insets = new Insets(0, 0, 10, 200);
		gbc_txtISBN.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtISBN.gridx = 1;
		gbc_txtISBN.gridy = 1;
		panelCadastro.add(txtISBN, gbc_txtISBN);
		
		JButton btnNewButton = new JButton("Cadastrar por ISBN.");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		panelCadastro.add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblCodigoExemplar = new JLabel("Código do exemplar:");
		lblCodigoExemplar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblCodigoExemplar = new GridBagConstraints();
		gbc_lblCodigoExemplar.anchor = GridBagConstraints.EAST;
		gbc_lblCodigoExemplar.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigoExemplar.gridx = 0;
		gbc_lblCodigoExemplar.gridy = 3;
		panelCadastro.add(lblCodigoExemplar, gbc_lblCodigoExemplar);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 10, 200);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 3;
		panelCadastro.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.anchor = GridBagConstraints.EAST;
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 4;
		panelCadastro.add(lblTitulo, gbc_lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtTitulo = new GridBagConstraints();
		gbc_txtTitulo.insets = new Insets(0, 0, 10, 200);
		gbc_txtTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitulo.gridx = 1;
		gbc_txtTitulo.gridy = 4;
		panelCadastro.add(txtTitulo, gbc_txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor:");
		GridBagConstraints gbc_lblAutor = new GridBagConstraints();
		gbc_lblAutor.anchor = GridBagConstraints.EAST;
		gbc_lblAutor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAutor.gridx = 0;
		gbc_lblAutor.gridy = 5;
		panelCadastro.add(lblAutor, gbc_lblAutor);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 10, 200);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 5;
		panelCadastro.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Editora:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		panelCadastro.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 10, 200);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 6;
		panelCadastro.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Data de publicação:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 7;
		panelCadastro.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_formattedTextField_1 = new GridBagConstraints();
		gbc_formattedTextField_1.insets = new Insets(0, 0, 10, 200);
		gbc_formattedTextField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedTextField_1.gridx = 1;
		gbc_formattedTextField_1.gridy = 7;
		panelCadastro.add(formattedTextField_1, gbc_formattedTextField_1);
		
		JLabel lblNewLabel_6 = new JLabel("Imagem:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 8;
		panelCadastro.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 10, 200);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 8;
		panelCadastro.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Descrição:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 9;
		panelCadastro.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 2;
		gbc_textArea.insets = new Insets(0, 0, 10, 100);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 10;
		panelCadastro.add(textArea, gbc_textArea);
		
		JButton btnNewButton_5 = new JButton("CADASTRAR");
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.gridwidth = 2;
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 12;
		panelCadastro.add(btnNewButton_5, gbc_btnNewButton_5);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(194, 446, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		
	}
}
