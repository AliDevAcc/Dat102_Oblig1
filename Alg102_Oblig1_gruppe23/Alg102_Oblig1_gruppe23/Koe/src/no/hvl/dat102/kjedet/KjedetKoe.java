package no.hvl.dat102.kjedet;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exception.EmptyCollectionException;
import no.hvl.dat102.tabell.*;

public class KjedetKoe<T> implements KoeADT<T> {
	private int antall; // antall elementer
	private LinearNode<T> front; // referanse til første node
	private LinearNode<T> bak;   // referanse til siste node
	/***************************************************     
	 * Oppretter en tom kø.   
	 * ***************************************************/
	public KjedetKoe(){
		antall = 0;
		front = bak = null;
		}
	@Override
	public void innKoe(T element) {
		LinearNode<T> nyNode=new LinearNode<T>(element);
		if(erTom()) {
			front=nyNode;
		} else {
			bak.setNeste(nyNode);
		}
		
		bak=nyNode;
		antall++;
	}

	@Override
	public T utKoe() {
		
		if (erTom()) 
			throw new EmptyCollectionException("koe");
			T resultat = front.getElement();
			front = front.getNeste();
			antall--;
		

		if (erTom()) {
			bak = null;
		}
		return resultat;

	}

	@Override
	public T foerste() {
		if (erTom())
			throw new EmptyCollectionException("koe");

		T resultat = front.getElement();

		return resultat;
	}

	@Override
	public boolean erTom() {
		return (antall == 0);
	}

	@Override
	public int antall() {
		return antall;
	}

}
