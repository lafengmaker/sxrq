package com.lafengmaker.core.service;
import java.util.Date;
import java.util.List;

import com.lafengmaker.core.entity.UserSchedule;
import com.lafengmaker.core.exception.UserException;
import com.lafengmaker.view.page.PageView;
import com.lafengmaker.view.schedule.ScheduleSearch;

public interface ScheduleService {
	public List<UserSchedule>getWeeklyList(String date,Long userid,Date dateshow);
	public UserSchedule getdayDate(String date,Long userid);
	public UserSchedule insertorupdate(UserSchedule userSchedule,String tpye) throws Exception;
	public void updateWeekdata(String p) throws Exception;
	public PageView<UserSchedule> getPageView( ScheduleSearch scheduleSearch ,Integer cu) ;
	public void daydatacheck(String p) throws UserException;
}
