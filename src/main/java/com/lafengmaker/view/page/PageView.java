package com.lafengmaker.view.page;

import java.util.List;

public class PageView<T>{
	public static final int PAGE_RESULT_NUM=10;
	/* ��ҳ���� */
	private List<T> records;
	/* ҳ�뿪ʼ�����ͽ������� */
	private PageIndex pageindex;
	/* ��ҳ�� */
	private long totalpage = 1;
	/* ÿҳ��ʾ��¼�� */
	private int maxresult;
	/* ��ǰҳ */
	private int currentpage = 1;
	/* �ܼ�¼�� */
	private long totalrecord=0;
	/* ҳ������ */
	private int pagecode=10;
	private T t;//������
	
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

	/* ��ǰҳ��������¼ */
	public int getFirstResult() {
		return (this.currentpage-1)*this.maxresult;
	}
	/* ��ǰҳ�����һ����¼ */
	public int getMaxresult() {
		return maxresult*currentpage;
	}

	/**
	 * ���ý����
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
