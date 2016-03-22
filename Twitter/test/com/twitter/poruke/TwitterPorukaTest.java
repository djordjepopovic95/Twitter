/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Djordje Popovic
 *
 */
public class TwitterPorukaTest {

	
	@Test
	public void testSetKorisnikOK() {
		TwitterPoruka t = new TwitterPoruka();
		String korisnik = "karijatida";
		t.setKorisnik(korisnik);
		
		assertEquals(korisnik, t.getKorisnik());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		TwitterPoruka t = new TwitterPoruka();
		String korisnik = null;
		t.setKorisnik(korisnik);
		
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazno() {
		TwitterPoruka t = new TwitterPoruka();
		String korisnik = "";
		t.setKorisnik(korisnik);
		
	}
	
	@Test
	public void testSetPorukaOK() {
		TwitterPoruka t = new TwitterPoruka();
		String poruka = "6 minutes late and counting";
		t.setPoruka(poruka);
		
		assertEquals(poruka, t.getPoruka());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		TwitterPoruka t = new TwitterPoruka();
		String poruka = null;
		t.setPoruka(poruka);
		
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPredugacka() {
		TwitterPoruka t = new TwitterPoruka();
		String poruka = "1234567891011121314151617181920212223242526272829303132333435363738394041424344454647484950515253545556575859606162636465666768697071727374757677787980";
		t.setPoruka(poruka);
		
	}
	
	@Test
	public void testToString() {
		TwitterPoruka t = new TwitterPoruka();
		t.setKorisnik("karijatida");
		t.setPoruka("6 minutes late and counting");
		String toString = "KORISNIK:" + t.getKorisnik() + " PORUKA:" + t.getPoruka();
		assertEquals(toString, t.toString());
	}

}
