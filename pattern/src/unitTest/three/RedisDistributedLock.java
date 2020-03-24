package unitTest.three;

/**
 * @author louis.yu
 */
public class RedisDistributedLock {

    private RedisDistributedLock(){}

    static class Holder{
        private static final RedisDistributedLock instance = new RedisDistributedLock();
    }

    public static RedisDistributedLock getSingletonIntance() {
        return RedisDistributedLock.Holder.instance;
    }

    public boolean lockTransction(String id) {
        return true;
    }

    public boolean unlockTransction(String id) {
        return true;
    }
}
