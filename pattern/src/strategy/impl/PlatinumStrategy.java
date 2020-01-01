package strategy.impl;

import strategy.Strategy;
import strategy.UserType;

import java.math.BigDecimal;

/**
 * @author kinden
 */
public class PlatinumStrategy implements Strategy {

    @Override
    public BigDecimal discount(BigDecimal value) {

        System.out.println("白金会员 优惠50元，再打7折");

        return value.subtract(new BigDecimal("50")).multiply(new BigDecimal("0.7"));
    }

    @Override
    public int getType() {

        return UserType.PLATINUM_VIP.getCode();
    }
}
