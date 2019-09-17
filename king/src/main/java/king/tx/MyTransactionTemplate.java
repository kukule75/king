package king.tx;

import king.service.impl.HelloServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author YuXiaodan
 * @ClassName TransactionTemplate
 * @Description
 * @date 2017年09月18日 2017/9/18
 */
@Component
public class MyTransactionTemplate {

	@Autowired
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

	@Autowired
	private DataSourceTransactionManager transactionManager;

	public <T> T execute(TransactionCallback<T> action) {

		DefaultTransactionDefinition txDef = new DefaultTransactionDefinition();
		TransactionStatus status = this.transactionManager.getTransaction(txDef);
		T result;

		try {
			result = action.doInTransaction(status);
		} catch (RuntimeException ex){
			rollbackOnException(status, ex);
			throw ex;
		} catch (Error ex){
			rollbackOnException(status, ex);
			throw ex;
		} catch (Throwable ex) {
			rollbackOnException(status, ex);
			throw ex;
		}
		transactionManager.commit(status);

		return result;
	}

	private void rollbackOnException(TransactionStatus status, Throwable ex) {

		try {
			this.transactionManager.rollback(status);
		} catch (TransactionSystemException ex2) {
			throw ex2;
		} catch (RuntimeException ex2) {
			throw ex2;
		} catch (Error err) {
			throw err;
		}
	}
}
