package testovi;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import controller.Aplikacija;
import model.Komentar;
import model.Rezervacija;
import model.Turista;

public class IzmenaProfilaKorisnikaTest {

	private void postaviTrenutnoUlogovanog(){
		ArrayList<Komentar> komentari = new ArrayList<>();
		ArrayList<Rezervacija> rezervacije = new ArrayList<>();
		Turista trenutnoUlogovani = new Turista("david123","david","David","Davidovic","065000000",komentari,rezervacije);
		Aplikacija.trenutnoAktivan = trenutnoUlogovani;
	}

	@Test
	public void test1() throws JsonGenerationException, JsonMappingException, IOException {
		postaviTrenutnoUlogovanog();
		Aplikacija.ucitajPodatke();
		Aplikacija.IzmeniKorisnika("Mitar", "Mitrovic", "065999999", "mile123", "mile");
		assertEquals(Aplikacija.trenutnoAktivan.getKorIme(),"mile123");
		assertEquals(Aplikacija.trenutnoAktivan.getLozinka(),"mile");
		assertEquals(Aplikacija.trenutnoAktivan.getIme(),"Mitar");
		assertEquals(Aplikacija.trenutnoAktivan.getPrezime(),"Mitrovic");
		assertEquals(Aplikacija.trenutnoAktivan.getTelefon(),"065999999");
	}
	
	@Test
	public void test2() throws JsonGenerationException, JsonMappingException, IOException {
		postaviTrenutnoUlogovanog();
		Aplikacija.ucitajPodatke();
		boolean korImePostoji = Aplikacija.IzmeniKorisnika("Janko", "Jankovic", "", "janko", "janko");
		assertEquals(false,korImePostoji);
	}
}
