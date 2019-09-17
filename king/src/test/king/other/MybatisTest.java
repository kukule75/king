package king.other;

import king.BaseJunit4Test;
import king.dao.AccountDao;
import king.model.po.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author YuXiaodan
 * @ClassName MybatisTest
 * @Description
 * @date 2018年07月31日 2018/7/31
 */
public class MybatisTest extends BaseJunit4Test {

	private final static Logger LOGGER = LoggerFactory.getLogger(MybatisTest.class);

	@Test
	public void testA() throws IOException {

		InputStream inputStream = Resources.getResourceAsStream("META-INF/mybatis/mybatis.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = factory.openSession();

//		AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
//
//		Account account1 = accountDao.findByAccNo("as12");
//
//		Account account2 = accountDao.findByAccNo("as12");

		Account account1 = sqlSession.selectOne("king.dao.AccountDao.findByAccNo", "as12");
		Account account2 = sqlSession.selectOne("king.dao.AccountDao.findByAccNo", "as12");

		LOGGER.info("result is {}", account1);
		sqlSession.commit();

		Account account3 = sqlSession.selectOne("king.dao.AccountDao.findByAccNo", "as12");

		LOGGER.info("result is {}", account3);

		SqlSession sqlSession2 = factory.openSession();

		Account account4 = sqlSession2.selectOne("king.dao.AccountDao.findByAccNo", "as12");

		LOGGER.info("result is {}", account4);

		sqlSession.close();
	}

	@Test
	public void testB() throws IOException {

		InputStream inputStream = Resources.getResourceAsStream("META-INF/mybatis/mybatis.xml");

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = factory.openSession();

		Account account = sqlSession.selectOne("king.dao.AccountDao.findByAccNo", "as12");

		LOGGER.info("result is {}", account);
	}
}
