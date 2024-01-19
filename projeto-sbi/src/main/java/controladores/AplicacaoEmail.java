package controladores;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

import dados.ExcecaoDados;
import dados.LeitorDados;
import dados.LivroDados;
import modelos.EmprestimoModelo;
import modelos.LeitorModelo;
import modelos.LivroModelo;

public class AplicacaoEmail {
	   
	private LeitorDados leitorDados = new LeitorDados();
	private LivroDados livroDados = new LivroDados();
	private String meuEmail = "sbiprojeto@gmail.com";
	private String minhaSenha = "lxoppiimqfdikqtx";
	 
		public void enviarEmailCadastro(LeitorModelo leitor) throws ExcecaoControlador {
			
			SimpleEmail email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
			email.setSSLOnConnect(true);
			
			try {
				email.setFrom(meuEmail);
				email.setSubject("Bem Vindo ao Sistema SIB de Bibliotecas");
				email.setMsg("Olá "+ leitor.getNome() + "\n"
						+ "\nSeja Bem Vindo ao nosso sistema! \n"
						+ "\nAqui você pode realizar até dois empréstimos de livros simultâneos \n"
						+ "\nAproveite!");
				email.addTo(leitor.getEmail());
				email.send();
				}catch(Exception e) {
					throw new ExcecaoControlador(e.getMessage(), e);
			}
		}
		
		public void enviarEmailEmprestimo(EmprestimoModelo emprestimo) throws ExcecaoControlador {
			
			SimpleEmail email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
			email.setSSLOnConnect(true);
			
			LeitorModelo leitor = new LeitorModelo();
			try {
				leitor = leitorDados.buscarLeitorPorCpf(emprestimo.getCpf());
			} catch (ExcecaoDados e) {
				throw new ExcecaoControlador(e.getMessage(), e);
			}
			
			LivroModelo livro = new LivroModelo();
			try {
				livro = livroDados.buscarLivroPorIsbn(emprestimo.getIsbn());
			} catch (ExcecaoDados e) {
				throw new ExcecaoControlador(e.getMessage(), e);
			}
			
			try {
				email.setFrom(meuEmail);
				email.setSubject("Empréstimo Realizado");
				email.setMsg("Olá "+ leitor.getNome()+ "\n" + 
						" \nVocê realizou com sucesso seu "+ leitor.getEmprestimo()+"° empréstimo simultâneo"
						+ " disponível do limite de 2\n"
						+ " \nAqui segue o ID do seu empréstimo: "+ emprestimo.getId()+"\n"
						+ " \nLivro Emprestado: "+ livro.getTitulo()+"\n"
						+ " \nData de Emprestimo: "+ emprestimo.getDataEmprestimo().format(emprestimo.getPadraoHora())+"\n"
						+ " \nData de Devolução: "+ emprestimo.getDataDevolucao().format(emprestimo.getPadraoHora())+"\n"
						+ " \nCaro Leitor ao faltar 3 dias para devolução do livro enviaremos um lembrete \n"
						+ " \nPara facilitar a devolução informe o ID ao Bibliotecário \n"
						+ " \nBoa Leitura!");
				email.addTo(leitor.getEmail());
				email.send();
				}catch(Exception e) {
					throw new ExcecaoControlador(e.getMessage(), e);
			}
		}
		
		public void enviarEmailDevolucao(EmprestimoModelo emprestimo) throws ExcecaoControlador {
			
			SimpleEmail email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
			email.setSSLOnConnect(true);
			
			LeitorModelo leitor = new LeitorModelo();
			try {
				leitor = leitorDados.buscarLeitorPorCpf(emprestimo.getCpf());
			} catch (ExcecaoDados e) {
				throw new ExcecaoControlador(e.getMessage(), e);
			}
			
			LivroModelo livro = new LivroModelo();
			try {
				livro = livroDados.buscarLivroPorIsbn(emprestimo.getIsbn());
			} catch (ExcecaoDados e) {
				throw new ExcecaoControlador(e.getMessage(), e);
			}
			
			try {
				email.setFrom(meuEmail);
				email.setSubject("Devolução Realizada");
				email.setMsg("Olá "+ leitor.getNome()+ "\n" + 
						" \nVocê realizou com sucesso sua devolução agora você tem mais um "
						+ "emprestimo disponível.\n"
						+ " \nAqui segue o ID do seu empréstimo: "+ emprestimo.getId()+"\n"
						+ " \nLivro Emprestado: "+ livro.getTitulo()+"\n"
						+ " \nData de Emprestimo: "+ emprestimo.getDataEmprestimo().format(emprestimo.getPadraoHora())+"\n"
						+ " \nData de Devolução: "+ emprestimo.getDataDevolucao().format(emprestimo.getPadraoHora())+"\n"
						+ " \nNumero de dias atrasado: "+emprestimo.getDiasAtraso()+"\n"
						+ " \nObrigado pela preferência \n"
						+ " \nVolte Sempre!");
				email.addTo(leitor.getEmail());
				email.send();
				}catch(Exception e) {
					throw new ExcecaoControlador(e.getMessage(), e);
			}
			
		}
		
		public void enviarEmailAtualizarDados(LeitorModelo leitor) throws ExcecaoControlador {
			SimpleEmail email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
			email.setSSLOnConnect(true);
			
			try {
				email.setFrom(meuEmail);
				email.setSubject("Atualização de Email");
				email.setMsg("Olá "+ leitor.getNome() + "\n"
						+ "\nNotamos que você atualizou seu email \n"
						+ "\nA partir de agora entraremos em contato com você por aqui \n"
						+ "\nCaso necessário solicite novamente a troca de email!");
				email.addTo(leitor.getEmail());
				email.send();
				}catch(Exception e) {
					throw new ExcecaoControlador(e.getMessage(), e);
			}
		}
		
		public void enviarEmailAtraso(EmprestimoModelo emprestimo) throws ExcecaoControlador {
			
			SimpleEmail email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
			email.setSSLOnConnect(true);
			
			LeitorModelo leitor = new LeitorModelo();
			try {
				leitor = leitorDados.buscarLeitorPorCpf(emprestimo.getCpf());
			} catch (ExcecaoDados e) {
				throw new ExcecaoControlador(e.getMessage(), e);
			}
			
			LivroModelo livro = new LivroModelo();
			try {
				livro = livroDados.buscarLivroPorIsbn(emprestimo.getIsbn());
			} catch (ExcecaoDados e) {
				throw new ExcecaoControlador(e.getMessage(), e);
			}
			
			try {
				email.setFrom(meuEmail);
				email.setSubject("Emprestimo Atrasado");
				email.setMsg("Olá "+ leitor.getNome()+ "\n" + 
						" \nVocê Possui um emprestimo atrasado "
						+ "a seguir seguem as informações do imprestimo.\n"
						+ " \nAqui segue o ID do seu empréstimo: "+ emprestimo.getId()+"\n"
						+ " \nLivro Emprestado: "+ livro.getTitulo()+"\n"
						+ " \nData de Emprestimo: "+ emprestimo.getDataEmprestimo().format(emprestimo.getPadraoHora())+"\n"
						+ " \nData de Devolução: "+ emprestimo.getDataDevolucao().format(emprestimo.getPadraoHora())+"\n"
						+ " \nNumero de dias atrasado: "+emprestimo.getDiasAtraso()+"\n"
						+ " \nAguardamos a devolução o mais breve possivel! \n");
				email.addTo(leitor.getEmail());
				email.send();
				}catch(Exception e) {
					throw new ExcecaoControlador(e.getMessage(), e);
			}
			
		}
		
		public void enviarEmailAviso(EmprestimoModelo emprestimo) throws ExcecaoControlador {
			
			SimpleEmail email = new SimpleEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(meuEmail, minhaSenha));
			email.setSSLOnConnect(true);
			
			LeitorModelo leitor = new LeitorModelo();
			try {
				leitor = leitorDados.buscarLeitorPorCpf(emprestimo.getCpf());
			} catch (ExcecaoDados e) {
				throw new ExcecaoControlador(e.getMessage(), e);
			}
			
			LivroModelo livro = new LivroModelo();
			try {
				livro = livroDados.buscarLivroPorIsbn(emprestimo.getIsbn());
			} catch (ExcecaoDados e) {
				throw new ExcecaoControlador(e.getMessage(), e);
			}
			
			try {
				email.setFrom(meuEmail);
				email.setSubject("Aviso Fim Emprestimo");
				email.setMsg("Olá "+ leitor.getNome()+ "\n" + 
						" \nSeu emprestimo está proximo de acabar "
						+ "a seguir seguem as informações do imprestimo.\n"
						+ " \nAqui segue o ID do seu empréstimo: "+ emprestimo.getId()+"\n"
						+ " \nLivro Emprestado: "+ livro.getTitulo()+"\n"
						+ " \nData de Emprestimo: "+ emprestimo.getDataEmprestimo().format(emprestimo.getPadraoHora())+"\n"
						+ " \nData de Devolução: "+ emprestimo.getDataDevolucao().format(emprestimo.getPadraoHora())+"\n"
						+ " \nNumero de dias atrasado: "+emprestimo.getDiasAtraso()+"\n"
						+ " \nAguardamos a devolução o mais breve possivel! \n");
				email.addTo(leitor.getEmail());
				email.send();
				}catch(Exception e) {
					throw new ExcecaoControlador(e.getMessage(), e);
			}
			
		}
}
