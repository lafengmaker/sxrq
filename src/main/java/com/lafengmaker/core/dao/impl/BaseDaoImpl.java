package com.lafengmaker.core.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lafengmaker.core.dao.BaseDao;
import com.lafengmaker.core.exception.UserException;
import com.lafengmaker.core.util.GenericUtil;
import com.lafengmaker.core.util.StringUtil;
import com.lafengmaker.view.page.PageView;
import com.lafengmaker.view.page.QueryMap;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>  {
	private Class<T> entityClass =GenericUtil.getSuperClassGenricType(this.getClass());
	private static Log logger = LogFactory.getLog(BaseDaoImpl.class);
	public void insertEntity(T t) {
			this.getHibernateTemplate().save(t);
	}
	public void updateEntity(T t) {
		this.getHibernateTemplate().update(t);
	}
	public T queryEnetityById(Class clazz,Long id) {
		return 	(T)this.getHibernateTemplate().get(clazz, id);
	}
	@Override
	public void deleteT(T t) {
			this.getHibernateTemplate().delete(t);
	}
	public List<T> queryEnetityByT(T t) throws Exception {
		try {
			return  (List<T>)this.getHibernateTemplate().findByExample(t);
		} catch (Exception e) {
			throw new UserException("数据库错误");
		}
	}
	public List<T> queryEnetityByTPage(T t, int firstResult, int maxResults) {
		return this.getHibernateTemplate().findByExample(t, firstResult, maxResults);
	}
	public Long queryEnetityByTPageCount(final T t, final String  wheresql) {
		 return (Long)this.getHibernateTemplate().execute(new HibernateCallback<Long>() {
			public Long doInHibernate(Session session) throws HibernateException,
					SQLException {
				Example example=Example.create(t); 
				example.excludeNone(); 
				example.excludeZeroes(); 
				example.enableLike(MatchMode.ANYWHERE); 
				Criteria criteria= session.createCriteria(entityClass).add(example);
				Integer i= (Integer)criteria.setProjection(Projections.rowCount()).uniqueResult(); 
				if(null!=i){
					return i.longValue();
				}else{
					return 0l;
				}
			}
			
		});
	}
	public List<T> queryEnetityByTPage(final T t,  final int first) {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			public List<T> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Example example=Example.create(t); 
				example.excludeNone(); 
				example.excludeZeroes(); 
				example.enableLike(MatchMode.ANYWHERE); 
				Criteria criteria= session.createCriteria(entityClass).add(example);
				criteria.setFirstResult(first);
				criteria.setMaxResults(PageView.PAGE_RESULT_NUM);
				return criteria.list();
			}
		
			
		});
	//return queryEnetityByTPage(t, first, PageView.PAGE_RESULT_NUM);
	}
	public Long queryPageCountByQueryMap(final Class clazz, final QueryMap q) {
		 return (Long)this.getHibernateTemplate().execute(new HibernateCallback<Long>() {
			public Long doInHibernate(Session session) throws HibernateException,
					SQLException {
				Criteria criteria= session.createCriteria(clazz);
				addRestriction(criteria, q);
				Integer i= (Integer)criteria.setProjection(Projections.rowCount()).uniqueResult(); 
				if(null!=i){
					return i.longValue();
				}else{
					return 0l;
				}
			}
			
		});
	}
	public List<T> quertByQueryMap(final Class clazz,  final QueryMap q) {
		return this.getHibernateTemplate().execute(new HibernateCallback<List<T>>() {
			@SuppressWarnings("unchecked")
			public List<T> doInHibernate(Session session)
					throws HibernateException, SQLException {
				Criteria criteria=session.createCriteria(clazz);
				addRestriction(criteria, q);
				if(null!=q.getFirst()){
					criteria.setFirstResult(q.getFirst());
				}
				if(null!=q.getMax()){
					criteria.setMaxResults(q.getMax());
				}
				if(null!=q.getOrder()&&q.getOrder().size()>0){
					for(String or:q.getOrder()){
						criteria.addOrder(Order.desc(or));
					}
				}
				if(!StringUtil.isEmpty(q.getOrderasc())){
					criteria.addOrder(Order.asc(q.getOrderasc()));
				}
				List<T> l=criteria.list();
				return l;
				
			}
			
		});
	}
	
	private void addRestriction(Criteria criteria,QueryMap q){
		if(null!=q){
			for(String s:q.getEqmap().keySet()){
				if(q.getNullmap().contains(s)){
					criteria.add(Restrictions.or(Restrictions.eq(s, q.getEqmap().get(s)), Restrictions.isNull(s)));
				}else{
				criteria.add(Restrictions.eq(s, q.getEqmap().get(s)));
				}
			}
			for(String s:q.getGtmap().keySet()){
				if(q.getNullmap().contains(s)){
					criteria.add(Restrictions.or(Restrictions.ge(s, q.getGtmap().get(s)), Restrictions.isNull(s)));
				}else{
				criteria.add(Restrictions.ge(s, q.getGtmap().get(s)));
				}
			}
			for(String s:q.getLtmap().keySet()){
				if(q.getNullmap().contains(s)){
					criteria.add(Restrictions.or(Restrictions.le(s, q.getLtmap().get(s)), Restrictions.isNull(s)));
				}else{
					criteria.add(Restrictions.le(s, q.getLtmap().get(s)));
				}
			}
			for(String s:q.getLikemap().keySet()){
				criteria.add(Restrictions.like(s, q.getLikemap().get(s)));
			}
			for(String s:q.getLikemap().keySet()){
				criteria.add(Restrictions.like(s, q.getLikemap().get(s)));
			}
			for(String s:q.getNotinmap().keySet()){
				criteria.add(Restrictions.not(Restrictions.in(s, q.getNotinmap().get(s))));
			}
			for(String s:q.getInmap().keySet()){
				criteria.add(Restrictions.in(s,q.getInmap().get(s)));
			}
		}
	}
	
	
	
	
}
