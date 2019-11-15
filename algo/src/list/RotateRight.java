package list;

/**
 * @author kinden
 *
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 思路1：
 *  倒转1->2->3->4->5，得到
 *  5-4-3-2-1，倒转前面n=2个，得到
 *  4-5-3-2-1，倒转后面剩余的，得到
 *  4-5-1-2-3
 *
 *  思路2：
 *  把前面n(链表长度len-k)个元素放到链表末尾
 */
public class RotateRight {

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || k < 0) {
            return head;
        }
        int len = 1;
        ListNode h = head;
        while (h.next != null) {
            h = h.next;
            len++;
        }

        int step = len -  (k % len);

        while (step >= 1) {
            h.next = head;
            h = h.next;
            head = head.next;
            h.next = null;
            step--;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode res = rotateRight(node1, 2);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

}
