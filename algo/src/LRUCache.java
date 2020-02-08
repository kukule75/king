import list.DListNode;

import java.util.Hashtable;

/**
 * @author kinden
 *
 * 最近访问的节点如在链表的尾部
 * 如果满容，删除链表头结点
 */
public class LRUCache {

    private DListNode head;

    private DListNode tail;

    private int capacity;

    private int count;

    private Hashtable<Integer, DListNode> hashtable = new Hashtable<>();

    public LRUCache(int capacity) {

        head = new DListNode(-1, -1);
        tail = new DListNode(-1, -1);
        head.pre = null;
        head.next = tail;
        tail.pre = head;
        tail.next = null;
        this.capacity = capacity;
        this.count = 0;
    }

    public int get(int key) {

        DListNode e = hashtable.get(key);
        if (e == null) {
            return -1;
        }

        // 移动到最尾端
        if (e.next != tail) {
            // 断开当前链表
            e.pre.next = e.next;
            e.next.pre = e.pre;
            // 放入尾端
            e.pre = tail.pre;
            tail.pre.next = e;
            tail.pre = e;
            e.next = tail;
        }

        return e.val;
    }

    public void put(int key, int value) {

        DListNode e = hashtable.get(key);

        if (e != null) {
            e.val = value;
            // 断开当前链表
            e.pre.next = e.next;
            e.next.pre = e.pre;
            // 放入尾端
            e.pre = tail.pre;
            tail.pre.next = e;
            tail.pre = e;
            e.next = tail;
            return;
        }

        // 缓存满容，删除hash表元素，删除头结点，元素个数-1
        if (count >= capacity) {
            hashtable.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
            count--;
        }

        // 创建节点
        e = new DListNode(key, value);

        // 放入hash表
        hashtable.put(key, e);
        // 放到链表最尾端
        e.pre = tail.pre;
        tail.pre.next = e;
        tail.pre = e;
        e.next = tail;
        // 缓存中元素个数加1
        count++;
    }

    public static void main(String[] args) {
//        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // 返回  1
//        cache.put(3, 3);    // 该操作会使得密钥 2 作废
//
//        System.out.println(cache.get(2));       // 返回 -1 (未找到)
//        cache.put(4, 4);    // 该操作会使得密钥 1 作废
//        System.out.println(cache.get(1));       // 返回 -1 (未找到)
//        System.out.println(cache.get(3));       // 返回  3
//        System.out.println(cache.get(4));       // 返回  4


//        LRUCache cache = new LRUCache( 1 /* 缓存容量 */ );
//
//        cache.put(2, 1);
//        System.out.println(cache.get(2));       // 返回  1
//        cache.put(3, 2);    // 该操作会使得密钥 2 作废
//        System.out.println(cache.get(2));       // 返回 -1 (未找到)
//        System.out.println(cache.get(3));       // 返回 2

        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
        System.out.println(cache.get(2));       // 返回  -1
        cache.put(2, 6);
        System.out.println(cache.get(1));       // 返回  -1
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));       // 返回 2
        System.out.println(cache.get(2));       // 返回 6


    }
}
