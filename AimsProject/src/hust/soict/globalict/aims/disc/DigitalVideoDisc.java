package hust.soict.globalict.aims.disc;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private int id;
	private static int nbDigitalVideoDiscs = 0;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(DigitalVideoDisc other) {
		super();
		this.title = other.title;
		this.category = other.category;
		this.director = other.director;
		this.length = other.length;
		this.cost = other.cost;
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs++;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id = nbDigitalVideoDiscs;
		nbDigitalVideoDiscs++;
	}
	
	public String toString() {
		return "DVD - " + title +" - " + (category == null?"N/A":category) + " - " + (director == null?"N/A":director) + " - " + 
		(length==0?"N/A":length) + ": " + (cost==0?"N/A":cost) + " $";
	}
	

}
