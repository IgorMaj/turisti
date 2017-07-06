package model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class Termin {

	private Stanje aktivnoStanje;
	private Tura tura;
	private String pocetakTure;
	private String krajTure;
	private int brojSlobodnihMesta;
	private boolean aktivan;
	private double cena;
	private ArrayList<Rezervacija> rezervacije;
	public Termin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Termin(Stanje aktivnoStanje, Tura tura, String pocetakTure, String krajTure, int brojSlobodnihMesta,
			boolean aktivan, double cena, ArrayList<Rezervacija> rezervacije) {
		super();
		aktivnoStanje.setTermin(this);
		this.aktivnoStanje = aktivnoStanje;
		this.tura = tura;
		this.pocetakTure = pocetakTure;
		this.krajTure = krajTure;
		this.brojSlobodnihMesta = brojSlobodnihMesta;
		this.aktivan = aktivan;
		this.cena = cena;
		this.rezervacije = rezervacije;
	}


	public void promeniStanje(Stanje s){
		this.aktivnoStanje=s;
	}
	
	public void aktivirajTermin(){
		Aktivan aktivno= new Aktivan();
		promeniStanje(aktivno);
		aktivnoStanje.aktivacijaTermina();
	};
	
	//ostale metode po uzoru na metoda aktivirajTermin()
	public void deaktivirajTermina(){};
	public void rezervisiTermin(){};
	public void otkaziTermin(){};
	
	public void terminZavrsen(){};
	public void nedovoljnoPrijavljenihTirusta(){};
	public void umanjiBrojSlobodnihMesta(){};
	public void uvecajBrojSlobodnihMesta(){};
	
	
	
	public Tura getTura() {
		return tura;
	}
	public void setTura(Tura tura) {
		this.tura = tura;
	}
	public String getPocetakTure() {
		return pocetakTure;
	}
	public void setPocetakTure(String pocetakTure) {
		this.pocetakTure = pocetakTure;
	}
	public String getKrajTure() {
		return krajTure;
	}
	public void setKrajTure(String krajTure) {
		this.krajTure = krajTure;
	}
	public int getBrojSlobodnihMesta() {
		return brojSlobodnihMesta;
	}
	public void setBrojSlobodnihMesta(int brojSlobodnihMesta) {
		this.brojSlobodnihMesta = brojSlobodnihMesta;
	}
	public boolean isAktivan() {
		return aktivan;
	}
	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public ArrayList<Rezervacija> getRezervacije() {
		return rezervacije;
	}
	public void setRezervacije(ArrayList<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}


	public Stanje getAktivnoStanje() {
		return aktivnoStanje;
	}


	public void setAktivnoStanje(Stanje aktivnoStanje) {
		this.aktivnoStanje = aktivnoStanje;
	}
	
	
	
}
