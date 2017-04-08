package exercicio5;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Moeda;

public class TesteBanco {
	
	private Banco bancoDoBrasil;

	@Before
	public void setUp() throws Exception {
		bancoDoBrasil = Auxiliar.criarBancoDoBrasil();
	}

	@Test
	public void testBancoDoBrasil() {
		assertEquals("Banco do Brasil", bancoDoBrasil.obterNome());
		assertEquals(Moeda.BRL, bancoDoBrasil.obterMoeda());
	}

}
