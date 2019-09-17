package king.service.impl;

import king.service.KingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author YuXiaodan
 * @ClassName KingServiceImpl
 * @Description
 * @date 2017年09月23日 2017/9/23
 */
public class KingServiceImpl implements KingService{

	private static final Logger LOGGER = LoggerFactory.getLogger(KingServiceImpl.class);

	private String message;

	public KingServiceImpl() {
		this.message = "hello java";
	}

	public KingServiceImpl(String message) {
		this.message = message;
	}

	@Override
	public String sayHello() {

		LOGGER.info("{}", this.message);
		return this.message;
	}
}
