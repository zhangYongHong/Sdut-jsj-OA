package cn.opencil.oa.core.query;

import java.util.Date;
import java.util.Map;

import cn.opencil.oa.common.util.DateUtil;

/**
 * Project Name:SdutOA
 * File Name:AwardsQuery.java
 * Date:2016-4-16下午4:21:18
 * Author : 王基伟
 *
 */
public class AwardsQuery extends BaseQuery{


	private String atime;
	
	public String getAtime() {
		return atime;
	}

	public void setAtime(String atime) {
		this.atime = atime;
	}



	/**
	 * 根据条件构造where
	 */
	@Override
	public Map<String, Object> buildWhere() {
		
		if(null != atime){
			this.getWhereKV().put("atime", this.atime);
		}else{
			this.getWhereKV().put("atime", DateUtil.dateToYear(new Date()));
		}
		
		return this.getWhereKV();
	}

}
