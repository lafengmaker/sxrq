package com.lafengmaker.view.page;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QueryMap {
	private Integer first;
	private Integer max=10;
	private Map<String, Object>eqmap;
	private Map<String, String>likemap;
	private Map<String, Object>gtmap;
	private Map<String, Object>ltmap;
	private Map<String, Set<String>>notinmap;
	private Map<String, Set<String>>inmap;
	private Set<String>nullmap;
	private List<String> order;
	private String orderasc;
	public QueryMap() {
		super();
		eqmap=new HashMap<String, Object>();
		likemap=new HashMap<String, String>();
		gtmap=new HashMap<String, Object>();
		ltmap=new HashMap<String, Object>();
		notinmap=new HashMap<String, Set<String>>();
		inmap=new HashMap<String, Set<String>>();
		nullmap=new HashSet<String>();
		order=new ArrayList<String>();
	}
	public QueryMap addlt(String key,Object object){
	this.ltmap.put(key, object);
	return this;
	}
	public QueryMap addgt(String key,Object object){
		this.gtmap.put(key, object);
		return this;
	}
	public QueryMap addeq(String key,Object object){
		this.eqmap.put(key, object);
		return this;
	}
	public QueryMap addlike(String key,String str){
		this.likemap.put(key, str);
		return this;
	}
	public QueryMap addNotIn(String key,String s){
		if(null==notinmap.get(key)){
			this.notinmap.put(key, new HashSet<String>());
		}
		this.notinmap.get(key).add(s);
		return this;
	}
	public void addNullMap(String key){
		this.nullmap.add(key);
	}
	public QueryMap addIn(String key,String s){
		if(null==inmap.get(key)){
			this.inmap.put(key, new HashSet<String>());
		}
		this.inmap.get(key).add(s);
		return this;
	}
	public Map<String, Object> getEqmap() {
		return eqmap;
	}
	public Map<String, String> getLikemap() {
		return likemap;
	}
	public Map<String, Object> getGtmap() {
		return gtmap;
	}
	public Map<String, Object> getLtmap() {
		return ltmap;
	}
	public Map<String, Set<String>> getNotinmap() {
		return notinmap;
	}
	public Map<String, Set<String>> getInmap() {
		return inmap;
	}
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	public List<String> getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order.add(order);
	}
	public String getOrderasc() {
		return orderasc;
	}
	public void setOrderasc(String orderasc) {
		this.orderasc = orderasc;
	}
	public Set<String> getNullmap() {
		return nullmap;
	}
	
	
	
	
	
	
}	
