package model;

import java.util.ArrayList;

public class Turista extends Korisnik {

	public Turista(){
		
	}
	
	public Turista(String korIme, String lozinka, String ime, String prezime, String telefon,
			ArrayList<Komentar> komentari, ArrayList<Rezervacija> rezervacije) {
		super(korIme, lozinka, ime, prezime, telefon, komentari, rezervacije);

	}
	
}
