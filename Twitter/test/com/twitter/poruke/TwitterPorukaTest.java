/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;

/**
 * @author Djordje Popovic
 *
 */
public class TwitterPorukaTest {

	TwitterPoruka t;
	
	@Before
	public void setUp() throws Exception {
		t = new TwitterPoruka();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}
	
	@Test
	public void testSetKorisnikOK() {
		String korisnik = "karijatida";
		t.setKorisnik(korisnik);
		
		assertEquals(korisnik, t.getKorisnik());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		String korisnik = null;
		t.setKorisnik(korisnik);
		
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazno() {
		String korisnik = "";
		t.setKorisnik(korisnik);
		
	}
	
	@Test
	public void testSetPorukaOK() {
		String poruka = "6 minutes late and counting";
		t.setPoruka(poruka);
		
		assertEquals(poruka, t.getPoruka());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		String poruka = null;
		t.setPoruka(poruka);
		
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPredugacka() {
		String poruka = "1234567891011121314151617181920212223242526272829303132333435363738394041424344454647484950515253545556575859606162636465666768697071727374757677787980";
		t.setPoruka(poruka);
		
	}
	
	@Test
	public void testToString() {
		t.setKorisnik("karijatida");
		t.setPoruka("6 minutes late and counting");
		String toString = "KORISNIK:" + t.getKorisnik() + " PORUKA:" + t.getPoruka();
		assertEquals(toString, t.toString());
	}

}
