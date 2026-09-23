package Graphs;

import java.util.*;

/**
 * Time Complexity: O(m * n) - each cell visited once per ocean
 * Space Complexity: O(m * n) - two visited grids + recursion stack
 */

public class PacificAtlantic {
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        boolean[][] pacific_reached = new boolean[m][n];
        boolean[][] atlantic_reached = new boolean[m][n];

        for(int i = 0; i < m; i++){
            dfs(i, 0, heights, pacific_reached, m, n, Integer.MIN_VALUE);
            dfs(i, n-1, heights, atlantic_reached, m, n, Integer.MIN_VALUE);
        }

        for(int i = 0; i < n; i++){
            dfs(0, i, heights, pacific_reached, m, n, Integer.MIN_VALUE);
            dfs(m-1, i, heights, atlantic_reached, m, n, Integer.MIN_VALUE);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(pacific_reached[i][j] && atlantic_reached[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    public static void dfs(int i, int j, int[][] heights, boolean[][] vis, int m, int n, int prevHeight) {
        // If current is LESS than previous, we can't go there (need uphill or flat)
        if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j] || heights[i][j] < prevHeight) return;

        vis[i][j] = true;

        // When recursing, pass CURRENT height as the next prevHeight
        dfs(i + 1, j, heights, vis, m, n, heights[i][j]);
        dfs(i - 1, j, heights, vis, m, n, heights[i][j]);
        dfs(i, j + 1, heights, vis, m, n, heights[i][j]);
        dfs(i, j - 1, heights, vis, m, n, heights[i][j]);
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println("Output: " + pacificAtlantic(heights));
    }
}
