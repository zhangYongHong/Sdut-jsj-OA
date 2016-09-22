package cn.opencil.oa.core.base.dao.impl;

import cn.opencil.oa.common.page.PageResult;
import cn.opencil.oa.core.base.dao.BaseDao;
import cn.opencil.oa.core.query.BaseQuery;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.metadata.ClassMetadata;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.Map.Entry;

/**
 * Project Name:SdutOA
 * File Name:BaseDaoImpl.java
 * Date:2016-4-15下午1:19:43
 * Author : 王基伟
 * basedao的实现类
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

    Class entityClass;//
    ClassMetadata classMetadata;//元数据类型
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    public BaseDaoImpl() {//获取泛型的class
        Type superclass = this.getClass().getGenericSuperclass();
        ParameterizedType type = (ParameterizedType) superclass;
        Type[] args = type.getActualTypeArguments();
        entityClass = (Class) ((null != args && args.length > 0) ? args[0]
                : null);
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @PostConstruct
    public void init() {//元数据需要在类构造之前
        this.classMetadata = this.hibernateTemplate//
                .getSessionFactory()//
                .getClassMetadata(entityClass);
    }

    @Override
    public void addEntry(T t) throws DataException {
        //org.springframework.dao.InvalidDataAccessApiUsageException: Write operations are not allowed in read-only mode (FlushMode.MANUAL): Turn your Session into FlushMode.COMMIT/AUTO or remove 'readOnly' marker from transaction definition.
        //解决导入Excel 时出现此异常
        //这种解决方式有可能引起其他问题
        //http://stackoverflow.com/questions/6810158/java-hibernate-write-operations-are-not-allowed-in-read-only-mode
//        this.getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        this.hibernateTemplate.save(t);
    }

    @Override
    public T getEntryById(Serializable id) {

        return (T) this.hibernateTemplate.get(entityClass, id);
    }

    @Override
    public Collection<T> getEntrys() {

        return (Collection<T>) this.hibernateTemplate.find("from "
                + this.entityClass.getSimpleName());
    }

    @Override
    public void updateEntry(T t) {//hibernate的更新操作需要注意
//        this.getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        this.hibernateTemplate.update(t);
    }

    @Override
    public void deleteEntriesByIDS(Serializable[] ids) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ids.length; i++) {
            if (i == ids.length - 1) {
                builder.append(ids[i]);
            } else {
                builder.append(ids[i]).append(",");
            }
        }

        StringBuilder hql = new StringBuilder();
        hql.append("from " + entityClass.getSimpleName());
        hql.append(" where ");
        hql.append(this.classMetadata.getIdentifierPropertyName());
        hql.append(" in (");
        hql.append(builder.toString() + " )");
        List list = this.hibernateTemplate.find(hql.toString());
        this.hibernateTemplate.deleteAll(list);//hibernate不支持批量操作，所以是一条一条删除的
    }

    @Override
    public void deleteEntry(Serializable id) {
        T t = (T) this.hibernateTemplate.get(entityClass, id);
        this.hibernateTemplate.delete(t);
    }


    @Override
    public int getCount(final BaseQuery baseQuery) {


        return this.hibernateTemplate.execute(
                new HibernateCallback<Integer>() {
                    @Override
                    public Integer doInHibernate(Session session) throws HibernateException {
                        StringBuilder hql = new StringBuilder();
                        /**
                         * 使用select count(1) 报错?
                         */
                        hql.append("select count(" + classMetadata.getIdentifierPropertyName() + ") from ");
                        String name = entityClass.getSimpleName();
                        hql.append(name);
                        hql.append(" where 1 = 1 ");
                        Map<String, Object> buildWhere = baseQuery.buildWhere();

                        /**
                         * 构造 where 1 = 1 and key=:key  注意: "=:"的前后是不允许有空格的
                         */
                        for (Entry<String, Object> entry : buildWhere.entrySet()) {
                            hql.append(" and " + entry.getKey() + "=:" + entry.getKey());
                        }

                        Query query = session.createQuery(hql.toString());

                        for (Entry<String, Object> entry : buildWhere.entrySet()) {
                            query.setParameter(entry.getKey(), entry.getValue());
                        }

                        Long count = (Long) query.uniqueResult();

                        return count.intValue();
                    }
                }
        );
    }

    @Override
    public PageResult<T> getPageResult(final BaseQuery baseQuery) {
        //找到符合条件的总记录数
        final int count = this.getCount(baseQuery);
        return this.hibernateTemplate.execute(
                new HibernateCallback<PageResult<T>>() {
                    @Override
                    public PageResult<T> doInHibernate(Session session) throws HibernateException {
                        StringBuilder hql = new StringBuilder();
                        hql.append("from " + entityClass.getSimpleName() + " where 1 = 1 ");
                        Map<String, Object> whereKV = baseQuery.buildWhere();

                        for (Entry<String, Object> entry : whereKV.entrySet()) {
                            hql.append(" and " + entry.getKey() + "=:" + entry.getKey());
                        }
                        hql.append(" order by id desc ");
                        Query query = session.createQuery(hql.toString());

                        for (Entry<String, Object> entry : whereKV.entrySet()) {
                            query.setParameter(entry.getKey(), entry.getValue());
                        }

                        //分页
                        int firstResult = (baseQuery.getCurrentPage() - 1) * baseQuery.getPageSize();
                        query.setFirstResult(firstResult).setMaxResults(baseQuery.getPageSize());
                        PageResult<T> pageResult = new PageResult<T>(baseQuery.getCurrentPage(), baseQuery.getPageSize(), count);
                        List list = query.list();
                        pageResult.setRows(list);
                        return pageResult;
                    }
                }
        );

    }


    @Override
    public Set<T> getEntrysByIds(Serializable[] ids) {

        StringBuilder id = new StringBuilder();
        if (ids != null && ids.length > 0) {
            for (int i = 0; i < ids.length; i++) {
                if (i == ids.length - 1) {
                    id.append(ids[i]);
                } else {
                    id.append(ids[i]).append(",");
                }
            }
        }

        StringBuilder hql = new StringBuilder();
        hql.append("from " + this.entityClass.getSimpleName() + " where 1 = 1 ");
        hql.append(" and " + this.classMetadata.getIdentifierPropertyName() + " in(" + id + ")");
        List list = this.hibernateTemplate.find(hql.toString());
        return new HashSet(list);
    }

}