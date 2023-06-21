package hust.soict.globalict.aims.screen.store;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

import hust.soict.globalict.aims.media.*;
import hust.soict.globalict.aims.screen.App;

public class StoreScreen extends JPanel implements ActionListener {
    protected App parentFrame;

    public StoreScreen(App app) {
        this.parentFrame = app;
        this.setLayout(new BorderLayout()); 
        add(createNorth(), BorderLayout.NORTH);
        add(createCenter(), BorderLayout.CENTER);
        setVisible(true);
    }


    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createHeader());
        return north;
    }
    
    JPanel createCenter() {
         JPanel center = new JPanel();
         center.setLayout(new GridLayout(3, 3, 2, 2));

         ArrayList<Media> mediaInStore = parentFrame.getStore().getItemsInStore();
         for (int i = 0; i < (mediaInStore.size() < 9 ? mediaInStore.size() : 9); i++) {
            MediaStore cell = new MediaStore(parentFrame, mediaInStore.get(i));
            center.add(cell);
         }

         return center;
    }


    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.ORANGE);

        JButton cart = new JButton("View cart");
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));
        cart.setActionCommand("viewCart");
        cart.addActionListener(this);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        
        return header;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        parentFrame.actionPerformed(e);
    }
}