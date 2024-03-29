package tree;

public class HowManyNodes {

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        calculate(node1);
    }

    private static int calculate(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = calculate(root.left);
        int right = calculate(root.right);

        System.out.println("node " + root.val + ", left children node has " + left + ", right children node has " + right);

        return left + right + 1;
    }
}
