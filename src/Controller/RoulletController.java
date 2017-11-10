package Controller;

import Model.BanditModel;
import Model.RoulletAllScores;
import View.Menu;
import View.PointOnCircle;
import View.RoulletView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Владислав on 19.09.2017.
 */
public class RoulletController {
    PointOnCircle pointOnCircle;
    RoulletAllScores allScores;

    private boolean redamount = false;
    private boolean blackamount = false;
    private boolean wingame = true;
    private boolean losegame = false;
    private boolean ColorAmount = false;
    private boolean NumberAmount = false;
    private String resultgame;
    Timer timer;
    RoulletView view;
    Menu menu;
    double angle = 100;
    int amount = 0;
    int color;
    String colorize;
    private int money = 10;
    BanditModel banditModel;


    public RoulletController(RoulletView view, PointOnCircle pointOnCircle, Menu menu, BanditModel banditModel) {
        allScores = new RoulletAllScores();
        this.pointOnCircle = pointOnCircle;
        this.view = view;
        this.menu = menu;
        this.banditModel = banditModel;


    }

    public PointOnCircle getPointOnCircle() {
        return pointOnCircle;
    }


    public void StartTimer() {
        RoulletAllScores allScores = new RoulletAllScores();
        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getButtonStartRoullet().setEnabled(false);
                angle /= 1.01;
                pointOnCircle.setAngle(angle);
                if (angle < allScores.getRandomScore()) {
                    timer.stop();
                    view.getButtonStartRoullet().setEnabled(true);
                    if (NumberAmount)
                    {
                        if (view.getTextscore().getText().equals(allScores.getcor()))
                        {
                            money = money + amount * 10;
                            view.getMoney().setText(String.valueOf(money));
                            amount = 0;
                            resultgame = "Win";
                            view.getJLabelYouAmount().setText(String.valueOf(amount));
                            menu.getJlabscore().setText(String.valueOf(money));
                        }
                        else
                        {
                            wingame = false;
                            resultgame = "Lose";
                            amount = 0;
                            view.getJLabelYouAmount().setText(String.valueOf(amount));
                        }
                        view.getJlabelInformYouResul().setText(String.valueOf(allScores.getcor())  + "   " + resultgame);
                     }
                    if (ColorAmount) {
                        if (allScores.getcolor() == 1) {
                            {
                                if (blackamount) {
                                    wingame = true;
                                    resultgame = "Win";
                                    money = money + amount * 2;
                                    view.getMoney().setText(String.valueOf(money));
                                    amount = 0;
                                    view.getJLabelYouAmount().setText(String.valueOf(amount));
                                    menu.getJlabscore().setText(String.valueOf(money));
                                } else {
                                    wingame = false;
                                    resultgame = "Lose";
                                    amount = 0;
                                    view.getJLabelYouAmount().setText(String.valueOf(amount));
                                }
                            }
                            colorize = "Black";
                            view.getJlabelInformYouResul().setForeground(Color.black);
                        }
                        if (allScores.getcolor() == 0) {
                            if (redamount) {
                                resultgame = "Win";
                                wingame = true;
                                money = money + amount * 2;
                                view.getMoney().setText(String.valueOf(money));
                                amount = 0;
                                view.getJLabelYouAmount().setText(String.valueOf(amount));
                                menu.getJlabscore().setText(String.valueOf(money));
                            } else {
                                resultgame = "Lose";
                                wingame = false;
                                amount = 0;
                                view.getJLabelYouAmount().setText(String.valueOf(amount));
                            }
                            colorize = "Red";
                            view.getJlabelInformYouResul().setForeground(Color.red);
                        }
                        view.getJlabelInformYouResul().setText(String.valueOf(allScores.getcor()) + colorize + "   " + "You " + resultgame);
                    }
                }
                view.updatevie();
            }
        });
    }

    public void startimr() {
        StartTimer();
        timer.start();
        angle = 100;

    }

    public void startmoney() {
        view.getMoney().setText(menu.getJlabscore().getText());
    }


    public void listener() {

        menu.getExit().addActionListener(e -> {
            menu.getMenu().setVisible(false);
            System.exit(0);
                }

        );
        menu.getGameRoulet().addActionListener(e -> {
            view.createRouletView();
            view.getMoney().setText(menu.getJlabscore().getText());

        });
        view.getButtonred().addActionListener(e -> {
            redamount = true;
            blackamount = false;
            view.getJlabelInformYouResul().setForeground(Color.red);
            view.getJlabelInformYouResul().setText("Ставка на красное");

        });

        view.getButtonblack().addActionListener(e -> {
            redamount = false;
            blackamount = true;
            view.getJlabelInformYouResul().setForeground(Color.black);
            view.getJlabelInformYouResul().setText("Ставка на черное");

        });

        view.getTextscore().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                view.getJlabelInformYouResul().setText("Ставка на"+view.getTextscore().getText());

            }


        });

        view.getButtonplus().addActionListener(e -> {

            if (Integer.valueOf(view.getMoney().getText()) > 0) {
                money--;
                amount++;
                view.getJLabelYouAmount().setText(String.valueOf(amount));
                view.getMoney().setText(String.valueOf(money));
                menu.getJlabscore().setText(String.valueOf(money));


            } else view.getJlabelInformYouResul().setText("Кошелек пуст((");

        });
        view.getButtonminus().addActionListener(e -> {
            if (amount > 0) {
                money++;
                amount--;
                view.getJLabelYouAmount().setText(String.valueOf(amount));
                view.getMoney().setText(String.valueOf(money));
                menu.getJlabscore().setText(String.valueOf(money));
            }
        });

        view.getButtonStartRoullet().addActionListener(e -> {
            if (Integer.valueOf(view.getJLabelYouAmount().getText()) == 0)
                view.getJlabelInformYouResul().setText("Сделайте ставку");
            else if (!blackamount && !redamount && !NumberAmount)
                view.getJlabelInformYouResul().setText("На что ставите?");
            else

                startimr();
        });
        view.getjRadioButtonColor().addActionListener(e -> {
            view.getButtonred().setEnabled(true);
            view.getButtonblack().setEnabled(true);
            view.getTextscore().setEnabled(false);
            ColorAmount = true;
            NumberAmount = false;

        });
        view.getjRadioButtonScore().addActionListener(e -> {
            view.getButtonred().setEnabled(false);
            view.getButtonblack().setEnabled(false);
            view.getTextscore().setEnabled(true);
            ColorAmount = false;
            NumberAmount = true;

        });
    }


}
