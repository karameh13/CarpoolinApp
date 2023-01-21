package domain;

public class benutzer {
	private int bid;
	private String name;
	private String email;
	private double avg;
	
	public benutzer() {
		bid=0;
		name="";
		email="";
	}
	
	public benutzer(int bid,String name,String email) {
		this.bid=bid;
		this.name=name;
		this.email=email;
	}
	
	
	
	public benutzer(int bid, String email) {
		this.bid=bid;
		this.email=email;
	}

	public int getbid() {
		return bid;
	}

	public void setbid(int bid) {
		this.bid = bid;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	
	
}
