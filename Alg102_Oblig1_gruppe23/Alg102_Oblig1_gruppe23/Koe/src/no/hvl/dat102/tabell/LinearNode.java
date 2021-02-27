package no.hvl.dat102.tabell;

//********************************************************************
//  LinearNode.java       
//
//  Representer en node i en dobbeltkjedet liste..
//********************************************************************

public class LinearNode<T> {
	private LinearNode<T> neste;
	private LinearNode<T> forrige;
	private T element;

	/******************************************************************
	 * Oppretter en tom node node.
	 ******************************************************************/
	public LinearNode() {
		neste = null;
		element = null;
		forrige = null;
	}

	/******************************************************************
	 * Oppretter en node som lagrer det spesifiserte elementet.
	 ******************************************************************/
	public LinearNode(T elem) {
		neste = null;
		forrige = null;
		element = elem;
	}

	/******************************************************************
	 * Returnerer en referanse til etterfølgeren av denne noden, eller null hvis
	 * denne er siste.
	 ******************************************************************/
	public LinearNode<T> getNeste() {
		return neste;
	}

	/*************************************************************************
	 * Returnerer forgjengeren til denne noden, eller null hvis denne er første
	 **************************************************************************/
	public LinearNode<T> getForrige() {
		return forrige;
	}

	/******************************************************************
	 * Setter neste til å peke på dnode.
	 ******************************************************************/
	public void setNeste(LinearNode<T> dnode) {
		neste = dnode;
	}

	/******************************************************************
	 * Settter ny forrige til å peke på dnode.
	 ******************************************************************/
	public void setForrige(LinearNode<T> dnode) {
		forrige = dnode;
	}

	/******************************************************************
	 * Returnerer elementet til denne noden..
	 ******************************************************************/
	public T getElement() {
		return element;
	}

	/******************************************************************
	 * Lagrer nytt element i denne noden..
	 ******************************************************************/
	public void setElement(T elem) {
		element = elem;
	}

}
