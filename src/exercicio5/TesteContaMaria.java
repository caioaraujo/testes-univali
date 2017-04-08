package exercicio5;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.Entrada;
import br.ufsc.ine.leb.sistemaBancario.Saida;
import br.ufsc.ine.leb.sistemaBancario.Transacao;

public class TesteContaMaria {
	
	private Agencia agenciaCentro;

	@Before
	public void setUp() throws Exception {
		agenciaCentro = Auxiliar.criarAgenciaCentro(Auxiliar.criarBancoDoBrasil());
	}

	@Test
	public void testContaMaria() {
		Conta contaMaria = createContaMaria(agenciaCentro);
		assertEquals("0001-5", contaMaria.obterIdentificador());
		assertEquals("Maria", contaMaria.obterTitular());
		assertEquals("0,00", contaMaria.calcularSaldo().obterQuantia().formatado());
		assertEquals("Centro", contaMaria.obterAgencia().obterNome());
	}
	
	@Test
	public void testDepositoDezConto() {
		Conta contaMaria = createContaMaria(agenciaCentro);
		// Deposito de 10 reais
		Dinheiro quantia = new Dinheiro(agenciaCentro.obterBanco().obterMoeda(), 10, 0);
		this.realizarDeposito(contaMaria, quantia);
		
		assertEquals(quantia, contaMaria.calcularSaldo().obterQuantia());
	}
	
	@Test
	public void testSaqueSeisConto() {
		Conta contaMaria = createContaMaria(agenciaCentro);
		// Deposito de 10 reais
		Dinheiro quantia = new Dinheiro(agenciaCentro.obterBanco().obterMoeda(), 10, 0);
		this.realizarDeposito(contaMaria, quantia);
		// Saque de 6 reais
		quantia = new Dinheiro(agenciaCentro.obterBanco().obterMoeda(), 6, 0);
		this.realizarSaque(contaMaria, quantia);
		
		assertEquals("+4,00 BRL", contaMaria.calcularSaldo().formatado());
	}
	
	@Test 
	public void testSaqueInsuficiente() {
		Conta contaMaria = createContaMaria(agenciaCentro);
		// Deposito de 10 reais
		Dinheiro quantia = new Dinheiro(agenciaCentro.obterBanco().obterMoeda(), 10, 0);
		this.realizarDeposito(contaMaria, quantia);
		// Saque de 6 reais
		quantia = new Dinheiro(agenciaCentro.obterBanco().obterMoeda(), 6, 0);
		this.realizarSaque(contaMaria, quantia);
		
		// Tentativa de saque de 8 reais
		quantia = new Dinheiro(agenciaCentro.obterBanco().obterMoeda(), 8, 0);
		this.realizarSaque(contaMaria, quantia);
		
		assertEquals("+4,00 BRL", contaMaria.calcularSaldo().formatado());
	}
	
	private Conta createContaMaria(Agencia agencia) {
		Conta contaMaria = agencia.criarConta("Maria");
		return contaMaria;
	}
	
	private void realizarDeposito(Conta conta, Dinheiro quantia) {
		Transacao transacao = new Entrada(conta, quantia);
		conta.adicionarTransacao(transacao);
	}
	
	private void realizarSaque(Conta conta, Dinheiro quantia) {
		Transacao transacao = new Saida(conta, quantia);
		conta.adicionarTransacao(transacao);
	}

}
