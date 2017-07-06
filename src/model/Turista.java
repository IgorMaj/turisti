package model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class Turista extends Korisnik {

	public Turista(){
		
	}
	
	public Turista(String korIme, String lozinka, String ime, String prezime, String telefon,
			ArrayList<Komentar> komentari, ArrayList<Rezervacija> rezervacije) {
		super(korIme, lozinka, ime, prezime, telefon, komentari, rezervacije);

	}
	
}
