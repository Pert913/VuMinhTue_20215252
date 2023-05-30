package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	
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
	public DigitalVideoDisc(String title, String category, float cost, int length, String director) {
		super(title, category, cost, length, director);
	}
	public DigitalVideoDisc(DigitalVideoDisc other) {
		super(other.getTitle(), other.getCategory(), other.getCost(), other.getLength(), other.getDirector());
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost, 0, null);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost, 0, director);
	}
	public DigitalVideoDisc(String title) {
		super(title, null, 0f, 0, null);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost, length, director);
	}
	
	public String toString() {
		return "DVD - No. " + id + " - " + title +" - " + (category == null?"N/A":category) + " - " + (director == null?"N/A":director) + " - " + 
		(length==0?"N/A":length) + ": " + (cost==0?"N/A":cost) + " $";
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle()); 
		System.out.println("DVD length: " + this.getLength()); 
	}

}
