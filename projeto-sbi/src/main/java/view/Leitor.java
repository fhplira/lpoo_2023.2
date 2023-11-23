package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

public class Leitor {

	private JFrame frame;
	private JTextField txtEmprestimo;
	private JTextField txtAtraso;
	private JTextField txtMulta;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Leitor window = new Leitor();
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
	public Leitor() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Dados do leitor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(267, 41, 274, 39);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(267, 179, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(399, 138, 86, 19);
		frame.getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCpf.setBounds(399, 179, 46, 14);
		frame.getContentPane().add(lblCpf);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(399, 219, 56, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblNewLabel_6 = new JLabel("Empréstimo:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(267, 311, 86, 19);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Em atraso:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(267, 353, 86, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Multa por atraso:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(267, 392, 138, 20);
		frame.getContentPane().add(lblNewLabel_8);
		
		txtEmprestimo = new JTextField();
		txtEmprestimo.setBounds(382, 311, 86, 20);
		frame.getContentPane().add(txtEmprestimo);
		txtEmprestimo.setColumns(10);
		
		txtAtraso = new JTextField();
		txtAtraso.setBounds(382, 351, 86, 20);
		frame.getContentPane().add(txtAtraso);
		txtAtraso.setColumns(10);
		
		txtMulta = new JTextField();
		txtMulta.setBounds(382, 393, 86, 20);
		frame.getContentPane().add(txtMulta);
		txtMulta.setColumns(10);
		
		JButton btnMultaPaga = new JButton("Multa paga");
		btnMultaPaga.setBounds(524, 373, 138, 39);
		frame.getContentPane().add(btnMultaPaga);
		
		txtNome = new JTextField();
		txtNome.setBounds(458, 138, 225, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(458, 179, 225, 20);
		frame.getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(458, 217, 225, 20);
		frame.getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
	}
}
