package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelos.EmprestimoModelo;
import modelos.LeitorModelo;
import modelos.LivroModelo;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizarEmprestimoEspecifico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNomeLeitor;
	private JTextField textFieldEmailLeitor;
	private JTextField textField_2;
	private JTextField textField_id_1;
	private JTextField textField_isbn_1;
	private JTextField textField_Titulo_1;
	private JTextField textField_dataEmprestimo_1;
	private JTextField textField_data_devolucao_1;
	private JTextField textField_diasAtrasados_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarEmprestimoEspecifico frame = new VisualizarEmprestimoEspecifico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void enviarValores(EmprestimoModelo emprestimo, LivroModelo livro, LeitorModelo leitor) {
		
		textField_isbn_1.setText(emprestimo.getIsbn());
		textField_id_1.setText(Integer.toString(emprestimo.getId()));
		textField_dataEmprestimo_1.setText(emprestimo.getDataEmprestimoFormatada());
		textField_data_devolucao_1.setText(emprestimo.getDataDevolucaoFormatada());
		textField_diasAtrasados_1.setText(Integer.toString(emprestimo.getDiasAtraso()));
		textField_Titulo_1.setText(livro.getTitulo());
		textFieldNomeLeitor.setText(leitor.getNome());
		textFieldEmailLeitor.setText(leitor.getEmail());
		
	}

	/**
	 * Create the frame.
	 */
	public VisualizarEmprestimoEspecifico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 820, 432);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelVisualizarEmprestimo = new JLabel("Visualizar Empréstimo");
		labelVisualizarEmprestimo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		labelVisualizarEmprestimo.setBounds(263, 11, 303, 52);
		panel.add(labelVisualizarEmprestimo);
		
		JLabel labelDadosLeitor = new JLabel("Dados do Leitor:");
		labelDadosLeitor.setBounds(62, 71, 96, 14);
		panel.add(labelDadosLeitor);
		
		JLabel labelNomeLeitor = new JLabel("Nome:");
		labelNomeLeitor.setBounds(67, 99, 46, 14);
		panel.add(labelNomeLeitor);
		
		textFieldNomeLeitor = new JTextField();
		textFieldNomeLeitor.setEditable(false);
		textFieldNomeLeitor.setBounds(109, 96, 181, 20);
		panel.add(textFieldNomeLeitor);
		textFieldNomeLeitor.setColumns(10);
		
		JLabel labelEmailLeitor = new JLabel("Email:");
		labelEmailLeitor.setBounds(437, 99, 37, 14);
		panel.add(labelEmailLeitor);
		
		textFieldEmailLeitor = new JTextField();
		textFieldEmailLeitor.setEditable(false);
		textFieldEmailLeitor.setBounds(484, 96, 194, 20);
		panel.add(textFieldEmailLeitor);
		textFieldEmailLeitor.setColumns(10);
		
		JLabel labelDadosEmprestimo1 = new JLabel("Dados do emprestimo 1:");
		labelDadosEmprestimo1.setBounds(67, 152, 135, 14);
		panel.add(labelDadosEmprestimo1);
		
		JLabel labelIsbn1 = new JLabel("ISBN:");
		labelIsbn1.setBounds(76, 217, 37, 14);
		panel.add(labelIsbn1);
		
		textField_id_1 = new JTextField();
		textField_id_1.setEditable(false);
		textField_id_1.setBounds(109, 177, 181, 20);
		panel.add(textField_id_1);
		textField_id_1.setColumns(10);
		
		JLabel labelTitulo1 = new JLabel("Título:");
		labelTitulo1.setBounds(62, 250, 37, 14);
		panel.add(labelTitulo1);
		
		textField_isbn_1 = new JTextField();
		textField_isbn_1.setEditable(false);
		textField_isbn_1.setBounds(109, 214, 181, 20);
		panel.add(textField_isbn_1);
		textField_isbn_1.setColumns(10);
		
		JLabel labelId1 = new JLabel("ID:");
		labelId1.setBounds(89, 177, 24, 14);
		panel.add(labelId1);
		
		textField_Titulo_1 = new JTextField();
		textField_Titulo_1.setEditable(false);
		textField_Titulo_1.setBounds(104, 247, 186, 20);
		panel.add(textField_Titulo_1);
		textField_Titulo_1.setColumns(10);
		
		JLabel labelDataEmprestimo1 = new JLabel("Data do empréstimo:");
		labelDataEmprestimo1.setBounds(58, 281, 100, 14);
		panel.add(labelDataEmprestimo1);
		
		textField_dataEmprestimo_1 = new JTextField();
		textField_dataEmprestimo_1.setEditable(false);
		textField_dataEmprestimo_1.setBounds(168, 278, 122, 20);
		panel.add(textField_dataEmprestimo_1);
		textField_dataEmprestimo_1.setColumns(10);
		
		JLabel labelDataDevolucao1 = new JLabel("Data de devolução:");
		labelDataDevolucao1.setBounds(58, 302, 100, 14);
		panel.add(labelDataDevolucao1);
		
		textField_data_devolucao_1 = new JTextField();
		textField_data_devolucao_1.setEditable(false);
		textField_data_devolucao_1.setBounds(168, 299, 122, 20);
		panel.add(textField_data_devolucao_1);
		textField_data_devolucao_1.setColumns(10);
		
		JLabel labelDiasAtraso1 = new JLabel("Dias em atraso:");
		labelDiasAtraso1.setBounds(58, 327, 100, 14);
		panel.add(labelDiasAtraso1);
		
		textField_diasAtrasados_1 = new JTextField();
		textField_diasAtrasados_1.setEditable(false);
		textField_diasAtrasados_1.setBounds(168, 324, 122, 20);
		panel.add(textField_diasAtrasados_1);
		textField_diasAtrasados_1.setColumns(10);
		
		JButton botaoDevolver_1 = new JButton("DEVOLVER");
		botaoDevolver_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		botaoDevolver_1.setBounds(445, 234, 89, 23);
		panel.add(botaoDevolver_1);
			
		JButton botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botaoVoltar.setBounds(703, 11, 89, 23);
		panel.add(botaoVoltar);
	}
}
