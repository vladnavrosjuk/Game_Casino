package View;

import javax.swing.*;
import java.awt.*;
import java.net.URL;


public class Menu {
    private ImageIcon icon2;

    private JButton GameMachine;
    private JButton GameRoulet;
    private JLabel jlabscore;
    private JButton Exit;
    JFrame Menu;


    public JFrame getMenu() {
        return Menu;
    }

    public JLabel getJlabscore() {
        return jlabscore;
    }

    public void getJlabscore1() {
        jlabscore.getText();
    }

    public ImageIcon getIcon2() {
        return icon2;
    }



    public Menu() {
        Menu = new JFrame("Casino Royal");
        Menu.setContentPane(new BgPanel("Images/kazino.jpg"));
        Menu.setResizable(false);
        Menu.getContentPane().setLayout(null);
        Menu.setSize(700, 250);
        Menu.setVisible(true);
        Menu.setLocationRelativeTo(null);
        Menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Exit = new JButton("Выйти");
        Exit.setBounds(600,175,95,50);
        Exit.setBackground(Color.RED);
        Menu.add(Exit);

        GameMachine = new JButton();
        /* GameMachine.setBackground(Color.GRAY);
         GameMachine.setOpaque(true);*/
        ImageIcon icon1 = createIcon("1.png");
        ImageIcon icon2 = createIcon("iconroulet.png");
        GameMachine.setIcon(icon1);
        GameMachine.setBounds(80, 10, 180, 200);
        Menu.add(GameMachine);

        GameRoulet = new JButton();
        GameRoulet.setIcon(icon2);
        GameRoulet.setBounds(325, 10, 180, 200);
        Menu.add(GameRoulet);
        GameMachine.setBorderPainted(false);
        GameMachine.setFocusPainted(false);
        GameMachine.setContentAreaFilled(false);
        GameRoulet.setBorderPainted(false);
        GameRoulet.setFocusPainted(false);
        GameRoulet.setContentAreaFilled(false);
        Font font = new Font("", Font.BOLD, 15);
        Exit.setFont(font);
        Exit.setBorderPainted(false);

        GameMachine.setForeground(Color.RED);
        GameMachine.setFont(font);
        jlabscore = new JLabel();
        Menu.add(jlabscore);
        JLabel jLabel = new JLabel("В кошельке:");
        jLabel.setForeground(Color.white);
        Menu.add(jLabel);
        jLabel.setBounds(590, 2, 80, 30);
        jlabscore.setBounds(675, 2, 30, 30);
    }

    protected static ImageIcon createIcon(String path) {
        URL imgURL = Menu.class.getResource(path);
        System.out.println(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            //java.util.Logger/ sel4j
            System.err.println("File not found " + path);
            return null;
        }
    }

    public JButton getExit() {
        return Exit;
    }

    public JButton getGameRoulet() {
        return GameRoulet;
    }

    public void setCredit(int score) {
        this.jlabscore.setText(Integer.toString(score));
    }


    public JButton getGameMachine() {
        return GameMachine;
    }
}
