package Trees;

import Trees.TreeNode;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1), auxiliary recursive stack space: O(n)
 */

public class IsValidBST {
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode root, long lowerBound, long upperBound) {
        if (root == null) return true;

        if(root.val <= lowerBound || root.val >= upperBound)    return false;

        boolean left = validate(root, lowerBound, root.val);

        boolean right = validate(root, root.val, upperBound);

        return left && right;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        // Input: [5,1,4,null,null,3,6]
        TreeNode root = new TreeNode(5,
                new TreeNode(1, new TreeNode(), new TreeNode()),
                new TreeNode(4, new TreeNode(3), new TreeNode(6)));

        System.out.println("Is it a valid BST? " + isValidBST(root));
    }
}
