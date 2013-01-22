package com.lafengmaker.app.schedule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lafengmaker.core.entity.User;
import com.lafengmaker.core.entity.UserSchedule;
import com.lafengmaker.core.exception.UserException;
import com.lafengmaker.core.service.ScheduleService;
import com.lafengmaker.core.service.UserService;
import com.lafengmaker.core.util.DateUtil;
import com.lafengmaker.core.util.StringUtil;
import com.lafengmaker.view.page.PageView;
import com.lafengmaker.view.schedule.ScheduleSearch;
@Controller
public class ScheduleManageControlloer {
	Logger logger=Logger.getLogger(ScheduleManageControlloer.class);
	private ScheduleService scheduleService;
	private UserService userService;
	@RequestMapping(value="/schedule/weeklist")
	public String weeklist(ModelMap modelMap,HttpServletRequest request,ScheduleSearch search){
		modelMap.addAttribute("userlist", userService.getAllUser());
		if(null==search.getUserid()){
			return "/schedule/list";
		}
		modelMap.addAttribute("scheduleList", scheduleService.getWeeklyList(search.getDate(), search.getUserid()));
		modelMap.addAttribute("scl", new UserSchedule() );
		return "/schedule/list";
	}
	@RequestMapping(value="/schedule/weeklistsubmit")
	@ResponseBody
	public ModelAndView weeklistsubmit(ModelMap modelMap,HttpServletRequest request,ScheduleSearch search){
		String p=request.getParameter("p");
		try {
			this.scheduleService.updateWeekdata(p);
		} catch (Exception e) {
			throw new UserException("更新出错");
		}
		return null;
	}
	@RequestMapping(value="/schedule/day")
	public String showdaydata(ModelMap modelMap,HttpServletRequest request,ScheduleSearch search){
		if(StringUtil.isEmpty(search.getDate())){
			search.setDate(DateUtil.toStirngDate(new Date(), DateUtil.DATE));
		}
		if(null==search.getUserid()||"0".equals(search.getUserid())){
			User u=(User)request.getSession().getAttribute("user");
			search.setUserid(u.getId());
		}
		modelMap.addAttribute("userlist", userService.getAllUser());
		UserSchedule us=this.scheduleService.getdayDate(search.getDate(), search.getUserid());
		if(null!=us){
			modelMap.addAttribute("day1", new DateUtil(us.getCdate()).add(Calendar.DAY_OF_MONTH, 1));
			modelMap.addAttribute("changeable","2".equals(us.getStatus())?false: new DateUtil().changeable());
		}
		modelMap.addAttribute("day", us);
		String dtime=StringUtil.readProperty("deadline", "day.properties", this);
		modelMap.addAttribute("deadline", search.getDate()+" "+dtime);
		return "/schedule/dayinfo";
	}
	@RequestMapping(value="/schedule/daysubmit")
	public String daydatasubmit(ModelMap modelMap,HttpServletRequest request,ScheduleSearch search,@Valid UserSchedule day,BindingResult bindingResult){
		System.out.println(bindingResult);
		modelMap.addAttribute("userlist", userService.getAllUser());
		if(StringUtil.isEmpty(search.getDate())){
			search.setDate(DateUtil.toStirngDate(new Date(), DateUtil.DATE));
		}
		if(null==search.getUserid()||"0".equals(search.getUserid())){
			User u=(User)request.getSession().getAttribute("user");
			search.setUserid(u.getId());
		}
		if(null!=day){
			modelMap.addAttribute("day1", new DateUtil(search.getDate()).add(Calendar.DAY_OF_MONTH, 1));
		}
		modelMap.addAttribute("changeable", new DateUtil().changeable());
		String dtime=StringUtil.readProperty("deadline", "day.properties", this);
		modelMap.addAttribute("deadline", search.getDate()+" "+dtime);
		if(bindingResult.hasErrors()){
			UserSchedule us=this.scheduleService.getdayDate(search.getDate(), search.getUserid());
			modelMap.addAttribute("day", us);
			return "/schedule/dayinfo"; 
		}
		String type=request.getParameter("type");
		try {
			day=this.scheduleService.update(day, type);
			modelMap.addAttribute("day", day);
		} catch (Exception e) {
			logger.error("更新出错",e);
			bindingResult.rejectValue("dayVol", null, "修改出错");
			bindingResult.rejectValue("changeVol", null, "修改出错");
			UserSchedule us=this.scheduleService.getdayDate(search.getDate(), search.getUserid());
			modelMap.addAttribute("day", us);
		}
		return "/schedule/dayinfo"; 
	}
	@RequestMapping(value="/schedule/daylist")
	public String showdaydataList(ModelMap modelMap,HttpServletRequest request,ScheduleSearch search,Integer currpage){
		if(null==currpage){
			currpage=1;
		}
		PageView<UserSchedule>pageView=scheduleService.getPageView(search, currpage);
		modelMap.addAttribute("search", search);
		modelMap.addAttribute("pageView", pageView);
		return "/schedule/daylist"; 
	}
	public ScheduleService getScheduleService() {
		return scheduleService;
	}
	@Autowired
	public void setScheduleService(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
		
}
