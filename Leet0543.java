// https://leetcode.com/problems/diameter-of-binary-tree/
public class Leet0543 {
    static int diameter;
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

        //             4
        //           /   \
        //          2     7
        //         / \   / \
        //        1   3  6  9
        // diameter = 4
        System.out.println(diameterOfBinaryTree(nodeOne));
        System.out.println(fib(8));
    }

    // messing around with using Binet’s Formula for the Nth Fibonacci
    public static int fib(int n)
    {
        double phi = (Math.sqrt(5) + 1) / 2;
        return Math.toIntExact(Math.round(Math.pow(phi, n) / Math.sqrt(5)));
    }


    public static int diameterOfBinaryTree(TreeNode n) {
        diameter = 0;
        dfs(n, 0);
        return diameter;
    }

    public static int dfs(TreeNode node, int max)
    {
        if (node == null) return -1;

        int left = dfs(node.left, max);
        int right = dfs(node.right, max);
        diameter = Math.max(diameter,  2 + left + right);
        return 1 + Math.max(left, right);

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
