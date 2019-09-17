package king.bean.singleton;

/**
 * @author YuXiaodan
 * @ClassName SingletonC
 * @Description 懒汉，双重检查
 * @date 2017年09月24日 2017/9/24
 */
public class SingletonC {

	private volatile static SingletonC singletonC;

	private SingletonC(){}

	public static SingletonC getInstance() {

		if (singletonC == null) {
			synchronized (SingletonC.class){
				if (singletonC == null) {
					singletonC = new SingletonC();
				}
				return singletonC;
			}
		}
		return singletonC;
	}
}
