package strategy.impl;

import strategy.Strategy;
import strategy.UserType;

import java.math.BigDecimal;

/**
 * @author kinden
 */
public class GoldStrategy implements Strategy {

    @Override
    public BigDecimal discount(BigDecimal value) {

        System.out.println("黄金会员 8折");

        return value.multiply(new BigDecimal("0.8"));
    }

    @Override
    public int getType() {

        return UserType.GOLD_VIP.getCode();
    }
}
