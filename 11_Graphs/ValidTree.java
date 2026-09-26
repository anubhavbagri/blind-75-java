package Graphs;

import java.util.*;

/**
 * Time Complexity: O(n+m)
 * Space Complexity: O(n)
 */

public class ValidTree {
    public static boolean validTree(int n, int[][] edges) {
        // early edge count filter
        if (edges.length != n - 1) return false;

        //build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // single DFS: check connectivity + cycle together
        boolean vis[] = new boolean[n];

        // start DFS from node 0
        if (checkDFS(0, -1, adj, vis)) {    // returns true if cycle found
            return false;   // has cycle -> not a tree
        }

        // check if all nodes are visited (connectivity)
        for (int i = 0; i < n; i++) {
            if (!vis[i]) return false;  //disconnected: not a tree
        }

        return true;    //no cycle + all connected + correct edges i.e. valid tree
    }

    // returns true if cycle is detected
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
