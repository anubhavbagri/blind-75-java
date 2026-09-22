package Graphs;

import java.util.*;

/**
 * Detecting cycles in a directed graph using Kahn's algorithm for topological sorting.
 * Time Complexity: O(V + E)
 * Space Complexity: O(V) + O(V)
 */

public class CourseSchedule {
    public static boolean courseSchedule(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int v : adj.get(i)) inDegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                    q.offer(neighbor);
            }
        }
        return res.size() == numCourses;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println("Output: " + courseSchedule(numCourses, prerequisites));
    }
}
