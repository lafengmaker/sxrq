package com.lafengmaker.core.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.lafengmaker.core.dao.SysLogDao;
import com.lafengmaker.core.entity.SysLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:springmvc.xml")
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)
@Transactional
public class JobManageServiceImplTest {
	private JobManageService jobManageService;
	private SysLogDao sysLogDao;
	@Test
//	@Rollback(value=false)
	public void updateDaySchedule() {
		try {
			try {
				jobManageService.updateDaySchedule();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<SysLog> sl2=sysLogDao.queryEnetityByT(new SysLog());
			System.out.println(sl2.size()+"=============");
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public JobManageService getJobManageService() {
		return jobManageService;
	}
	@Autowired
	public void setJobManageService(JobManageService jobManageService) {
		this.jobManageService = jobManageService;
	}
	public SysLogDao getSysLogDao() {
		return sysLogDao;
	}
	@Autowired
	public void setSysLogDao(SysLogDao sysLogDao) {
		this.sysLogDao = sysLogDao;
	}
	
	
}
