package king.service.impl;

import king.dao.AccountDao;
import king.dao.OneDao;
import king.model.po.Account;
import king.service.HelloService;
import king.service.OneService;
import king.tx.MyTransactionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;

/**
 * @author YuXiaodan
 * @ClassName HelloImpl
 * @Description
 * @date 2017年09月14日 2017/9/14
 */
@Service
public class HelloServiceImpl implements HelloService {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

	@Autowired
	private DataSourceTransactionManager transactionManager;

	@Autowired
	private TransactionTemplate transactionTemplate;

	@Autowired
	private AccountDao accountDao;
	@Autowired
	private OneDao oneDao;

	@Autowired
	private MyTransactionTemplate myTransactionTemplate;

	@Autowired
	private OneService oneService;

	@Transactional
	@Override
	public void test() {

		Account account = accountDao.findByAccNo("as12");
		account.debit(new BigDecimal(1));
		accountDao.update(account);

		oneService.update();
	}

	@Transactional
	@Override
	public void debit(BigDecimal amount) {

		Account account = accountDao.findByAccNo("as12");
		account.debit(amount);
		accountDao.update(account);

		LOGGER.info("accountDao update over...");

//		account.debit(amount);
//		accountDao.update(account);

		oneDao.update();

		LOGGER.info("oneDao update over...");
	}

	@Override
	public String hello(String name) {

		LOGGER.info("HelloService say: hello {}", name);

		return "hello " + name;
	}

	//演示编程事务
	@Override
	public boolean doTrans(Long userId, BigDecimal amount) {

		DefaultTransactionDefinition txDef = new DefaultTransactionDefinition();

		TransactionStatus txStatus = transactionManager.getTransaction(txDef);

		try {
			Account account = accountDao.findByUIdAndCode(userId, 100101);
			if (account != null) {
				account.debit(amount);
				accountDao.update(account);
				transactionManager.commit(txStatus);
				LOGGER.info("transaction commit ...");
			}
			return true;
		} catch (Exception e) {
			transactionManager.rollback(txStatus);
			LOGGER.info("transaction rollback ...");
			return false;
		}
	}

	@Override
	public void doTransA(Long userId, BigDecimal amount) {

		Account account = accountDao.findByUIdAndCode(userId, 100101);
		
//		transactionTemplate.execute((TransactionCallback<Object>) transactionStatus -> {
//
//			try {
//				if (account != null) {
//					account.debit(amount);
//					accountDao.update(account);
//					LOGGER.info("transaction commit ...");
//				}
//			} catch (Exception e) {
//				LOGGER.info("transaction rollback ...");
//				transactionStatus.setRollbackOnly();
//			}
//
//			return true;
//		});

		myTransactionTemplate.execute(transactionStatus -> {

			try {
				if (account != null) {
					account.debit(amount);
					accountDao.update(account);
					LOGGER.info("transaction commit ...");
				}
			} catch (Exception e) {
				LOGGER.info("transaction rollback ...");
				transactionStatus.setRollbackOnly();
			}

			return true;
		});
	}


}
