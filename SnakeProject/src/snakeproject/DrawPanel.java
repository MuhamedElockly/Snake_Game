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

public class DrawPanel extends javax.swing.JPanel {

    ArrayList<SnakeBody> snakeBodyLength;

    public ArrayList<SnakeHeadDirection> direction;
    public SnakeBody snakeBody;
    private Food food;
    Timer timer;

    double ranX;
    double ranY;

    public DrawPanel() {

        initComponents();
        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(this), 1000, 5);
        setSize(new Dimension(800, 800));

        ranX = Math.random() * this.getWidth();
        ranY = Math.random() * this.getHeight();
        setBackground(Color.WHITE);
        snakeBody = new SnakeBody(this);
        snakeBody.setP1(new Point(this.getWidth() / 2, this.getHeight() / 2));
        food = new Food(this);
        food.setP1(new Point((int) ranX, (int) ranY));
        snakeBodyLength = new ArrayList<>();
        direction = new ArrayList<>();
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

            if (counter == 400) {
                counter = 0;
            }
            eatFood();
            if (snakeBody.isMoveLeft()) {
                counter++;

                setDirection();
                moveAllBody(counter);

                snakeBody.getP1().x -= 1;

                if (snakeBody.getP1().x < 0) {

                    snakeBody.getP1().x = drawPanel.getWidth();
                }

            } else if (snakeBody.isMoveRight()) {
                counter++;
                setDirection();
                moveAllBody(counter);

                snakeBody.getP1().x += 1;

                if (snakeBody.getP1().x > drawPanel.getWidth()) {
                    snakeBody.getP1().x = 0;
                }

            } else if (snakeBody.isMoveUP()) {
                counter++;
                setDirection();
                moveAllBody(counter);

                snakeBody.getP1().y -= 1;

                if (snakeBody.getP1().y < 0) {
                    snakeBody.getP1().y = drawPanel.getHeight();
                }

            } else if (snakeBody.isMoveDown()) {

                counter++;

                setDirection();
                moveAllBody(counter);

                snakeBody.getP1().y += 1;

                if (snakeBody.getP1().y > drawPanel.getHeight()) {
                    snakeBody.getP1().y = 0;
                }

            }
//            System.out.println("Mohaedm");
//
//            if (counter == 400) {
////                System.out.println("Mohaedm");
//                // moveAllBody(counter);
//                counter = 0;
//            }
            resetArrayOfDirection();

            repaint();
        }
    }

    public void reInitalizeComponet() {
        ranX = Math.random() * this.getWidth();
//        ranY = Math.random() * this.getHeight();
//        food.setP1(new Point((int) ranX, (int) ranY));
        food.setP1(new Point((int) ranX, food.getP1().y));
        modifySnakeBody();
    }

    public void setDirection() {
        for (int i = 1; i < snakeBodyLength.size(); i++) {
            for (int j = 0; j < direction.size(); j++) {
                if ((snakeBodyLength.get(i).getP1().x == direction.get(j).getPosation().x)) {
//                    if ((snakeBodyLength.get(i).getP1().y == direction.get(j).getPosation().y)) {
                    {
                        System.out.println("size : " + direction.size());
                        snakeBodyLength.get(i).setMoveDown(direction.get(j).isDirectionDown());
                        snakeBodyLength.get(i).setMoveUP(direction.get(j).isDirectionUp());
                        snakeBodyLength.get(i).setMoveLeft(direction.get(j).isDirectionLeft());
                        snakeBodyLength.get(i).setMoveRight(direction.get(j).isDirectionRigth());

//                        }
                    }
                }

            }
        }
    }

    public void resetArrayOfDirection() {
        boolean clear = true;
        if (snakeBodyLength.size() > 1) {
            if (snakeBodyLength.get(1).getP1().x == snakeBodyLength.get(0).getP1().x) {

                for (int i = 1; i < snakeBodyLength.size(); i++) {
                    if (snakeBodyLength.get(i).getP1().x != snakeBodyLength.get(0).getP1().x) {
                        clear = false;
                        break;
                    }
                }
                if (clear == true) {
                    System.out.println("clear : " + clear);
                    direction.clear();
                }
            } else if (snakeBodyLength.get(1).getP1().y == snakeBodyLength.get(0).getP1().y) {
                for (int i = 1; i < snakeBodyLength.size(); i++) {
                    if (snakeBodyLength.get(i).getP1().y != snakeBodyLength.get(0).getP1().y) {
                        clear = false;
                        break;
                    }
                }
                if (clear == true) {
                    direction.clear();
                }

            }
        }
    }

    public void moveAllBody(int counter) {

        for (int i = 1; i < snakeBodyLength.size(); i++) {

            if (snakeBodyLength.get(i).isMoveDown()) {

                snakeBodyLength.get(i).setP1(new Point(snakeBodyLength.get(i).getP1().x, snakeBodyLength.get(i).getP1().y + 1));

            } else if (snakeBodyLength.get(i).isMoveUP()) {
                snakeBodyLength.get(i).setP1(new Point(snakeBodyLength.get(i).getP1().x, snakeBodyLength.get(i).getP1().y - 1));

            } else if (snakeBodyLength.get(i).isMoveLeft()) {
                snakeBodyLength.get(i).setP1(new Point(snakeBodyLength.get(i).getP1().x - 1, snakeBodyLength.get(i).getP1().y));

            } else if (snakeBodyLength.get(i).isMoveRight()) {
                snakeBodyLength.get(i).setP1(new Point(snakeBodyLength.get(i).getP1().x + 1, snakeBodyLength.get(i).getP1().y));

            }

        }
    }

    public void modifySnakeBody() {
        try {
            snakeBodyLength.add((SnakeBody) snakeBodyLength.get(snakeBodyLength.size() - 1).clone());
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(DrawPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (snakeBodyLength.get(snakeBodyLength.size() - 2).isMoveDown()) {
            snakeBodyLength.get(snakeBodyLength.size() - 1).setP1(new Point(snakeBodyLength.get(snakeBodyLength.size() - 1).getP1().x, snakeBodyLength.get(snakeBodyLength.size() - 1).getP1().y - 40));
        } else if (snakeBodyLength.get(snakeBodyLength.size() - 2).isMoveUP()) {
            snakeBodyLength.get(snakeBodyLength.size() - 1).setP1(new Point(snakeBodyLength.get(snakeBodyLength.size() - 1).getP1().x, snakeBodyLength.get(snakeBodyLength.size() - 1).getP1().y + 40));

        } else if (snakeBodyLength.get(snakeBodyLength.size() - 2).isMoveLeft()) {
            snakeBodyLength.get(snakeBodyLength.size() - 1).setP1(new Point(snakeBodyLength.get(snakeBodyLength.size() - 1).getP1().x + 40, snakeBodyLength.get(snakeBodyLength.size() - 1).getP1().y));

        } else if (snakeBodyLength.get(snakeBodyLength.size() - 2).isMoveRight()) {
            snakeBodyLength.get(snakeBodyLength.size() - 1).setP1(new Point(snakeBodyLength.get(snakeBodyLength.size() - 1).getP1().x - 40, snakeBodyLength.get(snakeBodyLength.size() - 1).getP1().y));

        }

//    snakeBodyLength.get(snakeBodyLength.size() - 1).setMoveDown( snakeBodyLength.get(snakeBodyLength.size() - 2).isMoveDown());
//       snakeBodyLength.get(snakeBodyLength.size() - 1).setMoveUP(snakeBodyLength.get(snakeBodyLength.size() - 2).isMoveUP());
//      snakeBodyLength.get(snakeBodyLength.size() - 1).setMoveLeft(snakeBodyLength.get(snakeBodyLength.size() - 2).isMoveLeft());
        repaint();
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
