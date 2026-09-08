package Trees;

import Trees.TreeNode;

import java.util.*;

/**
 * Time Complexity: O(2n)
 * Space Complexity: O(n)
 */

public class IsValidBST {
    public static boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i)) return false;
        }
        return true;
    }

    private static void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
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
