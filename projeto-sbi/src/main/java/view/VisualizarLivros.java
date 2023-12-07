package view;

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
	public VisualizarLivros() throws ExcecaoControlador {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(137, 197, 61));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(46, 60, 460, 378);
		contentPane.add(panel);
		
   
		
		List<LivroModelo> livros = livroControlador.buscarTodosOsLivros();
		
		 DefaultListModel<LivroModelo> modeloJList = new DefaultListModel<>();
	       
		 modeloJList.addAll(livros);
	       
	     JList<LivroModelo> jList = new JList<>(modeloJList);
	        jList.setSize(400, 447);
	        panel.setLayout(null);
	        JScrollPane scrollPane = new JScrollPane();
	   
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        
	        panel.add(jList);
	        
	        JButton visualizarLivro = new JButton("Visualizar Livro");
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
	        visualizarLivro.setBounds(610, 121, 148, 23);
	        contentPane.add(visualizarLivro);
	        
	        
	       
		        JLabel lblNewLabel = new JLabel("VisualizarLivros");
		        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		        lblNewLabel.setBounds(312, 11, 263, 38);
		        contentPane.add(lblNewLabel);
		        
	       
	              
	      
	    
	        
	        
	       
		
	        
	
	}
	}
