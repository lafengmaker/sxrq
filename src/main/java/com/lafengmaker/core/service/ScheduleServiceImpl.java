package com.lafengmaker.core.service;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lafengmaker.core.dao.SysLogDao;
import com.lafengmaker.core.dao.UserDao;
import com.lafengmaker.core.dao.UserScheduleDao;
import com.lafengmaker.core.entity.SysLog;
import com.lafengmaker.core.entity.User;
import com.lafengmaker.core.entity.UserSchedule;
import com.lafengmaker.core.exception.UserException;
import com.lafengmaker.core.helper.ScheduleHelper;
import com.lafengmaker.core.util.DateUtil;
import com.lafengmaker.core.util.StringUtil;
import com.lafengmaker.view.page.PageView;
import com.lafengmaker.view.page.QueryMap;
import com.lafengmaker.view.schedule.ScheduleSearch;
@Service
public class ScheduleServiceImpl implements ScheduleService {
	private Log log=LogFactory.getLog(ScheduleServiceImpl.class);
	private UserScheduleDao userScheduleDao;
	private UserDao userDao;
	private ScheduleHelper scheduleHelper;
	private SysLogDao sysLogDao;
	public List<UserSchedule> getWeeklyList(String date,Long userid) {
		DateUtil du=new DateUtil(date);
		QueryMap q=new QueryMap().addeq("userid", userid).addgt("cdate", du.getMonday())
				.addlt("cdate", du.getSunday());
		List<UserSchedule>ul=this.userScheduleDao.quertByQueryMap(UserSchedule.class, q);
		return ul;
	}
	public void insertWeekData(){
		SysLog g =new SysLog();
		g.setCreatetime(new Date());
		try {
			g.setStatus(1);
			List<User>ul=this.userDao.queryEnetityByT(new User());
			int i=ul.size();
			int j=0;
			for(User u:ul){
				j+=scheduleHelper.insertWeekScheduleForUser(u.getId());
			}
			g.setMessage("总记录"+i+"条，生成"+j+"条");
		} catch (Exception e) {
			log.error("定时任务出错", e);
			g.setStatus(1);
			g.setMessage("定时任务出错"+e.getMessage());
		}
		sysLogDao.insertEntity(g);
	}
	
	
	
	public UserSchedule getdayDate(String date, Long userid) {
		QueryMap q=new QueryMap().addgt("cdate", new DateUtil(date).getDayFirst())
				.addlt("cdate", new DateUtil(date).getDayEnd())
				.addeq("userid", userid);
		List<UserSchedule>ul=this.userScheduleDao.quertByQueryMap(UserSchedule.class, q);
		if(null!=ul&&ul.size()>0){
			return ul.get(0);
		}
		return null;
		
	}
	public UserSchedule update(UserSchedule userSchedule,String type) throws Exception {
		try {
			UserSchedule us=this.userScheduleDao.queryEnetityById(UserSchedule.class, userSchedule.getId());
			if("1".equals(type)){
				us.setDayVol(userSchedule.getDayVol());
				us.setDescription(userSchedule.getDescription());
				us.setStatus("1");
			}else{
				us.setChangeVol(userSchedule.getChangeVol());
				us.setChangedesc(userSchedule.getChangedesc());
			}
			us.setLastmodifytime(new Date());
			this.userScheduleDao.updateEntity(us);
			return us;
		} catch (Exception e) {
			log.error("更新出错",e);
			throw new UserException("数据出错");
		}
		
	}
	public PageView<UserSchedule> getPageView(ScheduleSearch scheduleSearch,
			Integer cu) {
		PageView<UserSchedule>pv=new PageView<UserSchedule>(cu);
		QueryMap q=new QueryMap();
		if(null!=scheduleSearch.getUserid()){
			q.addeq("userid", scheduleSearch.getUserid());
		}
		if(!StringUtil.isEmpty(scheduleSearch.getDate())){
			q.addgt("cdate", new DateUtil(scheduleSearch.getDate()).getDayFirst());
		}
		if(!StringUtil.isEmpty(scheduleSearch.getEnddate())){
			q.addlt("cdate", new DateUtil(scheduleSearch.getEnddate()).getDayEnd());
		}
		q.setFirst(pv.getFirstResult());
		q.addNotIn("status", "0");
		q.setOrder("lastmodifytime");
		List<UserSchedule>ul=this.userScheduleDao.quertByQueryMap(UserSchedule.class, q);
		Long total=this.userScheduleDao.queryPageCountByQueryMap(UserSchedule.class, q);
		pv.setRecords(ul);
		pv.setTotalrecord(total);
		return pv;
	}
	
	public void updateWeekdata(String p) throws Exception {
		JSONArray array=JSONArray.fromObject(p);
		if(null!=array&&array.size()>0){
			for(int i=0;i<array.size(); i++){
				UserSchedule us=(UserSchedule)JSONObject.toBean(array.getJSONObject(i), UserSchedule.class);
				UserSchedule u=this.userScheduleDao.queryEnetityById(UserSchedule.class, us.getId());
				u.setWeekforecast(us.getWeekforecast());
				u.setDescription(us.getDescription());
				this.userScheduleDao.updateEntity(u);
			}
		}
		
	}
	public UserScheduleDao getUserScheduleDao() {
		return userScheduleDao;
	}
	@Autowired
	public void setUserScheduleDao(UserScheduleDao userScheduleDao) {
		this.userScheduleDao = userScheduleDao;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public ScheduleHelper getScheduleHelper() {
		return scheduleHelper;
	}
	@Autowired
	public void setScheduleHelper(ScheduleHelper scheduleHelper) {
		this.scheduleHelper = scheduleHelper;
	}
	public SysLogDao getSysLogDao() {
		return sysLogDao;
	}
	@Autowired
	public void setSysLogDao(SysLogDao sysLogDao) {
		this.sysLogDao = sysLogDao;
	}
	
}
