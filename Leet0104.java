// https://leetcode.com/problems/maximum-depth-of-binary-tree

import java.util.ArrayDeque;
import java.util.Deque;


public class Leet0104 {
    public static void main(String[] args)
    {
        TreeNode nodeOne = new TreeNode(4);
        TreeNode nodeTwo = new TreeNode(2);
        TreeNode nodeThree = new TreeNode(7);
        TreeNode nodeFour = new TreeNode(1);
        TreeNode nodeFive = new TreeNode(3);
        TreeNode nodeSix = new TreeNode(6);
        TreeNode nodeSeven = new TreeNode(9);

        nodeOne.left = nodeTwo;
        nodeOne.right = nodeThree;
        nodeTwo.left = nodeFour;
        nodeTwo.right = nodeFive;
        nodeThree.left = nodeSix;
        nodeThree.right = nodeSeven;

        maxDepth(nodeOne);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null)
        {
            return 1;
        }

        return 1 + Math.min(maxDepth(root.left), maxDepth(root.right));
    }

    public static int maxDepthBfs(TreeNode root) {
        if (root == null)
        {
            return 0;
        }

        int curDepth = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            for (int i = 0; i<queue.size(); i++) {
                TreeNode node = queue.pop();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            curDepth += 1;
        }
        return curDepth;
    }

    // Definition for a binary tree node.

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
