/*
Goldman Sachs Question (Variation of Minimum Path Sum)
You are an avid rock collector who lives in southern California. Some rare and desirable rocks just became available in New York, so you are planning a cross-country road trip. There are several other rare rocks that you could pick up along the way. You have been given a grid filled with numbers, representing the number of rare rocks available in various cities across the country. Your objective is to find the optimal path from So_Cal to New_York that would allow you to accumulate the most rocks along the way.

Note: You can only travel either north (up) or east (right).
b) Consider adding some additional tests in doTestsPass().
c) Implement optimalPath() correctly.
d) Here is an example:
^
{{0, 0, 0, 0, 5}, New_York (finish) N
{0, 1, 1, 1, 0},
So_Cal (start) {2, 0, 0, 0, 0}} S
v
The total for this example would be 10 (2+0+1+1+1+0+5).
 */
package DP_2D;

import java.util.Arrays;

/**
 * Time Complexity: exponential
 * Space Complexity:
 */
public class MaxPathSum {

    public static int maxPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return backtrack(row - 1, 0, row, col, grid, dp);
    }

    private static int backtrack(int i, int j, int row, int col, int[][] grid, int[][] dp) {
        if (i == 0 && j == col - 1) return grid[i][j];

        if (dp[i][j] != -1)
            return dp[i][j];

        int right = Integer.MIN_VALUE, up = Integer.MIN_VALUE;

        if (i - 1 >= 0)
            up = backtrack(i - 1, j, row, col, grid, dp);

        if (j + 1 < col)
            right = backtrack(i, j + 1, row, col, grid, dp);

        return dp[i][j] = grid[i][j] + Math.max(up, right);
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[][] grid = {{0, 0, 0, 0, 5}, {0, 1, 1, 1, 0}, {2, 0, 0, 0, 0}};
        System.out.println("Output: " + maxPathSum(grid));
    }
}

