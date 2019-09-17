package king.dao;

import king.model.po.One;

/**
 * @author YuXiaodan
 * @ClassName OneDao
 * @Description
 * @date 2018年05月22日 2018/5/22
 */
public interface OneDao {

	One findById(int id);

	void save(One one);

	void update();
}
