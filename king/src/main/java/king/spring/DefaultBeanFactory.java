package king.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author YuXiaodan
 * @ClassName DefaultBeanFactory
 * @Description
 * @date 2017年09月28日 2017/9/28
 */
public class DefaultBeanFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultBeanFactory.class);

	private static final BeanDefinitionRegister BEAN_DEFINITION_REGISTER = new BeanDefinitionRegister();

	private static final SingletonBeanRegister SINGLETON_BEAN_REGISTER = new SingletonBeanRegister();


	public Object getBean(String beanName) {

		if (!BEAN_DEFINITION_REGISTER.containsBeanDefinition(beanName)) {
			throw new RuntimeException("没有找到beanDefinition");
		}
		BeanDefinition beanDefinition = BEAN_DEFINITION_REGISTER.getBeanDefinition(beanName);

		if (beanDefinition.getScope() == BeanDefinition.SCOPE_SINGLETON) {
			if (!SINGLETON_BEAN_REGISTER.containsSingleton(beanName)) {
				Object object = createBean(beanDefinition);
				SINGLETON_BEAN_REGISTER.registerSingleton(beanName, object);
			}

			return SINGLETON_BEAN_REGISTER.getSingleton(beanName);
		}
		if (beanDefinition.getScope() == BeanDefinition.SCOPE_PROTOTYPE) {
			return createBean(beanDefinition);
		}


		throw new RuntimeException("error ...");
	}

	public void registerBeanDefinition(BeanDefinition beanDefinition) {
		BEAN_DEFINITION_REGISTER.registerBeanDefinition(beanDefinition.getId(), beanDefinition);
	}

	private Object createBean(BeanDefinition beanDefinition) {

		try {
			Class clazz = Class.forName(beanDefinition.getClazz());
			return clazz.getConstructor().newInstance();
		} catch (ClassNotFoundException ex){
			throw new RuntimeException("没有找到bean类");
		} catch (Exception e) {
			throw new RuntimeException("error");
		}
	}
}
