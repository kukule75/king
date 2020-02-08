package singleton;

/**
 * @author kinden
 *
 * 静态内部类
 * Holder 是一个静态内部类，当外部类 IdGenerator 被加载的时候，
 * 并不会创建 Holder 实例对象。只有当调用 getInstance() 方法时，
 * Holder 才会被加载，这个时候才会创建 instance。insance 的唯一性、创建过程的线程安全性，
 * 都由 JVM 来保证。所以，这种实现方法既保证了线程安全，又能做到延迟加载。
 */
public class IdGeneratorD {

    private IdGeneratorD(){}

    static class Holder{
        private static final IdGeneratorD instance = new IdGeneratorD();
    }

    public static IdGeneratorD getInstance() {
        return Holder.instance;
    }
}
