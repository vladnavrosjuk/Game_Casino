package View;


import Controller.BanditController;
import Model.BanditModel;


public class EntryPoint {


    public static void main(String[] args) {
        RoulletView view = new RoulletView();
        BanditView theView = new BanditView();
        BanditModel theModel = new BanditModel();
        BanditController theController = new BanditController(theView, theModel, view.menu);
        theController.initialise();
    }

}
