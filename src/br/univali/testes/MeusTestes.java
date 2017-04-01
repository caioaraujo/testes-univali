package br.univali.testes;

import static org.junit.Assert.*;

import org.junit.Test;

public class MeusTestes {
	
	@Test
	public void meuTeste() throws Exception {
		String nome = "aaa";
		assertEquals("aaa", nome);
	}
	
	@Test(expected=ArithmeticException.class)
	public void meuTeste2() throws Exception {
		double rrr = 12 / 0;
	}

}
