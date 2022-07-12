package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author kinden
 *
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 */
public class PreorderTraversal {

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

//        List<Integer> res = preOrderTraversalIteration(node1);
//        List<Integer> res = preOrderTraversalRecursion(node1);

        List<Integer> res = preOrderDecompose(node1);

        res.stream().forEach(System.out::println);
    }

    ////////////////////////////Traversal/////////////////////////////
    // 1 recursion
    public static List<Integer> preOrderTraversalRecursion(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        preOrderTraversalRecursionHelper(root, res);

        return res;
    }

    // 1.1 helper
    private static void preOrderTraversalRecursionHelper(TreeNode e, List<Integer> res) {

        if (e == null) {
            return;
        }

        res.add(e.val);
        preOrderTraversalRecursionHelper(e.left, res);
        preOrderTraversalRecursionHelper(e.right, res);
    }

    // 2 Iteration
    public static List<Integer> preOrderTraversalIteration(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if(root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);
        while (!stack.empty()) {
            TreeNode e = stack.pop();
            res.add(e.val);
            if (e.right != null) {
                stack.add(e.right);
            }
            if (e.left != null) {
                stack.add(e.left);
            }
        }

        return res;

    }

    /////////////////////////Decompose///////////////////////////
    // Decompose
    public static List<Integer> preOrderDecompose(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        res.add(root.val);
        res.addAll(preOrderDecompose(root.left));
        res.addAll(preOrderDecompose(root.right));

        return res;
    }
}
