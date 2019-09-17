package king.biz.impl;

import king.biz.TransactionalBiz;
import king.service.AccountService;
import king.service.OneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YuXiaodan
 * @ClassName TransactionalBizImpl
 * @Description
 * @date 2019年08月02日 2019/8/2
 */
@Component
public class TransactionalBizImpl implements TransactionalBiz {

	@Autowired
	private AccountService accountService;
	@Autowired
	private OneService oneService;

	/**
	 * 内层事务加入外层事务，外层事务抛异常，都回滚
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void transactional1() {

		accountService.saveRequired();//回滚

		oneService.saveRequired();//回滚

		throw new RuntimeException();
	}

	/**
	 * 内层事务加入外层事务，内层事务抛异常，都回滚
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void transactional2() {

		accountService.saveRequired();//回滚

		oneService.save();//回滚

		oneService.saveRequiredException();//回滚
	}

	/**
	 * 内层事务加入外层事务，内层事务抛异常，虽然被catch住，但是都回滚
	 * 为什么？
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void transactional3() {

		accountService.saveRequired();//回滚
		oneService.save();//回滚

		try {
			oneService.saveRequiredException();//回滚
		} catch (Exception e) {
			System.out.println("抛异常");
		}
	}

	/**
	 * requried_new内层事务为独立事务，不会因为外层事务回滚而回滚
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void transactional4() {

		oneService.save();//回滚

		accountService.saveRequiredNew();//不回滚

		oneService.saveRequiredNew();//不回滚

		throw new RuntimeException();
	}

	/**
	 * requried_new内层事务为独立事务，但是内层事务会影响到外层事务的回滚
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void transactional5() {

		oneService.save();//回滚

		accountService.saveRequiredNew();//不回滚

		oneService.saveRequiredNewException();//回滚
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void transactional6() {

		oneService.save();//不回滚

		accountService.saveRequiredNew();//不回滚

		try {
			oneService.saveRequiredNewException();//回滚
		} catch (Exception e) {
			System.out.println("抛异常");
		}
	}

	/**
	 * 外层事务回滚，内层事务也回滚
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void transactional7() {

		oneService.saveNested();//回滚

		accountService.saveNested();//回滚

		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void transactional8() {

		accountService.saveNested();//回滚

		oneService.saveNestedException();//回滚
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void transactional9() {

		accountService.saveNested();//不回滚

		try {
			oneService.saveNestedException();//回滚
		} catch (Exception e) {
			System.out.println("抛异常");
		}
	}
}
