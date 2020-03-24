package unitTest.three;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import unitTest.Transaction;
import unitTest.two.MockWalletRpcService;

/**
 * @author louis.yu
 */
public class TransBiz3Test {

    @Autowired
    private TransBiz3 transBiz3;

    @Test
    public void execute() {

        Transaction transaction = new Transaction();
//        transaction.setCreateTimestamp(10L);
        TransactionLock lock = new TransactionLock(){
            public boolean lock(String id) {
                return true;
            }
        };

        transBiz3.setWalletRpcService(new MockWalletRpcService());
        transBiz3.setTransactionLock(lock);
        boolean result = transBiz3.execute(transaction);

        Assert.assertTrue(result);
    }
}