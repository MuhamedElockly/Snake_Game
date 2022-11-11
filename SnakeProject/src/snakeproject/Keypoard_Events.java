package snakeproject;

import java.awt.KeyEventPostProcessor;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import snakeproject.DrawPanel;

public class Keypoard_Events implements KeyEventPostProcessor {

    DrawPanel drawPanel;

    public Keypoard_Events(DrawPanel drawPanel) {
        this.drawPanel = drawPanel;
    }

    @Override
    public boolean postProcessKeyEvent(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT && drawPanel.getSnakeBody().isMoveRight() == false) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                if (drawPanel.checkMove('L')) {
                    drawPanel.setRunning(true);
                    drawPanel.getSnakeBody().setMoveLeft(true);
                    drawPanel.getSnakeBody().setMoveDown(false);
                    drawPanel.getSnakeBody().setMoveRight(false);
                    drawPanel.getSnakeBody().setMoveUP(false);
                    drawPanel.repaint();
                }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_UP && drawPanel.getSnakeBody().isMoveDown() == false) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                if (drawPanel.checkMove('U')) {
                    drawPanel.setRunning(true);
                    drawPanel.getSnakeBody().setMoveLeft(false);
                    drawPanel.getSnakeBody().setMoveDown(false);
                    drawPanel.getSnakeBody().setMoveRight(false);
                    drawPanel.getSnakeBody().setMoveUP(true);
                }
            }
            drawPanel.repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && drawPanel.getSnakeBody().isMoveUP() == false) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                if (drawPanel.checkMove('D')) {
                    drawPanel.setRunning(true);
                    drawPanel.getSnakeBody().setMoveLeft(false);
                    drawPanel.getSnakeBody().setMoveDown(true);
                    drawPanel.getSnakeBody().setMoveRight(false);
                    drawPanel.getSnakeBody().setMoveUP(false);
                }
            }
            drawPanel.repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && drawPanel.getSnakeBody().isMoveLeft() == false) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                if (drawPanel.checkMove('R')) {
                    drawPanel.setRunning(true);
                    drawPanel.getSnakeBody().setMoveLeft(false);
                    drawPanel.getSnakeBody().setMoveDown(false);
                    drawPanel.getSnakeBody().setMoveRight(true);
                    drawPanel.getSnakeBody().setMoveUP(false);
                }
            }
            drawPanel.repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (e.getID() == KeyEvent.KEY_PRESSED) {
                drawPanel.setRunning(false);
                drawPanel.getSnakeBody().setMoveLeft(false);
                drawPanel.getSnakeBody().setMoveDown(false);
                drawPanel.getSnakeBody().setMoveRight(false);
                drawPanel.getSnakeBody().setMoveUP(false);
                drawPanel.repaint();

            }
        }
        return true;
    }
}
