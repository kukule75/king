package king.tx;

import org.springframework.transaction.TransactionStatus;

/**
 * @author YuXiaodan
 * @ClassName TransactionCallback
 * @Description
 * @date 2017年09月18日 2017/9/18
 */
public interface TransactionCallback<T> {

	T doInTransaction(TransactionStatus status);
}
