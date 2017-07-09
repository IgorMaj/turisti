package testovi;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controller.Aplikacija;
import model.Destinacija;
import model.Komentar;
import model.Mesto;
import model.Rezervacija;
import model.Termin;
import model.Tura;
import model.Vodic;

public class TureUKojimaNeUcestvujeTest {
	
	@Before
	public void podesi(){
		ArrayList <Mesto> m = new ArrayList <Mesto>();
		Mesto m1= new Mesto("Kavos",5458);
		m.add(m1);
		ArrayList <Destinacija> d = new ArrayList <Destinacija>();
		Mesto m2= new Mesto("Krf",5458);
		Destinacija d1= new Destinacija ("Srpska kuca","muzej",m2);
		d.add(d1);
		ArrayList <Mesto> mesta = new ArrayList <Mesto>();
		Mesto mm= new Mesto("Zlatibor",22240);
		mesta.add(mm);
		ArrayList <Destinacija> dest = new ArrayList <Destinacija>();
		Destinacija d2= new Destinacija ("Mokra Gora","selo",mm);
		dest.add(d2);
		
		Aplikacija.ture = new ArrayList<Tura>();
		Vodic vodja1 = new Vodic("pero1", "123", "petar1", "petrovic","4810", new ArrayList<Komentar>(),new ArrayList<Rezervacija>(),Aplikacija.ture);
		Vodic pomocnik1 = new Vodic("pero2", "123", "petar2", "petrovic","4810", new ArrayList<Komentar>(),new ArrayList<Rezervacija>(),Aplikacija.ture);
		Vodic pomocnik2 = new Vodic("pero3", "123", "petar3", "petrovic","4810", new ArrayList<Komentar>(),new ArrayList<Rezervacija>(),Aplikacija.ture);
		Vodic vodja2 = new Vodic("pero4", "123", "petar4", "petrovic","4810", new ArrayList<Komentar>(),new ArrayList<Rezervacija>(),Aplikacija.ture);
		Aplikacija.trenutnoAktivan = new Vodic("pero5", "123", "petar5", "petrovic","4810", new ArrayList<Komentar>(),new ArrayList<Rezervacija>(),Aplikacija.ture);
		
		Aplikacija.vodici = new ArrayList<Vodic>();
		ArrayList<Vodic>vodici = Aplikacija.vodici;
		vodici.add(pomocnik1);
		vodici.add(pomocnik2);
		
		Tura t1= new Tura ("Kavos-nikad ne spava","10 neispavanih noci",0,20, vodja1, vodici, new ArrayList<Termin>(),new ArrayList<Komentar >(),m,d);
		Tura t2= new Tura ("Zlatibor-5 dana","odmor u prirodi",7,20,vodja2,vodici,new ArrayList<Termin>(),new ArrayList<Komentar >(),mesta,dest);
		
		Aplikacija.ture.add(t1);
		Aplikacija.ture.add(t2);
	}

	@Test
	public void test1() {
		int brojTura = 2;
		assertEquals(Aplikacija.vratiTureUKojimaNeUcestvuje().size(),brojTura);
	}
	
	@Test
	public void test2() {
		Aplikacija.vodici.add((Vodic) Aplikacija.trenutnoAktivan);
		Aplikacija.ture.get(0).getVodici().add((Vodic) Aplikacija.trenutnoAktivan);
		Aplikacija.ture.get(1).getVodici().add((Vodic) Aplikacija.trenutnoAktivan);
		
		((Vodic) Aplikacija.trenutnoAktivan).getTure().add(Aplikacija.ture.get(0));
		((Vodic) Aplikacija.trenutnoAktivan).getTure().add(Aplikacija.ture.get(1));
		
		int brojTura = 0;
		assertEquals(Aplikacija.vratiTureUKojimaNeUcestvuje().size(),brojTura);
	}
	
	

}
