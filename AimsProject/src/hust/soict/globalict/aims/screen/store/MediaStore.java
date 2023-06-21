package hust.soict.globalict.aims.screen.store;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.screen.App;

public class MediaStore extends JPanel implements ActionListener {
    private Media media;
    private App parentFrame;
    JButton btnAdd, btnPlay;

public MediaStore(App app, Media media) {
        this.parentFrame = app;
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        btnPlay = new JButton("Play");
        btnAdd = new JButton("Add to cart");

        container.add(btnAdd);
        btnAdd.setActionCommand("add");
        btnAdd.addActionListener(this);

        if (media instanceof Playable) {
            container.add(btnPlay);
            btnPlay.setActionCommand("play");
            btnPlay.addActionListener(this);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "play":
                JOptionPane.showMessageDialog(null, media.playMedia(), "Playing", JOptionPane.PLAIN_MESSAGE);
                break;

            case "add":
                parentFrame.addCart(media);
                break;
        }
    }
}
