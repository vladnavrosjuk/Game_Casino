package View;

import javax.swing.*;
import java.awt.*;

public class BanditView {
    public JFrame jframeSlot;
    private JLabel lblYouBet;
    private JLabel lblBetAmount;
    private JLabel lblMyCrefit;

    public void setErrMsg(String message) {
        this.lblErrMsg.setText(message);
    }

    private JLabel lblCredit;
    private JLabel lblErrMsg;
    private JLabel lblReel1;
    private JLabel lblReel2;
    private JLabel lblReel3;
    private JButton btnAddCoin;
    private JButton btnBetOne;
    private JButton btnStop;
    private JButton btnSpin;
    private JButton btnAll;

    public JButton getBtnStop() {
        return btnStop;
    }


    public BanditView() {
        ButtonBuilder buttonBuilder = new ButtonBuilder();


        lblYouBet = new JLabel("Ваша ставка : ");
        lblBetAmount = new JLabel();
        lblMyCrefit = new JLabel("В кошелькe : ");
        lblCredit = new JLabel();
        lblErrMsg = new JLabel("ERR");

        lblReel1 = new JLabel();
        lblReel2 = new JLabel();
        lblReel3 = new JLabel();


        btnAddCoin = buttonBuilder.create("Пустой кошелек");
        btnBetOne = buttonBuilder.create("+ 1");

        btnSpin = buttonBuilder.create("Крутить");
        btnAll = buttonBuilder.create("Ставлю все");
        btnStop = buttonBuilder.create("");


        jframeSlot = new JFrame();

        jframeSlot.setTitle("Однорукий бандит!!!");
        jframeSlot.setContentPane(new BgPanel("Images/sltmsh2.png"));
        jframeSlot.setLayout(null);

        jframeSlot.setSize(405, 430);
        jframeSlot.setLocationRelativeTo(null);

        String url = "Images/redseven.png";
        ImageIcon imgObj = new ImageIcon(
                new ImageIcon(url).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        lblReel1.setIcon(imgObj);
        lblReel2.setIcon(imgObj);
        lblReel3.setIcon(imgObj);


        lblErrMsg.setHorizontalAlignment(JLabel.CENTER);
        jframeSlot.add(lblErrMsg);
        lblErrMsg.setBounds(40, 260, 300, 100);


        jframeSlot.add(lblYouBet);
        jframeSlot.add(lblBetAmount);
        jframeSlot.add(lblMyCrefit);

        jframeSlot.add(lblCredit);


        jframeSlot.add(lblReel1);
        lblReel1.setBounds(50, 130, 100, 100);
        lblReel2.setBounds(150, 130, 100, 100);
        lblReel3.setBounds(255, 130, 100, 100);
        jframeSlot.add(lblReel2);
        jframeSlot.add(lblReel3);
        jframeSlot.add(btnStop);


        jframeSlot.add(btnAddCoin);
        jframeSlot.add(btnBetOne);
        Font font = new Font("Versd", Font.BOLD, 32);
        lblCredit.setFont(font);
        lblBetAmount.setFont(font);


        jframeSlot.add(btnSpin);
        btnSpin.setBounds(315, 335, 50, 50);
        btnAddCoin.setBounds(100, 335, 50, 50);

        btnBetOne.setBounds(150, 335, 50, 50);
        lblCredit.setBounds(130, 215, 100, 100);
        lblBetAmount.setBounds(180, 215, 100, 100);
        btnStop.setBounds(30, 335, 50, 50);
        jframeSlot.add(btnAll);
        btnAll.setBounds(200, 335, 50, 50);

    }

    public JLabel getLblCredit() {
        return lblCredit;
    }

    public JLabel getLblReel1() {
        return this.lblReel1;
    }

    public JLabel getLblReel2() {
        return this.lblReel2;
    }

    public JLabel getLblReel3() {
        return this.lblReel3;
    }


    public JButton getBtnAddCoin() {
        return btnAddCoin;
    }

    public JButton getBtnBetOne() {
        return btnBetOne;
    }


    public JButton getBtnSpin() {
        return btnSpin;
    }

    public JButton getBtnAll() {
        return btnAll;
    }


    public int getBetAmount() {
        return Integer.parseInt(lblBetAmount.getText());
    }

    public void setBetAmount(int betAmount) {
        this.lblBetAmount.setText(Integer.toString(betAmount));
    }

    public int getCredit() {
        return Integer.parseInt(lblCredit.getText());
    }

    public void setCredit(int score) {
        this.lblCredit.setText(Integer.toString(score));
    }


    public void buttonControl(boolean flag) {
        btnAddCoin.setEnabled(flag);
        btnBetOne.setEnabled(flag);

        btnSpin.setEnabled(flag);
        btnAll.setEnabled(flag);

    }


}
