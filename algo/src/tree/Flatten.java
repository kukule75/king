package tree;

public class Flatten {

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);

        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        flatten(node1);

    }

    public static void flatten(TreeNode root) {

        flattenSubTree(root);
    }

    private static TreeNode flattenSubTree(TreeNode node) {

        if (node == null) {
            return node;
        }

        TreeNode res = flattenSubTree(node.left);
        TreeNode tail = res;

        if (res == null) {
            return node;
        }

        while (tail.right != null) {
            tail = tail.right;
        }

        tail.right = node.right;
        node.right = res;
        node.left = null;

        return node;
    }
}
