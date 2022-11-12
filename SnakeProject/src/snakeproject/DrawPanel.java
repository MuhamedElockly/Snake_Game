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
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class DrawPanel extends javax.swing.JPanel implements Subject {

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    int score = 0;
    static final int SCREEN_WIDTH = 1650;
    static final int SCREEN_HEIGHT = 800;
    public static final int UNIT_SIZE = 50;
    private int levelScore = 10;
    private int Level_Speed = 100;

    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
//     int GAME_UNITS = ( this.getWidth()* this.getHeight()) / (UNIT_SIZE * UNIT_SIZE);
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
    Sounds sounds;
    private int level = 1;
    boolean gameOver = false;

    public DrawPanel() {

        initComponents();

        listener = new ArrayList<>();
        //     this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        timer = new Timer();
        sounds = new Sounds();
        // setSize(new Dimension(800, 800));

        setBackground(Color.WHITE);
        snakeBody = new SnakeBody(this);
//        snakeBody.setMoveRight(true);
        //  snakeBody.setP1(new Point(this.x.length / 2, this.y.length / 2));
        food = new Food(this);

//        appleX = (int) ((int) (Math.random() * SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
//        appleY = (int) ((int) (Math.random() * SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
//
//        food.setP1(new Point((int) appleX, (int) appleY));
        reInitalizeComponet();
        snakeBodyLength = new ArrayList<>();

        snakeBodyLength.add(snakeBody);
        try {
            this.temp3 = (SnakeBody) snakeBody.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(DrawPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        KeyboardFocusManager keyManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        keyManager.addKeyEventPostProcessor(new Keypoard_Events(this));
        try {
            snakeBodyLength.add((SnakeBody) snakeBodyLength.get(snakeBodyLength.size() - 1).clone());
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(DrawPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            snakeBodyLength.add((SnakeBody) snakeBodyLength.get(snakeBodyLength.size() - 1).clone());
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(DrawPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //  x[0]=3*UNIT_SIZE;
        // y[0]=3*UNIT_SIZE;

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
//        for (int i = 0; i < SCREEN_WIDTH / UNIT_SIZE; i++) {
//            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
//            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
//        }
        for (int i = 0; i < snakeBodyLength.size(); i++) {
            snakeBodyLength.get(i).drawBody(g);
        }
        getFood().drawBody(g);

    }

    public void startGame(int level) {
        int speed = 0;
        this.setLevel(level);
        if (level == 1) {
            speed = 200;
            this.levelScore = 10;
        } else if (level == 2) {
            speed = 100;
            this.levelScore = 20;
        } else if (level == 3) {
            speed = 50;
            this.levelScore = 30;
        }
        timer.scheduleAtFixedRate(new RemindTask(this), 1000, speed);
        this.levelScore = levelScore;
        try {
            sounds.startBackgroundSound();
            repaint();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(DrawPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DrawPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(DrawPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
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

            if (listener.get(i) instanceof MainFrame && gameOver == true) {
                listener.get(i).close();
            } else if (!(listener.get(i) instanceof MainFrame)) {
                listener.get(i).update(Integer.toString(score * getLevelScore()));
            }
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
                if (snakeBodyLength.size() > 3) {
                    checkCollisions();
                }
            }
            eatFood();
            if (x[0] == (SCREEN_WIDTH)) {
                x[0] = 0;
            } else if (x[0] < 0) {
                x[0] = SCREEN_WIDTH;
            } else if (y[0] == SCREEN_HEIGHT) {
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

        appleX = (int) ((int) (Math.random() * (SCREEN_WIDTH - UNIT_SIZE) / UNIT_SIZE)) * UNIT_SIZE;
        appleY = (int) ((int) (Math.random() * (SCREEN_HEIGHT - UNIT_SIZE) / UNIT_SIZE)) * UNIT_SIZE;

        if (appleX == 0) {
            appleX = UNIT_SIZE;
            if (appleY == 0) {
                appleY = UNIT_SIZE;
            }
        } else if (appleX == SCREEN_WIDTH - UNIT_SIZE) {
            appleX = SCREEN_WIDTH - 2 * UNIT_SIZE;
            if (appleY == SCREEN_HEIGHT - UNIT_SIZE) {
                appleY = SCREEN_HEIGHT - 2 * UNIT_SIZE;
            }
        }
        food.setP1(new Point((int) appleX, (int) appleY));
    }

    public void gameOver() {
        this.gameOver = true;
        new GameOverFrame(this).setVisible(true);
        notifyAllProperties();
        sounds.pauseSound();

    }

    public void checkCollisions() {
        //checks if head collides with body
        for (int i = snakeBodyLength.size(); i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
                gameOver();

            }
        }
//        //check if head touches left border
//        if (x[0] < 0) {
//            running = false;
//        }
//        //check if head touches right border
//        if (x[0] > SCREEN_WIDTH) {
//            running = false;
//        }
//        //check if head touches top border
//        if (y[0] < 0) {
//            running = false;
//        }
//        //check if head touches bottom border
//        if (y[0] > SCREEN_HEIGHT) {
//            running = false;
//        }
//
//        if (!running) {
//            timer.cancel();
//        }
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
            notifyAllProperties();
            reInitalizeComponet();
            try {
                sounds.startEatSound();
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(DrawPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DrawPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(DrawPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();

        }
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * @return the Score_Level
     */
    public int getLevelScore() {
        return levelScore;
    }

    /**
     * @param Score_Level the Score_Level to set
     */
    public void setLevelScore(int levelScore) {
        this.levelScore = levelScore;
    }

    /**
     * @return the Level_Speed
     */
    public int getLevel_Speed() {
        return Level_Speed;
    }

    /**
     * @param Level_Speed the Level_Speed to set
     */
    public void setLevel_Speed(int Level_Speed) {
        this.Level_Speed = Level_Speed;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
