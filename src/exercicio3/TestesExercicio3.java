package exercicio3;

import static org.junit.Assert.*;

import org.joda.time.IllegalFieldValueException;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
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
		LocalDate myBirthdate = new LocalDate(1986, 10, 6); // teste hipotetico. Eu nao nasci em 86
		assertEquals(6, myBirthdate.getDayOfMonth());
		assertEquals(10, myBirthdate.getMonthOfYear());
		assertEquals(1986, myBirthdate.getYear()); 
	}
	
	@Test
	public void testHorarioQueAcordeiHoje() {
		LocalTime wokeUpTime = new LocalTime(11, 59); // hoje eh sabado
		assertEquals(11, wokeUpTime.getHourOfDay());
		assertEquals(59, wokeUpTime.getMinuteOfHour());
	}
	
	@Test(expected = IllegalFieldValueException.class)
	public void dataInvalida() {
		new LocalDate(2017, 2, 29);
	}
	
	@Test
	public void testPlusDay() {
		LocalDate data = new LocalDate(2017, 2, 28);
		data = data.plusDays(1);
		
		assertEquals(1, data.getDayOfMonth());
		assertEquals(3, data.getMonthOfYear());
		assertEquals(2017, data.getYear()); 
	}
	
	@Test
	public void testSubtrairMilisegundo() {
		LocalTime zeroHora = new LocalTime(0, 0);
		LocalTime onzeE59 = zeroHora.minusMillis(1);
		
		assertEquals(23, onzeE59.getHourOfDay());
		assertEquals(59, onzeE59.getMinuteOfHour());
	}
	
	@Test
	public void testHorarioAntesMeiaNoite() {
		LocalTime onzeEPouco = new LocalTime(23, 59, 59, 999);
		LocalTime meiaNoite = new LocalTime(0, 0);
		
		assertTrue(onzeEPouco.compareTo(meiaNoite) < 0);
		
	}
	
}
