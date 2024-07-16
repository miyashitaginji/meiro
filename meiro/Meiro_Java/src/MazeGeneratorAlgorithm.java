import java.util.Random;

public class MazeGeneratorAlgorithm {
    private int mazeSize;
    private Cell[][] maze;
    private Random random = new Random();

    public MazeGeneratorAlgorithm(int mazeSize, Cell[][] maze) {
        this.mazeSize = mazeSize;
        this.maze = maze;
    }

    public void generateMaze() {
        for (int i = 0; i < mazeSize; i++) {
            for (int j = 0; j < mazeSize; j++) {
                maze[i][j] = new Cell();
            }
        }

        generatePath(0, 0);

        maze[0][0].setType(CellType.START);
        maze[mazeSize - 1][mazeSize - 1].setType(CellType.GOAL);
    }

    private void generatePath(int x, int y) {
        maze[x][y].setType(CellType.PATH);

        while (true) {
            int[] directions = {0, 1, 2, 3};
            shuffleArray(directions);

            boolean moved = false;
            for (int direction : directions) {
                int newX = x, newY = y;
                switch (direction) {
                    case 0: newX = x - 2; break; // 上
                    case 1: newX = x + 2; break; // 下
                    case 2: newY = y - 2; break; // 左
                    case 3: newY = y + 2; break; // 右
                }

                if (isValidMove(newX, newY)) {
                    maze[(x + newX) / 2][(y + newY) / 2].setType(CellType.PATH);
                    generatePath(newX, newY);
                    moved = true;
                    break;
                }
            }

            if (!moved) break;
        }
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && y >= 0 && x < mazeSize && y < mazeSize && maze[x][y].getType() == CellType.WALL;
    }

    private void shuffleArray(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
