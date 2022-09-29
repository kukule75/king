package doublePoint;

import list.ListNode;

public class DeleteDuplicates {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode res = deleteDuplicates(head);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {

        if(head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = fast;
            }

            fast = fast.next;
        }

        // 为了应付后面几个元素相同的链表
        slow.next = null;
        return head;
    }
}
