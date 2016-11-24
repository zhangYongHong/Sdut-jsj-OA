package cn.opencil.oa.core.base.dao;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.query.BaseQuery;
import org.hibernate.exception.DataException;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Project Name:SdutOA
 * File Name:BaseDao.java
 * Author : 王基伟
 * Date:2016-4-15下午1:16:02
 * 封装了DAO的基本操作：增删改查
 */
public interface BaseDao<T> {
	/**
	 * 分页的查询
	 * @param baseQuery
	 * @return
	 */
	PageResult<T> getPageResult(final BaseQuery baseQuery);
	
	/**
	 * 查询某一张表的总的记录数
	 */
	int getCount(final BaseQuery baseQuery);
	/**
	 * 添加
	 * @param t
	 */
	Serializable addEntry(T t) throws DataException;
	
	/**
	 * 查询一个
	 * @return
	 */
	T getEntryById(Serializable id);
	
	/**
	 * 按ids查询
	 */
	Set<T> getEntrysByIds(Serializable[] ids);
	
	/**
	 * 不分页的查询
	 * @return
	 */
	Collection<T> getEntrys();
	
	/**
	 * 修改
	 * @param t
	 */
	void updateEntry(T t);
	
	/**
	 * 根据ids删除一些数据
	 * @param ids
	 */
	void deleteEntriesByIDS(Serializable[] ids);
	
	/**
	 * 根据id删除一条数据
	 * @param id
	 */
	void deleteEntry(Serializable id);
}
