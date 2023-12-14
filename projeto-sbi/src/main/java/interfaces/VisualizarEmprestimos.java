package interfaces;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.EmprestimoControlador;
import controladores.ExcecaoControlador;
import controladores.LeitorControlador;
import controladores.LivroControlador;
import modelos.EmprestimoModelo;
import modelos.LeitorModelo;
import modelos.LivroModelo;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisualizarEmprestimos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private EmprestimoControlador emprestimoControlador = new EmprestimoControlador();
	private LivroControlador livroControlador = new LivroControlador();
	private LeitorControlador leitorControlador = new LeitorControlador();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VisualizarEmprestimos frame = new VisualizarEmprestimos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VisualizarEmprestimos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 876, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		List<EmprestimoModelo> emprestimos = new ArrayList<>();
		try {
			emprestimos = emprestimoControlador.buscarTodosEmprestimos();
			
		} catch (ExcecaoControlador e) {
			e.printStackTrace();
		}
		
		DefaultListModel<EmprestimoModelo> modeloJList = new DefaultListModel<>();
		modeloJList.addAll(emprestimos);
		JList<EmprestimoModelo> jList = new JList<>(modeloJList);
		jList.setBounds(50, 44, 395, 378);
		contentPane.add(jList);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(427, 44, 17, 378);
		contentPane.add(scrollBar);
		
		JButton btnNewButton = new JButton("VISUALIZAR EMPRÉSTIMO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmprestimoModelo emprestimoClicado = jList.getSelectedValue();
				
				try {
					LivroModelo livro = livroControlador.buscarLivroPorIsbn(emprestimoClicado.getIsbn());
					LeitorModelo leitor = leitorControlador.buscarLeitorPorCpf(emprestimoClicado.getCpf());
					VisualizarEmprestimoEspecifico enviar = new VisualizarEmprestimoEspecifico();
					enviar.enviarValores(emprestimoClicado, livro, leitor);
					enviar.setVisible(true);
					dispose();
					
				} catch (ExcecaoControlador e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(542, 109, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VOLTAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BotoesPrincipais().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(542, 180, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
