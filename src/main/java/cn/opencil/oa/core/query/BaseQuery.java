package cn.opencil.oa.core.query;

import java.util.HashMap;
import java.util.Map;

/**
 * Project Name:SdutOA
 * File Name:BaseQuery.java
 * Date:2016-4-15下午1:17:51
 * Author : 张树伟
 *
 * 查询的操作的虚类，与接口相比扩展性高
 */
public abstract class BaseQuery {
	/**
	 * 当前页码，初始化的值为1
	 */
	private int currentPage = 1;
	/**
	 * 一页显示的条数
	 */

	private int pageSize = 500;
	private Map<String, Object> whereKV = new HashMap<String, Object>();

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Map<String, Object> getWhereKV() {
		return whereKV;
	}
	public void setWhereKV(Map<String, Object> whereKV) {
		this.whereKV = whereKV;
	}
	/**
	 * 把页面上的查询条件封装成一个Map<String,Object>
	 * 并且返回
	 * @return
	 */
	public abstract Map<String, Object> buildWhere();
	
}
