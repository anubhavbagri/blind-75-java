package Trees;
/*
Mental template to develop for trees:
1. What should happen at the current node?
2. Can the same problem be applied to the left subtree?
3. Can the same problem be applied to the right subtree?
4. What is my base case?
5. What do I need to return to the caller?
 */
/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
