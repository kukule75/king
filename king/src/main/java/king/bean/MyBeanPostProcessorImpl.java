package king.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author YuXiaodan
 * @ClassName BeanPostProcessorImpl
 * @Description
 * @date 2018年09月13日 2018/9/13
 */
public class MyBeanPostProcessorImpl implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
		System.out.println("postProcessBeforeInitialization ...");
		return o;
	}

	@Override
	public Object postProcessAfterInitialization(Object o, String s) throws BeansException {

		System.out.println("postProcessAfterInitialization ...");
		return o;
	}
}
