package snakeproject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.util.ArrayList;

public class SnakeBody implements Cloneable {

    private Point p1;
    private boolean moveUP = false;
    private boolean moveDown = false;
    private boolean moveLeft = false;
    private boolean moveRight = false;
    DrawPanel drawPanel;

    public SnakeBody(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
        p1 = new Point();
    }

    public void drawBody(Graphics g) {
        //   g.setColor(Color.BLACK);
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setStroke(new BasicStroke(6));
        //  g.drawRect(getP1().x, getP1().y, 40, 40);
        if (this.equals(drawPanel.snakeBodyLength.get(0))) {
            g.setColor(Color.black);
        } else if (this.equals(drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.size() - 1)) && drawPanel.snakeBodyLength.size() > 1) {
            g.setColor(Color.BLUE);
        } else {
            checkCorner(g);
//            g.setColor(Color.red);
        }
        g.fillRect(getP1().x, getP1().y, DrawPanel.UNIT_SIZE, DrawPanel.UNIT_SIZE);
//        g2d.setStroke(new BasicStroke(1));
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public boolean isMoveUP() {
        return moveUP;
    }

    public void setMoveUP(boolean moveUP) {
        this.moveUP = moveUP;
    }

    public boolean isMoveDown() {
        return moveDown;
    }

    public void setMoveDown(boolean moveDown) {
        this.moveDown = moveDown;
    }

    public boolean isMoveLeft() {
        return moveLeft;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public boolean isMoveRight() {
        return moveRight;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public void checkCorner(Graphics g) {
        if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().x == this.getP1().x + DrawPanel.UNIT_SIZE) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().y == this.getP1().y)) {
            if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().x == this.getP1().x) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().y == this.getP1().y + DrawPanel.UNIT_SIZE)) {
                //Down To Up Right
                g.setColor(Color.GREEN);
            } else if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().x == this.getP1().x) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().y == this.getP1().y - DrawPanel.UNIT_SIZE)) {
                //Up To Down Right
                g.setColor(Color.ORANGE);
            } else {
                g.setColor(Color.RED);

            }
        } else if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().x == this.getP1().x + DrawPanel.UNIT_SIZE) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().y == this.getP1().y)) {
//          System.out.println("fdfff");
            if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().x == this.getP1().x) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().y == this.getP1().y + DrawPanel.UNIT_SIZE)) {
                //Right Up To Down 
                g.setColor(Color.GREEN);
//                 System.out.println("yarab");
            } else if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().x == this.getP1().x) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().y == this.getP1().y - DrawPanel.UNIT_SIZE)) {
                //Right Down To Up 
                g.setColor(Color.yellow);
//                 System.out.println("yarab");
            } else {
//                System.out.println("fdfff");
                g.setColor(Color.RED);
            }
        } else {
            g.setColor(Color.RED);
        }

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        SnakeBody snakeBody = null;
        snakeBody = (SnakeBody) super.clone();
        return snakeBody;
    }
}
