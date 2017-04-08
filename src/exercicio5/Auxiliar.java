package exercicio5;

import br.ufsc.ine.leb.sistemaBancario.Agencia;
import br.ufsc.ine.leb.sistemaBancario.Banco;
import br.ufsc.ine.leb.sistemaBancario.Moeda;
import br.ufsc.ine.leb.sistemaBancario.SistemaBancario;

public class Auxiliar {
	
	protected static Banco criarBancoDoBrasil() {
		return new SistemaBancario().criarBanco("Banco do Brasil", Moeda.BRL);
	}
	
	protected static Agencia criarAgenciaCentro(Banco banco) {
		return banco.criarAgencia("Centro");
	}

}
