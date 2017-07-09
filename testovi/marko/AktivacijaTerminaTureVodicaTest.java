package marko;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

import controller.Aplikacija;
import model.Aktivan;
import model.Destinacija;
import model.Komentar;
import model.Kreiran;
import model.Mesto;
import model.Rezervacija;
import model.Stanje;
import model.Termin;
import model.Tura;
import model.Vodic;

public class AktivacijaTerminaTureVodicaTest {

	private void postaviTrenutnoUlogovanog(){
		ArrayList<Komentar> komentari = new ArrayList<>();
		ArrayList<Rezervacija> rezervacije = new ArrayList<>();
		ArrayList<Tura> ture = new ArrayList<>();
		Vodic v1 = new Vodic("david123","david","David","Davidovic","065000000",komentari,rezervacije, ture);
		ArrayList<Vodic> vodici = new ArrayList<Vodic>();
		ArrayList<Termin> termini = new ArrayList<Termin>();
		ArrayList<Komentar> komentariTure = new ArrayList<Komentar>();
		ArrayList<Mesto> gradovi = new ArrayList<Mesto>();
		ArrayList<Destinacija> destinacije = new ArrayList<Destinacija>();
		Tura t1 = new Tura("tura250","Zlatibor-Uzice-Drvengrad", 5, 20, v1, vodici, termini, komentariTure, gradovi, destinacije);
		ArrayList<Rezervacija> rezervacijeTermin = new ArrayList<Rezervacija>();
		Termin ter1 = new Termin(new Aktivan(), t1, "21.9.2017", "25.9.2017", 35, true, 25000.0, rezervacijeTermin);
		Termin ter2 = new Termin(new Kreiran(), t1, "10.11.2017", "15.11.2017", 35, true, 27000.0, rezervacijeTermin);
		t1.getTermini().add(ter1);
		t1.getTermini().add(ter2);
		Vodic trenutnoUlogovani = v1;
		v1.getTure().add(t1);
		Aplikacija.trenutnoAktivan = trenutnoUlogovani;
	}
	
	@Test
	public void test1() {
		postaviTrenutnoUlogovanog();
		Aplikacija.ucitajPodatke();
		boolean aktivirana = Aplikacija.aktivirajTuru("tura250", "21.9.2017", "25.9.2017", "aktivan");
		assertEquals(aktivirana,false);
		
	}
	@Test
	public void test2() {
		postaviTrenutnoUlogovanog();
		Aplikacija.ucitajPodatke();
		boolean aktivirana = Aplikacija.aktivirajTuru("tura250", "10.11.2017", "15.11.2017", "neaktivan");
		Vodic v = (Vodic) Aplikacija.trenutnoAktivan;
		Tura t = v.getTure().get(0);
		Termin ter =t.getTermini().get(1);
		assertThat(ter.getAktivnoStanje(), instanceOf(Aktivan.class));
		assertEquals(aktivirana,true);
		
	}

}
