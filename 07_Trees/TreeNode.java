package Trees;
/*
Mental template to develop for trees:
RECURSIVE_FUNCTION(node):
    1. BASE CASE: What happens at leaf nodes (node == null)?
    2. RECURSIVE CASE:
       - Solve for LEFT subtree
       - Solve for RIGHT subtree
       - COMBINE results to answer for current node
    3. RETURN answer for current node
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
