package hust.soict.globalict.aims.media;

import java.util.List;
import java.util.ArrayList;

public class Book extends Media{

    private List<String> authors = new ArrayList<String>();

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

    public List<String> getAuthors() {
        return authors;
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("This author is already in the list.");
        }
        else {
            authors.add(authorName);
            System.out.println("Author added.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author removed.");
        }
        else {
            System.out.println("This author is not in the list.");
        }
    }

    public String toString() {
		String author = "";
        for (String string : this.getAuthors()) {
            author += string;
        }
        return "Book - No. " + id + " - " + title + " - " + (category == null?"N/A":category) + " - " + (author==""?"N/A":author) + ": " + (cost==0?"N/A":cost) + " $";
	}
}