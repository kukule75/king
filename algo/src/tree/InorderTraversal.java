package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author kinden
 *
 * 给定一个二叉树，返回它的中序 遍历。
 */
public class InorderTraversal {

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

        List<Integer> res = inOrderTraversalRecursion(node1);

        res.stream().forEach(System.out::println);
    }

    // Morris Traversal
    public static List<Integer> inOrderTraversalMorris(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        return res;
    }

    //递归法
    public static List<Integer> inOrderTraversalRecursion(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        inOrderTraversalRecursionHelper(root, res);

        return res;
    }

    private static void inOrderTraversalRecursionHelper(TreeNode e, List<Integer> res) {

        if (e.left != null) {
            inOrderTraversalRecursionHelper(e.left, res);
        }
        res.add(e.val);
        if (e.right != null) {
            inOrderTraversalRecursionHelper(e.right, res);
        }
    }

    //栈空间辅助，迭代法
    public static List<Integer> inOrderTraversal(TreeNode root) {

        List < Integer > res = new ArrayList< >();
        Stack < TreeNode > stack = new Stack < > ();

        TreeNode e = root;
        while (e != null || !stack.empty()) {
            while (e != null) {
                stack.add(e);
                e = e.left;
            }

            e = stack.pop();
            res.add(e.val);
            e = e.right;
        }

        return res;
    }

}
