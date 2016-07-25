package cn.opencil.oa.core.query;

import java.util.Map;


/**
 * Project Name:SdutOA
 * File Name:AwardsQuery.java
 * Date:2016-4-16下午4:21:18
 * Author : 王基伟
 *
 */
public class SystemDDLQuery extends BaseQuery{


	private String keyword;
	

	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	/**
	 * 根据条件构造where
	 */
	@Override
	public Map<String, Object> buildWhere() {
		
		if(null != keyword){
			this.getWhereKV().put("keyword", keyword);
		}else{
			this.getWhereKV().put("keyword", "竞赛项目");
		}
		
		return this.getWhereKV();
	}

}
