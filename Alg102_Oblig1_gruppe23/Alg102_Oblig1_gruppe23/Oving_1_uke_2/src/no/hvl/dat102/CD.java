package no.hvl.dat102;

public class CD {
private int cdNr;
private String navn;
private String tittel;
private int aar;
private Sjanger sjanger;
private String plselskap;

public CD(int cdNr, String navn, String tittel, int aar, Sjanger sjanger,String plselskap) {
	this.cdNr=cdNr;
	this.navn=navn;
	this.tittel=tittel;
	this.aar=aar;
	this.sjanger=sjanger;
}

public int getCdNr() {
	return cdNr;
}

public void setCdNr(int cdNr) {
	this.cdNr = cdNr;
}

public String getPlselskap() {
	return plselskap;
}

public void setPlselskap(String plselskap) {
	this.plselskap = plselskap;
}

public String getNavn() {
	return navn;
}

public void setNavn(String navn) {
	this.navn = navn;
}

public String getTittel() {
	return tittel;
}

public void setTittel(String tittel) {
	this.tittel = tittel;
}

public int getAar() {
	return aar;
}

public void setAar(int aar) {
	this.aar = aar;
}

public Sjanger getSjanger() {
	return sjanger;
}

public void setSjanger(Sjanger sjanger) {
	this.sjanger = sjanger;
}



}
