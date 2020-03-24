package unitTest;

import java.math.BigDecimal;

/**
 * @author louis.yu
 */
public class Transaction {

    private String id;
    private Long buyerId;
    private Long sellerId;
    private Long productId;
    private String orderId;
    private Long createTimestamp;//订单创建时间
    private BigDecimal amount;
    private String walletTransactionId;

    public String getId() {
        return id;
    }

    public Long getCreateTimestamp() {
        return createTimestamp;
    }

    // 破坏封装性、和接口隔离原则
//    public void setCreateTimestamp(Long createTimestamp) {
//        this.createTimestamp = createTimestamp;
//    }

    public boolean isExpired() {
        return System.currentTimeMillis() - this.createTimestamp > 14;
    }
}
