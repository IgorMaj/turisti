import java.util.Date;

public class Komentar {
	private Date datumPostavljanja;
	private String sadrzina;
	private Korisnik autor;
	
	Komentar(){}
	
	public Komentar(Date datumPostavljanja, String sadrzina, Korisnik autor) {
		super();
		this.datumPostavljanja = datumPostavljanja;
		this.sadrzina = sadrzina;
		this.autor = autor;
	}

	public Date getDatumPostavljanja() {
		return datumPostavljanja;
	}
	public void setDatumPostavljanja(Date datumPostavljanja) {
		this.datumPostavljanja = datumPostavljanja;
	}
	public String getSadrzina() {
		return sadrzina;
	}
	public void setSadrzina(String sadrzina) {
		this.sadrzina = sadrzina;
	}
	public Korisnik getAutor() {
		return autor;
	}
	public void setAutor(Korisnik autor) {
		this.autor = autor;
	}
	
}
