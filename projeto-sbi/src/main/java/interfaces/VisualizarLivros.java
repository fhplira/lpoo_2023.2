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
		setMinimumSize(new Dimension(824, 510));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(137, 197, 61));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{46, 529, 35, 148, 0};
		gbl_contentPane.rowHeights = new int[]{38, 378, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
   
		
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
	        
	        
	       
		        JLabel lblNewLabel = new JLabel("VisualizarLivros");
		        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		        gbc_lblNewLabel.gridwidth = 2;
		        gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		        gbc_lblNewLabel.insets = new Insets(40, 0, 15, 5);
		        gbc_lblNewLabel.gridx = 1;
		        gbc_lblNewLabel.gridy = 0;
		        contentPane.add(lblNewLabel, gbc_lblNewLabel);
	        
	        JButton btnNewButton = new JButton("VOLTAR");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		new BotoesPrincipais().setVisible(true);
	        	}
	        });
	        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
	        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
	        gbc_btnNewButton.insets = new Insets(40, 0, 15, 20);
	        gbc_btnNewButton.gridx = 3;
	        gbc_btnNewButton.gridy = 0;
	        contentPane.add(btnNewButton, gbc_btnNewButton);
	        
	        JPanel panel = new JPanel();
	        GridBagConstraints gbc_panel = new GridBagConstraints();
	        gbc_panel.fill = GridBagConstraints.BOTH;
	        gbc_panel.insets = new Insets(0, 0, 20, 5);
	        gbc_panel.gridx = 1;
	        gbc_panel.gridy = 1;
	        contentPane.add(panel, gbc_panel);
	     GridBagLayout gbl_panel = new GridBagLayout();
	     gbl_panel.columnWidths = new int[]{400, 0};
	     gbl_panel.rowHeights = new int[]{367, 0};
	     gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
	     gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
	     panel.setLayout(gbl_panel);
	     
	      JList<LivroModelo> jList = new JList<>(modeloJList);
	     
	     GridBagConstraints gbc_jList = new GridBagConstraints();
	     gbc_jList.fill = GridBagConstraints.BOTH;
	     gbc_jList.gridx = 0;
	     gbc_jList.gridy = 0;
	     panel.add(jList, gbc_jList);
		        
		        JButton visualizarLivro = new JButton("Visualizar Livro");
		        visualizarLivro.setAlignmentX(Component.CENTER_ALIGNMENT);
		        visualizarLivro.addActionListener(new ActionListener() {
		        	
		        		public void actionPerformed(ActionEvent e) {
		                  
		        		   LivroModelo livroClicado = jList.getSelectedValue();  
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
		        GridBagConstraints gbc_visualizarLivro = new GridBagConstraints();
		        gbc_visualizarLivro.insets = new Insets(0, 0, 0, 20);
		        gbc_visualizarLivro.gridx = 3;
		        gbc_visualizarLivro.gridy = 1;
		        contentPane.add(visualizarLivro, gbc_visualizarLivro);
		        
	       
	              
	      
	    
	        
	        
	       
		
	        
	
	}
	}
