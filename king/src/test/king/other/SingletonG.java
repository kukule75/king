package king.other;

/**
 * @author YuXiaodan
 * @ClassName SingletonG
 * @Description 懒汉内部静态类方式
 * @date 2017年09月24日 2017/9/24
 */
public class SingletonG {

	private SingletonG(){}

	private static class SingletonHolder{
		private static final SingletonG singletonE = new SingletonG();
	}

	public static final SingletonG getInstance() {
		return SingletonHolder.singletonE;
	}

	private int counter=0;
}
