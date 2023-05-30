package hust.soict.globalict.aims.media;

public class Track implements Playable {
    private String title;
    private int length;
    
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }
    
    public void play() {
        System.out.println("Playing track: " + this.getTitle()); 
        System.out.println("Track length: " + this.getLength()); 
    }

    @Override
    public boolean equals (Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Track obj = (Track) o;
        return this.title.equals(obj.title) && this.length == obj.length;
    }
}
