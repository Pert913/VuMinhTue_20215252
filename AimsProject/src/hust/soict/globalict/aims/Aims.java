package hust.soict.globalict.aims;
import java.util.Scanner;
import hust.soict.globalict.aims.store.*;
import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.cart.*;
public class Aims {
    public static void showMenu() {
		System.out.println("\nAIMS: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. View store"); 
		System.out.println("2. Update store"); 
		System.out.println("3. See current cart"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3"); 
	} 

    public static void storeMenu() {
		System.out.println("\nOptions: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. See a media's details"); 
		System.out.println("2. Add a media to cart"); 
		System.out.println("3. Play a media"); 
		System.out.println("4. See current cart"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4"); 
	} 

    public static void mediaDetailsMenu() { 
		System.out.println("\nOptions: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Add to cart"); 
		System.out.println("2. Play"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2"); 
	}

	public static void cartMenu() { 	
		System.out.println("\nOptions: "); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Filter medias in cart"); 
		System.out.println("2. Sort medias in cart"); 
		System.out.println("3. Remove media from cart"); 
		System.out.println("4. Play a media"); 
		System.out.println("5. Place order"); 
		System.out.println("0. Back"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4-5"); 
	} 	

    public static void updateStore() {
        System.out.println("\nOptions: "); 
		System.out.println("--------------------------------"); 
        System.out.println("1. Add a media to Store");
        System.out.println("2. Remove a media from Store");
        System.out.println("0. Back");
        System.out.println("--------------------------------"); 
        System.out.println("Please choose a number: 0-1-2"); 
    }
    
    public static void filterCart() {
        System.out.println("\nOptions: "); 
		System.out.println("--------------------------------"); 
        System.out.println("1. Filter by id");
        System.out.println("2. Filter by title");
        System.out.println("0. Back");
        System.out.println("--------------------------------"); 
        System.out.println("Please choose a number: 0-1-2"); 
    }

    public static void sortCart() {
        System.out.println("\nOptions: "); 
		System.out.println("--------------------------------"); 
        System.out.println("1. Sort by title");
        System.out.println("2. Sort by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------"); 
        System.out.println("Please choose a number: 0-1-2"); 
    }

    public static void main(String[] args) {
        // Create an instance of Store
        Store store = new Store();
    
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);
    
        Book book1 = new Book("Sherlock Holmes", "Detective", 35.2f);
        book1.addAuthor("Conan Doyle");
        store.addMedia(book1);
    
        // Create an instance of Cart
        Cart cart = new Cart();
    
        Scanner scanner = new Scanner(System.in);
        int n;
        String m;
        boolean exit = false;
        while (!exit) {
            // Main menu
            showMenu();
            n = scanner.nextInt(); scanner.nextLine();

            switch (n) {
                // View store
                case 1:
                    boolean exitStore = false;
                    while (!exitStore) {
                        // Display all items in the store
                        store.print();
    
                        storeMenu();
                        n = scanner.nextInt(); scanner.nextLine();
                        Media choice;
                        switch (n) {
                            // See a media's details
                            case 1:
                                System.out.println("Enter the title of the media.");
                                m = scanner.nextLine();
                                choice = store.searchMedia(m);
                                if (choice == null) {
                                    System.out.println("No match found");
                                } else {
                                    boolean exitDetails = false;
                                    while (!exitDetails) {
                                        mediaDetailsMenu();
                                        n = scanner.nextInt(); scanner.nextLine();
                                        switch (n) {
                                            // Add to cart
                                            case 1:
                                                cart.addMedia(choice);
                                                exitDetails = true;
                                                break;
                                            // Play
                                            case 2:
                                                choice.playMedia();
                                                break;
                                            // Exit
                                            case 0:
                                                exitDetails = true;
                                                break;
                                            default:
                                                System.out.println("Invalid input");
                                        }
                                    }
                                }
                                break;
                            // Add a media to cart
                            case 2:
                                System.out.println("Enter the title.");
                                m = scanner.nextLine();
                                cart.addMedia(store.searchMedia(m));
                                break;
                            // Play a media
                            case 3:
                                System.out.println("Enter the title.");
                                m = scanner.nextLine();
                                store.searchMedia(m).playMedia();
                                break;
                            // See current cart
                            case 4:
                                cart.print();
                                break;
                            // Exit
                            case 0:
                                exitStore = true;
                                break;
                            default:
                                System.out.println("Invalid input.");
                        }
                    }
                    break;

                // Update store
                case 2:
                    boolean exitUpdate = false;
                    updateStore();
                    while (!exitUpdate) {
                        // if (scanner.hasNextInt()) {
                            n = scanner.nextInt();
                            // scanner.nextLine();
                            switch (n) {
                                // Add to store
                                case 1:
                                    store.addToStore();
                                    break;

                                // Remove from store
                                case 2:
                                    store.removeFromStore();
                                    break;

                                // Exit
                                case 0:
                                    exitUpdate = true;
                                    break;

                                default:
                                    System.out.println("Invalid input.");
                            }
                            updateStore();
                    //     } else {
                    //         if (scanner.hasNextLine()) {
                    //             scanner.nextLine(); // Discard invalid input
                    //         }
                    //     }
                    }
                    break;

                // See current cart
                case 3:
                    boolean exitCart = false;
                    while (!exitCart) {
                    cart.print();
                    cartMenu();
                    n = scanner.nextInt(); scanner.nextLine();
                    switch (n) {
                        // Filter in cart
                        case 1:
                            filterCart();
                            n = scanner.nextInt(); scanner.nextLine();
                            switch (n) {
                                // Filter by id
                                case 1:
                                    System.out.println("Enter the id: ");
                                    n = scanner.nextInt(); scanner.nextLine();
                                    System.out.println("\n***********************CART***********************");
                                    System.out.println("Ordered Items:");
                                    System.out.println("1. " + cart.searchMedia(n).toString());
                                    System.out.println("Total cost: " + cart.totalCost() + " $");
                                    System.out.println("**************************************************");
                                    break;
    
                                // Filter by title
                                case 2:
                                    System.out.println("Enter the title: ");
                                    m = scanner.nextLine();
                                    System.out.println("\n***********************CART***********************");
                                    System.out.println("Ordered Items:");
                                    System.out.println("1. " + cart.searchMedia(m).toString());
                                    System.out.println("Total cost: " + cart.totalCost() + " $");
                                    System.out.println("**************************************************");
                                    break;
    
                                // Back
                                case 0:
                                    break;
                                default:
                                    System.out.println("Invalid input.");
                                }
                            break;
        
                        // Sort in cart
                        case 2:
                            sortCart();
                            n = scanner.nextInt(); scanner.nextLine();
                            switch(n) {
                                // Sort by title
                                case 1:
                                    cart.sortByTitle();
                                    break;
                                // Sort by cost
                                case 2:
                                    cart.sortByCost();
                                    break;
                                // Back
                                case 0:
                                    break;
                                default:
                                    System.out.println("Invalid input.");
                            }
                            break;
        
                        // Remove from cart
                        case 3:
                            cart.print();
                            System.out.println("Enter the ID: ");
                            n = scanner.nextInt(); scanner.nextLine();
                            cart.removeMedia(cart.searchMedia(n));
                            break;
        
                        // Play a media
                        case 4:
                            cart.print();
                            System.out.println("Enter the ID: ");
                            n = scanner.nextInt(); scanner.nextLine();
                            cart.searchMedia(n).playMedia();
                            break;
        
                        // Place order
                        case 5:
                            System.out.println("Order created.");
                            cart.placeOrder();
                            exitCart = true;
                            break;
        
                        // Exit
                        case 0:
                            exitCart = true;
                            break;
        
                        default:
                            System.out.println("Invalid input.");
                        }
                }
                    break;

                // Exit
                case 0:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid input.");
            }
        }
        scanner.close();
    }
}
    
