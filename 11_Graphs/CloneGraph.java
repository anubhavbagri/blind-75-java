package Graphs;

import java.util.*;

/**
 * Time Complexity:  O(V + E) - each node and edge is visited exactly once during DFS
 * Space Complexity: O(V)     - HashMap stores one entry per node; recursion stack depth is O(V)
 */

public class CloneGraph {
    public static Node cloneGraph(Node node) {
        if(node == null)    return null;

        Map<Node, Node> map = new HashMap<>();

        return dfs(node, map);
    }

    public static Node dfs(Node original, Map<Node, Node> map){
        if(map.containsKey(original))   return map.get(original);

        Node currentClone = new Node(original.val);

        map.put(original, currentClone);

        for(Node neighbor: original.neighbors){
            Node clonedNeighbor = dfs(neighbor, map);
            currentClone.neighbors.add(clonedNeighbor);
        }

        return currentClone;
    }

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        // Build graph: 1 -- 2 -- 3 -- 4
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        Node cloned = cloneGraph(n1);

        // Print cloned adjacency list
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(cloned);
        visited.add(cloned.val);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print("Node " + curr.val + " -> ");
            for (Node nb : curr.neighbors) {
                System.out.print(nb.val + " ");
                if (visited.add(nb.val)) queue.add(nb);
            }
            System.out.println();
        }
    }
}
