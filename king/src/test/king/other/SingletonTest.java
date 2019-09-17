package king.other;

import king.service.impl.HelloServiceImpl;
import king.spring.BeanDefinition;
import king.spring.DefaultBeanFactory;
import king.spring.SingletonClassLoader;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author YuXiaodan
 * @ClassName SingletonTest
 * @Description
 * @date 2017年09月27日 2017/9/27
 */
public class SingletonTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SingletonTest.class);

	@Test
	public void test() throws Exception {
		ClassLoader classLoader = new SingletonClassLoader();
		Class clazz = classLoader.loadClass("king.other.SingletonG");
		Method method = clazz.getDeclaredMethod("getInstance");
		Object singletonObject = method.invoke(clazz);
		Field counterField = clazz.getDeclaredField("counter");
		counterField.setAccessible(true);
		Integer counter = counterField.getInt(singletonObject);
		counterField.set(singletonObject, counter + 1);
		Assert.assertEquals(1, counterField.get(singletonObject));

	}

	@Test
	public void singletonBean() {

		DefaultBeanFactory defaultBeanFactory = new DefaultBeanFactory();
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
		beanDefinition.setId("bean");
		beanDefinition.setClazz(HelloServiceImpl.class.getName());
		defaultBeanFactory.registerBeanDefinition(beanDefinition);

		LOGGER.info(".... {}", defaultBeanFactory.getBean("bean") == defaultBeanFactory.getBean("bean"));
	}
}
