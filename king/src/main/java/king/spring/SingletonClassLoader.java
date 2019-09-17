package king.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author YuXiaodan
 * @ClassName SingletonClassLoader
 * @Description
 * @date 2017年09月27日 2017/9/27
 */
public class SingletonClassLoader extends ClassLoader{

	private static final Logger LOGGER = LoggerFactory.getLogger(SingletonClassLoader.class);

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {

		try {
			InputStream in = new ClassPathResource(name).getInputStream();
			int available = in.available();
			byte[] bytes = new byte[available];
			in.read(bytes, 0, available);

			return defineClass(name, bytes, 0, available);
		} catch (IOException e) {
			System.out.println(e);
			super.loadClass(name);
		}

		return super.loadClass(name);
	}

	public static void main(String[] args) throws Exception{
		ClassLoader classLoader = new SingletonClassLoader();
		Class clazz = classLoader.loadClass("king.bean.singleton.SingletonE");
		Method method = clazz.getDeclaredMethod("getInstance");
		Object singletonObject = method.invoke(clazz);
		Field counterField = clazz.getDeclaredField("counter");
		counterField.setAccessible(true);
		Integer counter = counterField.getInt(singletonObject);
		counterField.set(singletonObject, counter + 1);
		LOGGER.info("counter value is {}", counterField.get(singletonObject));
	}
}
