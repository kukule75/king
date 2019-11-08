package list;

/**
 * @author kinden
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。
 * val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。
 * 假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。
 *  如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *
 * 所有val值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 */
public class MyLinkedList {

    class Node {

        private int var;

        private Node next;

        public Node(int var) {
            this.var = var;
            this.next = null;
        }

    }

    private Node head;

    private Node tail;

    private int count;

    /** Initialize your data structure here. */
    public MyLinkedList() {

        head = new Node(-1);
        tail = head;
        count = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {

        if (index <= 0 || index > count) {
            return -1;
        }

        Node e = head;
        for (int i = 0; i <= index; i++) {
            e = e.next;
        }

        return e.var;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {

        Node node =  new Node(val);
        node.next = head.next;
        head.next = node;
        if (tail == head) {
            tail = node;
        }
        count++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {

        Node node =  new Node(val);
        tail.next = node;
        tail = node;
        count++;
    }

    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     * */
    public void addAtIndex(int index, int val) {

        if (index <= 0 || index > count) {
            return;
        }

        Node a = new Node(val);
        Node e = head;
        for (int i = 1; i <= index; i++) {
            e = e.next;
        }

        a.next = e.next;
        e.next = a;

        count++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {

        if (index <= 0 || index > count) {
            return;
        }

        Node e = head;
        Node pre = e;
        for (int i = 0; i <= index; i++) {
            pre = e;
            e = e.next;
        }

        pre.next = e.next;
        e = null;

        count--;
    }

    private void out() {

        Node e = head;
        while (e != null) {
            System.out.print(e.var);
            e = e.next;
        }

        System.out.println("\n");
    }

    public static void main(String[] args) {

        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.out();
        linkedList.addAtTail(3);
        linkedList.out();
        linkedList.addAtIndex(1, 2);   //链表变为1-> 2-> 3
        linkedList.out();
        System.out.println(linkedList.get(1));//返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.out();
        System.out.println(linkedList.get(1));//返回3
    }
}
