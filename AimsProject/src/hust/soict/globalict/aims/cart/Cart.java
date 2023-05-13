package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.disc.*;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] =
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The disc has been added.");
		} else {
			System.out.println("The cart is full.");
		}
	}
	// private void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
	// 	int n = dvdList.length;
	// 	for (int i = 0; i < n; i++) {
	// 		addDigitalVideoDisc(dvdList[i]);
	// 	}
	// }
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}
	public void addDigitalVideoDisc(DigitalVideoDisc ...dvd){
		for (DigitalVideoDisc i:dvd) {
			addDigitalVideoDisc(i);
		}
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemOrdered[i] == disc) {
				for (int j = i; j < qtyOrdered; j++) {
					itemOrdered[j] = itemOrdered[j + 1];
				}
				qtyOrdered--;
				System.out.println("The disc has been discarded.");
				return;
			}
		}
		System.out.println("The disc is not in the cart.");
	}
	public float totalCost() {
		float sum = 0f;
		for (int i = 0; i < qtyOrdered; i++) {
			sum += itemOrdered[i].getCost();
		}
		return sum;
	}

	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println((i + 1) + ". " + itemOrdered[i].toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("**************************************************");
	}

	public boolean isMatch(DigitalVideoDisc dvd, String title) {
		String [] tmp = title.split(" ");
		int n = tmp.length;
		for (int i = 0; i < n; i++) {
			if (dvd.getTitle().contains(tmp[i]))
				return true;
		}
		return false;
	}

	public void searchVideoDisc(DigitalVideoDisc []list, String title) {
		int cnt = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if (isMatch(list[i], title)) {
				System.out.println(list[i].toString());
				cnt++;
			}
		}
		if (cnt == 0) {
			System.out.println("No match found");
		}
	}
	public static void main(String[] args) {
		//Create new cart
		Cart anOrder = new Cart();
		
		//Create new DVD
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
				"Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		//Print total cost
		System.out.println("Total cost: " + anOrder.totalCost());
		
		//Remove a disc
		anOrder.removeDigitalVideoDisc(dvd3);
		
		//Print total cost again
		System.out.println("Total cost: " + anOrder.totalCost());

	}
}
