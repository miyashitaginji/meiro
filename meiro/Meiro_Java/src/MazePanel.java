import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MazePanel extends JPanel {
    private Cell[][] maze;
    private int mazeSize;

    public MazePanel(Cell[][] maze, int mazeSize) {
        this.maze = maze;
        this.mazeSize = mazeSize;
    }

    public void setMaze(Cell[][] maze) {
        this.maze = maze;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellSize = Math.min(getWidth() / mazeSize, getHeight() / mazeSize);
        for (int i = 0; i < mazeSize; i++) {
            for (int j = 0; j < mazeSize; j++) {
                switch (maze[i][j].getType()) {
                    case WALL:
                        g.setColor(Color.BLACK);
                        break;
                    case PATH:
                        g.setColor(Color.WHITE);
                        break;
                    case START:
                        g.setColor(Color.BLUE);
                        break;
                    case GOAL:
                        g.setColor(Color.RED);
                        break;
                }
                g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
    }
}
