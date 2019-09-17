package king.bean.depends;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author YuXiaodan
 * @ClassName DependentBean
 * @Description
 * @date 2017年09月24日 2017/9/24
 */
public class DependentBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(DependentBean.class);

	private ResourceBean resourceBean;

//	public DependentBean(ResourceBean resourceBean) {
//		this.resourceBean = resourceBean;
//	}

	public void write(String message) throws IOException {
		LOGGER.info("DependentBean write ...");
		resourceBean.getFileOutputStream().write(message.getBytes());
	}

	public void init() throws IOException {
		LOGGER.info("DependentBean init ...");
		resourceBean.getFileOutputStream().write("DependentBean init ...".getBytes());
	}

	public void destroy () throws IOException {
		LOGGER.info("DependentBean destroy ...");
		resourceBean.getFileOutputStream().write("DependentBean destroy ...".getBytes());
	}


	public void setResourceBean(ResourceBean resourceBean) {
		this.resourceBean = resourceBean;
	}
}
