package king.service;

import king.BaseJunit4Test;
import king.biz.TransactionalBiz;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.concurrent.*;

/**
 * @author YuXiaodan
 * @ClassName TransactionalTest
 * @Description
 * @date 2019年08月02日 2019/8/2
 */
public class TransactionalTest extends BaseJunit4Test {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImplTest.class);

	@Autowired
	private AccountService accountService;
	@Autowired
	private OneService oneService;
	@Autowired
	private TransactionalBiz transactionalBiz;

	@Transactional(propagation = Propagation.REQUIRED)
	@Test
	public void transactional0() {

//		accountService.saveRequired();

		oneService.save();
	}


	@Test
	public void transactional1() {

		transactionalBiz.transactional1();
	}

	@Test
	public void transactional2() {

		transactionalBiz.transactional2();

	}

	@Test
	public void transactional3() {

		transactionalBiz.transactional3();

	}

	@Test
	public void transactional4() {

		transactionalBiz.transactional4();

	}

	@Test
	public void transactional5() {

		transactionalBiz.transactional5();

	}

	@Test
	public void transactional6() {

		transactionalBiz.transactional6();

	}

	@Test
	public void transactional7() {

		transactionalBiz.transactional7();

	}

	@Test
	public void transactional8() {

		transactionalBiz.transactional8();

	}

	@Test
	public void transactional9() {

		transactionalBiz.transactional9();

	}

	@Test
	public void test() {
	}

	public static void main(String[] args) throws InterruptedException {

		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.shutdown();
		executorService.execute(() -> {
			String name = Thread.currentThread().getName();
			System.out.println(name);
		});

		HashMap<String, String> map = new HashMap<>();
		map.put(null, "aaaa");

	}


}
