package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Aktivan;
import model.Korisnik;
import model.Kreiran;
import model.Otkazan;
import model.Rezervacija;
import model.SadrzalacPodataka;
import model.Termin;
import model.Tura;
import model.Turista;
import model.Vodic;
import view.TabAktivacijaDeaktivacijaTure;

public class Aplikacija {

	public static Korisnik trenutnoAktivan = null;
	public static ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
	public static ArrayList<Tura> ture = new ArrayList<Tura>();
	public static ArrayList<Turista> turisti = new ArrayList<Turista>();
	public static ArrayList<Vodic> vodici = new ArrayList<Vodic>();
	public static String putanjaDoFajla = "fajlovi/podaci.json";
	
	//sadrzi reference na sve - kontejner
	public static SadrzalacPodataka podaci = new SadrzalacPodataka(turisti,vodici,ture);
	
	public static void pretraziKorisnike() {};
	
	//nova metoda
	public static void ucitajPodatke(){
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			podaci = mapper.readValue(new File(putanjaDoFajla),new TypeReference<SadrzalacPodataka>(){});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		turisti = podaci.getTuristi();
		vodici = podaci.getVodici();
		ture = podaci.getTure();

		// za potrebe logovanja
		for (int i = 0; i < turisti.size(); i++) {
			korisnici.add(turisti.get(i));
		}

		for (int i = 0; i < vodici.size(); i++) {
			korisnici.add(vodici.get(i));
		}
	}

	// nova metoda
	public static void upisiPodatke() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writer().withDefaultPrettyPrinter().writeValue(new File(putanjaDoFajla), podaci);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void dodajKorisnika(Korisnik k) throws JsonGenerationException, JsonMappingException, IOException {
		korisnici.add(k);

		if (k instanceof Turista) {
			turisti.add((Turista) k);
		}
		if (k instanceof Vodic) {
			vodici.add((Vodic) k);
		}
		upisiPodatke();
	}

	public static boolean provjeraKorisnika(String korisnicko_ime, String lozinka) {
		for (int i = 0; i < korisnici.size(); i++) {
			if (korisnici.get(i).getKorIme().equals(korisnicko_ime) && korisnici.get(i).getLozinka().equals(lozinka)) {
				trenutnoAktivan = korisnici.get(i);
				return true;
			}
		}
		return false;
	}

	public static boolean korisnikVecPostoji(String korisnicko_ime) {
		for (int i = 0; i < korisnici.size(); i++) {
			if (korisnici.get(i).getKorIme().equals(korisnicko_ime)) {
				return true;
			}
		}
		return false;
	}

	public static void dodajTuru(Tura t) throws JsonGenerationException, JsonMappingException, IOException {
		ture.add(t);
		((Vodic) trenutnoAktivan).getTure().add(t);
		upisiPodatke();
	};

	public static void obrisiTuru(Tura t) throws JsonGenerationException, JsonMappingException, IOException {
		ture.remove(t);

		for (Vodic vodic : vodici) {
			vodic.getTure().remove(t);
		}

		ArrayList<Rezervacija> rezervacijeZaBrisanje;
		for (Korisnik korisnik : korisnici) {
			rezervacijeZaBrisanje = new ArrayList<Rezervacija>();
			for (Rezervacija rezervacija : korisnik.getRezervacije()) {
				if (rezervacija.getTermin().getTura() == t) {
					rezervacijeZaBrisanje.add(rezervacija);
				}
			}
			korisnik.getRezervacije().removeAll(rezervacijeZaBrisanje);
		}
		upisiPodatke();
	};

	// pretraga tura po odredjenom kriterijumu pretrage
	public static ArrayList<Tura> pretraziTure(String tipPretrage, String parametarPretrage) {
		ArrayList<Tura> tur = new ArrayList<Tura>();

		switch (tipPretrage) {
		case "ocena":
			for (int i = 0; i < ture.size(); i++) {
				if (ture.get(i).getOcena() == Integer.parseInt(parametarPretrage)) {
					tur.add(ture.get(i));
				}
			}
			break;
		case "termin":
			for (int i = 0; i < ture.size(); i++) {
				for (int j = 0; j < ture.get(i).getTermini().size(); j++) {
					if (ture.get(i).getTermini().get(j).getPocetakTure().equals(parametarPretrage)) {
						tur.add(ture.get(i));
						break;
					}

				}
			}
			break;
		case "cena":
			for (int i = 0; i < ture.size(); i++) {
				for (int j = 0; j < ture.get(i).getTermini().size(); j++) {
					if (ture.get(i).getTermini().get(j).getCena() == Double.parseDouble(parametarPretrage)) {
						tur.add(ture.get(i));
						break;
					}

				}
			}
			break;
		case "grad":
			for (int i = 0; i < ture.size(); i++) {
				for (int j = 0; j < ture.get(i).getGradovi().size(); j++) {
					if (ture.get(i).getGradovi().get(j).getNaziv().equals(parametarPretrage)) {
						tur.add(ture.get(i));
						break;
					}
				}
			}
			break;
		}
		return tur;
	}

	public static ArrayList<Tura> prikazTuraKojeJeVodicKreirao() {
		ArrayList<Tura> tureKojeJeKreirao = new ArrayList<Tura>();

		for (Tura tura : Aplikacija.ture) {
			if (tura.getKreatorTure() == Aplikacija.trenutnoAktivan) {
				tureKojeJeKreirao.add(tura);
			}
		}
		return tureKojeJeKreirao;
	}

	public static boolean IzmeniKorisnika(String ime, String prezime, String telefon, String korIme, String lozinka)
			throws JsonGenerationException, JsonMappingException, IOException {

		if (korisnikVecPostoji(korIme) == true) {
			return false;
		}
		if (!korIme.equals("")) {
			Aplikacija.trenutnoAktivan.setKorIme(korIme);
		}
		if (!ime.equals("")) {
			Aplikacija.trenutnoAktivan.setIme(ime);
		}
		if (!prezime.equals("")) {
			Aplikacija.trenutnoAktivan.setPrezime(prezime);
		}
		if (!telefon.equals("")) {
			Aplikacija.trenutnoAktivan.setTelefon(telefon);
		}
		if (!lozinka.equals("")) {
			Aplikacija.trenutnoAktivan.setLozinka(lozinka);
		}
		upisiPodatke();
		return true;
	}

	public static ArrayList<Tura> vratiTureUKojimaNeUcestvuje() {
		ArrayList<Tura> odabraneTure = new ArrayList<Tura>();
		for (Tura t : ture) {
			if (!(t.getVodici().contains(trenutnoAktivan)) && t.getKreatorTure() != trenutnoAktivan) {
				odabraneTure.add(t);
			}
		}
		return odabraneTure;
	}

	public static void pridruziVodicaTuri(Tura tura) {
		tura.getVodici().add((Vodic) trenutnoAktivan);
		((Vodic) trenutnoAktivan).getTure().add(tura);
		upisiPodatke();

	}
	
	public static boolean aktivirajTuru(String idTure, String pocetakTure, String zavrsetakTure, String statusTure){
		
		Vodic v = null;
		
		if(Aplikacija.trenutnoAktivan instanceof Vodic){
			v = (Vodic)Aplikacija.trenutnoAktivan;
		}
		for(Tura t : v.getTure()){
			if(t.getIdTure().equals(idTure)){
				for(Termin ter : t.getTermini()){
					if(ter.getPocetakTure().equals(pocetakTure) && ter.getKrajTure().equals(zavrsetakTure)){
						if(statusTure.equals("neaktivan") && ter.getAktivnoStanje() instanceof Kreiran){
							ter.setAktivnoStanje(new Aktivan());
							Aplikacija.upisiPodatke();
							return true;
						}
						else if (statusTure.equals("aktivan") && ter.getAktivnoStanje() instanceof Aktivan){
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	
	
	public static boolean deaktivirajTuru(String idTure, String pocetakTure, String zavrsetakTure, String statusTure){
		Vodic v = null;
		
		if(Aplikacija.trenutnoAktivan instanceof Vodic){
			v = (Vodic)Aplikacija.trenutnoAktivan;
		}
		for(Tura t : v.getTure()){
			if(t.getIdTure().equals(idTure)){
				for(Termin ter : t.getTermini()){
					if(ter.getPocetakTure().equals(pocetakTure) && ter.getKrajTure().equals(zavrsetakTure)){						
						if(statusTure.equals("aktivan") && ter.getAktivnoStanje() instanceof Aktivan){
							ter.setAktivnoStanje(new Otkazan());
							Aplikacija.upisiPodatke();
							return true;
						}
						else if (statusTure.equals("neaktivan") && ter.getAktivnoStanje() instanceof Otkazan){
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	
	
}
