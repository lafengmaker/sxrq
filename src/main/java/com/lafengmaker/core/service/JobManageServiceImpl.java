package com.lafengmaker.core.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
import com.lafengmaker.view.page.QueryMap;
@Component(value="jobManage")
public class JobManageServiceImpl implements JobManageService {
	private static Logger logger = Logger.getLogger("JobManageServiceImpl");
	private SysLogDao sysLogDao;
	private UserDao userDao;
	private UserScheduleDao userScheduleDao;
	private ScheduleHelper scheduleHelper;
	@Transactional
	public void insertWeekData() {
		SysLog g =new SysLog();
		g.setCreatetime(new Date());
		logger.info("run insertWeekData");
		try {
			g.setStatus(1);
			User us=new User();
			us.setRole("0");
			List<User>ul=this.userDao.queryEnetityByT(us);
			int i=ul.size();
			int j=0;
			for(User u:ul){
				j+=scheduleHelper.insertWeekScheduleForUser(u.getId());
			}
			logger.info("总记录"+i+"条，生成"+j+"条");
			g.setMessage("总记录"+i+"条，生成"+j+"条");
		} catch (Exception e) {
			logger.error("定时任务出错", e);
			g.setStatus(1);
			g.setMessage("定时任务出错"+e.getMessage());
			throw new UserException("任务出错");
		}
		sysLogDao.insertEntity(g);
	}
	@Transactional()
	public void updateDaySchedule() {
			logger.info("run updateDaySchedule");
			Calendar ca=Calendar.getInstance();
			String end=StringUtil.readProperty("subend", this);
			String s[]=end.split(":");
			ca.add(Calendar.DAY_OF_MONTH, 1);
			ca.set(Calendar.HOUR_OF_DAY, Integer.parseInt(s[0]));
			ca.set(Calendar.MINUTE, Integer.parseInt(s[1]));
			ca.set(Calendar.SECOND, 0);
			ca.set(Calendar.MILLISECOND, 0);
			Calendar cal2=Calendar.getInstance();
			cal2.add(Calendar.DAY_OF_MONTH, 1);
			int betnum=cal2.get(Calendar.HOUR_OF_DAY)-ca.get(Calendar.HOUR_OF_DAY);
			if(cal2.after(ca)&&betnum<2){
				SysLog g =new SysLog();
				g.setCreatetime(new Date());
				try {
				g.setType("0");
				User qu=new User();
				qu.setRole("0");
				List<User>u=this.userDao.queryEnetityByT(qu);
				int i=0,j=0;
				if(null!=u&&u.size()>0){
					for(User mem:u){
						QueryMap q=new QueryMap(null);
						q.addlt("cdate", new DateUtil(cal2.getTime()).getDayEnd());
						q.addgt("cdate", new DateUtil(cal2.getTime()).getDayFirst());
						q.addeq("userid", mem.getId());
						List<UserSchedule> ul=this.userScheduleDao.quertByQueryMap(UserSchedule.class, q);
						if(null!=ul&&ul.size()>0){
								for(UserSchedule us:ul){
									if("0".equals(us.getStatus())){
										us.setStatus("1");
										us.setLastmodifytime(new Date());
										this.userScheduleDao.updateEntity(us);
									}
								}
						}else{
							scheduleHelper.insertWeekScheduleForUser(mem.getId());
							List<UserSchedule> ml=this.userScheduleDao.quertByQueryMap(UserSchedule.class, q);
							j+=ml.size();
							for(UserSchedule us:ml){
								us.setStatus("1");
								us.setLastmodifytime(new Date());
								this.userScheduleDao.updateEntity(us);
							}
						}
					}
					logger.info("一共"+u.size()+"个用户，"+"自动提交了"+i+"条，生成并提交了"+j+"条。");
					g.setMessage("一共"+u.size()+"个用户，"+"自动提交了"+i+"条，生成并提交了"+j+"条。");
				}
				sysLogDao.insertEntity(g);
			} catch (Throwable e) {
				logger.error("数据库错误,",e);
				throw new UserException("作业出错，事务回滚");
			}
			}else{
				logger.info("time not in runtime"+ca.getTime()+"now:"+cal2.getTime());
			}
	}

	public SysLogDao getSysLogDao() {
		return sysLogDao;
	}
	@Autowired
	public void setSysLogDao(SysLogDao sysLogDao) {
		this.sysLogDao = sysLogDao;
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
	public static void main(String[] args) {
		Calendar ca=Calendar.getInstance();
		String end=StringUtil.readProperty("subend", new User());
		String s[]=end.split(":");
		ca.add(Calendar.DAY_OF_MONTH, 1);
		ca.set(Calendar.HOUR_OF_DAY, Integer.parseInt(s[0]));
		ca.set(Calendar.MINUTE, Integer.parseInt(s[1]));
		ca.set(Calendar.SECOND, 0);
		ca.set(Calendar.MILLISECOND, 0);
		Calendar cal2=Calendar.getInstance();
		cal2.add(Calendar.DAY_OF_MONTH, 1);
		int betnum=cal2.get(Calendar.HOUR_OF_DAY)-ca.get(Calendar.HOUR_OF_DAY);
		System.out.println(ca.getTime());
		System.out.println(cal2.getTime());
		System.out.println(betnum);
		if(cal2.after(ca)&&betnum<2){
			System.out.println("===");
		}
	}
}
