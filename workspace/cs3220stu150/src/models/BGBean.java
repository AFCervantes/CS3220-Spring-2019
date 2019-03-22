package models;

public class BGBean {

	// Red, Green, Blue
	int red, green, blue;
	
	public BGBean() {
		super();
		this.red = 255;
		this.green = 0;
		this.blue = 0;
	}
	public int getR() { return red; }
	public int getG() { return green; }
	public int getB() { return blue; }
	
	public void setR(int red) { this.red = red; }
	public void setG(int green) { this.green = green; }
	public void setB(int blue) { this.blue = blue; }
}
