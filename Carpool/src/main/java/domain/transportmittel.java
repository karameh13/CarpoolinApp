package domain;

public class transportmittel {
	private int tid;
	private String name;
	private String icon;
	
	public transportmittel() {
		tid=0;
		name="";
		icon="";
	}
	public transportmittel(int tid, String name, String icon) {
		this.tid=tid;
		this.name=name;
		this.icon=icon;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	

}
