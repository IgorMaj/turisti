import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Korisnik {
	String ime;
	String prezime;
	String telefon;
	String korisnicko_ime;
	String lozinka;
	ArrayList<Komentar> korisnici;
	ArrayList<Rezervacija> rezervacije;
	
	public Korisnik(){
		
	}

	
	
	public Korisnik(String ime, String prezime, String telefon, String korisnicko_ime, String lozinka,
			ArrayList<Komentar> korisnici, ArrayList<Rezervacija> rezervacije) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.telefon = telefon;
		this.korisnicko_ime = korisnicko_ime;
		this.lozinka = lozinka;
		this.korisnici = korisnici;
		this.rezervacije = rezervacije;
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



	public String getKorisnicko_ime() {
		return korisnicko_ime;
	}



	public void setKorisnicko_ime(String korisnicko_ime) {
		this.korisnicko_ime = korisnicko_ime;
	}



	public String getLozinka() {
		return lozinka;
	}



	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}



	public ArrayList<Komentar> getKorisnici() {
		return korisnici;
	}



	public void setKorisnici(ArrayList<Komentar> korisnici) {
		this.korisnici = korisnici;
	}



	public ArrayList<Rezervacija> getRezervacije() {
		return rezervacije;
	}



	public void setRezervacije(ArrayList<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}



	
	
	public static void snimi_korisnike_u_fajl(HashMap<String, Korisnik> korisnici) throws IOException{
		PrintWriter out = new PrintWriter(new FileWriter("korisnici.txt"));

		for (String k : korisnici.keySet()) {
			if (korisnici.get(k) instanceof Vodic){
				out.println(korisnici.get(k).getIme() + "|" + korisnici.get(k).getPrezime() + "|" + korisnici.get(k).getTelefon() + "|" + k + "|" + korisnici.get(k).getLozinka() + "|" + "v");
			}else{
				out.println(korisnici.get(k).getIme() + "|" + korisnici.get(k).getPrezime() + "|" + korisnici.get(k).getTelefon() + "|" + k + "|" + korisnici.get(k).getLozinka() + "|" + "t");
			}
		}
		out.close();
	}
	
	
	public static boolean korisnik_vec_postoji(String korisnicko_ime) throws IOException{
		HashMap<String, Korisnik> korisnici = new HashMap<String,Korisnik>();
		if (korisnici.containsKey(korisnicko_ime)){
			return true;
		}
		return false;
	}
	
	public static boolean provjera_korisnika(String korisnicko_ime,String lozinka) throws IOException{
		HashMap<String, Korisnik> korisnici = new HashMap<String,Korisnik>();
		if (korisnici.containsKey(korisnicko_ime) && korisnici.get(korisnicko_ime).getLozinka().equals(lozinka)){
			return true;
		}
		return false;
	}
	
}