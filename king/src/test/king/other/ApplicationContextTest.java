package king.other;

import king.BaseJunit4Test;
import king.bean.ListBean;
import king.bean.MyBean;
import king.bean.depends.DependentBean;
import king.service.HelloService;
import king.service.KingService;
import king.service.impl.*;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author YuXiaodan
 * @ClassName ApplicationContextTest
 * @Description
 * @date 2017年09月22日 2017/9/22
 */
public class ApplicationContextTest{


	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContextTest.class);

	@Test
	public void debugTest() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/spring-test.xml");
//		KingService kingService1 = (KingService)applicationContext.getBean("kingService1");
		KingService kingService2 = (KingService)applicationContext.getBean("a");

	}

	/**
	 * 测试构造器初始化bean
	 * 1.构造器实例化bean
	 * 2.静态工厂方法实例化bean
	 */
	@Test
	public void test1() {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/spring-test.xml");

		KingService kingService1 = applicationContext.getBean("kingService1", KingServiceImpl.class);

		kingService1.sayHello();

		KingService kingService2 = applicationContext.getBean("kingService2", KingServiceImpl.class);

		kingService2.sayHello();

		KingService kingService3 = applicationContext.getBean("bean1", KingServiceImpl.class);

		kingService3.sayHello();
	}

	/**
	 * 测试bean依赖注入
	 * 1.构造器注入
	 * 2.setter注入
	 * 3.方法注入
	 */
	@Test
	public void test2() {

		/**
		 * 构造器注入
		 */
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/spring-test.xml");

		KingService kingService1 = applicationContext.getBean("bean2", King2ServiceImpl.class);
		kingService1.sayHello();

		KingService kingService2 = applicationContext.getBean("bean3", King2ServiceImpl.class);
		kingService2.sayHello();

		KingService kingService3 = applicationContext.getBean("bean4", King2ServiceImpl.class);
		kingService3.sayHello();

		/**
		 * 静态工厂注入
		 */
		KingService byIndex = applicationContext.getBean("byIndex", King2ServiceImpl.class);
		kingService1.sayHello();

		KingService byType = applicationContext.getBean("byType", King2ServiceImpl.class);
		kingService2.sayHello();

		KingService byName = applicationContext.getBean("byName", King2ServiceImpl.class);
		kingService3.sayHello();

		/**
		 * setter注入
		 */
		KingService bySet = applicationContext.getBean("bySet", King3ServiceImpl.class);
		bySet.sayHello();

		ListBean listBean = applicationContext.getBean("listBean", ListBean.class);

		LOGGER.info("size listBean is {}", listBean.getList().size());


		/**
		 * 装饰者模式解释bean注入
		 */
		KingService decorator1 = applicationContext.getBean("decoratorBean1", KingServiceDecoratorImpl.class);
		decorator1.sayHello();

		KingService decorator2 = applicationContext.getBean("decoratorBean2", KingServiceDecoratorImpl.class);
		decorator2.sayHello();

	}


	/**
	 * bean循环依赖测试
	 */
	@Test
//			(expected = BeanCurrentlyInCreationException.class)
	public void test3() {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/spring-test.xml");

//		applicationContext.getBean("circleC");

//		try {
//			ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/spring-test.xml");
//		} catch (BeansException e) {
//			e.printStackTrace();
//		}

	}

	/**
	 * depents-on init destroy
	 */
	@Test
	public void test4() {

		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/spring-test.xml");
		applicationContext.registerShutdownHook();
		DependentBean dependentBean = applicationContext.getBean("dependentBean", DependentBean.class);

		try {
			dependentBean.write("test for dependent bean ...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test5() {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/spring-test.xml");

		KingService kingService = applicationContext.getBean("kingServiceDecorator", KingServiceDecoratorImpl.class);
		kingService.sayHello();
	}

	@Test
	public void aopTest() {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/spring-aop-test.xml");

		HelloService helloService = applicationContext.getBean("helloService", HelloServiceImpl.class);

		helloService.test();

//		helloService.hello("aaaa");
	}

	@Test
	public void inter() {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/spring-test.xml");

		MyBean myBean = (MyBean)applicationContext.getBean("myBean");

//		myBean.doSomething();
	}
}
