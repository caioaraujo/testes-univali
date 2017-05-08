package exercicio6;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Dinheiro;
import br.ufsc.ine.leb.sistemaBancario.EstadosDeOperacao;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.Operacao;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class TesteTransferencia {

	private Agencia agenciaBrasileira;
	private Agencia agenciaAmericana;
	private SistemaBancario sistemaBancario;

	@Before
	public void setUp() {
		sistemaBancario = new SistemaBancario();
		Banco bancoBrasileiro = Auxiliar.criarBanco(sistemaBancario, "Brasileiro", Moeda.BRL);
		agenciaBrasileira = Auxiliar.criarAgencia(bancoBrasileiro, "Palhoca");
		Banco bancoAmericano = Auxiliar.criarBanco(sistemaBancario, "Americano", Moeda.USD);
		agenciaAmericana = Auxiliar.criarAgencia(bancoAmericano, "Washington");
	}

	@Test
	public void testMoedaInvalida() {
		Conta contaOrigem = Auxiliar.createConta(agenciaBrasileira, "Joao");
		Conta contaDestino = Auxiliar.createConta(agenciaAmericana, "Maria");
		Dinheiro quantia = new Dinheiro(Moeda.CHF, 10, 0);
		Operacao operacao = sistemaBancario.transferir(contaOrigem, contaDestino, quantia);
		assertEquals(EstadosDeOperacao.MOEDA_INVALIDA, operacao.obterEstado());
	}

}
