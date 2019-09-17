/**  
 * All rights Reserved, Designed By kinden
 * @Title:  BaseEntity.java   
 * @Package acc.model      
 * @version V1.0     
 */  
package king.model;

import java.io.Serializable;
import java.util.Date;

/**   
 * @ClassName:  BaseEntity   
 * @Description: base class of persistent object 
 * @author: YuXiaoDan  
 * @date:   2016年8月3日 下午8:18:05   
 *      
 */
public class BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	private Date createTime;
	
	private Date updateTime;
	
	private int version;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
}
