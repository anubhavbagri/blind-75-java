package Trees;

import Trees.TreeNode;

/**
 * Time Complexity: O(m * n) where m = nodes in root, n = nodes in subRoot
 * Space Complexity: O(h) where h = height of the tree at root
 */

public class IsSubtree {
    public static boolean isSubTree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return root == subRoot;

        if (root.val == subRoot.val) {
            if (isSameTree(root, subRoot)) return true;
        }

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;

        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        // Input: [3,4,5,1,2]
        TreeNode root = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(2)),
                new TreeNode(5));

        TreeNode subRoot = new TreeNode(4,
                new TreeNode(1),
                new TreeNode(2));

        System.out.println("Subtree of another tree? " + isSubTree(root, subRoot));
    }
}
