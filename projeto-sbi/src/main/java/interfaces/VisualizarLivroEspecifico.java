package interfaces;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controladores.Constantes;
import controladores.ExcecaoControlador;
import controladores.LivroControlador;
import modelos.LivroModelo;

import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.imageio.ImageIO;
import javax.swing.DropMode;
import javax.swing.ScrollPaneConstants;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class VisualizarLivroEspecifico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCampoIsbn;
	private JTextField textFieldCampoAutor;
	private JTextField textFieldTitulo;
	private JTextField textFieldCampoDataPublicacao;
	private JTextField textFieldCampoEditora;
	private JTextField textFieldCampoTotalExemplares;
	private JTextField textField_1CampoDisponiveis;
	private JTextField textFieldEmprestados;
	private JTextArea textAreaDescricao;
	private JLabel lblNewLabelImagemLivro;
	private final LivroControlador livroControlador = new LivroControlador();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarLivroEspecifico frame = new VisualizarLivroEspecifico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static String obterCaminhoSemExtensao(String caminhoArquivo) {
        File arquivo = new File(caminhoArquivo);
        String nomeArquivo = arquivo.getName();
        int posicaoPonto = nomeArquivo.lastIndexOf('.');

        if (posicaoPonto > 0) {
            // Remove a extensão do nome do arquivo
            String nomeSemExtensao = nomeArquivo.substring(0, posicaoPonto);
            
            // Concatena o caminho do diretório com o nome do arquivo sem extensão
            return arquivo.getParent() + File.separator + nomeSemExtensao;
        } else {
            // Se não houver extensão, retorna o caminho original
            return caminhoArquivo;
        }
    }
	
	public void enviarValores(LivroModelo livroClicado) throws HeadlessException, ExcecaoControlador {
		livroClicado = livroControlador.buscarLivroPorIsbn(livroClicado.getIsbn());
		textFieldTitulo.setText(livroClicado.getTitulo());
		textFieldCampoAutor.setText(livroClicado.getAutor());
	    textFieldCampoIsbn.setText(livroClicado.getIsbn());
		textFieldCampoDataPublicacao.setText(livroClicado.getDataPublicacao());
		textFieldCampoEditora.setText(livroClicado.getEditora());
		textFieldCampoTotalExemplares.setText(Integer.toString(livroClicado.getTotal()));
		textField_1CampoDisponiveis.setText(Integer.toString(livroClicado.getDisponivel()));
		textFieldEmprestados.setText(Integer.toString(livroClicado.getEmprestado()));
		textAreaDescricao.setText(livroClicado.getDescricao());
		
		if (livroClicado.getImg() != null) {
			String nomeImagem = livroClicado.getIsbn();
			String caminhoPastaLivros = System.getenv("APPDATA") + "/" + Constantes.PASTA_APP + "/" + Constantes.PASTA_LIVROS;
			String nomeImagemLivro = caminhoPastaLivros + "/" + nomeImagem;
			File file = new File(nomeImagemLivro);
			
			try {
				BufferedImage imagem = ImageIO.read(file);
				if (imagem != null) {
					ImageIcon icon = new ImageIcon(imagem);	
					lblNewLabelImagemLivro.setIcon(icon);
				} 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				BufferedImage imagemDefault = ImageIO.read(getClass().getResource("/images/livro-generico.png"));
				if (imagemDefault != null) {
		            ImageIcon icon = new ImageIcon(imagemDefault);
		            lblNewLabelImagemLivro.setIcon(icon);
				}
			} catch (IOException e){
				e.printStackTrace();
			}
			
			
		}
	    
	    
	}


	/**
	 * Create the frame.
	 * @throws ExcecaoControlador 
	 */
	public VisualizarLivroEspecifico() throws ExcecaoControlador {
	
		setMinimumSize(new Dimension(824, 510));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(141, 197, 62));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{100, 15, 15, 15, 15, 15, 100, 15, 15, 15, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(15, 20, 10, 20);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblNewLabelImagemLivro = new JLabel();
		lblNewLabelImagemLivro.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabelImagemLivro = new GridBagConstraints();
		gbc_lblNewLabelImagemLivro.insets = new Insets(30, 0, 0, 0);
		gbc_lblNewLabelImagemLivro.gridx = 0;
		gbc_lblNewLabelImagemLivro.gridy = 0;
		panel.add(lblNewLabelImagemLivro, gbc_lblNewLabelImagemLivro);
		
		JButton btnNewButton = new JButton("VOLTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
					new VisualizarLivros().setVisible(true);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		
		JLabel lblNewLabelTituloLivro = new JLabel("Titulo:");
		GridBagConstraints gbc_lblNewLabelTituloLivro = new GridBagConstraints();
		gbc_lblNewLabelTituloLivro.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelTituloLivro.insets = new Insets(0, 50, 5, 5);
		gbc_lblNewLabelTituloLivro.gridx = 0;
		gbc_lblNewLabelTituloLivro.gridy = 1;
		contentPane.add(lblNewLabelTituloLivro, gbc_lblNewLabelTituloLivro);
		
		
		textFieldTitulo = new JTextField();
		textFieldTitulo.setEditable(false);
		textFieldTitulo.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_textFieldTitulo = new GridBagConstraints();
		gbc_textFieldTitulo.insets = new Insets(0, 0, 5, 50);
		gbc_textFieldTitulo.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTitulo.gridx = 1;
		gbc_textFieldTitulo.gridy = 1;
		contentPane.add(textFieldTitulo, gbc_textFieldTitulo);
		textFieldTitulo.setColumns(10);
		
		
		JLabel lblNewLabelIsbn = new JLabel("ISBN:");
		GridBagConstraints gbc_lblNewLabelIsbn = new GridBagConstraints();
		gbc_lblNewLabelIsbn.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelIsbn.insets = new Insets(0, 50, 5, 5);
		gbc_lblNewLabelIsbn.gridx = 0;
		gbc_lblNewLabelIsbn.gridy = 2;
		contentPane.add(lblNewLabelIsbn, gbc_lblNewLabelIsbn);
		
		textFieldCampoIsbn = new JTextField();
		textFieldCampoIsbn.setEditable(false);
		textFieldCampoIsbn.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_textFieldCampoIsbn = new GridBagConstraints();
		gbc_textFieldCampoIsbn.insets = new Insets(0, 0, 5, 50);
		gbc_textFieldCampoIsbn.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCampoIsbn.gridx = 1;
		gbc_textFieldCampoIsbn.gridy = 2;
		contentPane.add(textFieldCampoIsbn, gbc_textFieldCampoIsbn);
		textFieldCampoIsbn.setColumns(10);
		
		
		JLabel lblNewLabelAutor = new JLabel("Autor:");
		GridBagConstraints gbc_lblNewLabelAutor = new GridBagConstraints();
		gbc_lblNewLabelAutor.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelAutor.insets = new Insets(0, 50, 5, 5);
		gbc_lblNewLabelAutor.gridx = 0;
		gbc_lblNewLabelAutor.gridy = 3;
		contentPane.add(lblNewLabelAutor, gbc_lblNewLabelAutor);
		
		textFieldCampoAutor = new JTextField();
		textFieldCampoAutor.setEditable(false);
		textFieldCampoAutor.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_textFieldCampoAutor = new GridBagConstraints();
		gbc_textFieldCampoAutor.insets = new Insets(0, 0, 5, 50);
		gbc_textFieldCampoAutor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCampoAutor.gridx = 1;
		gbc_textFieldCampoAutor.gridy = 3;
		contentPane.add(textFieldCampoAutor, gbc_textFieldCampoAutor);
		textFieldCampoAutor.setColumns(10);
		
		
		JLabel lblNewLabelDataPublicacao = new JLabel("Data de Publicação:");
		GridBagConstraints gbc_lblNewLabelDataPublicacao = new GridBagConstraints();
		gbc_lblNewLabelDataPublicacao.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelDataPublicacao.insets = new Insets(0, 50, 5, 5);
		gbc_lblNewLabelDataPublicacao.gridx = 0;
		gbc_lblNewLabelDataPublicacao.gridy = 4;
		contentPane.add(lblNewLabelDataPublicacao, gbc_lblNewLabelDataPublicacao);
		
		textFieldCampoDataPublicacao = new JTextField();
		textFieldCampoDataPublicacao.setEditable(false);
		textFieldCampoDataPublicacao.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_textFieldCampoDataPublicacao = new GridBagConstraints();
		gbc_textFieldCampoDataPublicacao.insets = new Insets(0, 0, 5, 50);
		gbc_textFieldCampoDataPublicacao.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCampoDataPublicacao.gridx = 1;
		gbc_textFieldCampoDataPublicacao.gridy = 4;
		contentPane.add(textFieldCampoDataPublicacao, gbc_textFieldCampoDataPublicacao);
		textFieldCampoDataPublicacao.setColumns(10);
		
		
		JLabel lblNewLabelEditora = new JLabel("Editora:");
		GridBagConstraints gbc_lblNewLabelEditora = new GridBagConstraints();
		gbc_lblNewLabelEditora.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelEditora.insets = new Insets(0, 50, 5, 5);
		gbc_lblNewLabelEditora.gridx = 0;
		gbc_lblNewLabelEditora.gridy = 5;
		contentPane.add(lblNewLabelEditora, gbc_lblNewLabelEditora);
		
		textFieldCampoEditora = new JTextField();
		textFieldCampoEditora.setEditable(false);
		textFieldCampoEditora.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_textFieldCampoEditora = new GridBagConstraints();
		gbc_textFieldCampoEditora.insets = new Insets(0, 0, 5, 50);
		gbc_textFieldCampoEditora.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCampoEditora.gridx = 1;
		gbc_textFieldCampoEditora.gridy = 5;
		contentPane.add(textFieldCampoEditora, gbc_textFieldCampoEditora);
		textFieldCampoEditora.setColumns(10);
		
		
		JLabel lblNewLabelDescricao = new JLabel("Descrição:");
		GridBagConstraints gbc_lblNewLabelDescricao = new GridBagConstraints();
		gbc_lblNewLabelDescricao.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelDescricao.insets = new Insets(0, 50, 5, 5);
		gbc_lblNewLabelDescricao.gridx = 0;
		gbc_lblNewLabelDescricao.gridy = 6;
		contentPane.add(lblNewLabelDescricao, gbc_lblNewLabelDescricao);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 50);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 6;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		textAreaDescricao = new JTextArea();
		textAreaDescricao.setEditable(false);
		scrollPane.setViewportView(textAreaDescricao);
		textAreaDescricao.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(textAreaDescricao);
		textAreaDescricao.setLineWrap(true);
		textAreaDescricao.setWrapStyleWord(true);
		
		
		JLabel lblNewLabelTotal = new JLabel("Quantidade:");
		GridBagConstraints gbc_lblNewLabelTotal = new GridBagConstraints();
		gbc_lblNewLabelTotal.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelTotal.insets = new Insets(0, 50, 5, 5);
		gbc_lblNewLabelTotal.gridx = 0;
		gbc_lblNewLabelTotal.gridy = 7;
		contentPane.add(lblNewLabelTotal, gbc_lblNewLabelTotal);
		
		textFieldCampoTotalExemplares = new JTextField();
		textFieldCampoTotalExemplares.setEditable(false);
		textFieldCampoTotalExemplares.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_textFieldCampoTotalExemplares = new GridBagConstraints();
		gbc_textFieldCampoTotalExemplares.insets = new Insets(0, 0, 5, 50);
		gbc_textFieldCampoTotalExemplares.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCampoTotalExemplares.gridx = 1;
		gbc_textFieldCampoTotalExemplares.gridy = 7;
		contentPane.add(textFieldCampoTotalExemplares, gbc_textFieldCampoTotalExemplares);
		textFieldCampoTotalExemplares.setColumns(10);
		
		JLabel lblNewLabelDisponiveis = new JLabel("Disponíveis:");
		GridBagConstraints gbc_lblNewLabelDisponiveis = new GridBagConstraints();
		gbc_lblNewLabelDisponiveis.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelDisponiveis.insets = new Insets(0, 50, 5, 5);
		gbc_lblNewLabelDisponiveis.gridx = 0;
		gbc_lblNewLabelDisponiveis.gridy = 8;
		contentPane.add(lblNewLabelDisponiveis, gbc_lblNewLabelDisponiveis);
		
		textField_1CampoDisponiveis = new JTextField();
		textField_1CampoDisponiveis.setEditable(false);
		textField_1CampoDisponiveis.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_textField_1CampoDisponiveis = new GridBagConstraints();
		gbc_textField_1CampoDisponiveis.insets = new Insets(0, 0, 5, 50);
		gbc_textField_1CampoDisponiveis.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1CampoDisponiveis.gridx = 1;
		gbc_textField_1CampoDisponiveis.gridy = 8;
		contentPane.add(textField_1CampoDisponiveis, gbc_textField_1CampoDisponiveis);
		textField_1CampoDisponiveis.setColumns(10);
		
		JLabel lblNewLabelEmprestados = new JLabel("Emprestados:");
		GridBagConstraints gbc_lblNewLabelEmprestados = new GridBagConstraints();
		gbc_lblNewLabelEmprestados.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelEmprestados.insets = new Insets(0, 50, 5, 5);
		gbc_lblNewLabelEmprestados.gridx = 0;
		gbc_lblNewLabelEmprestados.gridy = 9;
		contentPane.add(lblNewLabelEmprestados, gbc_lblNewLabelEmprestados);
		
		textFieldEmprestados = new JTextField();
		textFieldEmprestados.setEditable(false);
		textFieldEmprestados.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_textFieldEmprestados = new GridBagConstraints();
		gbc_textFieldEmprestados.insets = new Insets(0, 0, 5, 50);
		gbc_textFieldEmprestados.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmprestados.gridx = 1;
		gbc_textFieldEmprestados.gridy = 9;
		contentPane.add(textFieldEmprestados, gbc_textFieldEmprestados);
		textFieldEmprestados.setColumns(10);
		
	}
}
