package king.service;

import king.BaseJunit4Test;
import king.model.po.Account;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author YuXiaodan
 * @ClassName AccountServiceImplTest
 * @Description
 * @date 2017年11月27日 2017/11/27
 */
public class AccountServiceImplTest extends BaseJunit4Test{

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImplTest.class);

	@Autowired
	private AccountService accountService;
	@Autowired
	private HelloService helloService;

	private static AtomicInteger seq = new AtomicInteger(0);

	@Transactional
	@Test
	public void testInnodbRollbackOnTimeout() {

//		Account account = new Account();
//		account.setAccCode(100101);
//		account.setAccNo("as12");
//		account.setUserId(100L);
//		account.setStatus("1000");
//		account.setStatusCode(1);
//		account.setAccType("1");
//		account.setDcFlag("D");
//		account.setMinusFlag(1);
//		accountService.insert(account);

		helloService.debit(new BigDecimal(1));
	}

	@Transactional(timeout = 2)
	@Test
	public void debitA() throws InterruptedException {

		helloService.debit(new BigDecimal(1));

		TimeUnit.MILLISECONDS.sleep(3000);
	}

	@Transactional(timeout = 2)
	@Test
	public void debitB() throws InterruptedException {

		TimeUnit.MILLISECONDS.sleep(3000);

		helloService.debit(new BigDecimal(1));

	}

	@Test
	public void test() {

		int nextSeq = seq.incrementAndGet();

		accountService.query(29L);

//		accountService.query(29L);
	}

	@Test
	public void A() {

		Account account = new Account();
		account.setAccCode(100101);
		account.setAccNo("as12");
		account.setUserId(100L);
		account.setStatus("1000");
		account.setStatusCode(1);
		account.setAccType("1");
		account.setDcFlag("D");
		account.setMinusFlag(1);

		long start = System.nanoTime();

		accountService.insert(account);

		long end = System.nanoTime();

		LOGGER.info("cost time is {}", (end - start) / 1000000);
	}
}
