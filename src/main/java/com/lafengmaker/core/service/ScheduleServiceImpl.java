package com.lafengmaker.core.service;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lafengmaker.core.dao.SysLogDao;
import com.lafengmaker.core.dao.UserDao;
import com.lafengmaker.core.dao.UserScheduleDao;
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
	private Logger logger=Logger.getLogger(ScheduleServiceImpl.class);
	private UserScheduleDao userScheduleDao;
	private UserDao userDao;
	private ScheduleHelper scheduleHelper;
	private SysLogDao sysLogDao;
	public List<UserSchedule> getWeeklyList(String date,Long userid,Date dateshow) {
		DateUtil du=new DateUtil(date);
		QueryMap q=new QueryMap().addeq("userid", userid).addgt("cdate", du.getMonday())
				.addlt("cdate", du.getSunday());
		List<UserSchedule>ul=this.userScheduleDao.quertByQueryMap(UserSchedule.class, q);
		if(null==ul||ul.isEmpty()){
			if(DateUtil.isDateBefore(new Date(), dateshow)){
				if(null!=userid){
					scheduleHelper.insertWeekScheduleForUser(date,userid);
				}
				ul=this.userScheduleDao.quertByQueryMap(UserSchedule.class, q);
			}
		}
		return ul;
	}
	public UserSchedule getdayDate(String date, Long userid) {
		QueryMap q=new QueryMap(null).addgt("cdate", new DateUtil(date).getDayFirst())
				.addlt("cdate", new DateUtil(date).getDayEnd())
				.addeq("userid", userid);
		List<UserSchedule>ul=this.userScheduleDao.quertByQueryMap(UserSchedule.class, q);
		if(null!=ul&&ul.size()>0){
			return ul.get(0);
		}
		return null;
		
	}
	public UserSchedule insertorupdate(UserSchedule userSchedule,String type) throws Exception {
		try {
			if("1".equals(type)&&!new DateUtil().submitable(userSchedule.getCdate())){
				throw new UserException("已经过期");
			}
			if("2".equals(type)&&!new DateUtil(userSchedule.getCdate()).changeable()){
				throw new UserException("已经过期");
			}
			UserSchedule us=new UserSchedule();
			if(null==userSchedule.getId()){
				QueryMap q=new QueryMap();
				q.addEqDate("cdate", userSchedule.getCdate());
				List<UserSchedule> uql=this.userScheduleDao.quertByQueryMap(UserSchedule.class, q);
				if(null!=null&&uql.size()>0){
					throw new UserException("当天数据已经存在，请刷新重新提交");
				}
				scheduleHelper.insertWeekScheduleForUser(DateUtil.toStirngDate(userSchedule.getCdate(), DateUtil.DATE),userSchedule.getUserid());
				List<UserSchedule>sul=this.userScheduleDao.quertByQueryMap(UserSchedule.class, q);
				if(null!=sul&&sul.size()>0){
					us=sul.get(0);
				}else{
					throw new UserException("数据初始化错误");
				}
			}else{
				us=this.userScheduleDao.queryEnetityById(UserSchedule.class, userSchedule.getId());
			}
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
		} catch (UserException e) {
			logger.error("更新出错",e);
			throw e;
		}catch (Throwable te) {
			logger.error("更新出错",te);
			throw new UserException("更新出错");
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
		q.setOrder("cdate");
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
				if(p.indexOf("accVol")!=-1){
					u.setWeekplan(us.getAccVol());
				}
				try {
					this.userScheduleDao.updateEntity(u);
				} catch (Exception e) {
					throw new UserException("数据格式有误");
				}
			}
		}
		
	}
	@Override
	public void daydatacheck(String p) throws UserException {
		try {
			logger.info("日审批"+p);
			JSONArray array=JSONArray.fromObject(p);
			if(null!=array&&array.size()>0){
				for(int i=0;i<array.size(); i++){
					UserSchedule us=(UserSchedule)JSONObject.toBean(array.getJSONObject(i), UserSchedule.class);
					UserSchedule u=this.userScheduleDao.queryEnetityById(UserSchedule.class, us.getId());
					u.setStatus("2");
					u.setAccVol(us.getAccVol());
					this.userScheduleDao.updateEntity(u);
				}
			}
		} catch (Exception e) {
			logger.error("数据格式不正确",e);
			throw new UserException("数据格式不正确");
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
