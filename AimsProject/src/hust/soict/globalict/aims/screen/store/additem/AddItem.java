package hust.soict.globalict.aims.screen.store.additem;

import java.awt.*;
import javax.swing.*;

import hust.soict.globalict.aims.screen.App;

public class AddItem extends JPanel {
    
    protected App parentFrame;

    public AddItem(App app) {
        this.parentFrame = app;
        setLayout(new BorderLayout());
        add(createNorth(), BorderLayout.NORTH);
        setVisible(true);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createHeader());
        return north;
    }

    JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());

        JLabel title = new JLabel("Store");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.ORANGE);

        header.add(title, BorderLayout.WEST); 
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

}