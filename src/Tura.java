import java.util.LinkedList;

public class Tura {
	public LinkedList<Termin> termini;
	public LinkedList<Komentar> komentari;
	public String opisTure;
	double ocena;
	double cena;
	public Vodic vodic;
	public String naslovTure;
	
	public Tura(){}
	
	public Tura(LinkedList<Termin>termini,LinkedList<Komentar>komentari,String opis,double ocenaTure,Vodic vodic,String naslovTure,double cena){
		this.termini = termini;
		this.komentari = komentari;
		this.opisTure = opis;
		this.ocena = ocenaTure;
		this.vodic = vodic;
		this.naslovTure = naslovTure;
		this.cena = cena;
	}
}
