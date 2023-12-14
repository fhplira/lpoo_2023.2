package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;

import controladores.Constantes;
import controladores.ExcecaoControlador;
import controladores.LivroControlador;
import modelos.LivroModelo;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Component;

public class ControleExemplares extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIsbn;
	private JTextField txtQtdExemplares;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControleExemplares frameControleExemplares = new ControleExemplares();
					frameControleExemplares.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ControleExemplares() {
		setMinimumSize(new Dimension(824, 510));
		//setResizable(false);
		
		final DefaultListModel<LivroModelo> modeloJlist = new DefaultListModel();
		
		final LivroControlador controlador = new LivroControlador();
			
		List<LivroModelo> livros = new ArrayList<>();
		
		try {
			
			livros = controlador.buscarTodosOsLivros();
			
			modeloJlist.addAll(livros);
			
		} catch (ExcecaoControlador e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
			exc.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 774, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(141, 197, 62));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{217, 516, 0};
		gbl_contentPane.rowHeights = new int[]{16, 408, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("LIVROS:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{207, 214, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{37, 50, 22, 22, 140, 27, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblTitutlo = new JLabel("CONTROLE DE EXEMPLARES");
		lblTitutlo.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitutlo.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblTitutlo = new GridBagConstraints();
		gbc_lblTitutlo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitutlo.gridwidth = 5;
		gbc_lblTitutlo.gridx = 0;
		gbc_lblTitutlo.gridy = 1;
		panel.add(lblTitutlo, gbc_lblTitutlo);
		
		JLabel lblIsbn = new JLabel("ISBN:");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblIsbn = new GridBagConstraints();
		gbc_lblIsbn.anchor = GridBagConstraints.EAST;
		gbc_lblIsbn.insets = new Insets(0, 0, 5, 5);
		gbc_lblIsbn.gridx = 0;
		gbc_lblIsbn.gridy = 5;
		panel.add(lblIsbn, gbc_lblIsbn);
		
		txtIsbn = new JTextField();
		txtIsbn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtIsbn.setEnabled(false);
		GridBagConstraints gbc_txtIsbn = new GridBagConstraints();
		gbc_txtIsbn.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIsbn.insets = new Insets(0, 0, 5, 5);
		gbc_txtIsbn.gridx = 1;
		gbc_txtIsbn.gridy = 5;
		panel.add(txtIsbn, gbc_txtIsbn);
		txtIsbn.setColumns(10);
		
		JLabel lblQtdExemplares = new JLabel("Quantidade de exemplares:");
		lblQtdExemplares.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblQtdExemplares = new GridBagConstraints();
		gbc_lblQtdExemplares.gridheight = 2;
		gbc_lblQtdExemplares.anchor = GridBagConstraints.EAST;
		gbc_lblQtdExemplares.insets = new Insets(0, 0, 20, 5);
		gbc_lblQtdExemplares.gridx = 0;
		gbc_lblQtdExemplares.gridy = 6;
		panel.add(lblQtdExemplares, gbc_lblQtdExemplares);
		
		txtQtdExemplares = new JTextField();
		txtQtdExemplares.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_txtQtdExemplares = new GridBagConstraints();
		gbc_txtQtdExemplares.gridheight = 2;
		gbc_txtQtdExemplares.anchor = GridBagConstraints.NORTH;
		gbc_txtQtdExemplares.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtQtdExemplares.insets = new Insets(0, 0, 20, 5);
		gbc_txtQtdExemplares.gridx = 1;
		gbc_txtQtdExemplares.gridy = 6;
		panel.add(txtQtdExemplares, gbc_txtQtdExemplares);
		txtQtdExemplares.setColumns(10);
		
		JButton btnAdicionarExemplar = new JButton(" Adiconar Exemplar/s");
		btnAdicionarExemplar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String isbn = txtIsbn.getText();
				String qtdExemplares = txtQtdExemplares.getText();
				
				try {
					LivroModelo livro = new LivroModelo();
					livro.setIsbn(isbn);
					controlador.AdicionarExemplares(livro, qtdExemplares);
					JOptionPane.showMessageDialog(null, "Exemplar/s adicionado/s com sucesso!", null, JOptionPane.INFORMATION_MESSAGE, null);
				} catch (ExcecaoControlador e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
					exc.printStackTrace();
				}
				
			}
		});
		btnAdicionarExemplar.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnAdicionarExemplar = new GridBagConstraints();
		gbc_btnAdicionarExemplar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnAdicionarExemplar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdicionarExemplar.gridx = 0;
		gbc_btnAdicionarExemplar.gridy = 9;
		panel.add(btnAdicionarExemplar, gbc_btnAdicionarExemplar);
		
		JButton btnRemoverExemplar = new JButton("Remover Exemplar/s");
		btnRemoverExemplar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Isbn = txtIsbn.getText();
				String qtdExemplares = txtQtdExemplares.getText();
				
				try {
					LivroModelo livro = new LivroModelo();
					livro.setIsbn(Isbn);
					controlador.ExcluirExemplares(livro, qtdExemplares);
					JOptionPane.showMessageDialog(null, "Exemplar/s excluído/s com sucesso!", null, JOptionPane.INFORMATION_MESSAGE, null);
				} catch (ExcecaoControlador e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
					exc.printStackTrace();
				}
			}
		});
		btnRemoverExemplar.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_btnRemoverExemplar = new GridBagConstraints();
		gbc_btnRemoverExemplar.insets = new Insets(0, 0, 0, 5);
		gbc_btnRemoverExemplar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnRemoverExemplar.gridx = 1;
		gbc_btnRemoverExemplar.gridy = 9;
		panel.add(btnRemoverExemplar, gbc_btnRemoverExemplar);
		
		JButton btnNewButton = new JButton("SAIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BotoesPrincipais().setVisible(true);
				
			}
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 9;
		panel.add(btnNewButton, gbc_btnNewButton);
		final JList listaLivros = new JList(modeloJlist);
		JScrollPane scroll = new JScrollPane(listaLivros);
		
		listaLivros.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index = listaLivros.getSelectedIndex();
				String isbn = modeloJlist.get(index).getIsbn();
				txtIsbn.setText(isbn);
			}
		});
		
		listaLivros.setBounds(EXIT_ON_CLOSE, ABORT, 100, 450);
		listaLivros.setFont(new Font("Tahoma", Font.PLAIN, 13));
		listaLivros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaLivros.setVisibleRowCount(5);
		GridBagConstraints gbc_scroll = new GridBagConstraints();
		gbc_scroll.fill = GridBagConstraints.BOTH;
		gbc_scroll.insets = new Insets(0, 0, 0, 5);
		gbc_scroll.gridx = 0;
		gbc_scroll.gridy = 1;
		getContentPane().add(scroll, gbc_scroll);
	}
}
