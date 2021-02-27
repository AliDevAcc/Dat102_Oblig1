package no.hvl.dat102;

public class CDarkiv implements CDarkivADT {
	// Instansvariable
	private CD[] cdTabell;
	private int antall;
	
	public CDarkiv() {
		cdTabell=new CD[antall];
	}
	

	public void setCdTabell(CD[] cdTabell) {
		this.cdTabell = cdTabell;
	}

	@Override
	// Returnere en tabell av CD-er
	public  CD[] hentCdTabell() {
		return cdTabell;
	}
	@Override
	 // Legger til en ny CD 
	public void leggTilCd(CD nyCd) {
		boolean finnes=false;
		for(int i =0; i < antall; i++) {
		
		if(cdTabell[i].equals(nyCd)) {
			finnes=true;
		}
		}
		
		if(finnes==false && antall < cdTabell.length) {
		cdTabell[antall]=nyCd;
		antall++;
		}
	}
	@Override
	 // Sletter en CD hvis den fins 
	public boolean slettCd(int cdNr) {
		boolean slettet=false;
		
		for(int i=0; i < antall; i++) {
			if(cdTabell[i].getCdNr()==cdNr) {
				cdTabell[i]=null;
				slettet=true;
				antall--;
			}
		}
		return slettet;
	}
	
	@Override
	 // Søker og henter CD-er med en gitt delstreng
	public CD[] sokTittel(String delstreng) {
		CD[] max = new CD[antall];
		int Max_antall=0;
		for(int i=0; i < antall; i++) {
			
			if (cdTabell[i].getTittel().contains(delstreng)){
				max[Max_antall]=cdTabell[i];
				Max_antall++;
			}
				
		}
		
		return max;
	}
	@Override
	 // Søker og henter artister med en gitt delstreng
	public CD[] sokArtist(String delstreng) {
		CD[] max = new CD[antall];
		int Max_antall=0;
		for(int i=0; i < antall; i++) {
			
			if (cdTabell[i].getNavn().contains(delstreng)){
				max[Max_antall]=cdTabell[i];
				Max_antall++;
			}
				
		}
		
		return max;
	}
	@Override
	 // Henter antall CD-er for en gitt sjanger
	public int antallSjanger(Sjanger sjanger) {
		int amount=0;
		for(int i=0; i < antall; i++) {
			if(Sjanger.values()==sjanger.values()) {
				amount++;
			}
		}
		return amount;
	}
	
	@Override
	public int antall() {
		return antall;
	}
	// Returnerer antall CD-er
	// Konstruktører og andre metoder
	//...fyll ut
}
//class