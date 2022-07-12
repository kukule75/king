package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author kinden
 * <p>
 * 给定一个二叉树，返回它的 后序 遍历。
 */
public class PostorderTraversal {

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

        List<Integer> res = postOrderTraversalRecursion(node1);

        res.stream().forEach(System.out::println);
    }

    //////////////////////////////////Traversal//////////////////////
    // 1 recursion
    public static List<Integer> postOrderTraversalRecursion(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        postOrderTraversalHelper(root, res);

        return res;
    }

    // 1.1 helper
    private static void postOrderTraversalHelper(TreeNode e, List<Integer> res) {

        if (e == null) {
            return;
        }

        postOrderTraversalHelper(e.left, res);
        postOrderTraversalHelper(e.right, res);

        res.add(e.val);
    }

    // 2 Iteration
    public static List<Integer> postOrderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        while (curr != null || !stack.isEmpty()) {
            curr = stack.pop();
            curr = curr.right;
            if (curr.right == null || curr.left == null) {
                res.add(curr.val);
            }
            if (curr.right != null) {
                stack.push(curr);
            }
        }
        return res;
    }

    //////////////////////Decompose////////////////
    public static List<Integer> postOrderDecompose(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        res.addAll(postOrderDecompose(root.left));
        res.addAll(postOrderDecompose(root.right));
        res.add(root.val);

        return res;
    }
}
