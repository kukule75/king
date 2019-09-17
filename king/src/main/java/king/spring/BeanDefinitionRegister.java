package king.spring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YuXiaodan
 * @ClassName BeanDefinitionRegister
 * @Description
 * @date 2017年09月28日 2017/9/28
 */
public class BeanDefinitionRegister {

	private final Map<String, BeanDefinition> DEFINITIONS = new HashMap<>();

	public void registerBeanDefinition(String beanName, BeanDefinition bd) {

		if (DEFINITIONS.containsKey(bd.getId())) {
			throw new RuntimeException("beanDefinition已经存在");
		}
		DEFINITIONS.put(bd.getId(), bd);
	}

	public BeanDefinition getBeanDefinition(String beanName) {

		return DEFINITIONS.get(beanName);
	}

	public boolean containsBeanDefinition(String beanName) {

		return DEFINITIONS.containsKey(beanName);
	}
}
