package domain;

public class fahrerlaubnis {
	private int fahrer;
	private String fahrerName;
	private int nummer;
	private String ablaufdatum;
	
	public fahrerlaubnis() {
		fahrer = 0;
		nummer = 0;
		ablaufdatum = "";
	}
	public fahrerlaubnis(int fahrer, int nummer, String ablaufdatum) {
		this.fahrer = fahrer;
		this.nummer = nummer;
		this.ablaufdatum = ablaufdatum;
	}
	public int getFahrer() {
		return fahrer;
	}
	public void setFahrer(int fahrer) {
		this.fahrer = fahrer;
	}
	public int getNummer() {
		return nummer;
	}
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	public String getAblaufdatum() {
		return ablaufdatum;
	}
	public void setAblaufdatum(String ablaufdatum) {
		this.ablaufdatum = ablaufdatum;
	}
	public String getFahrerName() {
		return fahrerName;
	}
	public void setFahrerName(String fahrerName) {
		this.fahrerName = fahrerName;
	}
	
}
