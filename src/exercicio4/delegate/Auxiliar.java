package exercicio4.delegate;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class Auxiliar {
	
	protected static Conta criarContaJoao(Agencia agencia) {
		Conta joaoCaixaEconomicaTrindade = agencia.criarConta("João");
		return joaoCaixaEconomicaTrindade;
	}
	
	protected static Agencia criarCaixaEconomicaTrindade(Banco banco) {
		Agencia caixaEconomicaTrindade = banco.criarAgencia("Trindade");
		
		return caixaEconomicaTrindade;
	}
	
	protected static Banco criarCaixaEconomica() {
		Banco caixaEconomica = new SistemaBancario().criarBanco("Caixa Econômica", Moeda.BRL);
		return caixaEconomica;
	}

}
