package no.hvl.dat102;

import java.util.Scanner;

public class Tekstgrensesnitt {
	
	public CD lesCD() {
		Scanner sc = new Scanner(System.in);
	     int i = sc.nextInt();
	     String navn= sc.nextLine();
	     String tittel= sc.nextLine();
	     int aar=sc.nextInt();
	     
	     String sjanger= sc.nextLine();
	     Sjanger sj=Sjanger.finnSjanger(sjanger);
	     String pls=sc.nextLine();
	     CD cd= new CD(i,navn,tittel,aar,sj, pls);
	     
	     
	     return cd;
	     
	}
	
	public void visCD(CD cd) {
		System.out.println(cd.toString());
	}
	
	public void SkrivUtTittel (CDarkivADT cda, String delstreng) {
		System.out.println(cda.sokTittel(delstreng));
	}
	
	public void SkrivUtAritist (CDarkivADT cda,String delstreng) {
		System.out.println(cda.sokArtist(delstreng));
	}
	
	public void SkrivUtStat (Sjanger sj, CDarkivADT cda) {
		
		System.out.println("Totalt antall cd-er " + cda.hentCdTabell().length + "\n Per sjanger \n Rock:" + cda.antallSjanger(sj.finnSjanger(1))
		+ "\n Pop:" + cda.antallSjanger(sj.finnSjanger(2)) + " \n Opera:" + cda.antallSjanger(sj.finnSjanger(3)) + " \n Jazz:"
		+ cda.antallSjanger(sj.finnSjanger(4)) + " \n Klassisk:" + cda.antallSjanger(sj.finnSjanger(5)));
	}
}
