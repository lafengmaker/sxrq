package com.lafengmaker.core.service;

import org.springframework.transaction.annotation.Transactional;

import com.lafengmaker.core.exception.UserException;

public interface JobManageService {
	@Transactional
	public void insertWeekData();
	public void updateDaySchedule() throws UserException;
}
