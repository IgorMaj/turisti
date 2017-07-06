package model;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility= Visibility.ANY)

public class Tura {
	
	
	private String idTure;
	private String opis;
	private int ocena;
	private int minBrojMesta;
	private String kreatorTure;
	private ArrayList<String> vodici;
	private ArrayList<Termin> termini;
	private ArrayList<Komentar> komentari;
	private ArrayList<Mesto> gradovi;
	private ArrayList<Destinacija> destinacije;
	public Tura() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tura(String idTure, String opis, int ocena, int minBrojMesta, String kreatorTure, ArrayList<String> vodici,
			ArrayList<Termin> termini, ArrayList<Komentar> komentari, ArrayList<Mesto> gradovi,
			ArrayList<Destinacija> destinacije) {
		super();
		this.idTure = idTure;
		this.opis = opis;
		this.ocena = ocena;
		this.minBrojMesta = minBrojMesta;
		this.kreatorTure = kreatorTure;
		this.vodici = vodici;
		this.termini = termini;
		this.komentari = komentari;
		this.gradovi = gradovi;
		this.destinacije = destinacije;
	}
	public String getIdTure() {
		return idTure;
	}
	public void setIdTure(String idTure) {
		this.idTure = idTure;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	public int getMinBrojMesta() {
		return minBrojMesta;
	}
	public void setMinBrojMesta(int minBrojMesta) {
		this.minBrojMesta = minBrojMesta;
	}
	public String getKreatorTure() {
		return kreatorTure;
	}
	public void setKreatorTure(String kreatortTure) {
		this.kreatorTure = kreatortTure;
	}
	public ArrayList<String> getVodici() {
		return vodici;
	}
	public void setVodici(ArrayList<String> vodici) {
		this.vodici = vodici;
	}
	public ArrayList<Termin> getTermini() {
		return termini;
	}
	public void setTermini(ArrayList<Termin> termini) {
		this.termini = termini;
	}
	public ArrayList<Komentar> getKomentari() {
		return komentari;
	}
	public void setKomentari(ArrayList<Komentar> komentari) {
		this.komentari = komentari;
	}
	public ArrayList<Mesto> getGradovi() {
		return gradovi;
	}
	public void setGradovi(ArrayList<Mesto> gradovi) {
		this.gradovi = gradovi;
	}
	public ArrayList<Destinacija> getDestinacije() {
		return destinacije;
	}
	public void setDestinacije(ArrayList<Destinacija> destinacije) {
		this.destinacije = destinacije;
	}
	@Override
	public String toString() {
		return "Tura [idTure=" + idTure + ", opis=" + opis + ", ocena=" + ocena + ", minBrojMesta=" + minBrojMesta
				+ ", kreatorTure=" + kreatorTure + ", vodici=" + vodici + ", termini=" + termini + ", komentari="
				+ komentari + ", gradovi=" + gradovi + ", destinacije=" + destinacije + "]";
	}
	
	
}