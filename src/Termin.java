
import java.util.ArrayList;

public class Termin {

	private String pocetakTure;
	private String krajTure;
	private int brojSlobodnihMesta;
	private boolean aktivan;
	private double cena;
	private ArrayList<Rezervacija> rezervacije;

	public Termin() {
		super();
	}

	public Termin(String pocetakTure, String krajTure, int brojSlobodnihMesta, boolean aktivan, double cena,
			ArrayList<Rezervacija> rezervacije) {
		super();
		this.pocetakTure = pocetakTure;
		this.krajTure = krajTure;
		this.brojSlobodnihMesta = brojSlobodnihMesta;
		this.aktivan = aktivan;
		this.cena = cena;
		this.rezervacije = rezervacije;
	}

	public String getPocetakTure() {
		return pocetakTure;
	}

	public void setPocetakTure(String pocetakTutre) {
		this.pocetakTure = pocetakTutre;
	}

	public String getKrajTure() {
		return krajTure;
	}

	public void setKrajTure(String krajTure) {
		this.krajTure = krajTure;
	}

	public int getBrojSlobodnihMesta() {
		return brojSlobodnihMesta;
	}

	public void setBrojSlobodnihMesta(int brojSlobodnihMesta) {
		this.brojSlobodnihMesta = brojSlobodnihMesta;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public ArrayList<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(ArrayList<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}

	@Override
	public String toString() {
		return "Termin [pocetakTutre=" + pocetakTure + ", krajTure=" + krajTure + ", brojSlobodnihMesta="
				+ brojSlobodnihMesta + ", aktivan=" + aktivan + ", cena=" + cena + ", rezervacije=" + rezervacije + "]";
	}
	
}