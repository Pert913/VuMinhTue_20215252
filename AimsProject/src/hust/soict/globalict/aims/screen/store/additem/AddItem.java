package hust.soict.globalict.aims.screen.store.additem;

import java.awt.*;
import javax.swing.*;

import hust.soict.globalict.aims.screen.App;

public class AddItem extends JPanel {
    
    protected App parentFrame;

    public AddItem(App app) {
        this.parentFrame = app;
        add(createNorth());
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        // north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("Store");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.ORANGE);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        
        return header;
    }

    // public static void main(String[] args) {
    //     // Create an instance of Store
    //     Store newStore = new Store();
    //     Cart newCart = new Cart();
    
    //     DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
    //     newStore.addMedia(dvd1);
    
    //     Book book1 = new Book("Sherlock Holmes", "Detective", 35.2f);
    //     book1.addAuthor("Conan Doyle");
    //     newStore.addMedia(book1);
        
    //     new AddItem(newStore, newCart);
    // }

    // @Override
    // public void actionPerformed(ActionEvent e) {
    //     switch (e.getActionCommand()) {
    //         case "addBook":
    //             AddBook addBookFrame = new AddBook(store, cart);
    //             addBookFrame.setVisible(true);
    //             break;

    //         case "addCD":
    //             AddCD addCDFrame = new AddCD(store, cart);
    //             addCDFrame.setVisible(true);
    //             break;
            
    //         case "addDVD":
    //             AddDVD addDVDFrame = new AddDVD(store, cart);
    //             addDVDFrame.setVisible(true);
    //             break;
    //     }    
    // }
}