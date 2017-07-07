package model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")

public class Mesto {

		private String naziv;
		private int ptt;
		public Mesto(){};
		
		
		public String getNaziv() {
			return naziv;
		}



		public void setNaziv(String naziv) {
			this.naziv = naziv;
		}



		public int getPtt() {
			return ptt;
		}



		public void setPtt(int ptt) {
			this.ptt = ptt;
		}



		public Mesto(String naziv, int ptt) {
			super();
			this.naziv = naziv;
			this.ptt = ptt;
		}
		
		
		
}
