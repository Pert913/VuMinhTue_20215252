package hust.soict.globalict.test.cart;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.cart.*;


public class CartTest {
    public static void main(String[] args) {
		//Create new cart
		Cart cart = new Cart();
		
		//Create new DVD
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
				"Animation", 18.99f);
		cart.addMedia(dvd3);

		// Create new Book
		Book book1 = new Book("Sherlock Holmes", "Detective", 35.2f);
		book1.addAuthor("Conan Doyle");
		cart.addMedia(book1);

		// Create new CD
		CompactDisc cd1 = new CompactDisc("Folklore", "Alternative", 30f, 67, "Taylor Swift", "Taylor Swift");
		cart.addMedia(cd1);

        // Test the print method
        cart.print();
	} 
}
