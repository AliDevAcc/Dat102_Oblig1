package no.hvl.dat102;

import no.hvl.dat102.adt.StabelADT;
import no.hvl.dat102.exception.EmptyCollectionException;

//  Tabellimplementasjon av en stabel.
//********************************************************************

public class TabellStabel<T> implements StabelADT<T> {
	private final static int STDK = 100;
	private int topp; // indikerer neste plass
	private T[] stabel;

	/*******************************************************************
	 * Oppretter en tom stabel.
	 *******************************************************************/
	
	public TabellStabel() {
		this(STDK);		
	}

	/*******************************************************************
	 * Oppretter en tom stabel med en speisfisert kapasitet.
	 *******************************************************************/
	public TabellStabel(int startKapasitet) {
		topp = 0;
		stabel = (T[]) (new Object[startKapasitet]);
	}

	/*******************************************************************
	 * Legger til det spesifiserte elementet p� toppen av stabelen, utvider
	 * kapasiteten til stabelen hvis n�dvendig.
	 *******************************************************************/
	@Override
	public void push(T element) {
		
		
		if(topp<stabel.length) {
			stabel[topp]=element;
			topp++;
		} else { 
			T[] hjelpeTabell = (T[]) (new Object[stabel.length * 2]);

			for (int indeks = 0; indeks < stabel.length; indeks++) {
				hjelpeTabell[indeks] = stabel[indeks];
			}
			stabel = hjelpeTabell;
			stabel[topp]=element;
			topp++;
		}
		/*  TODO
		 * 
		 * 
		 * hvis antall lik tabell-lengden, s� utvid
		 * 
		 * sett stabelens topp-referanse til element
		 * 
		 * �k topp med 1
		 * 
		 */
	}

	/*************************************************************************
	 * 
	 * Fjerner toppelementet og returnerer en referanse til den. Hvis stabelen
	 * er tom fra f�r, s� kastes unntak
	 *************************************************************************/
	@Override
	public T pop() throws EmptyCollectionException  {
		
		/*
		 * TODO
		 * 
		 * Hvis stabel er tom, s� kast unntak
		 * 
		 * mink topp med 1
		 * 
		 * sett ref.variabelen resulat lik referansen til topp-elementet
		 * 
		 * sett stabelens topp-referanse til null
		 * 
		 * returner resultat
		 * 
		 */			
		
		T resultat=null;
		 
		
		if (!erTom()){
		resultat=stabel[topp-1];
		stabel[topp-1]=null;
		topp--; 
		}
		else {
		throw new EmptyCollectionException("Stabel");
		}
		
		
		
		
		return resultat;
	}

	/**********************************************************************
	 * Returnerer toppelementet uten � fjerne det. Hvis stabelen er tom fra
	 * f�r,s� kastes unntak
	 **********************************************************************/
	@Override
	public T peek()  {
		if (erTom())
			throw new EmptyCollectionException("Stabel");

		return stabel[topp-1];
	}

	/*******************************************************************
	 * Returnerer sann hvis stabelen er tom og usann ellers.
	 *******************************************************************/
	@Override
	public boolean erTom() {
		return (topp == 0);
	}

	/*******************************************************************
	 * Returnerer antall elementer.
	 *******************************************************************/
	@Override
	public int antall() {
		return topp;
	}

	
	/*******************************************************************
	 * Oppretter en ny tabell for � lagre innholdet.
	 *******************************************************************/
	private void utvid() {
		T[] hjelpeTabell = (T[]) (new Object[stabel.length * 2]);

		for (int indeks = 0; indeks < stabel.length; indeks++)
			hjelpeTabell[indeks] = stabel[indeks];

		stabel = hjelpeTabell;
	}
}
