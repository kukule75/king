package list;

/**
 * @author kinden
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode res = swapPairs(node1);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

    private static ListNode swapPairs(ListNode head) {

        ListNode sentry = new ListNode(0);
        sentry.next = head;

        ListNode pre = sentry;
        ListNode slow = head;
        ListNode next;
        ListNode fast;

        while (slow != null && slow.next != null) {
            fast = slow.next;
            next = fast.next;
            fast.next = slow;
            slow.next = next;
            pre.next = fast;
            pre = slow;
            slow = next;
        }

        return sentry.next;
    }
}
