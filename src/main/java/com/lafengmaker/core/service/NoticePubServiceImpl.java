package com.lafengmaker.core.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lafengmaker.core.dao.NoticePubDao;
import com.lafengmaker.core.entity.NoticePub;
import com.lafengmaker.core.util.DateUtil;
import com.lafengmaker.core.util.StringUtil;
import com.lafengmaker.view.page.PageView;
import com.lafengmaker.view.page.QueryMap;
@Service
public class NoticePubServiceImpl implements NoticePubService {
	private NoticePubDao noticePubDao;
	public void insertOrupdateNoticePub(NoticePub noticePub) {
		if(null!=noticePub){
			if(null!=noticePub.getId()){
				NoticePub nb=	this.noticePubDao.queryEnetityById(NoticePub.class, noticePub.getId());
				nb.setContent(noticePub.getContent());
				nb.setAdduser(noticePub.getAdduser());
				nb.setEnddate(noticePub.getEnddate());
				nb.setShowindex(noticePub.getShowindex());
				nb.setTitle(noticePub.getTitle());
				this.noticePubDao.updateEntity(nb);
			}else{
				noticePub.setCreatetime(new Date());
				this.noticePubDao.insertEntity(noticePub);
				
			}
		}
		
	}

	public PageView<NoticePub> getNotcePub(Integer currpage,NoticePub noticePub) {
		PageView<NoticePub>pv=new PageView<NoticePub>(currpage);
		QueryMap q=new QueryMap();
		if(!StringUtil.isEmpty(noticePub.getContent())){
			q.addlike("content", "%"+StringUtil.trim(noticePub.getContent())+"%");
		}
		if(!StringUtil.isEmpty(noticePub.getTitle())){
			q.addlike("title", "%"+StringUtil.trim(noticePub.getTitle())+"%");
		}
		List<NoticePub>ul=this.noticePubDao.quertByQueryMap(NoticePub.class, q);
		Long t=this.noticePubDao.queryPageCountByQueryMap(NoticePub.class, q);
		pv.setRecords(ul);pv.setTotalrecord(t);
		return pv;
	}
	
	public List<NoticePub> showNoticeOnWelcome() {
		QueryMap q=new QueryMap();
		q.setFirst(0);
		q.addgt("enddate",  new DateUtil().getDayEnd());
		q.addNullMap("enddate");
		q.setOrder("showindex");
		q.setOrder("createtime");
		List<NoticePub>bl=this.noticePubDao.quertByQueryMap(NoticePub.class, q);
		return bl;
	}
	
	public NoticePub getNoticePubById(Long id) {
		return this.noticePubDao.queryEnetityById(NoticePub.class,id);
	}

	public NoticePubDao getNoticePubDao() {
		return noticePubDao;
	}
	@Autowired
	public void setNoticePubDao(NoticePubDao noticePubDao) {
		this.noticePubDao = noticePubDao;
	}
	
	
}
