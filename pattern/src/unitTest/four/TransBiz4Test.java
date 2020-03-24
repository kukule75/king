package unitTest.four;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import unitTest.Transaction;
import unitTest.three.TransactionLock;
import unitTest.two.MockWalletRpcService;

/**
 * @author louis.yu
 */
public class TransBiz4Test {

    @Autowired
    private TransBiz4 transBiz4;

    @Test
    public void execute() {

        Transaction transaction = new Transaction(){
            public boolean isExpired() {
                return false;
            }
        };
        TransactionLock lock = new TransactionLock(){
            public boolean lock(String id) {
                return true;
            }
        };

        transBiz4.setWalletRpcService(new MockWalletRpcService());
        transBiz4.setTransactionLock(lock);
        boolean result = transBiz4.execute(transaction);

        Assert.assertTrue(result);
    }
}