package com.lafengmaker.core.service;

import com.lafengmaker.core.dao.SysLogDao;
import com.lafengmaker.core.dao.UserScheduleDao;

public class JobManageServiceImpl implements JobManageService {
	private SysLogDao sysLogDao;
	private UserScheduleDao userScheduleDao;
	public void weekJob() {
		
	}
	public SysLogDao getSysLogDao() {
		return sysLogDao;
	}
	public void setSysLogDao(SysLogDao sysLogDao) {
		this.sysLogDao = sysLogDao;
	}
	public UserScheduleDao getUserScheduleDao() {
		return userScheduleDao;
	}
	public void setUserScheduleDao(UserScheduleDao userScheduleDao) {
		this.userScheduleDao = userScheduleDao;
	}
	
	
}
