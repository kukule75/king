package king.service.impl;

import king.service.KingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author YuXiaodan
 * @ClassName KingServiceDecoratorImpl
 * @Description
 * @date 2017年09月23日 2017/9/23
 */
public class KingServiceDecoratorImpl implements KingService{

	private static final Logger LOGGER = LoggerFactory.getLogger(KingServiceDecoratorImpl.class);

	private KingService kingService;

	public KingServiceDecoratorImpl(){}

	public KingServiceDecoratorImpl(KingService kingService) {
		this.kingService = kingService;
	}
	@Override
	public String sayHello() {

		LOGGER.info("decorator start ...");
		kingService.sayHello();
		LOGGER.info("decorator end ...");

		return "";
	}

	public void setKingService(KingService kingService) {
		this.kingService = kingService;
	}
}
