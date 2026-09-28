package Trees;

import Trees.TreeNode;

/**
 * T.C. O(n)
 * S.C. Auxiliary recursion stack space : O(height of the tree)
 */

public class MaxPathSum {
    static int global_max = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        solve(root);
        return global_max;
    }

    private static int solve(TreeNode root){
        if(root == null)    return 0;

        int left_straight = solve(root.left);
        int right_straight = solve(root.right);

        int straight = root.val + Math.max(0, Math.max(left_straight, right_straight));

        int bent = root.val + Math.max(0, left_straight) + Math.max(0, right_straight);

        global_max = Math.max(global_max, Math.max(straight, bent));

        return straight;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        // Input: [-10,9,20,null,null,15,7]
        TreeNode root = new TreeNode(-10,
                new TreeNode(9, new TreeNode(), new TreeNode()),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        System.out.println("Output: " + maxPathSum(root));
    }
}
