package no.hvl.dat102;

import no.hvl.dat102.Sjanger;

public interface CDarkivADT {
	// Bruk gjerne javadoc her i
	// stedet for vanlige 
	// kommentarlinjer som her 
	// Returnere en tabell av CD-er
	public  CD[] hentCdTabell();
	 // Legger til en ny CD 
	public void leggTilCd(CD nyCd);
	 // Sletter en CD hvis den fins 
	public boolean slettCd(int cdNr);
	 // Søker og henter CD-er med en gitt delstreng
	public CD[] sokTittel(String delstreng);
	 // Søker og henter artister med en gitt delstreng
	public CD[] sokArtist(String delstreng);
	 // Henter antall CD-er for en gitt sjanger
	public int antallSjanger(Sjanger sjanger);
	// Returnerer antall CD-er
	public int antall();
//interface 
}
