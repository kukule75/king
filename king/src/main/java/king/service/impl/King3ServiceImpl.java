package king.service.impl;

import king.service.KingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author YuXiaodan
 * @ClassName King3ServiceImpl
 * @Description
 * @date 2017年09月23日 2017/9/23
 */
public class King3ServiceImpl implements KingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(King3ServiceImpl.class);

	private String message;

	private int index;

	@Override
	public String sayHello() {

		LOGGER.info("{}-{}", index, message);
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
