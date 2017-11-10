package View;

import Controller.RoulletController;
import Model.BanditModel;

import javax.swing.*;
import java.awt.*;

/**
 * Оф
 * Created by Владислав on 15.09.2017.
 */
public class RoulletView {
    PointOnCircle pointOnCircle;
    JButton ButtonStartRoullet;
    JButton buttonblack;
    JButton buttonred;
    JButton buttonplus;
    JLabel JlabelInformYouResul;
    JButton buttonminus;
    JTextField textscore;
    JFrame Roullet;
    RoulletController controller;
    JLabel money;
    Menu menu;
    private JRadioButton jRadioButtonScore;
    private JRadioButton jRadioButtonColor;

    public JTextField getTextscore() {
        return textscore;
    }

    public JRadioButton getjRadioButtonScore() {
        return jRadioButtonScore;
    }

    public JRadioButton getjRadioButtonColor() {
        return jRadioButtonColor;
    }

    public JButton getButtonStartRoullet() {
        return ButtonStartRoullet;
    }

    private JLabel JLabelYouAmount;


    public JLabel getMoney() {
        return money;
    }

    public JLabel getJLabelYouAmount() {

        return JLabelYouAmount;
    }

    RoulletView() {
        pointOnCircle = new PointOnCircle();
        menu = new Menu();
        BanditModel banditModel = new BanditModel();
        controller = new RoulletController(this, pointOnCircle, menu, banditModel);
        Roullet = new JFrame("Casino Royal");
        Roullet.setContentPane(new BgPanel("Images/kazinoha2.jpg"));
        Font font = new Font("Versd", Font.BOLD, 15);
        Font font1 = new Font("Versd", Font.BOLD, 37);
        Font font2 = new Font("Versd", Font.BOLD, 25);
        ButtonStartRoullet = new JButton("Крутить");
        ButtonStartRoullet.setBounds(350, 175, 90, 50);
        ButtonStartRoullet.setFocusPainted(false);
        ButtonStartRoullet.setFont(font);
        ButtonStartRoullet.setBackground(Color.black);
        ButtonStartRoullet.setForeground(Color.white);
        Roullet.add(ButtonStartRoullet);
        JlabelInformYouResul = new JLabel("Крути!");
        JlabelInformYouResul.setFont(font1);
        JlabelInformYouResul.setBounds(0, 0, 400, 50);
        buttonplus = new JButton("+");
        buttonplus.setBounds(50, 150, 50, 50);
        Roullet.add(buttonplus);
        buttonminus = new JButton("-");
        buttonminus.setFont(font1);
        buttonplus.setFont(font2);
        buttonplus.setBorderPainted(false);
        buttonplus.setFocusPainted(false);
        buttonplus.setContentAreaFilled(false);
        buttonminus.setBorderPainted(false);
        buttonminus.setFocusPainted(false);
        buttonminus.setContentAreaFilled(false);
        buttonminus.setBounds(100, 143, 50, 50);
        Roullet.add(buttonminus);
        money = new JLabel();
        money.setBounds(400, 0, 100, 50);
        money.setFont(font1);
        Roullet.add(money);
        buttonblack = new JButton("");
        buttonblack.setBackground(Color.black);
        buttonblack.setBounds(200, 150, 50, 50);
        Roullet.add(buttonblack);
        buttonred = new JButton("");
        buttonred.setBackground(Color.red);
        buttonred.setBounds(250, 150, 50, 50);
        Roullet.add(buttonred);
        textscore = new JTextField();
        textscore.setBounds(200, 200, 100, 50);
        Roullet.add(textscore);
        buttonblack.setEnabled(false);
        buttonred.setEnabled(false);
        textscore.setEnabled(false);
        jRadioButtonColor = new JRadioButton("");
        jRadioButtonColor.setBounds(170, 160, 20, 30);
        jRadioButtonColor.setOpaque(false);
        Roullet.add(jRadioButtonColor);
        jRadioButtonScore = new JRadioButton("");
        jRadioButtonScore.setBounds(170, 210, 20, 30);
        jRadioButtonScore.setOpaque(false);
        Roullet.add(jRadioButtonScore);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButtonColor);
        buttonGroup.add(jRadioButtonScore);
        JLabelYouAmount = new JLabel("0");
        JLabelYouAmount.setBounds(50, 200, 100, 50);
        JLabelYouAmount.setFont(font2);
        Roullet.add(JLabelYouAmount);
        Roullet.add(JlabelInformYouResul);
        Roullet.setResizable(false);
        Roullet.setLayout(null);
        Roullet.setSize(500, 700);
        Roullet.add(pointOnCircle);
        pointOnCircle.setBounds(43, 368, 250, 250);
        controller.listener();
        Roullet.setLocationRelativeTo(null);
    }


    public JLabel getJlabelInformYouResul() {
        return JlabelInformYouResul;
    }

    public void updatevie() {
        pointOnCircle.repaint();

    }

    public void createRouletView() {
        Roullet.setVisible(true);
    }

    public JButton getButtonblack() {
        return buttonblack;
    }

    public JButton getButtonred() {
        return buttonred;
    }

    public JButton getButtonplus() {
        return buttonplus;
    }

    public JButton getButtonminus() {
        return buttonminus;
    }
}
