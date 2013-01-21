package com.lafengmaker.core.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lafengmaker.core.dao.GasUseDao;
import com.lafengmaker.core.entity.GasUse;
import com.lafengmaker.core.util.DateUtil;
import com.lafengmaker.core.util.StringUtil;
import com.lafengmaker.view.gasuse.GasUseSearch;
import com.lafengmaker.view.page.PageView;
import com.lafengmaker.view.page.QueryMap;
@Service
public class GasUseServiceImpl implements GasUseService {
	private GasUseDao gasUseDao;
	public void addGasuse(GasUse gasUse) {
		gasUse.setCreatetime(new Date());
		this.gasUseDao.insertEntity(gasUse);
	}
	public PageView<GasUse> getGesUsePageView(GasUseSearch search, int currpage) {
		QueryMap q=new QueryMap();
		q.setOrder("createtime");
		if(null!=search.getUserid()){
			q.addeq("userid", search.getUserid());
		}
		if(!StringUtil.isEmpty(search.getD1())){
			q.addgt("addtime",  new DateUtil(search.getD1()).getDayFirst());
		}
		if(!StringUtil.isEmpty(search.getD2())){
			q.addlt("addtime",  new DateUtil(search.getD2()).getDayEnd());
		}
		PageView<GasUse>pv=new PageView<GasUse>(currpage);
		q.setFirst(pv.getFirstResult());
		List<GasUse>ul=this.gasUseDao.quertByQueryMap(GasUse.class, q);
		Long t=this.gasUseDao.queryPageCountByQueryMap(GasUse.class, q);
		pv.setTotalrecord(t);
		pv.setRecords(ul);
		return pv;
	}
	public GasUseDao getGasUseDao() {
		return gasUseDao;
	}
	@Autowired
	public void setGasUseDao(GasUseDao gasUseDao) {
		this.gasUseDao = gasUseDao;
	}
	
	
}
