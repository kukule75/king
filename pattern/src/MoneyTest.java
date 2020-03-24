import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author louis.yu
 */
public class MoneyTest {

    public static void main(String[] args) {

        BigDecimal value0 = new BigDecimal(0.1);
        BigDecimal value1 = new BigDecimal(0.1D);
        BigDecimal value2 = BigDecimal.valueOf(0.1D);

        BigDecimal value3 = new BigDecimal("0.1");
        BigDecimal value4 = new BigDecimal("0.10");

        System.out.println(value0);
        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3.compareTo(value4));
        System.out.println(value3.equals(value4));


        BigDecimal value5 = new BigDecimal("0.144");
        BigDecimal value7 = new BigDecimal("0.145");
        BigDecimal value6 = new BigDecimal("0.146");

        System.out.println(value5.setScale(2, RoundingMode.HALF_UP));
        System.out.println(value6.setScale(2, RoundingMode.HALF_UP));
        System.out.println(value7.setScale(2, RoundingMode.HALF_UP));

        // 精度位小于5或者大于5都没问题，与四舍五入一致
        System.out.println(value5.setScale(2, RoundingMode.HALF_EVEN));
        System.out.println(value6.setScale(2, RoundingMode.HALF_EVEN));

        // 精度位等于5，分三种种情况

        // 1.精度位后面有非0值，比如0.1451，进位舍去，0.15
        System.out.println(new BigDecimal("0.1451").setScale(2, RoundingMode.HALF_EVEN));
        // 2.精度位后面没有非0值，精度位前面是偶数，比如0.145，直接舍去，0.14
        System.out.println(new BigDecimal("0.145").setScale(2, RoundingMode.HALF_EVEN));
        // 3.精度位后面没有非0值，精度位前面是奇数，比如0.155，进位加1，0.16
        System.out.println(new BigDecimal("0.155").setScale(2, RoundingMode.HALF_EVEN));
    }
}
