package domain;

public class fahrt {
	
	private int fid;
	private String startort;
	private String zielort;
	private String fahrtdatumzeit;
	private int maxPlaetze;
	private int anzPlaetze;
	private double fahrtkosten;
	private String status;
	private int anbieter;
	private String anbieterName;
	private int transportmittel;
	private String beschreibung;
	private String icon;
	private String trname;
	
	public fahrt() {
		super();
		fid = 0;
		startort = "";
		zielort = "";
		fahrtdatumzeit = "";
		maxPlaetze = 0;
		anzPlaetze = 0;
		fahrtkosten = 0;
		status = "";
		anbieter = 0;
		transportmittel = 0;
		beschreibung = "";
		
	}
	
	public fahrt(String startort, String zielort, String status) {
		this.startort = startort;
		this.zielort = zielort;
		this.status = status;
	}
	public fahrt(String startort, String zielort, int maxPlaetze, double fahrtkosten) {
		this.startort = startort;
		this.zielort = zielort;
		this.maxPlaetze = maxPlaetze;
		this.fahrtkosten = fahrtkosten;
	}
	
	public fahrt(int fid, String startort, String zielort, String fahrtdatumzeit, 
			int maxPlaetze, int anzPlaetze, double fahrtkosten,
			String status, int anbieter, int transportmittel, String beschreibung) {
		
		this.fid = fid;
		this.startort = startort;
		this.zielort = zielort;
		this.fahrtdatumzeit = fahrtdatumzeit;
		this.maxPlaetze = maxPlaetze;
		this.anzPlaetze = anzPlaetze;
		this.fahrtkosten = fahrtkosten;
		this.status = status;
		this.anbieter = anbieter;
		this.transportmittel = transportmittel;
		this.beschreibung = beschreibung;
	}
	
	public fahrt(String startort, String zielort, double fahrtkosten,
			String status, int anbieter, String fahrtdatumzeit, String beschreibung) {
		this.startort = startort;
		this.zielort = zielort;
		this.fahrtkosten = fahrtkosten;
		this.status = status;
		this.anbieter = anbieter;
		this.fahrtdatumzeit = fahrtdatumzeit;
		this.beschreibung = beschreibung;
	}
	
	public fahrt(String startort, String zielort, double fahrtkosten,
			String status, int anbieter, String fahrtdatumzeit) {
		this.startort = startort;
		this.zielort = zielort;
		this.fahrtkosten = fahrtkosten;
		this.status = status;
		this.anbieter = anbieter;
		this.fahrtdatumzeit = fahrtdatumzeit;
		
	}
	
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getStartort() {
		return startort;
	}
	public void setStartort(String startort) {
		this.startort = startort;
	}
	public String getZielort() {
		return zielort;
	}
	public void setZielort(String zielort) {
		this.zielort = zielort;
	}
	public String getFahrtdatumzeit() {
		return fahrtdatumzeit;
	}
	public void setFahrtdatumzeit(String fahrtdatumzeit) {
		this.fahrtdatumzeit = fahrtdatumzeit;
	}
	public int getMaxPlaetze() {
		return maxPlaetze;
	}
	public void setMaxPlaetze(int maxPlaetze) {
		this.maxPlaetze = maxPlaetze;
	}
	public int getAnzPlaetze() {
		return anzPlaetze;
	}

	public void setAnzPlaetze(int anzPlaetze) {
		this.anzPlaetze = anzPlaetze;
	}

	public double getFahrtkosten() {
		return fahrtkosten;
	}
	public void setFahrtkosten(double fahrtkosten) {
		this.fahrtkosten = fahrtkosten;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAnbieter() {
		return anbieter;
	}
	public void setAnbieter(int anbieter) {
		this.anbieter = anbieter;
	}
	
	public int getTransportmittel() {
		return transportmittel;
	}
	public void setTransportmittel(int transportmittel) {
		this.transportmittel = transportmittel;
	}
	
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	

	public String getAnbieterName() {
		return anbieterName;
	}

	public void setAnbieterName(String anbieterName) {
		this.anbieterName = anbieterName;
	}
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTrname() {
		return trname;
	}

	public void setTrname(String trname) {
		this.trname = trname;
	}

	

}

