package com.twitter.poruke;

/**
 * Sadrzi atribute korisnik i poruka, odgovarajuce getere i setere i toString metodu.
 * @author Djordje Popovic
 *
 */
public class TwitterPoruka {
	
	/**
	 * Ime korisnika
	 */
	private String korisnik;
	
	/**
	 * Poruka koju kosrisnik salje 
	 */
	private String poruka;

	
	/**
	 * Vraca ime korisnika
	 * @return korisnik
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Postavlja novo korisnicko ime
	 * @param korisnik Ime korisnika
	 * @throws RuntimeException Ako ime korisnika nije uneto
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik == "")
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	
	/**
	 * Vraca poruku koju salje korisnik
	 * @return poruka
	 */
	public String getPoruka() {
		return "poruka";
	}

	
	/**
	 * Postavlja vrednost poruke
	 * @param poruka Poruka koju korisnik salje
	 * @throws RuntimeException Ako poruka nije uneta, ili ako je maksimalna duzina prekoracena
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || this.poruka.length() > 140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	
	/**
	 * Vraca vrednosti svih atributa u jednom stringu
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}
}
