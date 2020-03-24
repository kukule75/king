package unitTest.three;

/**
 * @author louis.yu
 */
public class TransactionLock {

    public boolean lock(String id) {
        return RedisDistributedLock.getSingletonIntance().lockTransction(id);
    }

    public void unlock(String id) {
        RedisDistributedLock.getSingletonIntance().unlockTransction(id);
    }

}
