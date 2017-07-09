package controller;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;

import model.Aktivan;
import model.Destinacija;
import model.Komentar;
import model.Kreiran;
import model.Mesto;
import model.Rezervacija;
import model.Termin;
import model.Tura;
import model.Vodic;
import view.GlavniProzor;

public class Main {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		//ako hocete da vratite stari sistem
		//izbrisite komentare ovde i u metodama za dodavanje, etc
		//Aplikacija.ucitavanjeTura();
		//Aplikacija.ucitajKorisnike();
		//Aplikacija.podaci.setTure(Aplikacija.ture);
		//Aplikacija.podaci.setTuristi(Aplikacija.turisti);
		//Aplikacija.podaci.setVodici(Aplikacija.vodici);
		
		Aplikacija.ucitajPodatke();
		//Aplikacija.upisiPodatke();
		//testniPodaci();
		//Aplikacija.trenutnoAktivan = new Turista("pero", "123", "petar", "petrovic","4810", new ArrayList<Komentar>(),new ArrayList<Rezervacija>());
		GlavniProzor gp=new GlavniProzor();
		gp.setLocationRelativeTo(null);
		gp.setVisible(true);
		
		//Za potrebe testiranja izbrisati komentar
		//OtkazivanjeRezervacijaIzgled otkIzgled = new OtkazivanjeRezervacijaIzgled(Aplikacija.trenutnoAktivan);
		//otkIzgled.setVisible(true);

	}
	
	public static void testniPodaci() throws JsonGenerationException, JsonMappingException, IOException{
		
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
		ArrayList<Vodic> vodici = new ArrayList<Vodic>(){{add((Vodic) Aplikacija.korisnici.get(2));add((Vodic) Aplikacija.korisnici.get(3));}};
		Tura t1= new Tura ("Kavos-nikad ne spava","10 neispavanih noci",0,20, (Vodic) Aplikacija.korisnici.get(2), vodici, new ArrayList<Termin>(),new ArrayList<Komentar >(),m,d);
		Tura t2= new Tura ("Zlatibor-5 dana","odmor u prirodi",7,20,(Vodic)Aplikacija.korisnici.get(3),vodici,new ArrayList<Termin>(),new ArrayList<Komentar >(),mesta,dest);
		
		Termin ter1= new Termin (new Kreiran(),t1,"30.6.2017","10.7.2017", 50,false,200,new ArrayList<Rezervacija>());
		Termin ter2= new Termin (new Aktivan(),t1,"15.7.2017","25.7.2017", 50,true,250,new ArrayList<Rezervacija>());
		t1.getTermini().add(ter1);
		t1.getTermini().add(ter2);
		

	}
}
