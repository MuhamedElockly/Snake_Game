package snakeproject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Stroke;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SnakeBody implements Cloneable {

    private Point p1;
    private boolean moveUP = false;
    private boolean moveDown = false;
    private boolean moveLeft = false;
    private boolean moveRight = false;
    DrawPanel drawPanel;
    Image headUp;
    Image headDown;
    Image headRight;
    Image headLeft;
    Image horizontal;
    Image topRightConrner;
    Image topLeftConrner;
    Image downLeftConrner;
    Image downRightConrner;
    Image vertical;
    Image downTail;
    Image upTail;
    Image rightTail;
    Image leftTail;

    public SnakeBody(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
        p1 = new Point();
        try {
            headUp = ImageIO.read(new File("./src\\Icons\\Head-Up.jpg"));
            headDown = ImageIO.read(new File("./src\\Icons\\Head-Down.jpg"));
            headRight = ImageIO.read(new File("./src\\Icons\\Head-Right.jpg"));
            headLeft = ImageIO.read(new File("./src\\Icons\\Head-Left.jpg"));
            horizontal = ImageIO.read(new File("./src\\Icons\\horizontal.jpg"));
            topRightConrner = ImageIO.read(new File("./src\\Icons\\TopRightCorner.jpg"));
            topLeftConrner = ImageIO.read(new File("./src\\Icons\\TopLeftCorner.jpg"));
            downLeftConrner = ImageIO.read(new File("./src\\Icons\\DownLeftCorner.jpg"));
            downRightConrner = ImageIO.read(new File("./src\\Icons\\DownRightCorner.jpg"));
            vertical = ImageIO.read(new File("./src\\Icons\\Vertical.jpg"));
            downTail = ImageIO.read(new File("./src\\Icons\\DownTail.jpg"));
            upTail = ImageIO.read(new File("./src\\Icons\\UpTail.jpg"));
            rightTail = ImageIO.read(new File("./src\\Icons\\RightTail.jpg"));
            leftTail = ImageIO.read(new File("./src\\Icons\\LeftTail.jpg"));

        } catch (IOException ex) {
            Logger.getLogger(BackgroundPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void drawBody(Graphics g) {
        //   g.setColor(Color.BLACK);
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.setStroke(new BasicStroke(6));
        //  g.drawRect(getP1().x, getP1().y, 40, 40);
        if (this.equals(drawPanel.snakeBodyLength.get(0))) {
            g.setColor(Color.black);
            if (this.isMoveUP()) {
                g.drawImage(headUp, getP1().x, getP1().y, null);
            } else if (this.isMoveDown()) {

                g.drawImage(headDown, getP1().x, getP1().y, null);
            } else if (this.isMoveLeft()) {

                g.drawImage(headLeft, getP1().x, getP1().y, null);
            } else if (this.isMoveRight()) {

                g.drawImage(headRight, getP1().x, getP1().y, null);
            }
        } else if (this.equals(drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.size() - 1)) && drawPanel.snakeBodyLength.size() > 1) {
            g.setColor(Color.BLUE);
            if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().x == this.getP1().x) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().y == this.getP1().y + DrawPanel.UNIT_SIZE)) {
                g.drawImage(upTail, getP1().x, getP1().y, null);
            } else if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().x == this.getP1().x) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().y == this.getP1().y - DrawPanel.UNIT_SIZE)) {
                g.drawImage(downTail, getP1().x, getP1().y, null);
            } else if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().x == this.getP1().x + DrawPanel.UNIT_SIZE) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().y == this.getP1().y)) {
                g.drawImage(leftTail, getP1().x, getP1().y, null);
            } else if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().x == this.getP1().x - DrawPanel.UNIT_SIZE) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().y == this.getP1().y)) {
                g.drawImage(rightTail, getP1().x, getP1().y, null);
            }
        } else {
            checkCorner(g);
//            g.setColor(Color.red);
        }
        //   g.fillRect(getP1().x, getP1().y, DrawPanel.UNIT_SIZE, DrawPanel.UNIT_SIZE);
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
                g.drawImage(topLeftConrner, getP1().x, getP1().y, null);
            } else if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().x == this.getP1().x) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().y == this.getP1().y - DrawPanel.UNIT_SIZE)) {
                //Up To Down Right
                g.drawImage(downLeftConrner, getP1().x, getP1().y, null);
                g.setColor(Color.ORANGE);
            } else {
                g.setColor(Color.RED);
                if (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().x == (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().x)) {
                    g.drawImage(vertical, getP1().x, getP1().y, null);
                } else {
                    g.drawImage(horizontal, getP1().x, getP1().y, null);
                }
            }
        } else if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().x == this.getP1().x + DrawPanel.UNIT_SIZE) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().y == this.getP1().y)) {
            if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().x == this.getP1().x) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().y == this.getP1().y + DrawPanel.UNIT_SIZE)) {
                //Right Up To Down 
                g.drawImage(topLeftConrner, getP1().x, getP1().y, null);
                g.setColor(Color.GREEN);
            } else if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().x == this.getP1().x) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().y == this.getP1().y - DrawPanel.UNIT_SIZE)) {
                //Right Down To Up 
                g.drawImage(downLeftConrner, getP1().x, getP1().y, null);
                g.setColor(Color.yellow);
            } else {
                g.setColor(Color.RED);
                if (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().x == (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().x)) {
                    g.drawImage(vertical, getP1().x, getP1().y, null);
                } else {
                    g.drawImage(horizontal, getP1().x, getP1().y, null);
                }
            }
        } else if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().x == this.getP1().x - DrawPanel.UNIT_SIZE) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().y == this.getP1().y)) {
            if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().x == this.getP1().x) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().y == this.getP1().y + DrawPanel.UNIT_SIZE)) {
                //Down To Up Left
                g.setColor(Color.CYAN);
                g.drawImage(topRightConrner, getP1().x, getP1().y, null);
            } else if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().x == this.getP1().x) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().y == this.getP1().y - DrawPanel.UNIT_SIZE)) {
                //Up To Down Left
                g.drawImage(downRightConrner, getP1().x, getP1().y, null);
                g.setColor(Color.GRAY);
            } else {
                g.setColor(Color.RED);
                if (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().x == (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().x)) {
                    g.drawImage(vertical, getP1().x, getP1().y, null);
                } else {
                    g.drawImage(horizontal, getP1().x, getP1().y, null);
                }
            }
        } else if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().x == this.getP1().x - DrawPanel.UNIT_SIZE) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().y == this.getP1().y)) {
            if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().x == this.getP1().x) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().y == this.getP1().y + DrawPanel.UNIT_SIZE)) {
                // Left Up To Down
                g.drawImage(topRightConrner, getP1().x, getP1().y, null);
                g.setColor(Color.BLUE);
            } else if ((drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().x == this.getP1().x) && (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().y == this.getP1().y - DrawPanel.UNIT_SIZE)) {
                // Left Down To Up
                g.drawImage(downRightConrner, getP1().x, getP1().y, null);
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.RED);
                if (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().x == (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().x)) {
                    g.drawImage(vertical, getP1().x, getP1().y, null);
                } else {
                    g.drawImage(horizontal, getP1().x, getP1().y, null);
                }
            }
        } else {
            g.setColor(Color.RED);
            if (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) + 1).getP1().x == (drawPanel.snakeBodyLength.get(drawPanel.snakeBodyLength.indexOf(this) - 1).getP1().x)) {
                g.drawImage(vertical, getP1().x, getP1().y, null);
            } else {
                g.drawImage(horizontal, getP1().x, getP1().y, null);
            }
        }

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        SnakeBody snakeBody = null;
        snakeBody = (SnakeBody) super.clone();
        return snakeBody;
    }
}
