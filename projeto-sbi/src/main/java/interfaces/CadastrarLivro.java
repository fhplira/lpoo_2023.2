package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controladores.ExcecaoControlador;
import controladores.LivroControlador;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import java.awt.Component;

public class CadastrarLivro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtEditora;
	private JTextField txtImagem;
	private JFormattedTextField txtISBN;
	private JFormattedTextField formattedtxtDataPublicacao;
	CadastrarLivro frameCadastrarLivro; 
	private JTextArea txtDescricao;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarLivro frameCadastrarLivro = new CadastrarLivro();
					frameCadastrarLivro.setVisible(true);
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
		setMaximumSize(new Dimension(3072, 3072));
		setMinimumSize(new Dimension(824, 510));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(141, 197, 62));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {0};
		gbl_contentPane.rowHeights = new int[] {0};
		gbl_contentPane.columnWeights = new double[]{1.0};
		gbl_contentPane.rowWeights = new double[]{1.0};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setMinimumSize(new Dimension(824, 510));
		panelCadastro.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_panelCadastro = new GridBagConstraints();
		gbc_panelCadastro.fill = GridBagConstraints.BOTH;
		gbc_panelCadastro.gridx = 0;
		gbc_panelCadastro.gridy = 0;
		contentPane.add(panelCadastro, gbc_panelCadastro);
		GridBagLayout gbl_panelCadastro = new GridBagLayout();
		gbl_panelCadastro.columnWidths = new int[]{200, 468, 0};
		gbl_panelCadastro.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCadastro.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelCadastro.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCadastro.setLayout(gbl_panelCadastro);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BotoesPrincipais().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnVoltar.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_btnVoltar = new GridBagConstraints();
		gbc_btnVoltar.insets = new Insets(0, 0, 5, 5);
		gbc_btnVoltar.gridx = 0;
		gbc_btnVoltar.gridy = 0;
		panelCadastro.add(btnVoltar, gbc_btnVoltar);
		
		JLabel lblTitle = new JLabel("CADASTRAR LIVRO");
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(30, 5, 60, 0);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 0;
		panelCadastro.add(lblTitle, gbc_lblTitle);
		
		JLabel lblISBN = new JLabel("* ISBN:");
		lblISBN.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblISBN.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblISBN = new GridBagConstraints();
		gbc_lblISBN.insets = new Insets(0, 50, 10, 5);
		gbc_lblISBN.anchor = GridBagConstraints.EAST;
		gbc_lblISBN.gridx = 0;
		gbc_lblISBN.gridy = 1;
		panelCadastro.add(lblISBN, gbc_lblISBN);
		
		final JFormattedTextField txtISBN_1 = new JFormattedTextField();
		txtISBN_1.setToolTipText("");
		txtISBN_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtISBN_1 = new GridBagConstraints();
		gbc_txtISBN_1.insets = new Insets(0, 0, 10, 50);
		gbc_txtISBN_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtISBN_1.gridx = 1;
		gbc_txtISBN_1.gridy = 1;
		panelCadastro.add(txtISBN_1, gbc_txtISBN_1);
		
		
		JButton btnCadastrarPorIsbn = new JButton("Cadastrar por ISBN");
		btnCadastrarPorIsbn.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCadastrarPorIsbn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ISBN = txtISBN_1.getText();
				LivroControlador controlador = new LivroControlador(); 
				try {
					controlador.cadastrarLivroPorISBN(ISBN);
					JOptionPane.showMessageDialog(null, "O livro foi cadastrado com sucesso.", "Success", JOptionPane.INFORMATION_MESSAGE);
				} catch (ExcecaoControlador ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception exc){
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		
		btnCadastrarPorIsbn.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnCadastrarPorIsbn = new GridBagConstraints();
		gbc_btnCadastrarPorIsbn.insets = new Insets(0, 0, 5, 0);
		gbc_btnCadastrarPorIsbn.gridx = 1;
		gbc_btnCadastrarPorIsbn.gridy = 2;
		panelCadastro.add(btnCadastrarPorIsbn, gbc_btnCadastrarPorIsbn);
		
		JLabel lblTitulo = new JLabel("* Titulo:");
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.anchor = GridBagConstraints.EAST;
		gbc_lblTitulo.insets = new Insets(0, 50, 10, 5);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 3;
		panelCadastro.add(lblTitulo, gbc_lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtTitulo = new GridBagConstraints();
		gbc_txtTitulo.insets = new Insets(0, 0, 10, 50);
		gbc_txtTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTitulo.gridx = 1;
		gbc_txtTitulo.gridy = 3;
		panelCadastro.add(txtTitulo, gbc_txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblAutor = new JLabel("*  Autor:");
		lblAutor.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblAutor = new GridBagConstraints();
		gbc_lblAutor.anchor = GridBagConstraints.EAST;
		gbc_lblAutor.insets = new Insets(0, 50, 10, 5);
		gbc_lblAutor.gridx = 0;
		gbc_lblAutor.gridy = 4;
		panelCadastro.add(lblAutor, gbc_lblAutor);
		
		txtAutor = new JTextField();
		txtAutor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtAutor = new GridBagConstraints();
		gbc_txtAutor.insets = new Insets(0, 0, 10, 50);
		gbc_txtAutor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAutor.gridx = 1;
		gbc_txtAutor.gridy = 4;
		panelCadastro.add(txtAutor, gbc_txtAutor);
		txtAutor.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Editora:");
		lblNewLabel_4.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 50, 10, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		panelCadastro.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		txtEditora = new JTextField();
		txtEditora.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtEditora = new GridBagConstraints();
		gbc_txtEditora.insets = new Insets(0, 0, 10, 50);
		gbc_txtEditora.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEditora.gridx = 1;
		gbc_txtEditora.gridy = 5;
		panelCadastro.add(txtEditora, gbc_txtEditora);
		txtEditora.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Data de publicação:");
		lblNewLabel_5.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 50, 10, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		panelCadastro.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		final JFormattedTextField formattedtxtDataPublicacao_1 = new JFormattedTextField();
		formattedtxtDataPublicacao_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_formattedtxtDataPublicacao_1 = new GridBagConstraints();
		gbc_formattedtxtDataPublicacao_1.insets = new Insets(0, 0, 10, 50);
		gbc_formattedtxtDataPublicacao_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_formattedtxtDataPublicacao_1.gridx = 1;
		gbc_formattedtxtDataPublicacao_1.gridy = 6;
		panelCadastro.add(formattedtxtDataPublicacao_1, gbc_formattedtxtDataPublicacao_1);
		
		JLabel lblNewLabel_6 = new JLabel("Imagem:");
		lblNewLabel_6.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 50, 10, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 7;
		panelCadastro.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		txtImagem = new JTextField();
		txtImagem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtImagem = new GridBagConstraints();
		gbc_txtImagem.insets = new Insets(0, 0, 10, 50);
		gbc_txtImagem.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtImagem.gridx = 1;
		gbc_txtImagem.gridy = 7;
		panelCadastro.add(txtImagem, gbc_txtImagem);
		txtImagem.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Descrição:");
		lblNewLabel_8.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 50, 10, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 8;
		panelCadastro.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JButton btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String isbn = txtISBN_1.getText();
				String titulo = txtTitulo.getText();
				String autor = txtAutor.getText();
				String editora = txtEditora.getText();
				String dataPublicacao = formattedtxtDataPublicacao_1.getText();
				String imagem = txtImagem.getText();
				String descricao = txtDescricao.getText();
				
				LivroControlador controlador = new LivroControlador();
				
				try {
					controlador.cadastrarLivro(isbn, titulo, autor, editora, dataPublicacao, imagem, descricao);
					JOptionPane.showMessageDialog(null, "O livro foi cadastrado com sucesso.", "Success", JOptionPane.INFORMATION_MESSAGE);
				} catch (ExcecaoControlador e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
				}
	
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 10, 50);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 8;
		panelCadastro.add(scrollPane, gbc_scrollPane);
		
		final JTextArea txtDescricaoLivro = new JTextArea();
		scrollPane.setViewportView(txtDescricaoLivro);
		txtDescricaoLivro.setLineWrap(true);
		txtDescricaoLivro.setWrapStyleWord(true);
		txtDescricaoLivro.setMaximumSize(new Dimension(300, 50));
		
		JLabel lblNewLabel = new JLabel("* campos obrigatórios");
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(20, 0, 5, 0);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 9;
		panelCadastro.add(lblNewLabel, gbc_lblNewLabel);
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		GridBagConstraints gbc_btnCadastrar = new GridBagConstraints();
		gbc_btnCadastrar.gridx = 1;
		gbc_btnCadastrar.gridy = 10;
		panelCadastro.add(btnCadastrar, gbc_btnCadastrar);
		
		
	}
}
