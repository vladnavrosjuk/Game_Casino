package View;

import Controller.RoulletController;
import Model.RoulletAllScores;
import Model.RoulletScore;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class PointOnCircle extends JComponent {
    private double angle = 100;
    private double x;
    private double r;
    private double y;
    int i = 0;
    double angle2;
    RoulletController controller;
    RoulletScore score;
    boolean stop = false;
    private int c = 40;
    Timer timer;
    RoulletAllScores allScores;

    public PointOnCircle() {
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }




  /*  public void startimr(){
        timer();
        timer.start();
        angle = 100;
    }*/

    @Override
    protected void paintComponent(Graphics g) {

        int width = getWidth();
        int height = getHeight();
        Color selec = new Color(255, 255, 255, 0);
        g.setColor(selec);
        g.setColor(Color.blue);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3f));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        x = 0.5 * width;
        y = 0.5 * height;
        r = 0.75 * Math.min(x, y);
        g2d.setColor(Color.red);
        x += r * Math.cos(angle);
        y += r * Math.sin(angle);

        System.out.println(angle);
        r = 4;
        g2d.fill(circle(x, y, r));
        g2d.setColor(Color.darkGray);
    }

   /* public void Reoaint(){
        updateUI();
        repaint();
    }*/

    private Shape circle(double x, double y, double r) {
        return new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
    }


}