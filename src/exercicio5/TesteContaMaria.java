package exercicio5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Conta;

public class TesteContaMaria {
	
	private Agencia agenciaCentro;

	@Before
	public void setUp() throws Exception {
		agenciaCentro = Auxiliar.criarAgenciaCentro(Auxiliar.criarBancoDoBrasil());
	}

	@Test
	public void testContaMaria() {
		String nomeMaria = "Maria";
		Conta contaMaria = agenciaCentro.criarConta(nomeMaria);
		assertEquals("0001-5", contaMaria.obterIdentificador());
		assertEquals(nomeMaria, contaMaria.obterTitular());
		assertEquals("0,00", contaMaria.calcularSaldo().obterQuantia().formatado());
		assertEquals("Centro", contaMaria.obterAgencia().obterNome());
	}

}
