package model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
@JsonTypeInfo(use=Id.CLASS, include=As.PROPERTY, property="class")
public abstract class Stanje {
	
	

	private Termin termin;
	
	public abstract void entry();
	public abstract void exit();
	
	public abstract void aktivacijaTermina();
	public abstract void deaktivacijaTermina();
	public abstract void rezervacijaTermina();
	public abstract void otkazvanjeRezervacije();
	
	public Stanje() {
	}
	
	public Stanje(Termin termin){
		this.termin = termin;
	}
	
	public Termin getTermin() {
		return termin;
	}
	public void setTermin(Termin termin) {
		this.termin = termin;
	}

}
