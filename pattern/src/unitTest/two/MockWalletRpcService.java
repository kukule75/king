package unitTest.two;

import unitTest.Transaction;
import unitTest.WalletRpcService;

/**
 * @author louis.yu
 */
public class MockWalletRpcService extends WalletRpcService {

    public String trans(Transaction transaction){

        return "121212";
    }
}
