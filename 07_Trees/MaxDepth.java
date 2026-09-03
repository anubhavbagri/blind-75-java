package Trees;

import Trees.TreeNode;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class MaxDepth {
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + Math.max(lh, rh);
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        // Input: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3,
                new TreeNode(9, new TreeNode(), new TreeNode()),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        System.out.println("Output: " + maxDepth(root));
    }
}
