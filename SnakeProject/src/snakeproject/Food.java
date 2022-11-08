package snakeproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Food {

    private Point p1;

    public Food(DrawPanel drawPanel) {

        p1 = new Point();
    }

    public void drawBody(Graphics g) {

        g.setColor(Color.GREEN);
        g.fillOval(this.getP1().x, this.getP1().y, 40, 40);

    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }
}
