//
// TetrisGrid encapsulates a tetris board and has
// a clearRows() capability.

public class TetrisGrid {
    private boolean[][] grid;

    public TetrisGrid(boolean[][] grid) {
        this.grid = grid;
    }

    public void clearRows() {
        int width = grid.length, height = grid[0].length;
        int newY = 0;
        for (int y = 0; y < height; y++) {
            boolean full = true;
            for (int x = 0; x < width; x++) {
                if (!grid[x][y]) {
                    full = false;
                    break;
                }
            }
            if (!full) {
                for (int x = 0; x < width; x++) {
                    grid[x][newY] = grid[x][y];
                }
                newY++;
            }
        }
        for (int y = newY; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[x][y] = false;
            }
        }
    }
    public boolean[][] getGrid() {
        return grid;
    }
}