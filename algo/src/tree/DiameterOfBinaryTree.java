package tree;

public class DiameterOfBinaryTree {

    static int maxDepth = 0;

    public static void main(String[] args) {

    }

    public int diameterOfBinaryTree(TreeNode root) {

        maxDepth(root);

        return maxDepth;
    }

    private int maxDepth(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);

        maxDepth = Math.max(maxDepth, left + right);

        return Math.max(left, right) + 1;
    }
}
