package model;

import java.util.ArrayList;

public abstract class Korisnik {
	
	private String korIme;
	private String lozinka;

	private String ime;
	private String prezime;
	private String telefon;
	private ArrayList<Komentar> komentari;
	private ArrayList <Rezervacija> rezervacije;
	
	
	public Korisnik(String korIme, String lozinka, String ime, String prezime, String telefon,
			ArrayList<Komentar> komentari, ArrayList<Rezervacija> rezervacije) {
		super();
		this.korIme = korIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.telefon = telefon;
		this.komentari = komentari;
		this.rezervacije = rezervacije;
	}
	//TO DO
	public void  rezervisiTuru(Termin t){
		Rezervacija r = new Rezervacija(false, t, this, false);
		t.getRezervacije().add(r);
		t.setBrojSlobodnihMesta(t.getBrojSlobodnihMesta()-1);
		this.getRezervacije().add(r);
	};
	public void otkaziTuru(){};
	public void oceniTuru(){}
	public String getKorIme() {
		return korIme;
	}
	public void setKorIme(String korIme) {
		this.korIme = korIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public ArrayList<Komentar> getKomentari() {
		return komentari;
	}
	public void setKomentari(ArrayList<Komentar> komentari) {
		this.komentari = komentari;
	}
	public ArrayList<Rezervacija> getRezervacije() {
		return rezervacije;
	}
	public void setRezervacije(ArrayList<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	};	
	
	
}
