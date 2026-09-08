package Trees;

import Trees.TreeNode;

import java.util.*;

/**
 * Time Complexity:
 * Space Complexity:
 */

public class KthSmallest {
    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k-1);
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
        // Input: [5,3,6,2,4,null,null,1]
        TreeNode root = new TreeNode(5,
                new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)),
                new TreeNode(6, null, null));

        System.out.println("kth smallest element in BST: " + kthSmallest(root, 3));
    }
}
