package king.service;

/**
 * @author YuXiaodan
 * @ClassName OneService
 * @Description
 * @date 2019年06月16日 2019/6/16
 */
public interface OneService {

	void update();

	void save();

	void saveRequired();

	void saveRequiredException();

	void saveRequiredNew();

	void saveRequiredNewException();

	void saveNested();

	void saveNestedException();
}
