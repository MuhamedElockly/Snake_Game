package snakeproject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Food {

    private Point p1;
    DrawPanel drawPanel;

    public Food(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
        p1 = new Point();
    }

    public void drawBody(Graphics g) {

        g.setColor(Color.GREEN);
        g.fillOval(this.getP1().x, this.getP1().y, DrawPanel.UNIT_SIZE, DrawPanel.UNIT_SIZE);

    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }
}
