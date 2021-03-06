package exercicio5;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteContaMaria {
	
	private Agencia agenciaCentro;
	private Conta contaMaria;
	private SistemaBancario sistemaBancario;

	@Before
	public void setUp() throws Exception {
		sistemaBancario = new SistemaBancario();
		agenciaCentro = Auxiliar.criarAgenciaCentro(Auxiliar.criarBancoDoBrasil(sistemaBancario));
		contaMaria = Auxiliar.createContaMaria(agenciaCentro);
	}

	@Test
	public void testContaMaria() {
		assertEquals("0001-5", contaMaria.obterIdentificador());
		assertEquals("Maria", contaMaria.obterTitular());
		assertEquals("0,00", contaMaria.calcularSaldo().obterQuantia().formatado());
		assertEquals("Centro", contaMaria.obterAgencia().obterNome());
	}
	
	@Test
	public void testDepositoDezConto() {
		// Deposito de 10 reais
		Dinheiro quantia = new Dinheiro(agenciaCentro.obterBanco().obterMoeda(), 10, 0);
		sistemaBancario.depositar(contaMaria, quantia);
		
		assertEquals(quantia, contaMaria.calcularSaldo().obterQuantia());
	}
	
	@Test
	public void testSaqueSeisConto() {
		// Deposito de 10 reais
		Dinheiro quantia = new Dinheiro(agenciaCentro.obterBanco().obterMoeda(), 10, 0);
		sistemaBancario.depositar(contaMaria, quantia);
		// Saque de 6 reais
		quantia = new Dinheiro(agenciaCentro.obterBanco().obterMoeda(), 6, 0);
		sistemaBancario.sacar(contaMaria, quantia);
		
		assertEquals("+4,00 BRL", contaMaria.calcularSaldo().formatado());
	}
	
	@Test 
	public void testSaqueInsuficiente() {
		// Deposito de 10 reais
		Dinheiro quantia = new Dinheiro(agenciaCentro.obterBanco().obterMoeda(), 10, 0);
		sistemaBancario.depositar(contaMaria, quantia);
		// Saque de 6 reais
		quantia = new Dinheiro(agenciaCentro.obterBanco().obterMoeda(), 6, 0);
		sistemaBancario.sacar(contaMaria, quantia);
		
		// Tentativa de saque de 8 reais
		quantia = new Dinheiro(agenciaCentro.obterBanco().obterMoeda(), 8, 0);
		sistemaBancario.sacar(contaMaria, quantia);
		
		assertEquals("+4,00 BRL", contaMaria.calcularSaldo().formatado());
	}
	
}
