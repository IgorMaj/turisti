import java.util.ArrayList;

public class Vodic extends Turista{

	
	
	public Vodic(){
		
	}
	
	public Vodic(String ime,String prezime,String telefon,String korisnicko_ime,String lozinka,ArrayList<Komentar> korisnici, ArrayList<Rezervacija> rezervacije){
		super(ime,prezime,telefon,korisnicko_ime,lozinka,korisnici,rezervacije);
	}
}
