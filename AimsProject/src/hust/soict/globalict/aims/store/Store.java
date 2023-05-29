package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.media.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("The item has been added.");
    }

    public void removeMedia(Media media){
        for (Media item : itemsInStore) {
			if (item.equals(media)) {
				itemsInStore.remove(media);
				System.out.println("The item has been removed.");
				return;
			}
		}
		System.out.println("Cannot find said item.");
    }

    public Media searchMedia(String title) {
		for (Media media : itemsInStore) {
			if (media.isMatch(title)) {
                return media;
			}
		}
            return null;
	}

	public void print() {
		int n = 0;
		System.out.println("\n**********************STORE***********************\n");
		for (Media media : itemsInStore) {
			System.out.println((n + 1) + ". " + media.toString());
			n++;
		}
		System.out.println("\n**************************************************");
	}

	public void addToStore() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the form of the media: Book, CD, or DVD.");
        String m = scanner.nextLine();
		String title, category, director, artist;
		float cost;
		int length;
		switch(m) {
			case "Book":
			System.out.println("Enter Title:");
			title = scanner.nextLine();
			System.out.println("Enter Category:");
			category = scanner.nextLine();
			System.out.println("Enter Cost:");
			cost = scanner.nextFloat();
			Book book = new Book(title, category, cost);
			System.out.println("Enter Author(s) separated by commas and a space(, ):");
			String authorString = scanner.nextLine();
			String[] authorNames = authorString.split(", "); 
			for (String author : authorNames) {
				book.addAuthor(author);
			}
			this.addMedia(book);
			System.out.println("Book added.");
			break;

			case "CD":
			// public CompactDisc(String title, String category, float cost, int length, String director, String artist)
			System.out.println("Enter Title:");
			title = scanner.nextLine();
			System.out.println("Enter Category:");
			category = scanner.nextLine();
			System.out.println("Enter Cost:");
			cost = scanner.nextFloat();
			System.out.println("Enter Length:");
			length = scanner.nextInt();
			System.out.println("Enter Director:");
			director = scanner.nextLine();
			System.out.println("Enter Artist:");
			artist = scanner.nextLine();
			CompactDisc cd = new CompactDisc(title, category, cost, length, director, artist);
			this.addMedia(cd);
			System.out.println("CD added");
			break;

			case "DVD":
			// public DigitalVideoDisc(String title, String category, float cost, int length, String director)
			System.out.println("Enter Title:");
			title = scanner.nextLine();
			System.out.println("Enter Category:");
			category = scanner.nextLine();
			System.out.println("Enter Cost:");
			cost = scanner.nextFloat();
			System.out.println("Enter Length:");
			length = scanner.nextInt();
			System.out.println("Enter Director:");
			director = scanner.nextLine();
			DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, length, director);
			this.addMedia(dvd);
			break;
			default:
			System.out.println("Invalid input.");
		}
		scanner.close();
	}

	public void removeFromStore() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the title:");
		String title = scanner.nextLine();
		Media media = this.searchMedia(title);
		System.out.println(media.toString());
		System.out.println("\nConfirm to remove this media (Y/N):");
		title = scanner.nextLine();
		switch (title) {
			case "Y":
			this.removeMedia(media);
			System.out.println("Item removed.");
			break;
			case "N":
			break;
			default:
			System.out.println("Invalid input.");
		}
		scanner.close();
	}
}
