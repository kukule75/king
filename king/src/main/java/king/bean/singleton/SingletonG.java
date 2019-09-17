package king.bean.singleton;

/**
 * @author YuXiaodan
 * @ClassName SingletonG
 * @Description
 * @date 2018年09月18日 2018/9/18
 */
public class SingletonG {

	private static class InnerSingleton{

		private static final SingletonG singletonG = new SingletonG();
	}

	public SingletonG getInstance () {
		return InnerSingleton.singletonG;
	}
}
