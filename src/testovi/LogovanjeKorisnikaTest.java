package testovi;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import controller.Aplikacija;
import model.Korisnik;

public class LogovanjeKorisnikaTest {
	
	@Test
	public void test1() throws JsonParseException, JsonMappingException, IOException {
		Aplikacija.ucitajPodatke();
		assertTrue("Tacno",Aplikacija.provjeraKorisnika("janko", "janko"));
		assertTrue("Tacno",Aplikacija.provjeraKorisnika("ognjen", "ognjen"));
		assertTrue("Tacno",Aplikacija.provjeraKorisnika("milan", "milan"));
	}
	
	@Test
	public void test2() throws JsonParseException, JsonMappingException, IOException {
		Aplikacija.ucitajPodatke();
		assertTrue("nije tacno",!Aplikacija.provjeraKorisnika("asfasfas", "asfsafasf"));
		assertTrue("nije tacno",!Aplikacija.provjeraKorisnika("dsgsgsdg", "asvsavsa"));
		assertTrue("nije tacno",!Aplikacija.provjeraKorisnika("rgsfeads", "adgasfda"));
	}
}