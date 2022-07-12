package tree;

/**
 * @author kinden
 *
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class MaxDepth {

    static int maxDepth = Integer.MIN_VALUE;

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

//        System.out.println(recurse(node1));
        back(node1, 0);

        System.out.println(maxDepth);
    }

    ////////////////////////Dynamic////////////////////
    public static int recurse(TreeNode node){

        if (node == null) {
            return 0;
        }

        return Math.max(recurse(node.left), recurse(node.right)) + 1;
    }

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int h1 = maxDepth(root.left);
        int h2 = maxDepth(root.right);

        return h1 >= h2 ? h1 + 1: h2 + 1;
    }

    /////////////////back tracking//////////////////

    public static void back(TreeNode root, int depth) {

        if (root == null) {
            return;
        }

        depth++;
        maxDepth = Math.max(depth, maxDepth);
        back(root.left, depth);
        back(root.right, depth);
        depth--;
    }
}
