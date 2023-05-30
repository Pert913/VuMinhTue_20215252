package hust.soict.globalict.aims.media;
import java.util.*;

public class Media {
    
    protected int id;
    protected String title;
    protected String category;
    protected float cost;
    private static int count = 0;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = 
        new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = 
        new MediaComparatorByCostTitle();
    
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getCategory() {
        return category;
    }
    public float getCost() {
        return cost;
    }

    public Media (String title, String category, float cost) {
        count++;
        this.id = count;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }   
    
    public boolean isMatch(String title) {
		String [] tmp = title.split(" ");
		int n = tmp.length;
		for (int i = 0; i < n; i++) {
			if (this.getTitle().contains(tmp[i]))
				return true;
		}
		return false;
	}

    public void playMedia() {
        if (this instanceof Playable) {
            Playable playable = (Playable) this;
            playable.play();
        } else {
            System.out.println("This form of media is not playable.");
        }
    }
    
    @Override
    public boolean equals (Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Media obj = (Media) o;
        return this.title.equals(obj.title);
    }
}