package Model;

import javax.swing.*;

public interface ISymbol {

    public abstract void setImage(String url);


    public abstract ImageIcon getImage();


    public abstract void setValue(int v);

    public abstract int getValue();

}
