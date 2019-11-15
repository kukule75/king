package list;

/**
 * @author kinden
 *
 * 反转一个单链表。
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseList {

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

        ListNode res = reverseListB(node1);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }


    /**
     * 换头法
     * 1->2->3->4->5
     * 2->1->3->4->5
     * 3->2->1->4->5
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode fh = head;
        ListNode nh = head;
        ListNode p = fh.next;
        while (p != null) {
            fh.next = p.next;
            p.next = nh;
            nh = p;
            p = fh.next;
        }

        return nh;
    }

    /**
     * 原地倒转法
     * 1->2->3->4->5
     * 1<-2->3->4->5
     * 1<-2<-3->4->5
     * 1<-2<-3<-4->5
     * 1<-2<-3->4<-5
     *
     * @param head
     * @return
     */
    public static ListNode reverseListA(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    /**
     * 原地倒转法
     * 1->2->3->4->5
     * 1<-2->3->4->5
     * 1<-2<-3->4->5
     * 1<-2<-3<-4->5
     * 1<-2<-3->4<-5
     *
     * @param head
     * @return
     */
    public static ListNode reverseListB(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode e = cur.next;
            cur.next = pre;
            pre = cur;
            cur = e;
        }

        return pre;
    }
}
