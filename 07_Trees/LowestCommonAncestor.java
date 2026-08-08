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

    public static void run() {
        // Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
        // Expected Output: 6
        TreeNode root = new TreeNode(6,
                new TreeNode(2,
                        new TreeNode(0),
                        new TreeNode(4, new TreeNode(3), new TreeNode(5))),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)));

        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);

        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("Output: " + (lca != null ? lca.val : "null"));
    }
}
