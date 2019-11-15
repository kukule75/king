package list;

import java.util.List;

/**
 * @author kinden
 *
 * 请判断一个链表是否为回文链表。
 *
 * 输入: 1->2
 * 输出: false
 *
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class IsPalindrome {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        System.out.println(isPalindrome(node1));

    }

    public static boolean isPalindrome(ListNode head) {

        if(head == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        ListNode temp = slow.next;

        while (fast != null && fast.next != null) {

            // 先让快指针走，否则慢指针修改了之后，快指针走不动
            fast = fast.next.next;
            // 先反转
            slow.next = pre;
            pre = slow;
            // 再后移
            slow = temp;
            temp = temp.next;
        }

        /**
         * 需要考虑链长是奇数和偶数的情况，自己画个图就清楚了
         */
        if (fast != null) {
            slow = slow.next;
        }

        while (pre != null) {
            if (slow.val != pre.val) {
                return false;
            }
            slow = slow.next;
            pre = pre.next;
        }

        return true;

    }
}
