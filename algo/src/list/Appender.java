package list;

/**
 * @author kinden
 */
public class Appender {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);

        append(node1, 2);

        ListNode e = node1;
        while (e != null) {
            System.out.println(e.val);
            e = e.next;
        }

    }

    private static void append(ListNode node, int var) {

        if (node == null) {
            return;
        }

        ListNode e = new ListNode(var);

        ListNode p = node;

        while (p.next != null) {
            p = p.next;
        }

        p.next = e;
    }
}
