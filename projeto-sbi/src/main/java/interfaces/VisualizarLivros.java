package interfaces;

import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controladores.ExcecaoControlador;
import controladores.LivroControlador;
import modelos.LivroModelo;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.SwingConstants;

public class VisualizarLivros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LivroControlador livroControlador = new LivroControlador();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarLivros frame = new VisualizarLivros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ExcecaoControlador 
	 */
	public VisualizarLivros() {
		setMaximumSize(new Dimension(3072, 3072));
		setMinimumSize(new Dimension(824, 510));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(137, 197, 61));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
        
		/*
		 * List<LivroModelo> livros = new ArrayList<>();
		 * 
		 * try { livros = livroControlador.buscarTodosOsLivros(); } catch
		 * (ExcecaoControlador e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } DefaultListModel<LivroModelo> modeloJList = new
		 * DefaultListModel<>();
		 * 
		 * modeloJList.addAll(livros); JScrollPane scrollPane = new JScrollPane();
		 * 
		 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setLocationRelativeTo(null);
		 * 
		 * JList<LivroModelo> jList = new JList<>(modeloJList);
		 * panelContents.add(jList);
		 */
        
        
        
        List<LivroModelo> livros = new ArrayList<>();
		
		try {
			livros = livroControlador.buscarTodosOsLivros();
		} catch (ExcecaoControlador e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 DefaultListModel<LivroModelo> modeloJList = new DefaultListModel<>();
	       
		 modeloJList.addAll(livros);
	        JScrollPane scrollPane = new JScrollPane();
	   
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
        
        JLabel lblNewLabel = new JLabel("VISUALIZAR LIVROS");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(30, 50, 60, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);
        
        JButton btnNewButton = new JButton("VOLTAR");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.anchor = GridBagConstraints.EAST;
        gbc_btnNewButton.insets = new Insets(30, 0, 60, 5);
        gbc_btnNewButton.gridx = 1;
        gbc_btnNewButton.gridy = 0;
        contentPane.add(btnNewButton, gbc_btnNewButton);
        
        JPanel panelContents = new JPanel();
        panelContents.setMinimumSize(new Dimension(824, 510));
        panelContents.setBackground(new Color(141, 197, 62));
        GridBagConstraints gbc_panelContents = new GridBagConstraints();
        gbc_panelContents.fill = GridBagConstraints.BOTH;
        gbc_panelContents.insets = new Insets(0, 50, 20, 5);
        gbc_panelContents.gridx = 0;
        gbc_panelContents.gridy = 1;
        contentPane.add(panelContents, gbc_panelContents);
        
        
        
        JPanel panel = new JPanel();
        panelContents.add(panel);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{400, 0};
        gbl_panel.rowHeights = new int[]{367, 0};
        gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);
        
        JList<LivroModelo> listaLivros = new JList<>(modeloJList);
        listaLivros.setFont(new Font("Tahoma", Font.PLAIN, 13));
        GridBagConstraints gbc_listaLivros = new GridBagConstraints();
        gbc_listaLivros.fill = GridBagConstraints.BOTH;
        gbc_listaLivros.gridx = 0;
        gbc_listaLivros.gridy = 0;
        panel.add(listaLivros, gbc_listaLivros);
        
        JButton visualizarLivro = new JButton("Visualizar Livro");
        GridBagConstraints gbc_visualizarLivro = new GridBagConstraints();
        gbc_visualizarLivro.insets = new Insets(0, 0, 0, 5);
        gbc_visualizarLivro.anchor = GridBagConstraints.NORTHEAST;
        gbc_visualizarLivro.gridx = 1;
        gbc_visualizarLivro.gridy = 1;
        contentPane.add(visualizarLivro, gbc_visualizarLivro);
        visualizarLivro.setFont(new Font("Tahoma", Font.BOLD, 13));
        visualizarLivro.setAlignmentX(Component.CENTER_ALIGNMENT);
        visualizarLivro.addActionListener(new ActionListener() {
        	
        		public void actionPerformed(ActionEvent e) {
                  
        		   LivroModelo livroClicado = listaLivros.getSelectedValue();  
		       		       String titulo = livroClicado.getTitulo();
		       		     
							try {
								LivroModelo chamarLivroCliclado = livroControlador.buscarLivroPorTitulo(titulo);
								
								VisualizarLivroEspecifico enviar = new VisualizarLivroEspecifico();
								enviar.enviarValores(chamarLivroCliclado);
								enviar.setVisible(true);
								dispose();
							} catch (ExcecaoControlador ex) {
								JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							} catch (Exception exc){
								JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
							}
        		
        		}});
	}
	}
