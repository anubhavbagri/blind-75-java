package Trees;

import Trees.TreeNode;

/**
 * Time Complexity: O(min(m,n)) in worst case because we stop at first mismatch, or O(m+n) if both trees are identical
 * Space Complexity: O(h) where h = height of the tree, balanced tree = O(log n), skewed tree = O(n)
 */

public class IsSameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if ((p == null && q != null) || (p != null && q == null)) return false;

        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        // Input: [3,9,20,null,null,15,7]
        TreeNode p = new TreeNode(3,
                new TreeNode(9, new TreeNode(), new TreeNode()),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        TreeNode q = new TreeNode(3,
                new TreeNode(20, new TreeNode(), new TreeNode()),
                new TreeNode(9, new TreeNode(15), new TreeNode(7)));

        System.out.println("Are binary trees same? " + isSameTree(p, q));
    }
}
