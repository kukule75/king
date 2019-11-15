package list;

/**
 * @author kinden
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

//        System.out.println(7 & 1);

        ListNode res = addTwoNumbers(null, node4);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    //     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    //     * 输出：7 -> 0 -> 8
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode h1 = new ListNode(0);
        h1.next = l1;
        ListNode pre = h1;
        int carry = 0;

        while (l1 != null || l2 != null) {
            ListNode e;
            int val;
            if (l1 == null) {
                val = l2.val + carry;
                e = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                val = l1.val + carry;
                e = l1;
                l1 = l1.next;
            } else {
                val = l1.val + l2.val + carry;
                e = l1;
                l1 = l1.next;
                l2 = l2.next;
            }
            e.val = val % 10;
            carry = val / 10;
            pre.next = e;
            pre = pre.next;
        }

        if (carry == 1) {
            ListNode e = new ListNode(1);
            pre.next = e;
        }

        return h1.next;
    }
}
