
public abstract class Korisnik {
	private String korisnickoIme;
	private String sifra;
	private String ime;
	private String prezime;
	
	public Korisnik(){
		
	}
	
	

	public Korisnik(String korisnickoIme, String sifra, String ime, String prezime) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.sifra = sifra;
		this.ime = ime;
		this.prezime = prezime;
	}



	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
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
		
}
