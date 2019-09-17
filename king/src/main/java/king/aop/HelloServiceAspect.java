package king.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author YuXiaodan
 * @ClassName HelloServiceAspect
 * @Description
 * @date 2017年09月30日 2017/9/30
 */
public class HelloServiceAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceAspect.class);

	void beforeAdvise(){

		LOGGER.info("beforeAdvise ...");
	}

	void afterFinalAdvise() {
		LOGGER.info("afterFinalAdvise ...");
	}
}
