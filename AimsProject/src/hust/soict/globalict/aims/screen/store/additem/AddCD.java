package hust.soict.globalict.aims.screen.store.additem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.screen.App;

public class AddCD extends AddItem implements ActionListener {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfArtist;
    private JTextField tfCost;
    private JTextField tfLength;
    private JTextField tfDirector;


    public AddCD (App app) {
        super(app);
        add(createCenter(), BorderLayout.CENTER);
    }

    public JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(null);

        JLabel titleLabel = new JLabel("Title: ");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(129, 75, 100, 26);
        center.add(titleLabel);

        JLabel categoryLabel = new JLabel("Category: ");
        categoryLabel.setFont(new Font("Arial", Font.BOLD, 20));
        categoryLabel.setBounds(129, 135, 100, 26);
        center.add(categoryLabel);

        JLabel lengthLabel = new JLabel("Length: ");
        lengthLabel.setFont(new Font("Arial", Font.BOLD, 20));
        lengthLabel.setBounds(128, 195, 100, 26);
        center.add(lengthLabel);

        JLabel artistLabel = new JLabel("Artist: ");
        artistLabel.setFont(new Font("Arial", Font.BOLD, 20));
        artistLabel.setBounds(128, 255, 100, 26);
        center.add(artistLabel);

        JLabel directorLabel = new JLabel("Director: ");
        directorLabel.setFont(new Font("Arial", Font.BOLD, 20));
        directorLabel.setBounds(128, 315, 110, 26);
        center.add(directorLabel);

        JLabel costLabel = new JLabel("Cost: ");
        costLabel.setFont(new Font("Arial", Font.BOLD, 20));
        costLabel.setBounds(128, 375, 100, 26);
        center.add(costLabel);

        tfTitle = new JTextField();
        tfTitle.setBounds(372, 77, 509, 26);
        center.add(tfTitle);

        tfCategory = new JTextField();
        tfCategory.setBounds(372, 137, 509, 26);
        center.add(tfCategory);

        tfLength = new JTextField();
        tfLength.setBounds(372, 197, 509, 26);
        center.add(tfLength);

        tfArtist = new JTextField();
        tfArtist.setBounds(372, 257, 509, 26);
        center.add(tfArtist);

        tfDirector = new JTextField();
        tfDirector.setBounds(372, 317, 509, 26);
        center.add(tfDirector);

        tfCost = new JTextField();
        tfCost.setBounds(372, 377, 509, 26);
        center.add(tfCost);

        JButton btnAdd = new JButton("Add CD");
        btnAdd.setBounds(768, 432, 112, 38);
        btnAdd.setBackground(Color.RED);
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Arial", Font.BOLD, 16));
        center.add(btnAdd);

        btnAdd.setActionCommand("add");
        btnAdd.addActionListener(this);

        return center;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "add") {

            String title, category, director, artist;
            float cost;
            int length;
            title = tfTitle.getText();
            category = tfCategory.getText();
            director = tfDirector.getText();
            artist = tfArtist.getText();
            length = Integer.parseInt(tfLength.getText());
            cost = Float.parseFloat(tfCost.getText());
            
            CompactDisc cd = new CompactDisc(title, category, cost, length, director, artist);
            
            parentFrame.addStores(cd);
        }
    }
}
