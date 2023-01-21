package domain;

public class reservieren {
	
	private int kunde;
	private int fahrt;
	private int anzPlaetze;
	
	public reservieren() {
		
		kunde = 0;
		fahrt = 0;
		anzPlaetze = 0;
	}
	
	public reservieren(int kunde, int fahrt, int anzPlaetze) {
		super();
		this.kunde = kunde;
		this.fahrt = fahrt;
		this.anzPlaetze = anzPlaetze;
	}
	public int getKunde() {
		return kunde;
	}
	public void setKunde(int kunde) {
		this.kunde = kunde;
	}
	public int getFahrt() {
		return fahrt;
	}
	public void setFahrt(int fahrt) {
		this.fahrt = fahrt;
	}
	public int getAnzPlaetze() {
		return anzPlaetze;
	}
	public void setAnzPlaetze(int anzPlaetze) {
		this.anzPlaetze = anzPlaetze;
	}
	
	
	
}
