package king.other;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author YuXiaodan
 * @ClassName AopTest
 * @Description
 * @date 2017年09月30日 2017/9/30
 */
public class AopTest {

	@Test
	public void A() {

		float a = 0.01F;
		float b = 0.06F;

		float result0 = a + b;

		double c = 0.01;
		double d = 0.06;

		double result3 = c + d;

		BigDecimal e = new BigDecimal("0.01");
		BigDecimal f = new BigDecimal("0.06");

		BigDecimal result1 = e.add(f);

		BigDecimal g = new BigDecimal(0.01);
		BigDecimal h = new BigDecimal(0.06);

		BigDecimal result2 = g.add(h);
	}

	@Test
	public void B() {

		BigDecimal a = new BigDecimal("0.01");
		BigDecimal b = new BigDecimal("0.02");
		a.add(b);

		BigDecimal amount = new BigDecimal("0.02120001");
		String str1 = amount.toString();
		String str2 = amount.toPlainString();
		String str3 = amount.toEngineeringString();


		BigDecimal c = new BigDecimal("0.01");
		BigDecimal d = new BigDecimal("0.010");
		BigDecimal e = new BigDecimal("0.01");
		System.out.println(c.compareTo(d) == 0);
		System.out.println(c.equals(d));
		System.out.println(c.equals(e));

	}

}
