package king.service;

import king.model.po.Account;

/**
 * @author YuXiaodan
 * @ClassName AccountService
 * @Description
 * @date 2017年11月27日 2017/11/27
 */
public interface AccountService {

	void query(long id);

	void insert(Account account);

	void saveRequired();

	void saveRequiredNew();

	void saveNested();
}
