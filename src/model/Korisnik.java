package model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import controller.Aplikacija;

import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Turista.class, name = "Turista"),

    @JsonSubTypes.Type(value = Vodic.class, name = "Vodic") }
)
public abstract class Korisnik {
	
	private String korIme;
	private String lozinka;

	private String ime;
	private String prezime;
	private String telefon;
	private ArrayList<Komentar> komentari;
	private ArrayList <Rezervacija> rezervacije;
	
	
	public Korisnik(){
		
	}
	
	public Korisnik(String korIme, String lozinka, String ime, String prezime, String telefon,
			ArrayList<Komentar> komentari, ArrayList<Rezervacija> rezervacije) {
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
		Aplikacija.upisiPodatke();
	};
	public void otkaziTuru(int indexTure){
		Rezervacija r = rezervacije.get(indexTure);
		r.getTermin().setBrojSlobodnihMesta(r.getTermin().getBrojSlobodnihMesta()+1);
		r.getTermin().getRezervacije().remove(r);
		rezervacije.remove(indexTure);
		Aplikacija.upisiPodatke();
		
	};
	
	public void platiRezervaciju(int indexTure){
		Rezervacija r = rezervacije.get(indexTure);
		r.setPlacena(true);
		Aplikacija.upisiPodatke();
	}
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
	}

	@Override
	public String toString() {
		return "Korisnik [korIme=" + korIme + ", lozinka=" + lozinka + ", ime=" + ime + ", prezime=" + prezime
				+ ", telefon=" + telefon + ", komentari=" + komentari + ", rezervacije=" + rezervacije + "]";
	};	
	
	
}
