package king;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author YuXiaodan
 * @ClassName BaseJunit4Test
 * @Description
 * @date 2017年09月22日 2017/9/22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/spring/app-bootstrap.xml"})
@Rollback(value = false)
//@ContextConfiguration(locations = {"classpath*:META-INF/mybatis/mybatis.xml",
//		"classpath*:mapper/AccountMapper.xml", "classpath*:META-INF/logback.xml"})
//@Transactional(transactionManager = "transactionManager")
public class BaseJunit4Test {
}
