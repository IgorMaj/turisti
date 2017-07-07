package model;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class Komentar {
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd.mm.yyyy. HH:mm:ss",timezone = "CEST")
	private Date datumObjave;
	private String sadrzina;
	
	@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class") 
	private Korisnik autor;
	private Tura tura;
	public Komentar() {
		super();
		// TODO Auto-generated constructor stub
		sadrzina = "";
		datumObjave = null;
		autor = null;
		tura = null;
	}
	
	public Komentar(Date datumObjave, String sadrzina, Korisnik autor, Tura tura) {
		super();
		this.datumObjave = datumObjave;
		this.sadrzina = sadrzina;
		this.autor = autor;
		this.tura = tura;
	}
	
	
	public Date getDatumObjave() {
		return datumObjave;
	}
	
	
	public void setDatumObjave(Date datumObjave) {
		this.datumObjave = datumObjave;
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
	public Tura getTura() {
		return tura;
	}
	public void setTura(Tura tura) {
		this.tura = tura;
	}
	
	
	
	
}
