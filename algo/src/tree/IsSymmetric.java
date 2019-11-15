package tree;

/**
 * @author kinden
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 */
public class IsSymmetric {

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

        System.out.println(isSymmetricRecursion(node1));

    }

    //递归
    public static boolean isSymmetricRecursion(TreeNode root) {

        return isSymmetricRecursionHelper(root, root);
    }

    private static boolean isSymmetricRecursionHelper(TreeNode e, TreeNode t) {

        if (e == null && t == null) {
            return true;
        }
        if (e == null || t == null) {
            return false;
        }

        return (e.val == t.val) &&
                isSymmetricRecursionHelper(e.left, t.right) &&
                isSymmetricRecursionHelper(e.right, t.left);
    }
}
