package list;

/**
 * @author kinden
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveElements {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode res = removeElements(node1, 1);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {

        ListNode sentry = new ListNode(0);
        sentry.next = head;

        ListNode pre = sentry;
        ListNode p = head;

        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
                p = p.next;
            } else {
                pre = p;
                p = p.next;
            }
        }

        return sentry.next;
    }
}
