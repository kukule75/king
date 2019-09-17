package king.bean.singleton;

/**
 * @author YuXiaodan
 * @ClassName SingletonA
 * @Description 懒汉式 线程不安全 不能使用
 * @date 2017年09月24日 2017/9/24
 */
public class SingletonA {

	private static SingletonA singletonA;

	private SingletonA(){}

	public static SingletonA getInstance() {
		if (singletonA == null) {
			singletonA = new SingletonA();
		}
		return singletonA;
	}
}
