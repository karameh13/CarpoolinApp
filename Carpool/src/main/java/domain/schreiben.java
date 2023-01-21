package domain;

public class schreiben {
	
  	private int benutzer;
	private int fahrt;
	private int bewertung;
	
	public schreiben(int benutzer, int fahrt, int bewertung) {
		super();
		this.benutzer = benutzer;
		this.fahrt = fahrt;
		this.bewertung = bewertung;
	}
	
	public schreiben() {
		
	}

	public int getBenutzer() {
		return benutzer;
	}
	public void setBenutzer(int benutzer) {
		this.benutzer = benutzer;
	}
	public int getFahrt() {
		return fahrt;
	}
	public void setFahrt(int fahrt) {
		this.fahrt = fahrt;
	}
	public int getBewertung() {
		return bewertung;
	}
	public void setBewertung(int bewertung) {
		this.bewertung = bewertung;
	}
	

}
