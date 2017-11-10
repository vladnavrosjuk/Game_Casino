package View;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Created by Владислав on 28.03.2017.
 */
public class ButtonBuilder {


    protected static ImageIcon createIcon(String path) {
        URL imgURL = Menu.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("File not found " + path);
            return null;
        }
    }


    JButton create(String text) {
        JButton button = new JButton(text);
        button.setOpaque(false);
        button.setBackground(Color.red);
        ImageIcon icon1 = createIcon("butonncreat.png");
        ImageIcon icon2 = createIcon("3.png");
        button.setRolloverIcon(icon1);
        button.setIcon(icon2);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);

        return button;
    }

}
