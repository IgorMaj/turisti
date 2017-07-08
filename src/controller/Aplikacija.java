package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Korisnik;
import model.Rezervacija;
import model.SadrzalacPodataka;
import model.Tura;
import model.Turista;
import model.Vodic;


public class Aplikacija {

	public static Korisnik trenutnoAktivan=null;
	public static ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
	public static ArrayList<Tura> ture = new ArrayList<Tura>();
	public static ArrayList<Turista> turisti = new ArrayList<Turista>();
	public static ArrayList<Vodic> vodici = new ArrayList<Vodic>();
	
	//sadrzi reference na sve - kontejner
	public static SadrzalacPodataka podaci = new SadrzalacPodataka(turisti,vodici,ture);
	
	public static void pretraziKorisnike() {};
	
	//nova metoda
	public static void ucitajPodatke(){
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			podaci = mapper.readValue(new File("fajlovi/podaci.json"),new TypeReference<SadrzalacPodataka>(){});
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		turisti = podaci.getTuristi();
		vodici = podaci.getVodici();
		ture = podaci.getTure();
		
		//za potrebe logovanja
		for (int i = 0;i<turisti.size();i++){
			korisnici.add(turisti.get(i));
		}	
		
		for (int i = 0;i<vodici.size();i++){
			korisnici.add(vodici.get(i));
		}
	}

	//nova metoda
	public static void upisiPodatke(){
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writer().withDefaultPrettyPrinter().writeValue(new File("Fajlovi/podaci.json"), podaci);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void dodajKorisnika(Korisnik k) throws JsonGenerationException, JsonMappingException, IOException {
		korisnici.add(k);
		
		if (k instanceof Turista){
			turisti.add((Turista) k);
			//upisiTuriste();
		}
		if (k instanceof Vodic){
			vodici.add((Vodic) k);
			//upisiVodice();
		}
		upisiPodatke();
	}

	public static void obrisiKorisnika() {};
	
	public static boolean provjeraKorisnika(String korisnicko_ime,String lozinka){
		for (int i = 0;i<korisnici.size();i++){
			if (korisnici.get(i).getKorIme().equals(korisnicko_ime) && korisnici.get(i).getLozinka().equals(lozinka)){
				trenutnoAktivan = korisnici.get(i);
				return true;
			}
		}
		return false;
	}
	
	public static boolean korisnikVecPostoji(String korisnicko_ime){
		for (int i = 0;i<korisnici.size();i++){
			if (korisnici.get(i).getKorIme().equals(korisnicko_ime)){
				return true;
			}
		}
		return false;
	}
	
	public static void ucitajKorisnike() throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		
		turisti = mapper.readValue(new File("fajlovi/turisti.json"),  new TypeReference<ArrayList<Turista>>(){});
		vodici = mapper.readValue(new File("fajlovi/vodici.json"), new TypeReference<ArrayList<Vodic>>(){});
		
		for (int i = 0;i<turisti.size();i++){
			korisnici.add(turisti.get(i));
		}	
		
		for (int i = 0;i<vodici.size();i++){
			korisnici.add(vodici.get(i));
		}
	}
	
	public static void dodajTuru(Tura t) throws JsonGenerationException, JsonMappingException, IOException {
		ture.add(t);
		((Vodic)trenutnoAktivan).getTure().add(t);
		upisiPodatke();
	};

	
	public static void upisiTuriste() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		mapper.writer().withDefaultPrettyPrinter().writeValue(new File("fajlovi/turisti.json"), turisti);
	}
	
	public static void upisiVodice() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		mapper.writer().withDefaultPrettyPrinter().writeValue(new File("fajlovi/vodici.json"), vodici);
	}
	
	
	
	public static void obrisiTuru(Tura t) throws JsonGenerationException, JsonMappingException, IOException {
		ture.remove(t);
		
		for (Vodic vodic : vodici) {
			vodic.getTure().remove(t);
		}
		
		ArrayList<Rezervacija> rezervacijeZaBrisanje;
		for (Korisnik korisnik : korisnici) {
			rezervacijeZaBrisanje = new ArrayList<Rezervacija>();
			for (Rezervacija rezervacija : korisnik.getRezervacije()) {
				if(rezervacija.getTermin().getTura() == t){
					rezervacijeZaBrisanje.add(rezervacija);
				}
			}
			korisnik.getRezervacije().removeAll(rezervacijeZaBrisanje);
		}
		upisiPodatke();
	};

	// ucitavanje tura u kolekciju(ture) aplikacije
	public static void ucitavanjeTura() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper om = new ObjectMapper();
		ture = om.readValue(new File("fajlovi/ture.json"), new TypeReference<ArrayList<Tura>>(){});
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
						if (ture.get(i).getTermini().get(j).getCena() == Integer.parseInt(parametarPretrage)) {
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
	// vraca ture koje je vodic licno kreirao (za prikaza tura koje vodic moze da brise)
	public static ArrayList<Tura> prikazTuraKojeJeVodicKreirao() {

		ArrayList<Tura> tureKojeJeKreirao = new ArrayList<Tura>();

		for (Tura tura : Aplikacija.ture) {
			if(tura.getKreatorTure() == Aplikacija.trenutnoAktivan){
				tureKojeJeKreirao.add(tura);
			}
		}
		return tureKojeJeKreirao;
	}
	
	
	public static boolean IzmeniKorisnika(String ime, String prezime, String telefon,
			String korIme, String lozinka) throws JsonGenerationException,
	JsonMappingException, IOException{
		
		if(korisnikVecPostoji(korIme) == true){
			return false;
		}
		if(!korIme.equals("")){
			Aplikacija.trenutnoAktivan.setKorIme(korIme);
		}
		if(!ime.equals("")){
			Aplikacija.trenutnoAktivan.setIme(ime);
		}
		if(!prezime.equals("")){
			Aplikacija.trenutnoAktivan.setPrezime(prezime);
		}
		if(!telefon.equals("")){
			Aplikacija.trenutnoAktivan.setTelefon(telefon);
		}
		if(!lozinka.equals("")){
			Aplikacija.trenutnoAktivan.setLozinka(lozinka);
		}
		//upisiTuriste();
		//upisiVodice();
		
		upisiPodatke();
		return true;
		
	}
}
