package model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class SadrzalacPodataka {
	
	
	
	private ArrayList<Turista> turisti;
	private ArrayList<Vodic> vodici;
	private ArrayList<Tura> ture;
	
	public SadrzalacPodataka(){
		turisti = new ArrayList<Turista>();
		vodici = new ArrayList<Vodic>();
		ture = new ArrayList<Tura>();
	}

	public SadrzalacPodataka(ArrayList<Turista>turisti,ArrayList<Vodic> vodici,ArrayList<Tura> ture){
		this.setTuristi(turisti);
		this.setVodici(vodici);
		this.setTure(ture);
	}

	public ArrayList<Turista> getTuristi() {
		return turisti;
	}

	public void setTuristi(ArrayList<Turista> turisti) {
		this.turisti = turisti;
	}

	public ArrayList<Vodic> getVodici() {
		return vodici;
	}

	public void setVodici(ArrayList<Vodic> vodici) {
		this.vodici = vodici;
	}

	public ArrayList<Tura> getTure() {
		return ture;
	}

	public void setTure(ArrayList<Tura> ture) {
		this.ture = ture;
	}
}
