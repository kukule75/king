package unitTest.two;

import org.springframework.stereotype.Component;
import unitTest.three.RedisDistributedLock;
import unitTest.Transaction;
import unitTest.WalletRpcService;

/**
 * @author louis.yu
 */
@Component
public class TranBiz2 {

    private WalletRpcService walletRpcService;

    public void setWalletRpcService(WalletRpcService walletRpcService) {
        this.walletRpcService = walletRpcService;
    }

    public boolean execute(Transaction transaction) {

        // 1.交易元素校验...

        boolean isLocked = false;
        try {
            // 2.获取分布式锁
            isLocked = RedisDistributedLock.getSingletonIntance().lockTransction(transaction.getId());
            if (!isLocked) {
                return false;
            }

            // 3.订单是否超时
            if (System.currentTimeMillis() - transaction.getCreateTimestamp() > 14) {
                // 更新订单状态...
                return false;
            }

            // 4.执行转账
            String walletTransactionId = walletRpcService.trans(transaction);

            // 更新订单等逻辑...

            return true;
        } finally {
            if (isLocked) {
                RedisDistributedLock.getSingletonIntance().unlockTransction(transaction.getId());
            }
        }
    }
}
