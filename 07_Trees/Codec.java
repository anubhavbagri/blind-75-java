package Trees;

import java.util.*;

import Trees.TreeNode;

import static Trees.InvertTree.levelOrder;

/**
 * T.C: Serialize O(n), Deserialize O(n)
 * S.C. O(n)
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(",");
            return;
        }

        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> q = new LinkedList<>();

        for (String s : arr) {
            if (!s.isEmpty()) q.offer(s);
        }

        return deserialize(q);
    }

    public TreeNode deserialize(Queue<String> q) {
        String token = q.poll();

        if (token.equals("null")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = deserialize(q);
        node.right = deserialize(q);

        return node;
    }

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        // Input: [1,2,3,null,null,4,5]
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(), new TreeNode()),
                new TreeNode(3, new TreeNode(4), new TreeNode(5)));

        Codec ser = new Codec();
        Codec deser = new Codec();
        TreeNode ans = deser.deserialize(ser.serialize(root));

//        System.out.println("Output: " + levelOrder(ans));
    }
}
