package interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.EmprestimoControlador;
import controladores.ExcecaoControlador;
import modelos.EmprestimoModelo;
import modelos.LeitorModelo;
import modelos.LivroModelo;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Color;

public class VisualizarEmprestimoEspecifico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNomeLeitor;
	private JTextField textFieldEmailLeitor;
	private JTextField textField_id_1;
	private JTextField textField_isbn_1;
	private JTextField textField_Titulo_1;
	private JTextField textField_dataEmprestimo_1;
	private JTextField textField_data_devolucao_1;
	private JTextField textField_diasAtrasados_1;
	private JTextField textFieldDevolvido;
	private JTextField textFieldCpf;
	
	private EmprestimoControlador emprestimoControlador = new EmprestimoControlador();

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
		
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		 String dataEmprestimoFormatada = emprestimo.getDataEmprestimo().format(formatter);
		 String dataDevolucaoFormatada = emprestimo.getDataDevolucao().format(formatter);

		textField_dataEmprestimo_1.setText(dataEmprestimoFormatada);
		textField_data_devolucao_1.setText(dataDevolucaoFormatada);
		textField_diasAtrasados_1.setText(Long.toString(emprestimo.getDiasAtraso()));
		textField_Titulo_1.setText(livro.getTitulo());
		textFieldNomeLeitor.setText(leitor.getNome());
		textFieldEmailLeitor.setText(leitor.getEmail());
		textFieldCpf.setText(leitor.getCpf());
		textFieldDevolvido.setText(Boolean.toString(emprestimo.isDevolvido()));
	}

	/**
	 * Create the frame.
	 */
	public VisualizarEmprestimoEspecifico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 471);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(141, 197, 62));
		contentPane.setMinimumSize(new Dimension(824, 510));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{820, 0};
		gbl_contentPane.rowHeights = new int[]{432, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(141, 197, 62));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{53, 46, 54, 86, 54, 134, 54, 0, 0};
		gbl_panel.rowHeights = new int[]{52, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel labelVisualizarEmprestimo = new JLabel("VISUALIZAR EMPRÉSTIMO");
		labelVisualizarEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 25));
		GridBagConstraints gbc_labelVisualizarEmprestimo = new GridBagConstraints();
		gbc_labelVisualizarEmprestimo.insets = new Insets(30, 50, 60, 5);
		gbc_labelVisualizarEmprestimo.gridwidth = 6;
		gbc_labelVisualizarEmprestimo.gridx = 1;
		gbc_labelVisualizarEmprestimo.gridy = 0;
		panel.add(labelVisualizarEmprestimo, gbc_labelVisualizarEmprestimo);
		
		JButton botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.setFont(new Font("Tahoma", Font.BOLD, 13));
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VisualizarEmprestimos().setVisible(true);
			}
		});
		GridBagConstraints gbc_botaoVoltar = new GridBagConstraints();
		gbc_botaoVoltar.insets = new Insets(30, 0, 60, 0);
		gbc_botaoVoltar.gridx = 7;
		gbc_botaoVoltar.gridy = 0;
		panel.add(botaoVoltar, gbc_botaoVoltar);
		
		JLabel labelDadosLeitor = new JLabel("DADOS DO LEITOR:");
		labelDadosLeitor.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_labelDadosLeitor = new GridBagConstraints();
		gbc_labelDadosLeitor.anchor = GridBagConstraints.WEST;
		gbc_labelDadosLeitor.insets = new Insets(0, 0, 5, 5);
		gbc_labelDadosLeitor.gridx = 1;
		gbc_labelDadosLeitor.gridy = 1;
		panel.add(labelDadosLeitor, gbc_labelDadosLeitor);
		
		JLabel labelNomeLeitor = new JLabel("Nome:");
		GridBagConstraints gbc_labelNomeLeitor = new GridBagConstraints();
		gbc_labelNomeLeitor.anchor = GridBagConstraints.EAST;
		gbc_labelNomeLeitor.insets = new Insets(0, 0, 5, 5);
		gbc_labelNomeLeitor.gridx = 1;
		gbc_labelNomeLeitor.gridy = 2;
		panel.add(labelNomeLeitor, gbc_labelNomeLeitor);
		
		textFieldNomeLeitor = new JTextField();
		textFieldNomeLeitor.setEditable(false);
		GridBagConstraints gbc_textFieldNomeLeitor = new GridBagConstraints();
		gbc_textFieldNomeLeitor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNomeLeitor.insets = new Insets(0, 5, 5, 5);
		gbc_textFieldNomeLeitor.gridx = 2;
		gbc_textFieldNomeLeitor.gridy = 2;
		panel.add(textFieldNomeLeitor, gbc_textFieldNomeLeitor);
		textFieldNomeLeitor.setColumns(10);
		
		JLabel labelEmailLeitor = new JLabel("Email:");
		GridBagConstraints gbc_labelEmailLeitor = new GridBagConstraints();
		gbc_labelEmailLeitor.anchor = GridBagConstraints.EAST;
		gbc_labelEmailLeitor.insets = new Insets(0, 0, 5, 5);
		gbc_labelEmailLeitor.gridx = 3;
		gbc_labelEmailLeitor.gridy = 2;
		panel.add(labelEmailLeitor, gbc_labelEmailLeitor);
		
		textFieldEmailLeitor = new JTextField();
		textFieldEmailLeitor.setEditable(false);
		GridBagConstraints gbc_textFieldEmailLeitor = new GridBagConstraints();
		gbc_textFieldEmailLeitor.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldEmailLeitor.insets = new Insets(0, 5, 5, 5);
		gbc_textFieldEmailLeitor.gridx = 4;
		gbc_textFieldEmailLeitor.gridy = 2;
		panel.add(textFieldEmailLeitor, gbc_textFieldEmailLeitor);
		textFieldEmailLeitor.setColumns(10);
		
		JLabel labelCpf = new JLabel("CPF:");
		GridBagConstraints gbc_labelCpf = new GridBagConstraints();
		gbc_labelCpf.anchor = GridBagConstraints.EAST;
		gbc_labelCpf.insets = new Insets(0, 0, 5, 5);
		gbc_labelCpf.gridx = 5;
		gbc_labelCpf.gridy = 2;
		panel.add(labelCpf, gbc_labelCpf);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setEditable(false);
		GridBagConstraints gbc_textFieldCpf = new GridBagConstraints();
		gbc_textFieldCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldCpf.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldCpf.gridx = 6;
		gbc_textFieldCpf.gridy = 2;
		panel.add(textFieldCpf, gbc_textFieldCpf);
		textFieldCpf.setColumns(10);
		
		JLabel labelDadosEmprestimo1 = new JLabel("DADOS DO EMPRÉSTIMO:");
		labelDadosEmprestimo1.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_labelDadosEmprestimo1 = new GridBagConstraints();
		gbc_labelDadosEmprestimo1.anchor = GridBagConstraints.WEST;
		gbc_labelDadosEmprestimo1.insets = new Insets(0, 0, 5, 5);
		gbc_labelDadosEmprestimo1.gridx = 1;
		gbc_labelDadosEmprestimo1.gridy = 4;
		panel.add(labelDadosEmprestimo1, gbc_labelDadosEmprestimo1);
		
		JLabel labelId1 = new JLabel("ID:");
		GridBagConstraints gbc_labelId1 = new GridBagConstraints();
		gbc_labelId1.anchor = GridBagConstraints.EAST;
		gbc_labelId1.insets = new Insets(0, 0, 5, 5);
		gbc_labelId1.gridx = 1;
		gbc_labelId1.gridy = 5;
		panel.add(labelId1, gbc_labelId1);
		
		textField_id_1 = new JTextField();
		textField_id_1.setEditable(false);
		GridBagConstraints gbc_textField_id_1 = new GridBagConstraints();
		gbc_textField_id_1.gridwidth = 3;
		gbc_textField_id_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_id_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_id_1.gridx = 2;
		gbc_textField_id_1.gridy = 5;
		panel.add(textField_id_1, gbc_textField_id_1);
		textField_id_1.setColumns(10);
		
		JLabel labelIsbn1 = new JLabel("ISBN:");
		GridBagConstraints gbc_labelIsbn1 = new GridBagConstraints();
		gbc_labelIsbn1.anchor = GridBagConstraints.EAST;
		gbc_labelIsbn1.insets = new Insets(0, 0, 5, 5);
		gbc_labelIsbn1.gridx = 1;
		gbc_labelIsbn1.gridy = 6;
		panel.add(labelIsbn1, gbc_labelIsbn1);
		
		textField_isbn_1 = new JTextField();
		textField_isbn_1.setEditable(false);
		GridBagConstraints gbc_textField_isbn_1 = new GridBagConstraints();
		gbc_textField_isbn_1.gridwidth = 3;
		gbc_textField_isbn_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_isbn_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_isbn_1.gridx = 2;
		gbc_textField_isbn_1.gridy = 6;
		panel.add(textField_isbn_1, gbc_textField_isbn_1);
		textField_isbn_1.setColumns(10);
		
		JLabel labelTitulo1 = new JLabel("Título:");
		GridBagConstraints gbc_labelTitulo1 = new GridBagConstraints();
		gbc_labelTitulo1.anchor = GridBagConstraints.EAST;
		gbc_labelTitulo1.insets = new Insets(0, 0, 5, 5);
		gbc_labelTitulo1.gridx = 1;
		gbc_labelTitulo1.gridy = 7;
		panel.add(labelTitulo1, gbc_labelTitulo1);
		
		textField_Titulo_1 = new JTextField();
		textField_Titulo_1.setEditable(false);
		GridBagConstraints gbc_textField_Titulo_1 = new GridBagConstraints();
		gbc_textField_Titulo_1.gridwidth = 3;
		gbc_textField_Titulo_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_Titulo_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Titulo_1.gridx = 2;
		gbc_textField_Titulo_1.gridy = 7;
		panel.add(textField_Titulo_1, gbc_textField_Titulo_1);
		textField_Titulo_1.setColumns(10);
		
		JLabel labelDataEmprestimo1 = new JLabel("Data do empréstimo:");
		GridBagConstraints gbc_labelDataEmprestimo1 = new GridBagConstraints();
		gbc_labelDataEmprestimo1.anchor = GridBagConstraints.EAST;
		gbc_labelDataEmprestimo1.insets = new Insets(0, 0, 5, 5);
		gbc_labelDataEmprestimo1.gridx = 1;
		gbc_labelDataEmprestimo1.gridy = 8;
		panel.add(labelDataEmprestimo1, gbc_labelDataEmprestimo1);
		
		textField_dataEmprestimo_1 = new JTextField();
		textField_dataEmprestimo_1.setEditable(false);
		GridBagConstraints gbc_textField_dataEmprestimo_1 = new GridBagConstraints();
		gbc_textField_dataEmprestimo_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_dataEmprestimo_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_dataEmprestimo_1.gridwidth = 3;
		gbc_textField_dataEmprestimo_1.gridx = 2;
		gbc_textField_dataEmprestimo_1.gridy = 8;
		panel.add(textField_dataEmprestimo_1, gbc_textField_dataEmprestimo_1);
		textField_dataEmprestimo_1.setColumns(10);
		
		JLabel labelDataDevolucao1 = new JLabel("Data de devolução:");
		GridBagConstraints gbc_labelDataDevolucao1 = new GridBagConstraints();
		gbc_labelDataDevolucao1.anchor = GridBagConstraints.EAST;
		gbc_labelDataDevolucao1.insets = new Insets(0, 0, 5, 5);
		gbc_labelDataDevolucao1.gridx = 1;
		gbc_labelDataDevolucao1.gridy = 9;
		panel.add(labelDataDevolucao1, gbc_labelDataDevolucao1);
		
		textField_data_devolucao_1 = new JTextField();
		textField_data_devolucao_1.setEditable(false);
		GridBagConstraints gbc_textField_data_devolucao_1 = new GridBagConstraints();
		gbc_textField_data_devolucao_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_data_devolucao_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_data_devolucao_1.gridwidth = 3;
		gbc_textField_data_devolucao_1.gridx = 2;
		gbc_textField_data_devolucao_1.gridy = 9;
		panel.add(textField_data_devolucao_1, gbc_textField_data_devolucao_1);
		textField_data_devolucao_1.setColumns(10);
		
		JLabel labelDiasAtraso1 = new JLabel("Dias em atraso:");
		GridBagConstraints gbc_labelDiasAtraso1 = new GridBagConstraints();
		gbc_labelDiasAtraso1.anchor = GridBagConstraints.EAST;
		gbc_labelDiasAtraso1.insets = new Insets(0, 0, 5, 5);
		gbc_labelDiasAtraso1.gridx = 1;
		gbc_labelDiasAtraso1.gridy = 10;
		panel.add(labelDiasAtraso1, gbc_labelDiasAtraso1);
		
		textField_diasAtrasados_1 = new JTextField();
		textField_diasAtrasados_1.setEditable(false);
		GridBagConstraints gbc_textField_diasAtrasados_1 = new GridBagConstraints();
		gbc_textField_diasAtrasados_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_diasAtrasados_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_diasAtrasados_1.gridwidth = 3;
		gbc_textField_diasAtrasados_1.gridx = 2;
		gbc_textField_diasAtrasados_1.gridy = 10;
		panel.add(textField_diasAtrasados_1, gbc_textField_diasAtrasados_1);
		textField_diasAtrasados_1.setColumns(10);
		
		JLabel labelDevolvido = new JLabel("Devolvido:");
		GridBagConstraints gbc_labelDevolvido = new GridBagConstraints();
		gbc_labelDevolvido.anchor = GridBagConstraints.EAST;
		gbc_labelDevolvido.insets = new Insets(0, 0, 15, 5);
		gbc_labelDevolvido.gridx = 1;
		gbc_labelDevolvido.gridy = 11;
		panel.add(labelDevolvido, gbc_labelDevolvido);
		
		textFieldDevolvido = new JTextField();
		textFieldDevolvido.setEditable(false);
		GridBagConstraints gbc_textFieldDevolvido = new GridBagConstraints();
		gbc_textFieldDevolvido.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDevolvido.gridwidth = 3;
		gbc_textFieldDevolvido.insets = new Insets(0, 0, 15, 5);
		gbc_textFieldDevolvido.gridx = 2;
		gbc_textFieldDevolvido.gridy = 11;
		panel.add(textFieldDevolvido, gbc_textFieldDevolvido);
		textFieldDevolvido.setColumns(10);
		
		JButton botaoDevolver_1 = new JButton("DEVOLVER");
		botaoDevolver_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		botaoDevolver_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					EmprestimoModelo emprestimoPego =  emprestimoControlador.buscarEmprestimo(textFieldCpf.getText(),textField_isbn_1.getText());
					emprestimoControlador.fazerDevolucao(emprestimoPego);
					
					JOptionPane.showMessageDialog(null, "O livro " + textField_Titulo_1.getText()+ " foi devolvido com sucesso.", "Success", JOptionPane.INFORMATION_MESSAGE);
					textFieldDevolvido.setText(Boolean.toString(true));
					
				} catch (ExcecaoControlador e1) {	
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				} catch (Exception exc){
					JOptionPane.showMessageDialog(null, "Algum erro inesperado aconteceu.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		GridBagConstraints gbc_botaoDevolver_1 = new GridBagConstraints();
		gbc_botaoDevolver_1.insets = new Insets(0, 0, 15, 5);
		gbc_botaoDevolver_1.gridx = 7;
		gbc_botaoDevolver_1.gridy = 11;
		panel.add(botaoDevolver_1, gbc_botaoDevolver_1);
	}
}
