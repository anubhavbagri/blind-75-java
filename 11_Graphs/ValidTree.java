package Graphs;

import java.util.*;

/**
 * Time Complexity:
 * Space Complexity:
 */

public class ValidTree {
    public static boolean validTree(int n, int[][] edges) {
        // condition 1: correct no. of edges
        if(edges.length != n-1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean vis[] = new boolean[n];
        int noc = 0;
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                noc++;
                dfs(i, adj, vis);
            }
        }

        // Condition 2: all nodes connected & Condition 3: no cycles
        return (noc == 1) && !(isCycle(n, adj));
    }

    private static void dfs(int i, List<List<Integer>> adj, boolean[] vis){
        vis[i] = true;
        for(int v : adj.get(i)){
            if(!vis[v]) dfs(v, adj, vis);
        }
    }

    public static boolean isCycle(int n, List<List<Integer>> adj){
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i] && checkDFS(i, -1, adj, vis))    return true;
        }
        return false;
    }

    private static boolean checkDFS(int src, int parent, List<List<Integer>> adj, boolean[] vis){
        vis[src] = true;
        for(int neighbor : adj.get(src)){
            if(neighbor == parent)   continue;
            if(vis[neighbor]) return true;
            if(checkDFS(neighbor, src, adj, vis))   return true;
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
