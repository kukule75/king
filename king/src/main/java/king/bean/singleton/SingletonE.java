package king.bean.singleton;

/**
 * @author YuXiaodan
 * @ClassName SingletonE
 * @Description 懒汉内部静态类方式
 * @date 2017年09月24日 2017/9/24
 */
public class SingletonE {

	private SingletonE(){}

	private static class SingletonHolder{
		private static final SingletonE singletonE = new SingletonE();
	}

	public static final SingletonE getInstance() {
		return SingletonHolder.singletonE;
	}

	private int counter=0;
}
