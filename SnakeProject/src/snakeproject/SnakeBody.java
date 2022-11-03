package snakeproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class SnakeBody {

    private Point p1;
    private boolean moveUP = false;
    private boolean moveDown = false;
    private boolean moveLeft = false;
    private boolean moveRight = false;

    public SnakeBody(DrawPanel drawPanel) {

        p1 = new Point();
    }

    public void drawBody(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(getP1().x, getP1().y, 40, 40);
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

}
