package Controller;

import Model.BanditModel;
import Model.Reel;
import Model.Symbol;
import View.BanditView;
import View.Menu;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.net.URL;

public class BanditController {


    private BanditView theView;
    private BanditModel theModel;
    private Menu menu;


    private static final int StartCrefit = 10;
    private static final int StartBet = 0;
    private static final String GAMEOVER = "Ты проиграл!";

    private MyThread thread1;
    private MyThread thread2;
    private MyThread thread3;


    private boolean spin = false;


    public BanditController(BanditView theView, BanditModel theModel, Menu menu) {
        this.theView = theView;
        this.theModel = theModel;
        this.menu = menu;


    }


    public void initialise() {
        theView.setCredit(StartCrefit);
        menu.setCredit(StartCrefit);
        theView.setBetAmount(StartBet);
        theView.setErrMsg("Крути и Выигрывай!!!");

        this.actionListnerCreator();


    }


    public void actionListnerCreator() {

        theView.getBtnStop().addActionListener(e -> {

            threadControl(false);
            winCalculator();

            theView.buttonControl(true);
        });
        theView.getBtnAddCoin().addActionListener(e -> {
            theView.setErrMsg("");
            addCoinControl();
        });
        menu.getGameMachine().addActionListener(e -> {
            theView.jframeSlot.setVisible(true);
            theView.getLblCredit().setText(menu.getJlabscore().getText());
        });


        theView.getBtnBetOne().addActionListener(e -> {
            theView.setErrMsg("");
            betOneControl();
        });


        theView.getBtnSpin().addActionListener(e -> {
            theView.setErrMsg("");
            theView.buttonControl(false);
            threadControl(true);

        });

        theView.getBtnAll().addActionListener(e -> {
            theView.setErrMsg("");
            addallcredit();
        });


    }


    public void addCoinControl() {
        int credit = theView.getCredit();
        int newCredit = theModel.addCoin(credit);
        theView.setCredit(newCredit);
        menu.setCredit(newCredit);

    }


    public void betOneControl() {
        int credit = theView.getCredit();
        if (credit > 0) {
            int oldBet = theView.getBetAmount();
            int newBet = theModel.betOne(oldBet);
            int newCredit = theModel.removeOneCoin(credit);
            theView.setCredit(newCredit);
            menu.setCredit(newCredit);
            theView.setBetAmount(newBet);
        } else {
            theView.setErrMsg("Кошелек пуст((");
        }
    }


    public void addallcredit() {
        int existingCredit = theView.getCredit();
        menu.setCredit(0);
        theView.setCredit(0);
        theView.setBetAmount(existingCredit + theView.getBetAmount());
    }

    public void winCalculator() {
        if (spin) {
            int betAmnt = theView.getBetAmount();
            Symbol sym1 = thread1.getObj();
            Symbol sym2 = thread2.getObj();
            Symbol sym3 = thread3.getObj();

            boolean result1 = sym1.compareSymbols(sym1, sym2);
            boolean result2 = sym1.compareSymbols(sym2, sym3);
            boolean result3 = sym1.compareSymbols(sym1, sym3);

            int credits = theView.getCredit();
            spin = false;
            if (result1 && result2) {

                theView.setBetAmount(StartBet);

                int symbolAmnt = sym1.getValue();
                int newCredits = theModel.addWinningCoins(credits, betAmnt, symbolAmnt);
                int wonCredits = newCredits - (credits + betAmnt);
                theView.setCredit(newCredits);
                theView.setErrMsg("А ты везунчик" + wonCredits + "!");
            } else if (result1 || result2 || result3) {
                theView.setErrMsg("Крути еще!");
            } else {

                theView.setBetAmount(StartBet);

                theView.setErrMsg(GAMEOVER);
            }
        }
    }


    protected static ImageIcon createIcon(String path) {
        URL imgURL = Menu.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("File not found " + path);
            return null;
        }
    }

    public void threadControl(boolean flag) {
        int betAmnt = theView.getBetAmount();
        if (betAmnt > 0) {
            if (flag) {
                Reel reel1 = new Reel();
                Reel reel2 = new Reel();
                Reel reel3 = new Reel();

                Symbol[] symArray1 = reel1.spin();
                Symbol[] symArray2 = reel2.spin();
                Symbol[] symArray3 = reel3.spin();

                thread1 = new MyThread(symArray1, theView.getLblReel1());
                thread2 = new MyThread(symArray2, theView.getLblReel2());
                thread3 = new MyThread(symArray3, theView.getLblReel3());

                thread1.start();
                thread2.start();
                thread3.start();

                spin = true;
            } else if (spin) {
                thread1.stop();
                thread2.stop();
                thread3.stop();
            }
        } else {
            theView.buttonControl(true);
            theView.setErrMsg("Сделай ставку");
        }
    }


    class MyThread extends Thread {
        private Symbol obj;
        private Symbol[] symArray;
        private JLabel label;


        MyThread(Symbol[] symArray, JLabel label) {
            this.symArray = symArray;
            this.label = label;
        }



        public Symbol getObj() {
            return obj;
        }


        @Override
        public void run() {
            JButton button;


            for (int i = 0; i <= symArray.length; i++) {
                try {
                    obj = symArray[i];

                    label.setIcon(symArray[i].getImage());

                    Thread.sleep(100);

                } catch (ArrayIndexOutOfBoundsException e) {

                    i = 0;
                }

                catch (InterruptedException e) {


                    System.out.println("Ошибка");
                }

            }
        }
    }
}
