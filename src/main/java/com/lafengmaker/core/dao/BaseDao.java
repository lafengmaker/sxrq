package com.lafengmaker.core.dao;

import java.util.List;

import com.lafengmaker.view.page.QueryMap;

public interface BaseDao<T>{
	public	void insertEntity(T t);
	public	void updateEntity(T t);
	public	T queryEnetityById(Class<T> clazz,Long id);
	public	List<T> queryEnetityByT(T t) throws Exception;
	public List<T>queryEnetityByTPage(T t,int first,int max);
	public List<T>queryEnetityByTPage(T t,int first);
	public Long queryEnetityByTPageCount(T t,String sql);
	public List<T> quertByQueryMap(Class<T> clazz,QueryMap q);
	public Long queryPageCountByQueryMap(Class<T> clazz, final QueryMap q) ;
}
