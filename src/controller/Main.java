package controller;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import model.Komentar;
import model.Rezervacija;
import model.Turista;
import view.GlavniProzor;

public class Main {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		//test slucajevi za ture
		/*ArrayList <Tura> ture = new ArrayList<Tura>();
		ArrayList<Komentar> kom=new ArrayList<Komentar >();
		ArrayList <Rezervacija> rez = new ArrayList<Rezervacija>();
	
		
		Vodic v1= new Vodic("pero", "123", "petar", "petrovic","4810",kom,rez,ture);
		Vodic v2= new Vodic("djole", "321", "djoka", "djokic","8646",kom,rez,ture);
		
		ArrayList <String> vodici = new ArrayList <String>();
		vodici.add("petar petrovic");
		vodici.add("djoka djokic");
		ArrayList <Termin> ter = new ArrayList <Termin>();
		Termin ter1= new Termin ("30.6.2017","10.7.2017", 50,true,200,rez);
		Termin ter2= new Termin ("15.7.2017","25.7.2017", 50,true,250,rez);
		ter.add(ter1);
		ter.add(ter2);
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
		Tura t1= new Tura ("Kavos-nikad ne spava","10 neispavanih noci",0,20,"petar petrovic" ,vodici,ter,kom,m,d);
		Tura t2= new Tura ("Zlatibor-5 dana","odmor u prirodi",7,20,"djoka djokic",new ArrayList<String>(){{add("djoka djokic");}},ter,kom,mesta,dest);
		Aplikacija.trenutnoAktivan = v1;
		Aplikacija.dodajTuru(t1);
		Aplikacija.trenutnoAktivan = v2;
		Aplikacija.dodajTuru(t2);
		*/
		
		Aplikacija.ucitavanjeTura();
		Aplikacija.trenutnoAktivan = new Turista("pero", "123", "petar", "petrovic","4810", new ArrayList<Komentar>(),new ArrayList<Rezervacija>());
		GlavniProzor gp=new GlavniProzor();
		gp.setVisible(true);
		
		//Za potrebe testiranja izbrisati komentar
		//OtkazivanjeRezervacijaIzgled otkIzgled = new OtkazivanjeRezervacijaIzgled(Aplikacija.trenutnoAktivan);
		//otkIzgled.setVisible(true);

	}

}
