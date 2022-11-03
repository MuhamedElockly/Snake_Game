package snakeproject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

public class DrawPanel extends javax.swing.JPanel {

    private SnakeBody snakeBody;
    private Food food;
    Timer timer;

    double ranX;
    double ranY;

    public DrawPanel() {
        initComponents();
        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(this), 1000, 2);
        setSize(new Dimension(800, 800));

        ranX = Math.random() * this.getWidth();
        ranY = Math.random() * this.getHeight();
        setBackground(Color.WHITE);
        snakeBody = new SnakeBody(this);
        snakeBody.setP1(new Point(this.getWidth() / 2, this.getHeight() / 2));
        food = new Food(this);
        food.setP1(new Point((int) ranX, (int) ranY));

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

        getSnakeBody().drawBody(g);
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

    class RemindTask extends TimerTask {

        DrawPanel drawPanel;

        public RemindTask(DrawPanel drawPanel) {
            this.drawPanel = drawPanel;
        }

        public void run() {
            eatFood();
            if (snakeBody.isMoveLeft()) {
                snakeBody.getP1().x -= 1;
                if (snakeBody.getP1().x < 0) {
                    snakeBody.getP1().x = drawPanel.getWidth();
                }
            } else if (snakeBody.isMoveRight()) {
                snakeBody.getP1().x += 1;
                if (snakeBody.getP1().x > drawPanel.getWidth()) {
                    snakeBody.getP1().x = 0;
                }
            } else if (snakeBody.isMoveUP()) {
                snakeBody.getP1().y -= 1;
                if (snakeBody.getP1().y < 0) {
                    snakeBody.getP1().y = drawPanel.getHeight();
                }
            } else if (snakeBody.isMoveDown()) {
                snakeBody.getP1().y += 1;
                if (snakeBody.getP1().y > drawPanel.getHeight()) {
                    snakeBody.getP1().y = 0;
                }
            }
            repaint();
        }
    }

    public void reInitalizeComponet() {
        ranX = Math.random() * this.getWidth();
        ranY = Math.random() * this.getHeight();
        food.setP1(new Point((int) ranX, (int) ranY));
    }

    public void eatFood() {

        if (getSnakeBody().getP1().x > getFood().getP1().x && getSnakeBody().getP1().x < getFood().getP1().x + 30) {
            if (getSnakeBody().getP1().y > getFood().getP1().y && getSnakeBody().getP1().y < getFood().getP1().y + 30) {
                reInitalizeComponet();
            } else if (getSnakeBody().getP1().y + 40 > getFood().getP1().y && getSnakeBody().getP1().y + 40 < getFood().getP1().y + 30) {
                reInitalizeComponet();
            }
        } else if (getSnakeBody().getP1().x + 40 > getFood().getP1().x && getSnakeBody().getP1().x + 40 < getFood().getP1().x + 30) {
            if (getSnakeBody().getP1().y > getFood().getP1().y && getSnakeBody().getP1().y < getFood().getP1().y + 30) {
                reInitalizeComponet();
            } else if (getSnakeBody().getP1().y + 40 > getFood().getP1().y && getSnakeBody().getP1().y + 40 < getFood().getP1().y + 30) {
                reInitalizeComponet();
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
