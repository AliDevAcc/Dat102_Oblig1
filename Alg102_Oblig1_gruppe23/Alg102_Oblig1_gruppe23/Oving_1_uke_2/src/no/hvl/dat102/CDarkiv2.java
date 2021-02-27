package no.hvl.dat102;

public class CDarkiv2 implements CDarkivADT {
	// Instansvariable
	private LinearNode<CD> start;
	private int antall;
	
	public CDarkiv2() {
		antall=0;
		start=null;
	}
	

	public void setLinearNode(LinearNode<CD> start) {
		this.start = start;
	}

	@Override
	// Returnere en tabell av CD-er
	public CD[] hentCdTabell() {
		LinearNode<CD> denne = start;
		CD[] cdTab = new CD[antall];
		int i = 0;
		while(denne != null) {
			System.out.println(denne.getElement().toString());
			cdTab[i] = denne.getElement();
			denne = denne.getNeste();
			i++;
		}
		return cdTab;
	}
	@Override
	 // Legger til en ny CD 
	public void leggTilCd(CD nyCd) {
		boolean finnes=false;
		
		if(start.getElement().equals(nyCd)) {
			finnes=true;
		}
		
		if(finnes==false) {
		LinearNode<CD> node = new LinearNode<CD> (nyCd);
			start = node;
			antall++;
		}
		
	}
	@Override
	 // Sletter en CD hvis den fins 
	public boolean slettCd(int cdNr) {
		CD[] cdTab= new CD[antall];
		boolean slettet=false;
		LinearNode<CD> denne = start;
		LinearNode<CD> forrige=denne.getForrige();
		
		for(int i=0; i < antall; i++) {
			if(denne.getElement().getCdNr()==cdNr) {
				
					if(denne.getForrige() !=null) {
						denne=forrige.getNeste();
						forrige.setNeste(denne.getNeste());
						antall--;
						slettet=true;
						
					} else {
						start=denne.getNeste();
						antall--;
						slettet=true;
					}
			}
		}
		return slettet;
	}
	
	@Override
	 // Søker og henter CD-er med en gitt delstreng
	public CD[] sokTittel(String delstreng) {
		LinearNode<CD> denne = start;
		int i=0;
		boolean funnet=false;
		CD[] cdTab=new CD[antall];
		
		while(denne !=null && funnet) {	
			if (start.getElement().getTittel().contains(delstreng)){
				cdTab[i]=denne.getElement();
				i++;
				funnet=true;
			}
				
		}
		
		return trimTab(cdTab,i);
	}
	@Override
	 // Søker og henter artister med en gitt delstreng
	public CD[] sokArtist(String delstreng) {
		boolean funnet=false;
		LinearNode<CD> denne=start;
		CD[] cdTab = new CD[antall];
		int i=0;
		while(denne !=null && funnet) {
			
			if (denne.getElement().getNavn().contains(delstreng)){
				cdTab[i]=denne.getElement();
				i++;
			}
				
		}
		
		return trimTab(cdTab, i);
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
	
	public CD[] trimTab(CD[] cdTab, int n) { // n er antall elementer
		CD[] cdTab2= new CD[n];
		int i = 0;
		while (i<n) {
			cdTab2[i]=cdTab[i];
			i++;
		} //while
		
		return cdTab2;
		
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