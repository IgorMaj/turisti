package testovi;

import static org.junit.Assert.*;
import org.junit.Test;


import controller.Aplikacija;

public class UcitavanjeTest {

	private void ucitaj(String putanja){
		Aplikacija.putanjaDoFajla = putanja;
		Aplikacija.ucitajPodatke();
	}

	@Test
	public void test1() {
		ucitaj("src/testovi/test1.json");
		assertFalse(Aplikacija.ture.size()==0);
		assertFalse(Aplikacija.turisti.size()==0);
		assertFalse(Aplikacija.vodici.size()==0);
	}
	
	@Test
	public void test2() {
		ucitaj("src/testovi/test2.json");
		assertTrue(Aplikacija.ture.size()==0);
		assertTrue(Aplikacija.turisti.size()==0);
		assertTrue(Aplikacija.vodici.size()==0);
	}
	
	@Test
	public void test3() {
		ucitaj("src/testovi/test3.json");
		assertTrue(Aplikacija.ture.size()==0);
		assertTrue(Aplikacija.turisti.size()==1);
		assertTrue(Aplikacija.vodici.size()==0);
		assertEquals(Aplikacija.turisti.get(0).getKorIme(),"ognjen");
	}
	
	
	
	

}
