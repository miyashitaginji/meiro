import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MazeGenerator extends JFrame {
    private static final int MAZE_SIZE = 15;
    private Cell[][] maze;
    private MazePanel mazePanel;
    private MazeGeneratorAlgorithm generator;

    public MazeGenerator() {
        setTitle("Maze Generator");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        maze = new Cell[MAZE_SIZE][MAZE_SIZE];
        generator = new MazeGeneratorAlgorithm(MAZE_SIZE, maze);
        generator.generateMaze();

        mazePanel = new MazePanel(maze, MAZE_SIZE);
        add(mazePanel);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    generator.generateMaze();
                    mazePanel.setMaze(maze);
                    mazePanel.repaint();
                }
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MazeGenerator::new);
    }
}
