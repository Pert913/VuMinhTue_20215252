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

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.screen.App;

public class AddBook extends AddItem implements ActionListener {
    private JTextField tfTitle;
    private JTextField tfCategory;
    private JTextField tfAuthor;
    private JTextField tfCost;

    public AddBook(App app) {
        super(app);
        add(createCenter(), BorderLayout.CENTER);
        setVisible(true);
    }

    public JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(null);

        JLabel titleLabel = new JLabel("Title: ");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setBounds(129, 125, 100, 26);
        center.add(titleLabel);

        JLabel categoryLabel = new JLabel("Category: ");
        categoryLabel.setFont(new Font("Arial", Font.BOLD, 20));
        categoryLabel.setBounds(129, 185, 100, 26);
        center.add(categoryLabel);

        JLabel costLabel = new JLabel("Cost: ");
        costLabel.setFont(new Font("Arial", Font.BOLD, 20));
        costLabel.setBounds(128, 253, 100, 26);
        center.add(costLabel);

        JLabel authorLabel = new JLabel("Author(s): ");
        authorLabel.setFont(new Font("Arial", Font.BOLD, 20));
        authorLabel.setBounds(128, 324, 110, 26);
        center.add(authorLabel);

        tfTitle = new JTextField();
        tfTitle.setBounds(372, 127, 509, 26);
        center.add(tfTitle);

        tfCategory = new JTextField();
        tfCategory.setBounds(372, 187, 509, 26);
        center.add(tfCategory);

        tfCost = new JTextField();
        tfCost.setBounds(372, 255, 509, 26);
        center.add(tfCost);

        tfAuthor = new JTextField();
        tfAuthor.setBounds(372, 326, 509, 26);
        tfAuthor.setToolTipText("Separated by commas and a space(, )");
        center.add(tfAuthor);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.setBounds(768, 402, 112, 38);
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

            String title, category, authorString;
            float cost;
            title = tfTitle.getText();
            category = tfCategory.getText();
            authorString = tfAuthor.getText();
            cost = Float.parseFloat(tfCost.getText());
            
            Book book = new Book(title, category, cost);
            String[] authorNames = authorString.split(", "); 
            for (String author : authorNames) {
                book.addAuthor(author);
            }
            
            parentFrame.addStores(book);
        }
    }
}
