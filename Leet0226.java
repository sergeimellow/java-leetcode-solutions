// https://leetcode.com/problems/invert-binary-tree/
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
// Memory Usage: 39.8 MB, less than 94.41% of Java online submissions for Invert Binary Tree.
public class Leet0226 {

    public void main(String[] args) {
        //root = [4,2,7,1,3,6,9]
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

        invertTree(nodeOne);
        String abc = "123";
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

     public class TreeNode {
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
