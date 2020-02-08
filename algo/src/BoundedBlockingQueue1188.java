import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author kinden
 */
public class BoundedBlockingQueue1188 {

    // 数据存贮容器
    private LinkedList<Integer> queue;
    // 容器容量
    private final int capacity;

    private final ReentrantLock lock = new ReentrantLock();

    private final Condition notFull = lock.newCondition();

    private final Condition notEmpty = lock.newCondition();

    public BoundedBlockingQueue1188(int capacity) {

        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {

        try {
            lock.lock();
            while (queue.size() == capacity) {
                notFull.await();
            }
            queue.offerFirst(element);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public int dequeue() throws InterruptedException {

        int e ;
        try {
            lock.lock();
            while (queue.size() == 0) {
                notEmpty.await();
            }
            e = queue.removeLast();
            notFull.signalAll();
        } finally {
            lock.unlock();
        }

        return e;
    }

    public int size() {

        return queue.size();
    }
}
