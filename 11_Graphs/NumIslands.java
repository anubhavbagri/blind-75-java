package Graphs;

import java.util.*;

/**
 * Time Complexity: Amortized Analysis: O(m * n)
 * traversing all cells once + visiting each cell once
 * Space Complexity: O(m × n) + O(m × n) = O(m × n)
 * Visited array: O(m × n), BFS Queue: O(m × n) worst case
 */

public class NumIslands {
    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    cnt++;
                    bfs(i, j, grid, vis, m, n);
                }
            }
        }
        return cnt;
    }

    public static void bfs(int i, int j, char[][] grid, boolean[][] vis, int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        vis[i][j] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int[][] neighbours = {{r - 1, c}, {r + 1, c}, {r, c - 1}, {r, c + 1}};
            for (int[] neighbour : neighbours) {
                int nr = neighbour[0];
                int nc = neighbour[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n || vis[nr][nc] || grid[nr][nc] == '0')
                    continue;

                q.offer(new int[]{nr, nc});
                vis[nr][nc] = true;
            }
        }
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};    
        System.out.println("Output: " + numIslands(grid));
    }
}
