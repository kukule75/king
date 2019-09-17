package kinden.spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author YuXiaodan
 * @ClassName Account
 * @Description
 * @date 2019年09月16日 2019/9/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account implements Serializable {
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

    private Long statusCode;

    private String accType;

    private String dcFlag;

    private String minusFlag;

    private BigDecimal minusAmount;

    private BigDecimal totalMinusAmount;

    private String currency;

    private Date createTime;

    private Date updateTime;

    private Integer version;

    private static final long serialVersionUID = 1L;

    public Account debit(BigDecimal amount) {

        checkAccountCanDebit(amount);
        this.balance = this.balance.subtract(amount);

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
}