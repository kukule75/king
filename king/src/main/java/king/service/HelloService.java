package king.service;

import java.math.BigDecimal;

/**
 * @author YuXiaodan
 * @ClassName Hello
 * @Description
 * @date 2017年09月14日 2017/9/14
 */
public interface HelloService {

	void debit(BigDecimal amount);

	String hello(String name);

	boolean doTrans(Long userId, BigDecimal amount);

	void doTransA(Long userId, BigDecimal amount);

	void test();
}
