package Trees;

import java.util.*;
import Trees.TreeNode;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class BuildTree {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = preorder.length;

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, n - 1, 0, n - 1, map);
    }

    private static TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map) {
        if(preStart > preEnd || inStart > inEnd)    return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int inRoot = map.get(root.val);
        int numLeft = inRoot - inStart;

        root.left = buildTree(preorder, inorder, preStart + 1, preStart + numLeft, inStart, inRoot - 1, map);
        root.right = buildTree(preorder, inorder, preStart + numLeft + 1, preEnd, inRoot + 1, inEnd, map);

        return root;
    }

    public static void main(String[] args) {
        run();
    }

    private static List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n == null) {
                res.add(null);
            } else {
                res.add(n.val);
                q.offer(n.left);   // enqueue even if null
                q.offer(n.right);  // enqueue even if null
            }
        }
        int i = res.size() - 1;
        while (i >= 0 && res.get(i) == null) i--;
        return res.subList(0, i + 1);
    }

    public static void run() {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        System.out.println("Output: " + levelOrder(buildTree(preorder, inorder)));
    }
}
