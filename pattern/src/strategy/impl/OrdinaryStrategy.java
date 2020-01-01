package strategy.impl;

import strategy.Strategy;
import strategy.UserType;

import java.math.BigDecimal;

/**
 * @author kinden
 */
public class OrdinaryStrategy implements Strategy {

    @Override
    public BigDecimal discount(BigDecimal value) {

        System.out.println("普通会员不打折");
        return value;
    }

    @Override
    public int getType() {

        return UserType.ORDINARY_VIP.getCode();
    }
}
