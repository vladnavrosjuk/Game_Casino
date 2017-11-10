package View; /**
 * Created by Владислав on 13.09.2017.
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


class BgPanel extends JPanel


{
    private String image;

    BgPanel(String image){

        this.image = image;
    }
    public void paintComponent(Graphics g1){
        Image im = null;
        try {
            im = ImageIO.read(new File(image));
        } catch (IOException e) {}
        g1.drawImage(im, 0, 0, null);
    }

}