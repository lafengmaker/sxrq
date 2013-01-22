package com.lafengmaker.core.helper;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lafengmaker.core.dao.UserScheduleDao;
import com.lafengmaker.core.entity.UserSchedule;
import com.lafengmaker.core.util.DateUtil;
import com.lafengmaker.view.page.QueryMap;
@Service
public class ScheduleHelper {
	private Log log=LogFactory.getLog(ScheduleHelper.class);
	private UserScheduleDao userScheduleDao;
	public  int   insertWeekScheduleForUser(Long id){
		DateUtil du=new DateUtil();
		QueryMap q=new QueryMap().addgt("cdate",DateUtil.formatStringTodate(du.thisMonday(), DateUtil.DATE) ).addlt("cdate", DateUtil.formatStringTodate(du.thisSunday(), DateUtil.DATE)).addeq("userid", id);
		List<UserSchedule>ul=this.userScheduleDao.quertByQueryMap(UserSchedule.class, q);
		if(null!=ul&&ul.size()>0){
			log.info(id+"has record");
//			SysLog g=new SysLog();
//			g.setCreatetime(new Date());
//			g.setMessage(du.today()+"成员:"+id+"已经生成了记录");
//			g.setStatus(1);
//			sysLogDao.insertEntity(g)
			return 0;
		}else{
			Calendar calendar=Calendar.getInstance();
			calendar.setTime(DateUtil.formatStringTodate(du.thisMonday(), DateUtil.DATE));
			UserSchedule us=new UserSchedule();
			us.setLastmodifytime(new Date());
			us.setUserid(id);
			us.setCreatetime(new Date());
			us.setStatus("0");
			int j=0;
			for(int i=0;i<7;i++){
				if(i!=0){
					j=1;
				}
				calendar.add(Calendar.DATE, j);
				us.setCdate(calendar.getTime());
				us.setWeeknum(calendar.get(Calendar.YEAR)+""+calendar.get(Calendar.WEEK_OF_YEAR));
				userScheduleDao.insertEntity(us);
			}
			return 1;
		}
		
		
	}
	public UserScheduleDao getUserScheduleDao() {
		return userScheduleDao;
	}
	@Autowired
	public void setUserScheduleDao(UserScheduleDao userScheduleDao) {
		this.userScheduleDao = userScheduleDao;
	}
	
	
}