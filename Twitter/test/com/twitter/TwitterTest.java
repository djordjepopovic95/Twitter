package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

import junit.framework.Assert;

public class TwitterTest {
	
	Twitter t;
	TwitterPoruka tp;
	
	@Before
	public void setUp() throws Exception {
		t = new  Twitter();
		tp = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
		tp = null;
	}

	@Test
	public void testUnesiOK() {
		String korisnik = "karijatida";
		String poruka = "6 minutes late and counting";
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		t.unesi(korisnik, poruka);
		LinkedList<TwitterPoruka> p = t.vratiSvePoruke();
	    String[] expected = {tp.getKorisnik(), tp.getPoruka()};
	    String[] actual = {p.getLast().getKorisnik(), p.getLast().getPoruka()};
		assertArrayEquals(expected, actual);
	}
	
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiKorisnikNull() {
		String korisnik = null;
		String poruka = "alkdnac";
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		t.unesi(korisnik, poruka);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiPorukaNull() {
		String korisnik = "agnjz";
		String poruka = null;
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		t.unesi(korisnik, poruka);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiNullKorisnikPrazan() {
		String korisnik = "";
		String poruka = null;
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		t.unesi(korisnik, poruka);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testUnesiPorukaPrazna() {
		String korisnik = null;
		String poruka = "";
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		t.unesi(korisnik, poruka);
	}

	@Test
	public void testVratiPorukeOK() {
		TwitterPoruka[] tpNiz = new TwitterPoruka[4];
		//tpNiz[0].setKorisnik("wtpnncs"); tpNiz[0].setPoruka("Los tvit."); 	
		tpNiz[0] = new TwitterPoruka();
		tpNiz[0].setKorisnik("wtpnncs"); tpNiz[0].setPoruka("Turbofolk mama."); 
		tpNiz[1] = new TwitterPoruka();
		tpNiz[1].setKorisnik("wtpnncs"); tpNiz[1].setPoruka("Turbofolk."); 	
		//tpNiz[0].setKorisnik("wtpnncs"); tpNiz[0].setPoruka("Sve."); 	
		
		t.unesi("wtpnncs", "Los tvit.");
		t.unesi("wtpnncs", "Turbofolk mama.");
		t.unesi("wtpnncs", "Turbofolk.");
		t.unesi("wtpnncs", "Sve.");
		
		 String[] expected = {tpNiz[0].getPoruka(), tpNiz[1].getPoruka()};
		 String[] actual = {t.vratiPoruke(10, "folk")[0].getPoruka(), t.vratiPoruke(10, "folk")[1].getPoruka()};
		 assertArrayEquals(expected, actual);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagNull() {
		
		t.unesi("wtpnncs", "Los tvit.");
		t.unesi("wtpnncs", "Turbofolk mama.");
		t.unesi("wtpnncs", "Turbofolk.");
		t.unesi("wtpnncs", "Sve.");
		
		t.vratiPoruke(10, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPorukeTagPrazan() {
		
		t.unesi("wtpnncs", "Los tvit.");
		t.unesi("wtpnncs", "Turbofolk mama.");
		t.unesi("wtpnncs", "Turbofolk.");
		t.unesi("wtpnncs", "Sve.");
		
		t.vratiPoruke(10, "");
	}
}
