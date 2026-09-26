package Graphs;

import java.util.*;

/**
 * Time Complexity:
 * Space Complexity:
 */

public class ValidTree {
    public static boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean vis[] = new boolean[n];

        if (checkDFS(0, -1, adj, vis)) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (!vis[i]) return false;
        }
        return true;
    }

    private static boolean checkDFS(int src, int parent, List<List<Integer>> adj, boolean[] vis) {
        vis[src] = true;
        for (int neighbor : adj.get(src)) {
            if (neighbor == parent) continue;
            if (vis[neighbor]) return true;
            if (checkDFS(neighbor, src, adj, vis)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        System.out.println("Output: " + validTree(5, edges));
    }
}
