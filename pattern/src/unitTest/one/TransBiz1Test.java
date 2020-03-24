package unitTest.one;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import unitTest.Transaction;

/**
 * @author louis.yu
 */
public class TransBiz1Test {

    @Autowired
    private TransBiz1 transBiz1;

    @Test
    public void execute() {

        Transaction transaction = new Transaction();
        boolean result = transBiz1.execute(transaction);

        Assert.assertTrue(result);
    }
}