package king.model.po;

import king.model.BaseEntity;

import java.math.BigDecimal;


/**
 * @author YuXiaoDan
 * @ClassName Account
 * @Description G2账户实体
 * @date 2017/4/15 上午10:37
 */
public class Account extends BaseEntity {

    private Long id;

    private String accNo;

    private Integer accCode;

    private Long userId;

    private BigDecimal balance;

    private BigDecimal freezeAmount;

    private String sign;

    private BigDecimal maxBalance;

    private BigDecimal minBalance;

    private String status;

    private Integer statusCode;

    private String accType;

    private String dcFlag;

    /**余额是否允许负数，1-允许，0-不允许*/
    private Integer minusFlag;

    private BigDecimal minusAmount;

    private BigDecimal totalMinusAmount;

    private String currency;

    public Account debit(BigDecimal amount) {

//        if (isAsynCredit()) {
//            return this;
//        }
//        validateSign();
        checkAccountCanDebit(amount);
        this.balance = this.balance.subtract(amount);
//        generateSign();

        return this;
    }

    private void checkAccountCanDebit(BigDecimal amount) {

        if (this.availableBalanceIsEnough(amount)) {
            throw new RuntimeException("不能扣款");
        }
    }

    private boolean availableBalanceIsEnough(BigDecimal amount) {

        BigDecimal diff = this.getAvailableBalance().subtract(amount);
        if (diff.compareTo(BigDecimal.ZERO) >= 0)
            return false;
        return true;
    }

    public BigDecimal getAvailableBalance() {
        return this.balance.subtract(this.freezeAmount);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public Integer getAccCode() {
        return accCode;
    }

    public void setAccCode(Integer accCode) {
        this.accCode = accCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getFreezeAmount() {
        return freezeAmount;
    }

    public void setFreezeAmount(BigDecimal freezeAmount) {
        this.freezeAmount = freezeAmount;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public BigDecimal getMaxBalance() {
        return maxBalance;
    }

    public void setMaxBalance(BigDecimal maxBalance) {
        this.maxBalance = maxBalance;
    }

    public BigDecimal getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(BigDecimal minBalance) {
        this.minBalance = minBalance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getDcFlag() {
        return dcFlag;
    }

    public void setDcFlag(String dcFlag) {
        this.dcFlag = dcFlag;
    }

    public Integer getMinusFlag() {
        return minusFlag;
    }

    public void setMinusFlag(Integer minusFlag) {
        this.minusFlag = minusFlag;
    }

    public BigDecimal getMinusAmount() {
        return minusAmount;
    }

    public void setMinusAmount(BigDecimal minusAmount) {
        this.minusAmount = minusAmount;
    }

    public BigDecimal getTotalMinusAmount() {
        return totalMinusAmount;
    }

    public void setTotalMinusAmount(BigDecimal totalMinusAmount) {
        this.totalMinusAmount = totalMinusAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accNo='" + accNo + '\'' +
                ", accCode=" + accCode +
                ", userId=" + userId +
                ", balance=" + balance +
                ", freezeAmount=" + freezeAmount +
                ", sign='" + sign + '\'' +
                ", maxBalance=" + maxBalance +
                ", minBalance=" + minBalance +
                ", status='" + status + '\'' +
                ", statusCode=" + statusCode +
                ", accType='" + accType + '\'' +
                ", dcFlag='" + dcFlag + '\'' +
                ", minusFlag=" + minusFlag +
                ", minusAmount=" + minusAmount +
                ", totalMinusAmount=" + totalMinusAmount +
                ", currency='" + currency + '\'' +
                '}';
    }
}