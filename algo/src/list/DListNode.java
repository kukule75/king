package list;

/**
 * @author kinden
 *
 * 双向链表节点
 */
public class DListNode {

    public DListNode pre;
    public DListNode next;
    public int key;
    public int val;

    public DListNode(int key, int val) {
        this.key = key;
        this.val = val;
        pre = null;
        next = null;
    }
}
