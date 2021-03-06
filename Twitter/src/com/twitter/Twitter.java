package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Sadr�i lisu sa porukama (klasa TwitterPoruka), metodu za uno�enje nove poruke, metodu koja vra�a sve poruke u obliku niza
 * i metodu koja pretra�uje poruke pomo�u prosle�enog taga.
 * @author Djordje Popovic
 *
 */
public class Twitter {
	
	/**
	 * Lista objekata TwitterPoruka
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Metoda vraca atribut poruke tipa LinkedList
	 * @return Lista objekata TwitterPoruka
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * Unosi novi element u listu
	 * @param korisnik Ime korisnika
	 * @param poruka Poruka koju korisnik salje
	 */
	public void unesi(String korisnik, String poruka) {
		// Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		// Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}

	/**
	 * Vraca niz objekata TwitterPoruka koje u poruci sadrze prosledjeni tag
	 * @param maxBroj Maksimalna duzina niza koji se vraca
	 * @param tag Kriterijum za pretrazivanje
	 * @throws RuntimeException Ako uneti tag ima vrednos null ili je prazan string
	 * @return TwitterPoruka[]
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag == null || tag == "")
			throw new RuntimeException("Morate uneti tag");
		// Ako je maxBroj <=0, vraca maxBroj se postavlja na 100 poruka
		if (maxBroj <= 0)
			maxBroj = 100;
		// Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		// Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		// sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		// Pretrazuju se poruke i traze se one koje sadrze tag.
		// Ako se nadje neka takva, i ako nije prekoracen maxBroj
		// ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		// se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}