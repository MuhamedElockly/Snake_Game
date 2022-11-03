package snakeproject;

import java.awt.KeyEventPostProcessor;
import java.awt.event.KeyEvent;
import snakeproject.DrawPanel;

public class Keypoard_Events implements KeyEventPostProcessor {

    DrawPanel drawPanel;

    public Keypoard_Events(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
    }

    @Override
    public boolean postProcessKeyEvent(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT && drawPanel.getSnakeBody().isMoveRight() == false) {
            drawPanel.getSnakeBody().setMoveLeft(true);
            drawPanel.getSnakeBody().setMoveDown(false);
            drawPanel.getSnakeBody().setMoveRight(false);
            drawPanel.getSnakeBody().setMoveUP(false);
            drawPanel.repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_UP && drawPanel.getSnakeBody().isMoveDown() == false) {
            drawPanel.getSnakeBody().setMoveLeft(false);
            drawPanel.getSnakeBody().setMoveDown(false);
            drawPanel.getSnakeBody().setMoveRight(false);
            drawPanel.getSnakeBody().setMoveUP(true);
            drawPanel.repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && drawPanel.getSnakeBody().isMoveUP() == false) {
            drawPanel.getSnakeBody().setMoveLeft(false);
            drawPanel.getSnakeBody().setMoveDown(true);
            drawPanel.getSnakeBody().setMoveRight(false);
            drawPanel.getSnakeBody().setMoveUP(false);
            drawPanel.repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && drawPanel.getSnakeBody().isMoveLeft() == false) {
            drawPanel.getSnakeBody().setMoveLeft(false);
            drawPanel.getSnakeBody().setMoveDown(false);
            drawPanel.getSnakeBody().setMoveRight(true);
            drawPanel.getSnakeBody().setMoveUP(false);
            drawPanel.repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            drawPanel.getSnakeBody().setMoveLeft(false);
            drawPanel.getSnakeBody().setMoveDown(false);
            drawPanel.getSnakeBody().setMoveRight(false);
            drawPanel.getSnakeBody().setMoveUP(false);
            drawPanel.repaint();
        }
        return true;
    }
}