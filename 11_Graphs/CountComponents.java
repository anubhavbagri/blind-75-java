package Graphs;

import java.util.*;

/**
 * Time Complexity:
 * Space Complexity:
 */

public class CountComponents {
    public static int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        int noc = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                noc++;
                dfs(adj, i, vis);
            }
        }
        return noc;
    }

    public static void dfs(List<List<Integer>> adj, int i, boolean[] vis) {
        vis[i] = true;
        for (int v : adj.get(i)) {
            if (!vis[v]) dfs(adj, v, vis);
        }
    }


    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println("Output: " + countComponents(5, edges));
    }
}
