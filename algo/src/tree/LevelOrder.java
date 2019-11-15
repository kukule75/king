package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author kinden
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {

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

        List<List<Integer>> res = levelOrder(node1);
    }

    // 队列空间辅助
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int level = 0;

        while (!queue.isEmpty()) {

            levels.add(new ArrayList<>());
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                TreeNode e = queue.remove();
                levels.get(level).add(e.val);
                if (e.left != null) {
                    queue.add(e.left);
                }
                if (e.right != null) {
                    queue.add(e.right);
                }
            }
            level++;
        }

        return levels;

    }
}
