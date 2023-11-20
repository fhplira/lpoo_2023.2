package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class BuscarLeitor {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarLeitor window = new BuscarLeitor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BuscarLeitor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 824, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnTodosLivros = new JButton("Todos os livros ");
		btnTodosLivros.setBounds(20, 129, 138, 39);
		frame.getContentPane().add(btnTodosLivros);
		
		JButton btnCadastrarLivro = new JButton("Cadastrar livro");
		btnCadastrarLivro.setBounds(20, 179, 138, 43);
		frame.getContentPane().add(btnCadastrarLivro);
		
		JButton btnBuscarLivro = new JButton("Buscar livro");
		btnBuscarLivro.setBounds(20, 233, 138, 39);
		frame.getContentPane().add(btnBuscarLivro);
		
		JButton btnLeito = new JButton("Leitor");
		btnLeito.setBounds(20, 283, 138, 39);
		frame.getContentPane().add(btnLeito);
		
		JButton btnAdicionarLeitor = new JButton("Adicionar leitor");
		btnAdicionarLeitor.setBounds(20, 333, 138, 39);
		frame.getContentPane().add(btnAdicionarLeitor);
		
		JButton btnBuscarLeitor = new JButton("Buscar leitor");
		btnBuscarLeitor.setBounds(20, 383, 138, 39);
		frame.getContentPane().add(btnBuscarLeitor);
		
		JLabel lblNewLabel = new JLabel("Buscar leitor");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(364, 93, 188, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E-mail/CPF:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(287, 179, 200, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(363, 177, 247, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(378, 233, 138, 39);
		frame.getContentPane().add(btnBuscar);
	}

}
