package strategy.impl;

import strategy.Strategy;
import strategy.UserType;

import java.math.BigDecimal;

/**
 * @author kinden
 */
public class SilverStrategy implements Strategy {

    @Override
    public BigDecimal discount(BigDecimal value) {

        System.out.println("白银会员优惠50元");

        return value.subtract(new BigDecimal("50"));
    }

    @Override
    public int getType() {

        return UserType.SILVER_VI.getCode();
    }
}
