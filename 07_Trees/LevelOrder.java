package Trees;

import Trees.TreeNode;

import java.util.*;

/**
 * Time Complexity: O(n) where n = no. of nodes
 * Space Complexity: O(n)
 */

public class LevelOrder {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root != null) q.offer(root);

        while (!q.isEmpty()) {
            int level = q.size();
            List<Integer> sublist = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if (q.peek().left != null)
                    q.offer(q.peek().left);
                if (q.peek().right != null)
                    q.offer(q.peek().right);

                sublist.add(q.poll().val);
            }
            res.add(sublist);
        }
        return res;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        // Input: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        System.out.println("Level order traversal: " + levelOrder(root));
    }
}
