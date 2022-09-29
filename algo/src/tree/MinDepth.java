package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {

    public static void main(String[] args) {

//        TreeNode n3 = new TreeNode(3);
//        TreeNode n9 = new TreeNode(9);
//        TreeNode n20 = new TreeNode(20);
//
//        TreeNode n15 = new TreeNode(15);
//        TreeNode n7 = new TreeNode(7);
//
//        n3.left = n9;
//        n3.right = n20;
//
//        n20.left = n15;
//        n20.right = n7;
//
//        System.out.println(minDepth(n3));

        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n2.left = null;
        n2.right = n3;

        n3.left = null;
        n3.right = n4;

        n4.left = null;
        n4.right = n5;

        n5.left = null;
        n5.right = n6;
        System.out.println(minDepth(n2));

    }

    public static int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int depth = 0;
        while (!queue.isEmpty()){
            depth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }

        }

        return depth;
    }
}
