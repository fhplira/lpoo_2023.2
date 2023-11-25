package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ExcecaoController;
import controller.LivroControlador;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
	private JTextField txtAutor;
	private JTextField txtEditora;
	private JTextField txtImagem;
	private JTextField txtCodigoExemplar;
	private JFormattedTextField txtISBN;
	private JFormattedTextField formattedtxtDataPublicacao;
	
	
	
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
		
		final JFormattedTextField txtISBN = new JFormattedTextField();
		txtISBN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtISBN = new GridBagConstraints();
		gbc_txtISBN.insets = new Insets(0, 0, 10, 200);
		gbc_txtISBN.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtISBN.gridx = 1;
		gbc_txtISBN.gridy = 1;
		panelCadastro.add(txtISBN, gbc_txtISBN);
		
		JButton btnNewButton = new JButton("Cadastrar por ISBN.");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ISBN = txtISBN.getText();
				LivroControlador controlador = new LivroControlador(); 
				try {
					controlador.cadastrarLivroPorISBN(ISBN);
					JOptionPane.showMessageDialog(null, "O livro foi cadastrado com sucesso.", "Success", JOptionPane.INFORMATION_MESSAGE);
				} catch (ExcecaoController ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception exc){
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
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
		
		txtCodigoExemplar = new JTextField();
		txtCodigoExemplar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtCodigoExemplar = new GridBagConstraints();
		gbc_txtCodigoExemplar.insets = new Insets(0, 0, 10, 200);
		gbc_txtCodigoExemplar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodigoExemplar.gridx = 1;
		gbc_txtCodigoExemplar.gridy = 3;
		panelCadastro.add(txtCodigoExemplar, gbc_txtCodigoExemplar);
		txtCodigoExemplar.setColumns(10);
		
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
		
		txtAutor = new JTextField();
		txtAutor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtAutor = new GridBagConstraints();
		gbc_txtAutor.insets = new Insets(0, 0, 10, 200);
		gbc_txtAutor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAutor.gridx = 1;
		gbc_txtAutor.gridy = 5;
		panelCadastro.add(txtAutor, gbc_txtAutor);
		txtAutor.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Editora:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		panelCadastro.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		txtEditora = new JTextField();
		txtEditora.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtEditora = new GridBagConstraints();
		gbc_txtEditora.insets = new Insets(0, 0, 10, 200);
		gbc_txtEditora.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEditora.gridx = 1;
		gbc_txtEditora.gridy = 6;
		panelCadastro.add(txtEditora, gbc_txtEditora);
		txtEditora.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Data de publicação:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 7;
		panelCadastro.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		final JFormattedTextField formattedtxtDataPublicacao = new JFormattedTextField();
		formattedtxtDataPublicacao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_formattedtxtDataPublicacao = new GridBagConstraints();
		gbc_formattedtxtDataPublicacao.insets = new Insets(0, 0, 10, 200);
		gbc_formattedtxtDataPublicacao.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedtxtDataPublicacao.gridx = 1;
		gbc_formattedtxtDataPublicacao.gridy = 7;
		panelCadastro.add(formattedtxtDataPublicacao, gbc_formattedtxtDataPublicacao);
		
		JLabel lblNewLabel_6 = new JLabel("Imagem:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 8;
		panelCadastro.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		txtImagem = new JTextField();
		txtImagem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtImagem = new GridBagConstraints();
		gbc_txtImagem.insets = new Insets(0, 0, 10, 200);
		gbc_txtImagem.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtImagem.gridx = 1;
		gbc_txtImagem.gridy = 8;
		panelCadastro.add(txtImagem, gbc_txtImagem);
		txtImagem.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Descrição:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 9;
		panelCadastro.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		final JTextArea txtDescricao = new JTextArea();
		GridBagConstraints gbc_txtDescricao = new GridBagConstraints();
		gbc_txtDescricao.gridheight = 2;
		gbc_txtDescricao.insets = new Insets(0, 0, 10, 100);
		gbc_txtDescricao.fill = GridBagConstraints.BOTH;
		gbc_txtDescricao.gridx = 1;
		gbc_txtDescricao.gridy = 10;
		panelCadastro.add(txtDescricao, gbc_txtDescricao);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String isbn = txtISBN.getText();
				String codigoExemplar = txtCodigoExemplar.getText();
				String titulo = txtTitulo.getText();
				String autor = txtAutor.getText();
				String editora = txtEditora.getText();
				String dataPublicacao = formattedtxtDataPublicacao.getText();
				String imagem = txtImagem.getText();
				String descricao = txtDescricao.getText();
				
				LivroControlador controlador = new LivroControlador();
				
				try {
					controlador.cadastrarLivro(titulo, autor, editora, isbn, dataPublicacao, descricao, imagem);
					JOptionPane.showMessageDialog(null, "O livro foi cadastrado com sucesso.", "Success", JOptionPane.INFORMATION_MESSAGE);
				} catch (ExcecaoController e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.gridwidth = 2;
		gbc_btnCadastrar.gridx = 0;
		gbc_btnCadastrar.gridy = 12;
		panelCadastro.add(btnCadastrar, gbc_btnCadastrar);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(194, 446, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		
	}
}
