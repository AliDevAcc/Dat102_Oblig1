package no.hvl.dat102;

public class CDarkivKlient {
	public static void main(String[] args) {
		CDarkivADT cda= new CDarkiv();
		Meny meny = new Meny(cda);	
		meny.start();
		
	}
}
