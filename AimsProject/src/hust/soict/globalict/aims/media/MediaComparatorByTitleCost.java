package hust.soict.globalict.aims.media;
import java.util.*;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media a, Media b) {
        int titleCompare =  a.getTitle().compareTo(b.getTitle());
        int costCompare = Float.compare(a.getCost(), b.getCost());
        return (titleCompare == 0) ? costCompare : titleCompare;
    }
}
