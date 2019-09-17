package king.service.impl;

import king.service.KingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author YuXiaodan
 * @ClassName King2ServiceImpl
 * @Description
 * @date 2017年09月23日 2017/9/23
 */
public class King2ServiceImpl implements KingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(King2ServiceImpl.class);

	private String message;

	private int index;

	/**
	 *
	 * @param message
	 * @param index
	 */
	public King2ServiceImpl(String message, int index) {

		this.message = message;
		this.index = index;
	}

	@Override
	public String sayHello() {

		LOGGER.info("{}-{}", index, message);
		return message;
	}
}
