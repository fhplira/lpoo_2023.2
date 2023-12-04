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

public class VisualizarLivros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String titulo1;
    private String autor1;
    private String isbn1;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(46, 60, 460, 378);
		contentPane.add(panel);
		
       LivroControlador livrosControlador = new LivroControlador();
		
		List<LivroModelo> livros = livrosControlador.buscarTodosOsLivros();
		
		 DefaultListModel<LivroModelo> modeloJList = new DefaultListModel<>();
	        for (LivroModelo livro : livros) {
	            modeloJList.addElement(livro);
	        }
	        

	        JList<LivroModelo> jList = new JList<>(modeloJList);
	        jList.setSize(400, 447);
	        //jList.setBounds(325, 0, 441, 452);
	        panel.setLayout(null);
	        JScrollPane scrollPane = new JScrollPane();
	        //jList.getBaseline(200, 200);
	   
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLocationRelativeTo(null);
	        
	        panel.add(jList);
	        
	        JButton visualizarLivro = new JButton("Visualizar Livro");
	        visualizarLivro.addActionListener(new ActionListener() {
	        	
	        		public void actionPerformed(ActionEvent e) {
	        			LivroModelo pegarLivro = new LivroModelo();
		                
		                   LivroModelo livroClicado = jList.getSelectedValue();
		                   String titulo = livroClicado.getTitulo();
		                   
		                   for(LivroModelo procurarLivro : livros) {
		                	   if(procurarLivro.equals(livroClicado)) {
		                		   pegarLivro.getTitulo();	                		 
		                		   pegarLivro.getIsbn();	                		 
		                		   pegarLivro.getDataPublicacao();	                		 
		                		                		 
		                	   }
		                   }
		                   
		                   LivroControlador livrosControlador = new LivroControlador();
		                   List<LivroModelo> livro = new ArrayList<>();
		                   
		                   try {
							livro = livrosControlador.buscarLivroPorTitulo(titulo);
						} catch (ExcecaoControlador e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		                  
		                  
		                   for(LivroModelo livroEspecifico : livro) {
		                	   titulo1 = livroEspecifico.getTitulo();
		                	   autor1 = livroEspecifico.getAutor();
		                	   isbn1 = livroEspecifico.getIsbn();
		                   }
		                   
		                
		                   File file = new File("src/main/resources/images/9788543808246");
		       		    
		   				byte[] bytes = null;
						try {
							bytes = Files.readAllBytes(file.toPath());
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		   				ImageIcon imagemIcon = new ImageIcon(bytes);
		   				
		   				//JLabel label = new JLabel(imagemIcon);
		   				//contentPane.add(label);
		                   
		                   JDialog dialog = new JDialog();
			                dialog.setVisible(true);
			                dialog.setSize(600, 800);
			        	
			        		//dialog.add(new JLabel(livro.get(1)));
			        		dialog.add(new JLabel(("titulo " + titulo1)));
			        		dialog.add(new JLabel(imagemIcon));
			        		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        	     setLocationRelativeTo(null);
			      
	        		}
	        });
	        visualizarLivro.setBounds(610, 121, 148, 23);
	        contentPane.add(visualizarLivro);
	        
	        
	       
		        JLabel lblNewLabel = new JLabel("VisualizarLivros");
		        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		        lblNewLabel.setBounds(312, 11, 263, 38);
		        contentPane.add(lblNewLabel);
	        	
	       
	              
	      
	    
	        
	        
	       
		
	        
	
	}
	}
