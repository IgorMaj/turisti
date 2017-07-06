package model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

public class Vodic extends Korisnik {

	ArrayList<Tura> ture;

	public Vodic() {

	}

	public Vodic(String korIme, String lozinka, String ime, String prezime, String telefon,
			ArrayList<Komentar> komentari, ArrayList<Rezervacija> rezervacije, ArrayList<Tura> ture) {
		super(korIme, lozinka, ime, prezime, telefon, komentari, rezervacije);
		this.ture = ture;
	}

	public ArrayList<Tura> getTure() {
		return ture;
	}

	public void setTure(ArrayList<Tura> ture) {
		this.ture = ture;
	}

	// TO DO
	public void prikaziListuTurista() {
	};

	public void potvrdiRezervaciju() {
	}

		
}
