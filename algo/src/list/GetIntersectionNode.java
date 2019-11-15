package list;

/**
 * @author kinden
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，
 * 链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 * 注意：
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class GetIntersectionNode {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode nodeA1 = new ListNode(4);
        ListNode nodeA2 = new ListNode(1);

        ListNode nodeB1 = new ListNode(5);
        ListNode nodeB2 = new ListNode(0);
        ListNode nodeB3 = new ListNode(1);

        ListNode nodeC3 = new ListNode(8);
        ListNode nodeC4 = new ListNode(4);
        ListNode nodeC5 = new ListNode(5);
        nodeC3.next = nodeC4;
        nodeC4.next = nodeC5;
        nodeC5.next = null;

        nodeA1.next = nodeA2;
        nodeA2.next = nodeC3;

        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;
        nodeB3.next = nodeC3;

        ListNode res = getIntersectionNode(nodeA1, nodeB1);

        System.out.println(res == null ? "" : res.val);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
