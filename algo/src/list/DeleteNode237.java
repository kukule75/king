package list;

/**
 * @author kinden
 */
public class DeleteNode237 {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
    }


    // 传入要删除的当前节点，无法定位到之前的pre节点，只能使用替换法
    public static void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
}
