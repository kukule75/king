package unitTest.two;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import unitTest.Transaction;

/**
 * @author louis.yu
 */
public class TranBiz2Test {

    @Autowired
    private TranBiz2 tranBiz2;

    @Test
    public void execute() {

        Transaction transaction = new Transaction();
        tranBiz2.setWalletRpcService(new MockWalletRpcService());
        boolean result = tranBiz2.execute(transaction);

        Assert.assertTrue(result);
    }
}