package strategy;

import java.math.BigDecimal;

/**
 * @author kinden
 */
public interface Strategy {

    BigDecimal discount(BigDecimal value);

    int getType();
}
