package king.bean.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author YuXiaodan
 * @ClassName Receiver
 * @Description
 * @date 2018年04月09日 2018/4/9
 */
public class Receiver {

	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

	public void doSomething() {
		LOGGER.info("receiver do something ...");
	}
}
