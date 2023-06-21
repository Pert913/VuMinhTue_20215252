package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.media.*;
import java.util.ArrayList;
// import java.util.Scanner;

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

	// public void removeFromStore() {
	// 	Scanner scanner = new Scanner(System.in);
	// 	System.out.println("Enter the title:");
	// 	String title = scanner.nextLine();
	// 	Media media = this.searchMedia(title);
	// 	System.out.println(media.toString());
	// 	System.out.println("\nConfirm to remove this media (Y/N):");
	// 	title = scanner.nextLine();
	// 	switch (title) {
	// 		case "Y":
	// 			this.removeMedia(media);
	// 			break;
	// 		case "N":
	// 			break;
	// 		default:
	// 			System.out.println("Invalid input.");
	// 	}
	// }
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}
}
