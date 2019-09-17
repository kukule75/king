package king.bean.depends;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author YuXiaodan
 * @ClassName ResourceBean
 * @Description
 * @date 2017年09月24日 2017/9/24
 */
public class ResourceBean {

	private static final Logger LOGGER = LoggerFactory.getLogger(ResourceBean.class);

	private File file;

	private FileOutputStream fileOutputStream;

	public void init() {

		LOGGER.info("ResourceBean init ...");

		try {
			this.fileOutputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void destroy() {

		LOGGER.info("ResourceBean destroy ...");

		try {
			this.fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ResourceBean (){}

	public ResourceBean (File file) {
		this.file = file;
	}

	public FileOutputStream getFileOutputStream() {

		LOGGER.info("ResourceBean getFileOutputStream ...");
		return this.fileOutputStream;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
