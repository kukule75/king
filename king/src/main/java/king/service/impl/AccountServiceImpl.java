package king.service.impl;

import king.dao.AccountDao;
import king.model.po.Account;
import king.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @author YuXiaodan
 * @ClassName AccountServiceImpl
 * @Description
 * @date 2017年11月27日 2017/11/27
 */
@Service
public class AccountServiceImpl implements AccountService{

	private static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountDao accountDao;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void saveRequired() {

		Account account = new Account();
		account.setAccCode(100101);
		account.setAccNo("as12");
		account.setUserId(100L);
		account.setStatus("1000");
		account.setStatusCode(1);
		account.setAccType("1");
		account.setDcFlag("D");
		account.setMinusFlag(1);

		accountDao.save(account);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void saveRequiredNew() {

		Account account = new Account();
		account.setAccCode(100101);
		account.setAccNo("as12");
		account.setUserId(100L);
		account.setStatus("1000");
		account.setStatusCode(1);
		account.setAccType("1");
		account.setDcFlag("D");
		account.setMinusFlag(1);

		accountDao.save(account);
	}

	@Transactional(propagation = Propagation.NESTED)
	@Override
	public void saveNested() {

		Account account = new Account();
		account.setAccCode(100101);
		account.setAccNo("as12");
		account.setUserId(100L);
		account.setStatus("1000");
		account.setStatusCode(1);
		account.setAccType("1");
		account.setDcFlag("D");
		account.setMinusFlag(1);

		accountDao.save(account);
	}

	@Override
	public void query(long id) {


		long startA = System.nanoTime();

		Account account = accountDao.findById(id);
//		account.debit(new BigDecimal(1));
//		accountDao.update(account);

		long endA = System.nanoTime();

		logger.info("first time is {}, account is {}", (endA - startA)/1000000, account.toString());

		long startB = System.nanoTime();

		Account account1 = accountDao.findById(id);

		long endB = System.nanoTime();

		logger.info("second time is {}, account is {}", (endB - startB)/1000000, account1.toString());
	}

//	@Transactional
	@Override
	public void insert(Account account) {

		accountDao.save(account);

//		throw new RuntimeException();
	}

	public void testInnodbRollbackOnTimeout(Account account) {
		accountDao.save(account);
	}
}
