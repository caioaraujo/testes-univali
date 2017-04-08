package exercicio5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;

public class TesteAgencia {
	
	private Agencia agenciaCentro;

	@Before
	public void setUp() throws Exception {
		Banco bb = Auxiliar.criarBancoDoBrasil();
		agenciaCentro = Auxiliar.criarAgenciaCentro(bb);
	}

	@Test
	public void testAgenciaCentro() {
		assertEquals("001", agenciaCentro.obterIdentificador());
		assertEquals("Centro", agenciaCentro.obterNome());
		assertEquals("Banco do Brasil", agenciaCentro.obterBanco().obterNome());
	}

}
