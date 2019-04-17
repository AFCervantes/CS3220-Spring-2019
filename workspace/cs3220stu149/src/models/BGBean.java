package models;

public class BGBean {
	
	int red, green, blue;

	public BGBean() {
		super();
		red = 255;
	}
	
	public int getR() { return this.red; }
	public int getG() { return this.green; }
	public int getB() { return this.blue; }
	
	public void setR(int r) { this.red = r; }
	public void setG(int g) { this.green = g; }
	public void setB(int b) { this.blue = b; }
	
	public String getAbc() { return "abc"; }
	public String getName() { return "Albert"; }

}
