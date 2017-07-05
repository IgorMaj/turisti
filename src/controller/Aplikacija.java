package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Komentar;
import model.Korisnik;
import model.Rezervacija;
import model.Tura;
import model.Turista;
import model.Vodic;
import view.ProzorZaLogovanje;
import view.ProzorZaRegistraciju;


public class Aplikacija {

	public static Korisnik trenutnoAktivan=null;
	public static ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
	public static ArrayList<Tura> ture = new ArrayList<Tura>();

	
	public static void pretraziKorisnike() {};

	public static void dodajKorisnika(Korisnik k) throws JsonGenerationException, JsonMappingException, IOException {
		korisnici.add(k);
		
		boolean turista = true;
		if (k instanceof Vodic){
			turista = false;
		}
		
		ArrayList<Turista> turisti = new ArrayList<Turista>();
		ArrayList<Vodic> vodici = new ArrayList<Vodic>();
		
		for (Korisnik kor: korisnici){
			if (turista && kor instanceof Turista){
				turisti.add((Turista) kor);
			}else if (!turista && kor instanceof Vodic){
				vodici.add((Vodic) kor);
			}
		}
		
		if (turista){
			upisiTuriste(turisti);
			return;
		}
		upisiVodice(vodici);
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
	
	
	public static void izgenerisiVodice() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		
		ArrayList<Vodic> kor = new ArrayList<Vodic>();
		kor.add(new Vodic("Milan123","milan","Milan","Milanovic","065555333",new ArrayList<Komentar>(),new ArrayList<Rezervacija>(),new ArrayList<Tura>()));
		kor.add(new Vodic("Janko135","janko","Janko","Jankovic","064555333",new ArrayList<Komentar>(),new ArrayList<Rezervacija>(),new ArrayList<Tura>()));
		kor.add(new Vodic("Nikola90","nikola","Nikola","Nikolic","064123445",new ArrayList<Komentar>(),new ArrayList<Rezervacija>(),new ArrayList<Tura>()));
		kor.add(new Vodic("Petar","pera","Petar","Petrovic","062345128",new ArrayList<Komentar>(),new ArrayList<Rezervacija>(),new ArrayList<Tura>()));
		
		mapper.writer().withDefaultPrettyPrinter().writeValue(new File("fajlovi/vodici.json"), kor);
	
	}
	
	public static void izgenerisiTuriste() throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		
		ArrayList<Turista> kor = new ArrayList<Turista>();
		kor.add(new Turista("Marko90","marko","Marko","Markovic","064241232",new ArrayList<Komentar>(),new ArrayList<Rezervacija>()));
		kor.add(new Turista("Mladen75","mladen","Mladen","Mladenovic","065227877",new ArrayList<Komentar>(),new ArrayList<Rezervacija>()));
		kor.add(new Turista("Branko","branko","Branko","Brankovic","065123345",new ArrayList<Komentar>(),new ArrayList<Rezervacija>()));
		kor.add(new Turista("Jovana","jovana","Jovana","Jovanovic","065333444",new ArrayList<Komentar>(),new ArrayList<Rezervacija>()));
		
		//mapper.writeValue(new File("fajlovi/turisti.json"), kor);
		mapper.writer().withDefaultPrettyPrinter().writeValue(new File("fajlovi/turisti.json"), kor);
	}
	
	public static void ucitajKorisnike() throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		
		ArrayList<Turista> turisti = mapper.readValue(new File("fajlovi/turisti.json"),  new TypeReference<ArrayList<Turista>>(){});
		ArrayList<Vodic> vodici = mapper.readValue(new File("fajlovi/vodici.json"), new TypeReference<ArrayList<Vodic>>(){});
		
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

	};

	
	public static void upisiTuriste(ArrayList<Turista> turisti) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		mapper.writer().withDefaultPrettyPrinter().writeValue(new File("fajlovi/turisti.json"), turisti);
	}
	
	public static void upisiVodice(ArrayList<Vodic> vodici) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		mapper.writer().withDefaultPrettyPrinter().writeValue(new File("fajlovi/vodici.json"), vodici);
	}
	
	
	
	public static void obrisiTuru(Tura t) throws JsonGenerationException, JsonMappingException, IOException {

		ture.remove(t);

		ObjectMapper mapper = new ObjectMapper();
		mapper.writer().withDefaultPrettyPrinter().writeValue(new File("Fajlovi/ture.json"), ture);

		ArrayList<Tura> tur = new ArrayList<Tura>();
		for (int i = 0; i < t.getVodici().size(); i++) {
			for (int j = 0; j < korisnici.size(); j++) {
				if (korisnici.get(j) instanceof Vodic) {
					String imePrezime = korisnici.get(j).getIme() + " " + korisnici.get(j).getPrezime();
					if (imePrezime.equals(t.getVodici().get(i))) {
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
		for (Korisnik k : Aplikacija.korisnici) {
			if(k instanceof Vodic){
				vodici.add((Vodic)k);
			}
		}
		mapper.writer().withDefaultPrettyPrinter().writeValue(new File("Fajlovi/vodici.json"), vodici);
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

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException{
		
	}
	
}
