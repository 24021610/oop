// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
    private char[][] grid;

    /**
     * Constructs a new CharGrid with the given grid.
     * Does not make a copy.
     *
     * @param grid
     */
    public CharGrid(char[][] grid) {
        this.grid = grid;
    }

    /**
     * Returns the area for the given char in the grid. (see handout).
     *
     * @param ch char to look for
     * @return area for given char
     */
    public int charArea(char ch) {
        int min_col = 9999, max_col = -1, min_row = 9999, max_row = -1, cnt = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ch) {
                    cnt++;
                    if (i < min_col) min_col = i;
                    if (i > max_col) max_col = i;
                    if (j < min_row) min_row = j;
                    if (j > max_row) max_row = j;
                }
            }
        }
        return (cnt == 0) ? 0 : (max_col - min_col + 1) * (max_row - min_row + 1); // YOUR CODE HERE
    }

    /**
     * Returns the count of '+' figures in the grid (see handout).
     *
     * @return number of + in grid
     */
    public int countPlus() {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int arm = minLength(i, j);
                if (arm >= 2) {
                    count++;
                }
            }
        }
        return count;
    }

    private int countDir(int i, int j, int di, int dj, char ch) {
        int len = 0;
        while (i >= 0 && i < grid.length &&
                j >= 0 && j < grid[0].length &&
                grid[i][j] == ch) {
            len++;
            i += di;
            j += dj;
        }
        return len;
    }

    private int minLength(int i, int j) {
        char ch = grid[i][j];
        int left  = countDir(i, j-1, 0, -1, ch);
        int right = countDir(i, j+1, 0, +1, ch);
        int up    = countDir(i-1, j, -1, 0, ch);
        int down  = countDir(i+1, j, +1, 0, ch);
        return Math.min(Math.min(left, right), Math.min(up, down));
    }
}
}
