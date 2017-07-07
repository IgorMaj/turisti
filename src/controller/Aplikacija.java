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

		ArrayList<Tura> tur = ((Vodic) trenutnoAktivan).getTure();
		tur.add(t);
		((Vodic) trenutnoAktivan).setTure(tur);

		ObjectMapper mapper = new ObjectMapper();
		mapper.writer().withDefaultPrettyPrinter().writeValue(new File("Fajlovi/ture.json"), ture);
		
		ArrayList<Vodic> vodici = new ArrayList<Vodic>();
		for (Korisnik k : Aplikacija.korisnici) {
			if(k instanceof Vodic){
				vodici.add((Vodic)k);
			}
		}
		mapper.writer().withDefaultPrettyPrinter().writeValue(new File("Fajlovi/vodici.json"), vodici);
		
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

		ObjectMapper mapper = new ObjectMapper();
		

		ArrayList<Tura> tur = new ArrayList<Tura>();
		for (int i = 0; i < t.getVodici().size(); i++) {
			for (int j = 0; j < korisnici.size(); j++) {
				if (korisnici.get(j) instanceof Vodic) {
					String imePrezime = korisnici.get(j).getIme() + " " + korisnici.get(j).getPrezime();
					String vodic = t.getVodici().get(i).getIme()+" "+t.getVodici().get(i).getPrezime();
					if (imePrezime.equals(vodic)) {
						tur = ((Vodic) korisnici.get(j)).getTure();
						for (Tura tura : tur) {
							if(tura.getIdTure().equals(t.getIdTure())){
								tur.remove(tura);
								break;
							}
						}
						((Vodic) korisnici.get(j)).setTure(tur);
					}
				}
			}
		}
		ArrayList<Vodic> vodici = new ArrayList<Vodic>();
		ArrayList<Turista> turisti = new ArrayList<Turista>();
		
		
		for (Korisnik korisnik : Aplikacija.korisnici) {
			ArrayList<Rezervacija> korRezervacija = korisnik.getRezervacije();
			for (Rezervacija rezervacija : korRezervacija) {
				if(t.getIdTure().equals(rezervacija.getTermin().getTura().getIdTure())){
					korisnik.getRezervacije().remove(rezervacija);
				}
			}
		}
		
		for (Korisnik k : Aplikacija.korisnici) {
			if(k instanceof Vodic){
				vodici.add((Vodic)k);
			}
			if(k instanceof Turista){
				turisti.add((Turista)k);
			}
		}
		
		for (Tura tura : Aplikacija.ture) {
			ArrayList<Tura> tureKreator = tura.getKreatorTure().getTure();
			for(Tura turaK : tureKreator){
				if(turaK.getIdTure().equals(t.getIdTure())){
					tureKreator.remove(turaK);
				}
			}
			ArrayList<Vodic> vodiciTure = tura.getVodici();
			for (Vodic vodic : vodiciTure) {
				for (Tura tureVodici : vodic.getTure()) {
					if(tureVodici.getIdTure().equals(t.getIdTure())){
						vodic.getTure().remove(tureVodici);
						break;
					}
				}
			}
		}
		
		//brisanje rezervazija za vodice u turama kojima je trenutno tura obrisana
		for (Tura tura : Aplikacija.ture) {
			ArrayList<Rezervacija> kreatorRezervacije = tura.getKreatorTure().getRezervacije();
			for (Rezervacija rezervacija : kreatorRezervacije) {
				if(t.getIdTure().equals(rezervacija.getTermin().getTura().getIdTure())){
					tura.getKreatorTure().getRezervacije().remove(rezervacija);
				}
			}
			ArrayList<Vodic> vodiciTure = tura.getVodici();
			for (Vodic vodic : vodiciTure) {
				ArrayList<Rezervacija> vodiciRezervacije = vodic.getRezervacije();
				for (Rezervacija rezervacija : vodiciRezervacije) {
					if(t.getIdTure().equals(rezervacija.getTermin().getTura().getIdTure())){
						vodic.getRezervacije().remove(rezervacija);
					}
				}
			}
		}
		
		
		
		
		
		
		mapper.writer().withDefaultPrettyPrinter().writeValue(new File("Fajlovi/ture.json"), ture);
		mapper.writer().withDefaultPrettyPrinter().writeValue(new File("Fajlovi/vodici.json"), vodici);
		mapper.writer().withDefaultPrettyPrinter().writeValue(new File("Fajlovi/turisti.json"), turisti);
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

		ArrayList<Tura> t = new ArrayList<Tura>();

		String imePrz = trenutnoAktivan.getIme() + " " + trenutnoAktivan.getPrezime();

		for (int i = 0; i < ture.size(); i++) {
			if (imePrz.equals(ture.get(i).getKreatorTure())) {
				t.add(ture.get(i));
			}
		}
		return t;
	}
	// vraca ture u cijem vodjenju vodic ucestvuje
	public static ArrayList<Tura> prikazTuraKojeVodicVodi() {

		ArrayList<Tura> t = new ArrayList<Tura>();

		String imePrz = trenutnoAktivan.getIme() + " " + trenutnoAktivan.getPrezime();

		for (int i = 0; i < ture.size(); i++) {
			for (int j = 0; j < ture.get(i).getVodici().size(); j++) {
				if (imePrz.equals(ture.get(i).getVodici().get(j))) {
					t.add(ture.get(i));
					break;
				}
			}
		}
		return t;
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

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException{
		
	}
	
}
