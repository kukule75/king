package list;

/**
 * @author kinden
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);

        node4.next = node5;
        node5.next = node6;

//        ListNode res = mergeTwoLists(node1, node4);

        ListNode res = mergeTwoListsRecurse(node1, node4);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }


    // 递归
    public static ListNode mergeTwoListsRecurse(ListNode l1, ListNode l2) {

//        return recurse(l1, l2);
        return recurseA(l1, l2);
    }

    // 适合长度不一致的
    public static ListNode recurseA(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = recurseA(l1.next, l2);
            return l1;
        } else {
            l2.next = recurseA(l2.next, l1);
            return l2;
        }
    }

    // 链表长度相同的情况可以使用这种方式
    public static ListNode recurse(ListNode l1, ListNode l2) {

        if (l1 == null || l2 == null) {
            return null;
        }

        ListNode tail;
        ListNode head;
        ListNode ll1 = l1.next;
        ListNode ll2 = l2.next;
        if (l1.val >= l2.val) {
            l2.next = l1;
            tail = l1;
            head = l2;
        } else {
            l1.next = l2;
            tail = l2;
            head = l1;
        }

        ListNode e = recurse(ll1, ll2);
        tail.next = e;

        return head;
    }

    // 指针比较法
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode p = new ListNode(0);// 新链表当前指针
        ListNode nhead = p;
        ListNode p1 = l1;// l1链表移动指针
        ListNode p2 = l2;// l2链表移动指针

        while (p1 != null && p2 != null) {
            ListNode e;
            if (p2.val >= p1.val) {
                e = p1;
                p1 = p1.next;
            } else {
                e = p2;
                p2 = p2.next;
            }

            p.next = e;
            p = e;
        }

        if (p1 == null) {
            p.next = p2;
        } else if (p2 == null) {
            p.next = p1;
        }

        return nhead.next;

    }
}
