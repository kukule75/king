package king.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author YuXiaodan
 * @ClassName MyBean
 * @Description
 * @date 2017年11月29日 2017/11/29
 */
@Component
public class MyBean implements
//		InitializingBean, BeanPostProcessor {
		InitializingBean,DisposableBean{

	private static final Logger LOGGER = LoggerFactory.getLogger(MyBean.class);


//	public MyBean() {
//		System.out.println("MyBean construct...");
//	}

	@PostConstruct
	public void postConstruct() {
//		LOGGER.info("postConstruct ...");
		System.out.println("postConstruct ...");
	}

	@PreDestroy
	public void preDestroy()  {
		System.out.println("执行InitAndDestroySeqBean: preDestroy");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet ...");
	}

	public void init() {
		System.out.println("init ...");
	}

	public void doSomething() {
		System.out.println("doSomething ...");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy ...");
	}

//	@Override
//	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		System.out.println("postProcessBeforeInitialization ...");
//		return bean;
//	}
//
//	@Override
//	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//		System.out.println("postProcessAfterInitialization ...");
//		return bean;
//	}
}
