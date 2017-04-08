package exercicio6;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Conta;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class Auxiliar {
	
	protected static Banco criarBanco(SistemaBancario sistemaBancario, String nome, Moeda moeda) {
		return sistemaBancario.criarBanco(nome, Moeda.BRL);
	}
	
	protected static Agencia criarAgencia(Banco banco, String nome) {
		return banco.criarAgencia(nome);
	}
	
	protected static Conta createConta(Agencia agencia, String nome) {
		Conta conta = agencia.criarConta(nome);
		return conta;
	}

}
