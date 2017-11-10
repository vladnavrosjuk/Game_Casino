package Model;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Reel {


    private Symbol iitbsuir = new Symbol(50, "Images/iitbsuir.png");
    private Symbol bsuir = new Symbol(10, "Images/bsuir.png");
    private Symbol seven = new Symbol(7, "Images/redseven.png");
    private Symbol bell = new Symbol(6, "Images/bell.png");
    private Symbol watermelon = new Symbol(5, "Images/watermelon.png");
    private Symbol plum = new Symbol(4, "Images/plum.png");
    private Symbol lemon = new Symbol(3, "Images/lemon.png");
    private Symbol cherry = new Symbol(2, "Images/cherry.png");


    private Symbol[] picArray = new Symbol[8];

    public Symbol[] spin() {
        initializeArray(picArray);
        RandomArray(picArray);
        return picArray;
    }


    private void RandomArray(Symbol[] ar) {

        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {

            int index = rnd.nextInt(i + 1);

            Symbol a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }


    private void initializeArray(Symbol[] ar) {
        ar[0] = seven;
        ar[1] = bell;
        ar[2] = watermelon;
        ar[3] = plum;
        ar[4] = lemon;
        ar[5] = cherry;
        ar[6] = bsuir;
        ar[7] = iitbsuir;

    }
}
