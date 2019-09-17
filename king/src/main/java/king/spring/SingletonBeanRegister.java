package king.spring;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;

/**
 * @author YuXiaodan
 * @ClassName SingletonBeanRegister
 * @Description
 * @date 2017年09月27日 2017/9/27
 */
public class SingletonBeanRegister implements SingletonBeanRegistry{

	private final HashMap<String, Object> BEANS = new HashMap<>();

	@Override
	public void registerSingleton(String beanName, Object singletonObject) {

		if (BEANS.containsKey(beanName)) {
			throw new RuntimeException("bean 已经存在");
		}

		BEANS.put(beanName, singletonObject);
	}

	@Override
	public Object getSingleton(String beanName) {

		return BEANS.get(beanName);
	}

	@Override
	public boolean containsSingleton(String beanName) {
		return BEANS.containsKey(beanName);
	}

	@Override
	public String[] getSingletonNames() {
		return BEANS.keySet().toArray(new String[0]);
	}

	@Override
	public int getSingletonCount() {
		return BEANS.size();
	}

	@Override
	public Object getSingletonMutex() {
		return null;
	}
}
