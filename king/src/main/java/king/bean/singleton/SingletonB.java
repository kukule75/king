package king.bean.singleton;

/**
 * @author YuXiaodan
 * @ClassName SingletonB
 * @Description 懒汉 线程安全 但是效率低下
 * @date 2017年09月24日 2017/9/24
 */
public class SingletonB {

	private static SingletonB singletonB;

	private SingletonB(){}

	public static synchronized SingletonB getInstance() {
		if (singletonB == null) {
			singletonB = new SingletonB();
		}
		return singletonB;
	}
}
