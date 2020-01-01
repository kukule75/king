package tree;

/**
 * @author kinden
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 */
public class IsValidBST {

    public static void main(String[] args) {

        // true
//        TreeNode node1 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(1);
//        TreeNode node3 = new TreeNode(5);
//        TreeNode node4 = new TreeNode(2);
//        node1.left = node2;
//        node1.right = node3;
//        node2.right = node4;

        // false
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node3.right = node5;
        node3.left = node4;



        System.out.println(isValidBSTB(node1));
    }

    // 这是很容易犯的错误，错了得比较了左右节点，而不是左右子树
    public static boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }

        if ((root.left != null && root.left.val > root.val) ||
                (root.right != null && root.right.val < root.val)) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    // 中序遍历树，记录当前节点以及前面的节点，是否是依次递增
//    public static boolean isValidBSTA(TreeNode root) {
//
//    }

    // 递归，取左子树的最大值max，取右子树的最小值min，满足max<root.val<min
    // 巧妙写法，传入最大最小值，判断
    public static boolean isValidBSTB(TreeNode root) {

        return isValidBSTHelper(root, null, null);
    }

    private static boolean isValidBSTHelper(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return true;
        }

        if ((min != null && root.val <= min) ||
                (max != null && root.val >= max)) {
            return false;
        }

        return isValidBSTHelper(root.left, min, root.val) &&
                isValidBSTHelper(root.right, root.val, max);
    }
}
