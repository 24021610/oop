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
        return 0; // YOUR CODE HERE
    }

}
