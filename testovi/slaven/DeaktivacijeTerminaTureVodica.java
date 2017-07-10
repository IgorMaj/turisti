package slaven;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

import org.junit.Test;

import controller.Aplikacija;
import model.Aktivan;
import model.Destinacija;
import model.Komentar;
import model.Kreiran;
import model.Mesto;
import model.Otkazan;
import model.Rezervacija;
import model.Termin;
import model.Tura;
import model.Vodic;

public class DeaktivacijeTerminaTureVodica {

	private void postaviTrenutnoUlogovanog(){
		Vodic v1 = new Vodic("milivoje","mili","Milivoje","Milivojevic","065555333", new ArrayList<Komentar>(),new ArrayList<Rezervacija>(), new ArrayList<Tura>());
		Tura t1 = new Tura("tura200","Kadinjaca", 5, 20, v1, new ArrayList<Vodic>(),  new ArrayList<Termin>(), new ArrayList<Komentar>(),  new ArrayList<Mesto>(),  new ArrayList<Destinacija>());
		ArrayList<Rezervacija> rezervacijeTermin = new ArrayList<Rezervacija>();
		Termin ter1 = new Termin(new Aktivan(), t1, "10.9.2017", "23.9.2017", 35, true, 25000.0, rezervacijeTermin);
		Termin ter2 = new Termin(new Otkazan(), t1, "15.11.2017", "19.11.2017", 35, true, 27000.0, rezervacijeTermin);
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
		boolean deaktivirana = Aplikacija.deaktivirajTuru("tura200", "10.9.2017", "23.9.2017", "aktivan");
		assertEquals(deaktivirana,true);
		
	}
	@Test
	public void test2() {
		postaviTrenutnoUlogovanog();
		Aplikacija.ucitajPodatke();
		boolean deaktivirana = Aplikacija.deaktivirajTuru("tura200", "15.11.2017", "19.11.2017", "neaktivan");
		Vodic v = (Vodic) Aplikacija.trenutnoAktivan;
		Tura t = v.getTure().get(0);
		Termin ter =t.getTermini().get(1);
		assertThat(ter.getAktivnoStanje(), instanceOf(Otkazan.class));
		assertEquals(deaktivirana,false);
		
	}
	
	
}
