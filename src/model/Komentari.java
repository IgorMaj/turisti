package model;

import java.util.Observable;

public class Komentari extends Observable {
	public Tura tura;
	Korisnik ulogovaniKorisnik;
	
	public Komentari(Tura tura,Korisnik ulogovaniKorisnik){
		super();
		this.tura = tura;
		this.ulogovaniKorisnik = ulogovaniKorisnik;
	}
	
	public void dodajKomentar(Komentar arg0){
		this.tura.getKomentari().add(arg0);
		this.ulogovaniKorisnik.getKomentari().add(arg0);
		this.setChanged();
		this.notifyObservers();
	}
}
