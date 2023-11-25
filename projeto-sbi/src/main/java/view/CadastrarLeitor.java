package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class CadastrarLeitor {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarLeitor window = new CadastrarLeitor();
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
	public CadastrarLeitor() {
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
		btnCadastrarLivro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CadastrarLivro frameCadastrarLivro = new CadastrarLivro();
				frame.dispose();
				frameCadastrarLivro.setVisible(true);
				
			}
			
		}
				);
		
		
		
		JButton btnBuscarLivro = new JButton("Buscar livro");
		btnBuscarLivro.setBounds(20, 233, 138, 39);
		frame.getContentPane().add(btnBuscarLivro);
		
		JButton btnLeito = new JButton("Leitor");
		btnLeito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLeito.setBounds(20, 290, 138, 39);
		frame.getContentPane().add(btnLeito);
		
		JLabel lblNewLabel = new JLabel("Cadastrar leitor");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(356, 67, 258, 39);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(277, 154, 98, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(276, 192, 115, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(277, 229, 127, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(342, 152, 247, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(342, 190, 247, 20);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(342, 227, 247, 20);
		frame.getContentPane().add(textField_2);
		
		JButton btnNewButton_2 = new JButton("Cadastrar");
		btnNewButton_2.setBounds(397, 288, 138, 43);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnCadastrarLeitor = new JButton("Cadastrar Leitor");
		btnCadastrarLeitor.setBounds(20, 340, 138, 39);
		frame.getContentPane().add(btnCadastrarLeitor);
		
	}
}
