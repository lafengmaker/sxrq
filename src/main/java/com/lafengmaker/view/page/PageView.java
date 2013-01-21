package com.lafengmaker.view.page;

import java.util.List;

public class PageView<T>{
	public static final int PAGE_RESULT_NUM=10;
	/* 分页数据 */
	private List<T> records;
	/* 页码开始索引和结束索引 */
	private PageIndex pageindex;
	/* 总页数 */
	private long totalpage = 1;
	/* 每页显示记录数 */
	private int maxresult;
	/* 当前页 */
	private int currentpage = 1;
	/* 总记录数 */
	private long totalrecord=0;
	/* 页码数量 */
	private int pagecode=10;
	private T t;//单个类
	
	public PageView(int maxresult, int currentpage) {
		this.maxresult = maxresult;
		if(currentpage>0){
			this.currentpage = currentpage;
		} else {
			this.currentpage = 1;			
		}
		this.setTotalrecord(0L);
	}
	
	public PageView(int currentpage) {
		super();
		this.currentpage = currentpage;
		this.maxresult =PAGE_RESULT_NUM;
	}

	/* 当前页的首条记录 */
	public int getFirstResult() {
		return (this.currentpage-1)*this.maxresult;
	}
	/* 当前页的最后一条记录 */
	public int getMaxresult() {
		return maxresult*currentpage;
	}

	/**
	 * 设置结果集
	 * @param qr
	 */
	public void setQueryResult(QueryResult<T> qr){
		setTotalrecord(qr.getTotalrecord());
		setRecords(qr.getResultlist());
	}
	
	public long getTotalrecord() {
		return totalrecord;
	}
	
	public void setTotalrecord(Long totalrecord) {
		this.totalrecord = totalrecord;
		setTotalpage(this.totalrecord%this.maxresult==0? this.totalrecord/this.maxresult : this.totalrecord/this.maxresult+1);
	}
	
	public void setTotalpage(long totalpage) {
		if(totalpage > 0){			
			this.totalpage = totalpage;
		} else {
			this.totalpage = 1;
		}
		this.pageindex = PageIndex.getPageIndex(pagecode, currentpage, totalpage);
	}
	
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	
	public PageIndex getPageindex() {
		return pageindex;
	}
	
	public long getTotalpage() {
		return totalpage;
	}
	
	public int getCurrentpage() {
		return currentpage ;		
	}
	public int getPagecode() {
		return pagecode;
	}
	public void setPagecode(int pagecode) {
		this.pagecode = pagecode;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public PageView() {
		super();
	}
	
	
	
}
