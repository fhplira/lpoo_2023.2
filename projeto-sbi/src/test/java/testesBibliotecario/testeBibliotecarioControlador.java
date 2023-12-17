package testesBibliotecario;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import controladores.BibliotecarioControlador;
import controladores.ExcecaoControlador;
import dados.BibliotecarioDados;
import dados.ExcecaoDados;

@RunWith(MockitoJUnitRunner.class)
public class testeBibliotecarioControlador {

    @InjectMocks
    private BibliotecarioControlador controlador;

    @Mock
    private BibliotecarioDados dadosMock;

    @Test
    public void loginBibliotecarioComSucessoTest() throws Exception {
        when(dadosMock.verificarEmailBibliotecario("exemplo@gmail.com")).thenReturn(true);
        when(dadosMock.verificarSenha("exemplo@gmail.com", "senha123")).thenReturn(true);

        try {
            controlador.login("exemplo@gmail.com", "senha123");
        } catch (ExcecaoControlador e) {
            fail();
        }
    }
}
