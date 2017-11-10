package Model;

import javax.swing.*;
import java.awt.*;

public class Symbol implements ISymbol {

    private int value;
    private ImageIcon image;


    public Symbol(int value, String url) {
        this.value = value;
        this.setImage(url);
    }

    @Override
    public void setImage(String url) {
        ImageIcon imgObj = new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        this.image = imgObj;
    }

    @Override
    public ImageIcon getImage() {
        return this.image;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return this.value;
    }


    public boolean compareSymbols(Symbol obj1, Symbol obj2) {
        return obj1.value == obj2.value;
    }
}
