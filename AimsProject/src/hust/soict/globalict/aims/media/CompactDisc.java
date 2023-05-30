package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks= new ArrayList<Track>();
    
    public String getArtist() {
        return artist;
    }
    public int getLength() {
        int length = 0;
        for (Track track : tracks) {
            length += track.getLength();
        }
        return length;
    }

    public CompactDisc(String title, String category, float cost, int length, String director, String artist) {
        super(title, category, cost, length, director);
        this.artist = artist;
    }

    public void addTrack(Track trackName) {
        if (tracks.contains(trackName)) {
            System.out.println("This track is already in the list.");
        }
        else {
            tracks.add(trackName);
            System.out.println("Track added.");
        }
    }

    public void removeTrack(Track trackName) {
        if (tracks.contains(trackName)) {
            tracks.remove(trackName);
            System.out.println("Track removed.");
        }
        else {
            System.out.println("This track is not in the list.");
        }
    }

    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Total length: " + this.getLength());
        for (Track track : tracks) {
            track.play();
        }
    }

    public String toString() {
		return "CD - No. " + id + " - " + title +" - " + (category == null?"N/A":category) + " - " + (director == null?"N/A":director) + " - " + 
        (artist == null?"N/A":artist) + " - " + (getLength()==0?"N/A":getLength()) + ": " + (cost==0?"N/A":cost) + " $";
	}
}
