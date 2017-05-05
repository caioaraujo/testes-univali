package exercicio5;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class Auxiliar {
	
	protected static Banco criarBancoDoBrasil(SistemaBancario sistemaBancario) {
		return sistemaBancario.criarBanco("Banco do Brasil", Moeda.BRL);
	}
	
	protected static Agencia criarAgenciaCentro(Banco banco) {
		return banco.criarAgencia("Centro");
	}
	
	protected static Conta createContaMaria(Agencia agencia) {
		Conta contaMaria = agencia.criarConta("Maria");
		return contaMaria;
	}

}
