package king.bean.singleton;

/**
 * @author YuXiaodan
 * @ClassName SingletonD
 * @Description 饿汗 线程安全
 * @date 2017年09月24日 2017/9/24
 */
public class SingletonD {

	private final static SingletonD SINGLETON_D = new SingletonD();

	private SingletonD(){}

	public static SingletonD getInstance() {
		return SINGLETON_D;
	}
}
