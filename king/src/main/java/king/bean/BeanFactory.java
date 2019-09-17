package king.bean;

import king.service.KingService;
import king.service.impl.King2ServiceImpl;
import king.service.impl.KingServiceImpl;

/**
 * @author YuXiaodan
 * @ClassName BeanFactory
 * @Description
 * @date 2017年09月23日 2017/9/23
 */
public class BeanFactory {

	public static KingService newInstance(String message) {
		return new KingServiceImpl(message);
	}

	public static KingService newInstance(String message, int index) {
		return new King2ServiceImpl(message, index);
	}
}
