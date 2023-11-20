package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Emprestimo {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emprestimo window = new Emprestimo();
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
	public Emprestimo() {
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
		
		JLabel lblNewLabel = new JLabel("Dados do livro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(267, 31, 226, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Título:");
		lblNewLabel_1.setBounds(357, 108, 57, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Autor:");
		lblNewLabel_2.setBounds(357, 129, 57, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Ano:");
		lblNewLabel_3.setBounds(357, 153, 67, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Editora:");
		lblNewLabel_4.setBounds(357, 179, 67, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(407, 104, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(407, 129, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(407, 153, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(407, 177, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Quantidade:");
		lblNewLabel_5.setBounds(617, 107, 86, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Emprestados:");
		lblNewLabel_6.setBounds(617, 128, 86, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Disponíveis:");
		lblNewLabel_7.setBounds(617, 154, 106, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		textField_4 = new JTextField();
		textField_4.setBounds(712, 104, 38, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(712, 129, 38, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(712, 153, 37, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Dados do Solicitante");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_8.setBounds(267, 222, 248, 27);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Nome:");
		lblNewLabel_9.setBounds(357, 283, 46, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("E-mail:");
		lblNewLabel_10.setBounds(357, 308, 46, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("CPF:");
		lblNewLabel_11.setBounds(357, 333, 46, 14);
		frame.getContentPane().add(lblNewLabel_11);
		
		textField_7 = new JTextField();
		textField_7.setBounds(407, 305, 235, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(407, 277, 235, 20);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(407, 330, 235, 20);
		frame.getContentPane().add(textField_9);
		
		JButton btnNewButton = new JButton("Fazer emprestimo");
		btnNewButton.setBounds(461, 401, 138, 39);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_12 = new JLabel("Data de emprestimo:");
		lblNewLabel_12.setBounds(357, 358, 147, 14);
		frame.getContentPane().add(lblNewLabel_12);
		
		textField_10 = new JTextField();
		textField_10.setBounds(493, 355, 86, 20);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
	}

}
