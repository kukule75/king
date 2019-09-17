package king.dao;

import king.model.po.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author YuXiaoDan
 * @ClassName AccountDao
 * @Description G2账户表account dao接口
 * @date 2017/4/15 上午10:43
 */
public interface AccountDao {

    Account findByAccNo(@Param("accNo") String accNo);

    /**
     * @Description 根据ID获取账户
     * @params [id]
     * @return acc.model.po.Account
     */
    Account findById(@Param("id") long id);

    /**
     * @Description 保存账户
     * @params [account]
     * @return java.lang.Integer
     */
    Integer save(Account account);

    Integer saveAccounts(List<Account> accounts);

    /**
     * @Description 根据用户ID、账户科目获取账户信息
     * @params [userId, accCode]
     * @return acc.model.po.Account
     */
    Account findByUIdAndCode(@Param("userId") long userId, @Param("accCode") int accCode);

    /**
     * @Description 更新账户
     * @params [account]
     * @return java.lang.Integer
     */
    Integer update(Account account);
}