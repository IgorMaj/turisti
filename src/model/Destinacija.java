package model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")

public class Destinacija {

		private String naziv;
		private String opis;
		private Mesto mesto;
		
		public Destinacija(){};
		public Destinacija(String naziv, String opis, Mesto mesto) {
			super();
			this.naziv = naziv;
			this.opis = opis;
			this.mesto = mesto;
		}


		public String getNaziv() {
			return naziv;
		}


		public void setNaziv(String naziv) {
			this.naziv = naziv;
		}


		public String getOpis() {
			return opis;
		}


		public void setOpis(String opis) {
			this.opis = opis;
		}


		public Mesto getMesto() {
			return mesto;
		}


		public void setMesto(Mesto mesto) {
			this.mesto = mesto;
		}
		
		
}
