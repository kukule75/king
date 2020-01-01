package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kinden
 */
public class BinaryTreePaths {

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        List<String> res = new ArrayList<>();

        binaryTreePathsHelper("", node1, res);

    }

    // 递归
    private static void binaryTreePathsHelper(String cur, TreeNode root, List<String> res) {

        if (root == null) {
            return;
        }

        StringBuilder sb = new StringBuilder(cur);
        sb.append(root.val);
        if (root.right == null && root.left == null) {
            res.add(sb.toString());
            return;
        } else {
            sb.append("->");
            binaryTreePathsHelper(sb.toString(), root.left, res);
            binaryTreePathsHelper(sb.toString(), root.right, res);
        }
    }
}
