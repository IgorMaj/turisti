package dragana;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controller.Aplikacija;
import model.Tura;

public class PretragaTuraIKreiraneTureTest {
	
	@Before
	public void setUp(){
		Aplikacija.ucitajPodatke();
		Aplikacija.trenutnoAktivan = Aplikacija.korisnici.get(2);
	}
	
	@Test
	public void pretraziTureTest(){
		ArrayList<Tura> turePretraga = new ArrayList<Tura>();
		assertTrue(turePretraga.isEmpty());
		
		turePretraga = Aplikacija.pretraziTure("ocena", "7");
		assertTrue(!turePretraga.isEmpty());
		
		turePretraga = Aplikacija.pretraziTure("ocena", "100");
		assertTrue(turePretraga.isEmpty());
		
		turePretraga = Aplikacija.pretraziTure("grad", "Kavos");
		assertTrue(!turePretraga.isEmpty());

		turePretraga = Aplikacija.pretraziTure("grad", "Prcanj");
		assertTrue(turePretraga.isEmpty());
	
		turePretraga = Aplikacija.pretraziTure("cena", "200.00");
		assertTrue(!turePretraga.isEmpty());
		
		turePretraga = Aplikacija.pretraziTure("cena", "-100.00");
		assertTrue(turePretraga.isEmpty());
		
		turePretraga = Aplikacija.pretraziTure("termin", "30.6.2017");
		assertTrue(!turePretraga.isEmpty());
		
		turePretraga = Aplikacija.pretraziTure("termin", "21.12.2012");
		assertTrue(turePretraga.isEmpty());
	}
	
	@Test
	public void kreiraneTureTest() {
		ArrayList<Tura> tureKojeVodi = new ArrayList<Tura>();
		assertTrue(tureKojeVodi.isEmpty());
		tureKojeVodi = Aplikacija.prikazTuraKojeJeVodicKreirao();
		assertTrue(!tureKojeVodi.isEmpty());
	}

}
