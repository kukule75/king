package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kinden
 */
public class Traversal {

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

//        List<TreeNode> res = preTraversal(node1);

    }

    private static List<TreeNode> preTraversal(TreeNode node) {

        List<TreeNode> res = new ArrayList<>();

        if (node == null) {
            return res;
        }

        preTraversalHelper(node, res);

        return res;
    }

    private static void preTraversalHelper(TreeNode node, List<TreeNode> res) {

        if (node == null) {
            return;
        }

        res.add(node);
        preTraversalHelper(node.left, res);
        preTraversalHelper(node.right, res);
    }




}
