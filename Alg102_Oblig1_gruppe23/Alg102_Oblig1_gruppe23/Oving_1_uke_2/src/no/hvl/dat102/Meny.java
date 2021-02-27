package no.hvl.dat102;

import java.util.*;


import java.io.*;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private CDarkivADT cda;
	public Meny(CDarkivADT cda){
		tekstgr = new Tekstgrensesnitt();
		this.cda = cda;
		}
	
	public void setCDA(CDarkivADT cda) {
		this.cda=cda;
	}
	
	public CDarkivADT getCDA() {
		return cda;
	}
	
public void start(){
		System.out.println("Velg 0 for � ta ut noe spesifikkt, Velg 1 for � f� ut hele tabellen");
		Scanner sc= new Scanner(System.in);
		int svar=sc.nextInt();
		if(svar==0) {
		System.out.println("Velg 0 for � avslutte s�ket,\nVelg 1 for � hente hele tabellen,\nVelg 2 for � legge til ny CD, "
				+ "\nVelg 3 for � s�ke etter en artist, \nVelg 4 for � s�ke etter tittel, "
				+ "\nVelg 5 for � s�ke etter antall cd-er i tabellen");
		svar=sc.nextInt();
		}
		String ukjent="";
		
		while(svar!=0) {
		switch (svar) {
		
		case 1: cda.hentCdTabell();
		break;
		
		case 2:	
			System.out.println("Legg til ny CD");
			Tekstgrensesnitt eks= new Tekstgrensesnitt();
			cda.leggTilCd(eks.lesCD());
		break;
		
	
		case 3: 
			Scanner sc3= new Scanner(System.in);
			String art=sc3.nextLine();
			cda.sokArtist(art);
		break;
		
		case 4: 
			Scanner sc4= new Scanner(System.in);
			String title=sc4.nextLine();
			cda.sokTittel(title);
		break;
		
		case 5:
			cda.antall();
		break;
		
		case 6:
			Scanner sc5= new Scanner(System.in);
			String sjanger=sc5.nextLine();
			Sjanger sj=Sjanger.finnSjanger(sjanger);
			cda.antallSjanger(sj);
		break;
		
		default:
			ukjent="Ukjent";
		break;
		
		}
		
		System.out.println("Velg 0 for � avslutte s�ket,\nVelg 1 for � hente hele tabellen,\nVelg 2 for � legge til ny CD, "
				+ "\nVelg 3 for � s�ke etter en artist, \nVelg 4 for � s�ke etter tittel, "
				+ "\nVelg 5 for � s�ke etter antall cd-er i tabellen");
		svar=sc.nextInt();
	}
		System.out.println("Meny Avsluttet");
		
	}
}// class