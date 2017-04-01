package exercicio3;

import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.junit.Test;

public class TestesExercicio3 {
	
	@Test
	public void testDataHoje() throws Exception {
		LocalDate hoje = new LocalDate(2017, 4, 1);
		assertEquals(1, hoje.getDayOfMonth());
		assertEquals(4, hoje.getMonthOfYear());
		assertEquals(2017, hoje.getYear());
	}
	
	@Test
	public void testMinhaDataDeNascimento() {
		LocalDate myBirthdate = new LocalDate(1986, 10, 6); // Teste hipotetico. Eu nao nasci em 86 :x
		assertEquals(6, myBirthdate.getDayOfMonth());
		assertEquals(10, myBirthdate.getMonthOfYear());
		assertEquals(1986, myBirthdate.getYear()); 
	}

}
