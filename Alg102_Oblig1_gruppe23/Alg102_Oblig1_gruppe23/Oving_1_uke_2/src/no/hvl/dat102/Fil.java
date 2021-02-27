package no.hvl.dat102;

import java.io.*;
import java.util.*;

public class Fil {
private final static String SKILLE = "#"; 
// Eventuelt ha som parameter i// metodene.
// Lese et CDarkiv fra tekstfil

public static void lesFraFil(CDarkivADT cdarkiv, String filnavn){
	try {
		
		 FileReader ansFil = new FileReader(filnavn);
		 			 
        
			 
		 
		BufferedReader innfil = new BufferedReader(ansFil);

		// 3 - Leser den første posten som kun inneholder et heltall som er antall info-poster
		       
		String linje = innfil.readLine();
		int n = Integer.parseInt(linje);
		cdarkiv = new CDarkiv();

		// 4 - Les postene, en hel post om gangen
		for (int i = 0; i < n; i++) {
			String post = innfil.readLine();
			String[] felt = post.split(SKILLE);
			int nr = Integer.parseInt(felt[0]);
			String artist = felt[1];
			String tittel = felt[2];
			int aar = Integer.parseInt(felt[3]);
			String sjStr = felt[4];
			Sjanger sj = Sjanger.finnSjanger(sjStr);
			String plselskap = felt[5];

			CD cd = new CD(nr, artist, tittel, aar, sj, plselskap);

			cdarkiv.leggTilCd(cd);
			
			// 4 - Lukk filen
		    innfil.close();
		}

		

	} catch (FileNotFoundException unntak) {// arver fra IOE.. må stå først
		                                    // hvis ikke vil unntaket for IOException skygge
		System.out.println("Finner ikke filen " + filnavn);
		System.exit(1); //avbryte utføringen
	} catch (IOException e) {
		System.out.println("Feil ved lesing av fil: " + e);
		System.exit(2); //avbryte utføringen
	}
	
}

// Alt: public static CDarkivADTlesFraFil(String filnavn){CDarkivADT cda = null;...; cda = new CDarkiv(n);...; return cda}

// Lagre et CDarkiv til tekstfil
public static void skrivTilFil(CDarkivADT cdarkiv, String filnav){
	try {
		// 1 - FileWriter
		FileWriter ansFil = new FileWriter(filnav, false);

		// 2 - PrintWriter
		PrintWriter utfil = new PrintWriter(ansFil);

		// 3 - Skriver først ut antall ansatt-info-er på den første linjen
		utfil.println(cdarkiv.antall());

		// Hvis vi tar imot en tabell av ansatte, ville vi her lage en løkke der
		// vi for hver ansatt henter ut feltvariable og skriver de ut på samme linje

		// 3 - Skriv postene, felt for felt
		utfil.print(cdarkiv.hentCdTabell());;

		// 4 - Lukk filen
		utfil.close();
		
	} catch (FileNotFoundException unntak) {// arver fra IOE.. må stå først
		// hvis ikke vil unntaket for IOException skygge
		System.out.println("Finner ikke filen ");
		System.exit(1);

	} catch (IOException e) {
		System.out.println("Feil ved skriving til fil : " + e);
		System.exit(3);
	}
}
}//class

