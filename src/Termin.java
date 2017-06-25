import java.util.Date;

public class Termin {
	
	Date datumPocetka;
	Date datumZavrsetka;
	int brojSlobodnihMesta;
	
	Termin(){}
	
	public Date getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}

	public Date getDatumZavrsetka() {
		return datumZavrsetka;
	}

	public void setDatumZavrsetka(Date datumZavrsetka) {
		this.datumZavrsetka = datumZavrsetka;
	}

	public int getBrojSlobodnihMesta() {
		return brojSlobodnihMesta;
	}

	public void setBrojSlobodnihMesta(int brojSlobodnihMesta) {
		this.brojSlobodnihMesta = brojSlobodnihMesta;
	}

	public Termin(Date datumPocetka, Date datumZavrsetka, int brojSlobodnihMesta) {
		super();
		this.datumPocetka = datumPocetka;
		this.datumZavrsetka = datumZavrsetka;
		this.brojSlobodnihMesta = brojSlobodnihMesta;
	}
	
	
	
}
