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

public class DrawPanel extends javax.swing.JPanel implements Subject {

    int score = 0;
    static final int SCREEN_WIDTH = 1920;
    static final int SCREEN_HEIGHT = 920;
    static final int UNIT_SIZE = 40;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
    // static final int DELAY = 175;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];

    ArrayList<PropertyChangeListener> listener;
    ArrayList<SnakeBody> snakeBodyLength;
    private boolean running = true;
    public SnakeBody snakeBody;
    private Food food;
    Timer timer;
    int appleX;
    int appleY;

    public DrawPanel() {

        initComponents();
        listener = new ArrayList<>();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(this), 1000, 150);
        setSize(new Dimension(800, 800));

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

    @Override
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        listener.add(propertyChangeListener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        listener.remove(propertyChangeListener);
    }

    @Override
    public void notifyAllProperties() {
        for (int i = 0; i < listener.size(); i++) {
            listener.get(i).update(Integer.toString(score * 10));
        }
    }

    class RemindTask extends TimerTask {

        private DrawPanel drawPanel;

        public RemindTask(DrawPanel drawPanel) {
            this.drawPanel = drawPanel;
        }

        public void run() {
            if (isRunning() == true) {
                moveAllBody();
            }
            eatFood();
            if (x[0] > (SCREEN_WIDTH)) {
                x[0] = 0;
            } else if (x[0] < 0) {
                x[0] = SCREEN_WIDTH;
            } else if (y[0] > SCREEN_HEIGHT) {
                y[0] = 0;
            } else if (y[0] < 0) {
                y[0] = SCREEN_HEIGHT;
            }

            repaint();
        }

        public DrawPanel getDrawPanel() {
            return drawPanel;
        }

        public void setDrawPanel(DrawPanel drawPanel) {
            this.drawPanel = drawPanel;
        }
    }

    public boolean checkMove(char ch) {
        if (ch == 'D') {
            if ((x[0] == x[1] && y[0] < y[1]) && y[0] < SCREEN_HEIGHT) {
                return false;
            }
        } else if (ch == 'U') {
            if ((x[0] == x[1] && y[0] > y[1]) && y[0] > 0) {
                return false;
            }
        } else if (ch == 'L') {
            if ((y[0] == y[1] && x[0] > x[1]) && x[0] < SCREEN_WIDTH) {
                return false;
            }
        } else if (ch == 'R') {
            if ((y[0] == y[1] && x[0] < x[1]) && x[0] > 0) {
                return false;
            }
        }
        return true;
    }

    public void reInitalizeComponet() {
        appleX = (int) ((int) (Math.random() * SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
        appleY = (int) ((int) (Math.random() * SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
        food.setP1(new Point((int) appleX, (int) appleY));
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
            try {
                snakeBodyLength.add((SnakeBody) snakeBodyLength.get(snakeBodyLength.size() - 1).clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(DrawPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            score++;
//            this.getScorePanel().setScore(Integer.toString(score * 10));
            notifyAllProperties();
            reInitalizeComponet();
            
            repaint();

        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
