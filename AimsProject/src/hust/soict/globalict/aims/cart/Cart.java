package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.media.*;
import java.util.ArrayList;
import java.util.Collections;
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED && !itemsOrdered.contains(media)) {
			itemsOrdered.add(media);
			System.out.println("The item has been added.");
		}
		else {
			System.out.println("Cannot add this item to the cart.");
		}
	}

	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println("The item has been removed.");
		}
		else {
			System.out.println("Item not found.");
		}
	}

	public float totalCost() {
		float sum = 0f;
		for (Media media : itemsOrdered) {
			sum += media.getCost();
		}
		return sum;
	}

	public void print() {
		int n = 0;
		System.out.println("\n***********************CART***********************");
		System.out.println("Ordered Items:");
		for (Media media : itemsOrdered) {
			System.out.println((n + 1) + ". " + media.toString());
			n++;
		}
		System.out.println("Total cost: " + totalCost() + " $");
		System.out.println("**************************************************");
	}

	public Media searchMedia(String title) {
		for (Media media : itemsOrdered) {
			if (media.isMatch(title)) {
				System.out.println(media.toString());
                return media;
			}
		}
            return null;
	}

	public Media searchMedia(int id) {
		for (Media media : itemsOrdered) {
			if (media.getId() == id) {
				System.out.println(media.toString());
                return media;
			}
		}
            return null;
	}

	public void placeOrder() {
		if (itemsOrdered.size() > 0) {
			ArrayList<Media> itemsToRemove = new ArrayList<>();
	
			for (Media media : itemsOrdered) {
				itemsToRemove.add(media);
			}
	
			for (Media media : itemsToRemove) {
				itemsOrdered.remove(media);
			}
		} else {
			System.out.println("No items in the cart.");
		}
	}
	
	public void sortByTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}

	public void sortByCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
}
