package domain;

public class bewertung {
	
	private int fid;
	private int bid;
	private int beid;
	private String email;
	private String textnachricht;
	private String erstellungsdatum;
	private int rating;
	private double avgRating;
	
	public bewertung() {
		fid = 0;
		bid = 0;
		beid = 0;
		email = "";
		textnachricht = "";
		erstellungsdatum = "";
		rating = 0;
		avgRating = 0;
	}
	
	public bewertung(String textnachricht) {
		this.textnachricht = textnachricht;
	}
	
	public bewertung(int fid, int bid, int beid, String email, String textnachricht, String erstellungsdatum, int rating, int avgRating) {
		this.fid = fid;
		this.bid = bid;
		this.beid = beid;
		this.email = email;
		this.textnachricht = textnachricht;
		this.erstellungsdatum = erstellungsdatum;
		this.rating = rating;
		this.avgRating = avgRating;
	}

	
	public int getBeid() {
		return beid;
	}

	public void setBeid(int beid) {
		this.beid = beid;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTextnachricht() {
		return textnachricht;
	}

	public void setTextnachricht(String textnachricht) {
		this.textnachricht = textnachricht;
	}

	public String getErstellungsdatum() {
		return erstellungsdatum;
	}

	public void setErstellungsdatum(String erstellungsdatum) {
		this.erstellungsdatum = erstellungsdatum;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}
	

}
