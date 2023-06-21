package hust.soict.globalict.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.screen.store.StoreScreen;
import hust.soict.globalict.aims.screen.store.additem.AddBook;
import hust.soict.globalict.aims.screen.store.additem.AddCD;
import hust.soict.globalict.aims.screen.store.additem.AddDVD;
import hust.soict.globalict.aims.store.Store;

public class App extends JFrame implements ActionListener {
    private Store store;
    private Cart cart;

    private AddBook addBook;
    private AddDVD addDVD;
    private AddCD addCD;
    private StoreScreen storeScreen;
    private CardLayout cl;
    private JPanel cards;

    public App() {
        this.store = new Store();
        this.cart = new Cart();

        // Create some items for the store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addMedia(dvd1);
    
        Book book1 = new Book("Sherlock Holmes", "Detective", 35.2f);
        book1.addAuthor("Conan Doyle");
        store.addMedia(book1);

        addBook = new AddBook(this);
        addDVD = new AddDVD(this);
        addCD = new AddCD(this);
        storeScreen = new StoreScreen(this);
        
        setJMenuBar(createMenuBar());

        cards = new JPanel(new CardLayout());
        cards.add(addBook, "addBook");
        cards.add(addCD, "addCD");
        cards.add(addDVD, "addDVD");
        cards.add(storeScreen, "storeScreen");

        add(cards);

        cl = (CardLayout) cards.getLayout();
        cl.show(cards, "storeScreen");
        
        setTitle("Store");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1024, 768);
        setVisible(true);
    }

    public void addStores(Media media) {
        store.addMedia(media);
    }

    public void addCart(Media media) {
        cart.addMedia(media);
    }

    public Store getStore() {
        return store;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem bookItem = new JMenuItem("Add Book");
        bookItem.setActionCommand("addBook");
        bookItem.addActionListener(this);
        smUpdateStore.add(bookItem);

        JMenuItem cdItem = new JMenuItem("Add CD");
        cdItem.setActionCommand("addCD");
        cdItem.addActionListener(this);
        smUpdateStore.add(cdItem);

        JMenuItem dvdItem = new JMenuItem("Add DVD");
        dvdItem.setActionCommand("addDVD");
        dvdItem.addActionListener(this);
        smUpdateStore.add(dvdItem);

        menu.add(smUpdateStore);
        JMenuItem viewStoreItem = new JMenuItem("View Store");
        viewStoreItem.setActionCommand("viewStore");
        viewStoreItem.addActionListener(this);
        menu.add(viewStoreItem);
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        cl = (CardLayout)(cards.getLayout());

        switch (command) {
            case "addBook":
                cl.show(cards, "addBook");
                break;
            
            case "addCD":
                cl.show(cards, "addCD");
                break;

            case "addDVD":
                cl.show(cards, "addDVD");
                break;
            
            case "viewStore":
                cl.show(cards, "storeScreen");
                break;
        }
    }
}
