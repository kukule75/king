package king.service.impl;

import king.dao.OneDao;
import king.model.po.One;
import king.service.OneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YuXiaodan
 * @ClassName OneServiceImpl
 * @Description
 * @date 2019年06月16日 2019/6/16
 */
@Service
public class OneServiceImpl implements OneService {

	@Autowired
	private OneDao oneDao;

	@Transactional
	@Override
	public void update() {

		oneDao.update();
	}

	@Override
	public void save() {

		One one = new One();
//		one.setId(1);

		oneDao.save(one);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void saveRequired() {

		One one = new One();
//		one.setId(1);

		oneDao.save(one);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void saveRequiredException() {

		One one = new One();
//		one.setId(1);

		oneDao.save(one);

		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void saveRequiredNew() {

		One one = new One();
//		one.setId(1);

		oneDao.save(one);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void saveRequiredNewException() {

		One one = new One();
//		one.setId(1);

		oneDao.save(one);

		throw new RuntimeException();
	}

	@Transactional(propagation = Propagation.NESTED)
	@Override
	public void saveNested() {

		One one = new One();
//		one.setId(1);

		oneDao.save(one);
	}

	@Transactional(propagation = Propagation.NESTED)
	@Override
	public void saveNestedException() {

		One one = new One();
//		one.setId(1);

		oneDao.save(one);

		throw new RuntimeException();
	}
}
