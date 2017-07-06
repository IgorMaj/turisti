package model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class Rezervacija {
	
	private boolean potvrdjena;
	private Termin termin;
	private Korisnik korisnik;
	private boolean placena;
	
	
	
	public Rezervacija() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rezervacija(boolean potvrdjena, Termin termin, Korisnik korisnik, boolean placena) {
		super();
		this.potvrdjena = potvrdjena;
		this.termin = termin;
		this.korisnik = korisnik;
		this.placena = placena;
	}

	public boolean isPotvrdjena() {
		return potvrdjena;
	}



	public void setPotvrdjena(boolean potvrdjena) {
		this.potvrdjena = potvrdjena;
	}



	public Termin getTermin() {
		return termin;
	}



	public void setTermin(Termin termin) {
		this.termin = termin;
	}



	public Korisnik getKorisnik() {
		return korisnik;
	}



	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}



	public boolean isPlacena() {
		return placena;
	}



	public void setPlacena(boolean placena) {
		this.placena = placena;
	}



	
	

}
