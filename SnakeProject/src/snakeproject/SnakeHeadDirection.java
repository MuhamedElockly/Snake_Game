package snakeproject;

import java.awt.Point;

public class SnakeHeadDirection {

    public SnakeHeadDirection() {
        posation = new Point();
        directionDown = false;
        directionUp = false;
        directionLeft = false;
        directionRigth = false;

    }
    private Point posation;
    private boolean directionDown;
    private boolean directionUp;
    private boolean directionLeft;
    private boolean directionRigth;

    public Point getPosation() {
        return posation;
    }

    public void setPosation(Point posation) {
        this.posation = posation;
    }

    public boolean isDirectionDown() {
        return directionDown;
    }

    public void setDirectionDown(boolean directionDown) {
        this.directionDown = directionDown;
    }

    public boolean isDirectionUp() {
        return directionUp;
    }

    public void setDirectionUp(boolean directionUp) {
        this.directionUp = directionUp;
    }

    public boolean isDirectionLeft() {
        return directionLeft;
    }

    public void setDirectionLeft(boolean directionLeft) {
        this.directionLeft = directionLeft;
    }

    public boolean isDirectionRigth() {
        return directionRigth;
    }

    public void setDirectionRigth(boolean directionRigth) {
        this.directionRigth = directionRigth;
    }

}
