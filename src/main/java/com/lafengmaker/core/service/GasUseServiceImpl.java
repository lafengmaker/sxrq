package com.lafengmaker.core.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lafengmaker.core.dao.GasUseDao;
import com.lafengmaker.core.entity.GasUse;
import com.lafengmaker.core.exception.UserException;
import com.lafengmaker.core.util.DateUtil;
import com.lafengmaker.core.util.StringUtil;
import com.lafengmaker.view.gasuse.GasUseSearch;
import com.lafengmaker.view.gasuse.GasUseView;
import com.lafengmaker.view.page.PageView;
import com.lafengmaker.view.page.QueryMap;
@Service
public class GasUseServiceImpl implements GasUseService {
	private GasUseDao gasUseDao;
	public void addGasuse(GasUse gasUse) {
		QueryMap q=new QueryMap();
		q.addgt("addtime", new DateUtil(gasUse.getAddtime()).getDayFirst()).
		addlt("addtime", new DateUtil(gasUse.getAddtime()).getDayEnd()).addeq("userid", gasUse.getUserid());
		List<GasUse> gl=this.gasUseDao.quertByQueryMap(GasUse.class, q);
		if(null!=gl&&gl.size()>0){
			if(null==gasUse.getId()||!gl.get(0).getId().equals(gasUse.getId())){
				throw new UserException("同一天只能添加一条，请选择另外的日期");
			}
		}
		if(null==gasUse.getId()){
			gasUse.setCreatetime(new Date());
			gasUse.setLastmodifytime(new Date());
			this.gasUseDao.insertEntity(gasUse);
		}else{
			GasUse gg=this.gasUseDao.queryEnetityById(GasUse.class, gasUse.getId());
			gasUse.setLastmodifytime(new Date());
			gasUse.setCreatetime(gg.getCreatetime());
			this.gasUseDao.updateEntity(gasUse);
		}
	}
	public PageView<GasUse> getGesUsePageView(GasUseSearch search, int currpage) {
		QueryMap q=new QueryMap();
		q.setOrder("addtime");
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
	@Override
	public GasUseView findgasUseViewById(String id) {
		GasUseView gv=new GasUseView();
		if(!StringUtil.isEmpty(id)){
			GasUse g= this.gasUseDao.queryEnetityById(GasUse.class, StringUtil.getLongnull(id));
			gv.toGasUseView(g);
		}
		return gv;
	}
	public GasUseDao getGasUseDao() {
		return gasUseDao;
	}
	@Autowired
	public void setGasUseDao(GasUseDao gasUseDao) {
		this.gasUseDao = gasUseDao;
	}
	
	
}
