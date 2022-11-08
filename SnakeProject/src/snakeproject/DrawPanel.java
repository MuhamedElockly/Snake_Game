package snakeproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.KeyboardFocusManager;
import java.awt.Point;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;

public class DrawPanel extends javax.swing.JPanel {

    static final int SCREEN_WIDTH = 1920;
    static final int SCREEN_HEIGHT = 1000;
    static final int UNIT_SIZE = 40;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    // static final int DELAY = 175;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];

    ArrayList<SnakeBody> snakeBodyLength;

    public SnakeBody snakeBody;
    private Food food;
    Timer timer;
    int appleX;
    int appleY;
    double ranX;
    double ranY;

    public DrawPanel() {

        initComponents();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(this), 1000, 100);
        setSize(new Dimension(800, 800));

        ranX = Math.random() * this.getWidth();
        ranY = Math.random() * this.getHeight();
        setBackground(Color.WHITE);
        snakeBody = new SnakeBody(this);
        //  snakeBody.setP1(new Point(this.x.length / 2, this.y.length / 2));
        food = new Food(this);

        appleX = (int) ((int) (Math.random() * SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = (int) ((int) (Math.random() * SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

        food.setP1(new Point((int) appleX, (int) appleY));
        snakeBodyLength = new ArrayList<>();
   
        snakeBodyLength.add(snakeBody);
        try {
            this.temp3 = (SnakeBody) snakeBody.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(DrawPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        KeyboardFocusManager keyManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        keyManager.addKeyEventPostProcessor(new Keypoard_Events(this));
        repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < SCREEN_WIDTH / UNIT_SIZE; i++) {
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
        }
        for (int i = 0; i < snakeBodyLength.size(); i++) {
            snakeBodyLength.get(i).drawBody(g);
        }
        getFood().drawBody(g);
    }

    public SnakeBody getSnakeBody() {
        return snakeBody;
    }

    public void setSnakeBody(SnakeBody snakeBody) {
        this.snakeBody = snakeBody;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Food getFood() {
        return food;
    }
    SnakeBody temp3;
    int counter = 0;

    class RemindTask extends TimerTask {

        DrawPanel drawPanel;

        public RemindTask(DrawPanel drawPanel) {
            this.drawPanel = drawPanel;
        }

        public void run() {
            moveAllBody();
            eatFood();
           
            repaint();
        }
    }

    public void reInitalizeComponet() {
        appleX = (int) ((int) (Math.random() * SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = (int) ((int) (Math.random() * SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;

        food.setP1(new Point((int) appleX, (int) appleY));

        //  modifySnakeBody();
    }

    public void moveAllBody() {
        for (int i = snakeBodyLength.size(); i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];

        }
        if (snakeBody.isMoveUP()) {
            y[0] = y[0] - UNIT_SIZE;
            snakeBody.setP1(new Point(x[0], y[0]));
        } else if (snakeBody.isMoveDown()) {
            y[0] = y[0] + UNIT_SIZE;
            snakeBody.setP1(new Point(x[0], y[0]));
        } else if (snakeBody.isMoveLeft()) {
            x[0] = x[0] - UNIT_SIZE;
            snakeBody.setP1(new Point(x[0], y[0]));
        } else if (snakeBody.isMoveRight()) {
            x[0] = x[0] + UNIT_SIZE;
            snakeBody.setP1(new Point(x[0], y[0]));
        }
        for (int i = 0; i < snakeBodyLength.size(); i++) {
            snakeBodyLength.get(i).setP1(new Point(x[i], y[i]));
        }
    }

    public void eatFood() {

        if ((x[0] == food.getP1().x) && (y[0] == food.getP1().y)) {
            System.out.println("Yess");
            try {
                snakeBodyLength.add((SnakeBody) snakeBodyLength.get(snakeBodyLength.size() - 1).clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(DrawPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            reInitalizeComponet();
            repaint();
        }

//        if (getSnakeBody().getP1().x > getFood().getP1().x && getSnakeBody().getP1().x < getFood().getP1().x + 30) {
//            if (getSnakeBody().getP1().y > getFood().getP1().y && getSnakeBody().getP1().y < getFood().getP1().y + 30) {
//                reInitalizeComponet();
//            } else if (getSnakeBody().getP1().y + 40 > getFood().getP1().y && getSnakeBody().getP1().y + 40 < getFood().getP1().y + 30) {
//                reInitalizeComponet();
//            }
//        } else if (getSnakeBody().getP1().x + 40 > getFood().getP1().x && getSnakeBody().getP1().x + 40 < getFood().getP1().x + 30) {
//            if (getSnakeBody().getP1().y > getFood().getP1().y && getSnakeBody().getP1().y < getFood().getP1().y + 30) {
//                reInitalizeComponet();
//            } else if (getSnakeBody().getP1().y + 40 > getFood().getP1().y && getSnakeBody().getP1().y + 40 < getFood().getP1().y + 30) {
//                reInitalizeComponet();
//            }
//        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
