package cn.opencil.oa.core.base.service.impl;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.base.service.BaseService;
import cn.opencil.oa.core.query.BaseQuery;
import org.hibernate.exception.DataException;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Project Name:SdutOA
 * File Name:BaseServiceImpl.java
 * Date:2016-4-15下午1:26:26
 * Author : 王基伟
 *
 * Service的实现
 *
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

	public abstract BaseDao getBaseDao();//此种实现可提高扩展性
	
	public PageResult<T> getPageResult(final BaseQuery baseQuery){
		return this.getBaseDao().getPageResult(baseQuery);
	}
	
	@Override
	public void addEntry(T t) throws DataException {
		this.getBaseDao().addEntry(t);
	}

	@Override
	public T getEntryById(Serializable id) {

		return (T) this.getBaseDao().getEntryById(id);
	}

	@Override
	public Set<T> getEntrysByIds(Serializable [] ids){
		return this.getBaseDao().getEntrysByIds(ids);
	}
	
	@Override
	public Collection<T> getEntrys() {
		return this.getBaseDao().getEntrys();
	}

	@Override
	public void updateEntry(T t) {
		this.getBaseDao().updateEntry(t);
	}
	@Override
	public void deleteEntriesByIDS(Serializable[] ids) {
		this.getBaseDao().deleteEntriesByIDS(ids);
	}
	@Override
	public void deleteEntry(Serializable id) {
		this.getBaseDao().deleteEntry(id);
	}

}
