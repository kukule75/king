package list;

/**
 * @author kinden
 * 给定一个链表，判断链表中是否有环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

 */
public class HasCycle {

    private class Node {

        private int var;

        private Node next;

        public Node(int var) {
            this.var = var;
            this.next = null;
        }

    }

    public static void main(String[] args) {

    }

    public static boolean hasCycle(Node head) {

        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != slow ) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;

    }
}
