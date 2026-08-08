package Trees;

import java.util.*;

import Trees.TreeNode;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1), auxiliary stack space: O(n)
 */

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)    return null;

        if(p.val < root.val && q.val < root.val)    return lowestCommonAncestor(root.left, p, q);

        else if(p.val > root.val && q.val > root.val)    return lowestCommonAncestor(root.right, p, q);

        else return root;
    }

    public static void main(String[] args) {
        run();
    }

    private static List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        for (q.offer(root); !q.isEmpty(); ) {
            TreeNode n = q.poll();
            res.add(n.val);
            if (n.left != null) q.offer(n.left);
            if (n.right != null) q.offer(n.right);
        }
        return res;
    }

    public static void run() {
        // Input: [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));

        System.out.println("Output: " + levelOrder(lowestCommonAncestor(root, p, q)));
    }
}
