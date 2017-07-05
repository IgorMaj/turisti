package model;

import java.util.ArrayList;
import java.util.Observable;

public class Komentari extends Observable {
	public ArrayList<Komentar> komentari;
	Korisnik ulogovaniKorisnik;
	
	public Komentari(ArrayList<Komentar> komentari,Korisnik ulogovaniKorisnik){
		super();
		this.komentari = komentari;
		this.ulogovaniKorisnik = ulogovaniKorisnik;
	}
	
	public void dodajKomentar(Komentar arg0){
		this.komentari.add(arg0);
		this.ulogovaniKorisnik.getKomentari().add(arg0);
		this.setChanged();
		this.notifyObservers();
	}
}
