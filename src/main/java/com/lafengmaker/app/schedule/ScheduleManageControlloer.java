package com.lafengmaker.app.schedule;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lafengmaker.core.entity.User;
import com.lafengmaker.core.entity.UserSchedule;
import com.lafengmaker.core.service.ScheduleService;
import com.lafengmaker.core.service.UserService;
import com.lafengmaker.core.util.DateUtil;
import com.lafengmaker.core.util.SessionUtil;
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
		List<User>ul=this.userService.getcommUserNoEmpty();
		modelMap.addAttribute("userlist",ul );
		modelMap.addAttribute("userdiable", true);
		String add=StringUtil.readProperty("weekdead",this);
		DateUtil du=new DateUtil(new DateUtil(search.getDate()).thisMonday());
		Date deadshow= du.add(Calendar.DAY_OF_MONTH, Integer.parseInt(add));
		Date deadshowcompare= du.add(Calendar.DAY_OF_MONTH, 1);
		modelMap.addAttribute("weekdead",deadshow);
		User u= SessionUtil.getUserFromRequest(request);
		if(!"0".equals(u.getRole())){
			modelMap.addAttribute("userdiable", false);
			if(ul.size()>0){
				setSearchUserid(search,ul.get(0).getId());
			}
		}else{
			setSearchUserid(search,u.getId());
		}
		if(StringUtil.isEmpty(search.getDate())){
			search.setDate(DateUtil.toStirngDate(new Date(), DateUtil.DATE));
		}
		modelMap.addAttribute("scheduleList", scheduleService.getWeeklyList(search.getDate(), search.getUserid(),deadshowcompare));
		modelMap.addAttribute("scl", new UserSchedule());
		modelMap.addAttribute("subable", false);
		if(DateUtil.isDateBefore(new Date(), deadshowcompare)&&u.getId().equals(search.getUserid())){
			modelMap.addAttribute("subable", true);
		}
		return "/schedule/list";
	}
	private void setSearchUserid(ScheduleSearch scheduleSearch,Long userid){
		if(null==scheduleSearch.getUserid()||scheduleSearch.getUserid().intValue()==0){
			scheduleSearch.setUserid(userid);
		}
	}
	@RequestMapping(value="/schedule/weeklistsubmit")
	@ResponseBody
	public ModelAndView weeklistsubmit(ModelMap modelMap,HttpServletRequest request,ScheduleSearch search,HttpServletResponse response){
		String p=request.getParameter("p");
		response.setCharacterEncoding("utf-8");
		try {
			this.scheduleService.updateWeekdata(p);
			response.getWriter().print("提交成功");
		} catch (Exception e) {
			try {
				response.getWriter().print(e.getMessage());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}
	@RequestMapping(value="/schedule/day")
	public String showdaydata(ModelMap modelMap,HttpServletRequest request,@ModelAttribute ScheduleSearch search,BindingResult bindingResult){
		bindingResult=(BindingResult)request.getAttribute("bdr");
		User u=(User)request.getSession().getAttribute("user");
		ScheduleSearch ss=(ScheduleSearch)request.getAttribute("search");
		UserSchedule dds=(UserSchedule)request.getAttribute("day");
		if(null!=ss){
			search.setDate(ss.getDate());
			search.setUserid(ss.getUserid());
		}
		if(null==search.getUserid()||"0".equals(search.getUserid())){
			search.setUserid(u.getId());
		}
		modelMap.addAttribute("userlist", userService.getcommUser());
		if(StringUtil.isEmpty(search.getDate())){
			search.setDate(DateUtil.toStirngDate(new DateUtil().add(Calendar.DAY_OF_MONTH, 1), DateUtil.DATE));
		}
		UserSchedule us=this.scheduleService.getdayDate(search.getDate(), search.getUserid());
		if(null==us){
			us=new UserSchedule();
			us.setCdate(DateUtil.formatStringTodate(search.getDate(), DateUtil.DATE));
			us.setStatus("0");
			us.setUserid(u.getId());
			us.setBuser(u);
		}
		Date d=new DateUtil(us.getCdate()).add(Calendar.DAY_OF_MONTH, 1);
		Date d2=new DateUtil(us.getCdate()).add(Calendar.DAY_OF_MONTH, -1);
		modelMap.addAttribute("day1", d);
		modelMap.addAttribute("changeable","1".equals(us.getStatus())&&new DateUtil(search.getDate()).changeable()?true:false );
		if("0".equals(us.getStatus())&&new DateUtil().submitable(us.getCdate())){
			modelMap.addAttribute("submitable", true);
		}
		if(null!=dds&&null!=dds.getAccVol()){
			us.setAccVol(dds.getAccVol());
			us.setDescription(dds.getDescription());
		}
		if(null!=dds&&null!=dds.getChangeVol()){
			us.setChangeVol(dds.getChangeVol());
			us.setChangedesc(dds.getChangedesc());
		}
		modelMap.addAttribute("day", us);
		String dtime=StringUtil.readProperty("subend", "day.properties", this);
		modelMap.addAttribute("deadline", DateUtil.toStirngDate(d2, DateUtil.DATE)+" "+dtime);
		return "/schedule/dayinfo";
	}
	@RequestMapping(value="/schedule/daysubmit")
	public String daydatasubmit(ModelMap modelMap,HttpServletRequest request,ScheduleSearch search,@Valid UserSchedule day,BindingResult bindingResult){
		search.setDate(DateUtil.toStirngDate(day.getCdate(), DateUtil.DATE));
		search.setUserid(day.getUserid());
		request.setAttribute("search", search);
		request.setAttribute("day", day);
		if(bindingResult.hasErrors()){
			request.setAttribute("bdr",bindingResult);
			return "forward:day";
		}
		String type=request.getParameter("type");
		try {
			day=this.scheduleService.insertorupdate(day, type);
			modelMap.addAttribute("day", day);
		} catch (Exception e) {
			logger.error("更新出错",e);
			bindingResult.rejectValue("dayVol", null, e.getMessage());
		}
		return "forward:day";
	}
	@RequestMapping(value="/schedule/daylist")
	public String showdaydataList(ModelMap modelMap,HttpServletRequest request,ScheduleSearch search,Integer currpage){
		User u=SessionUtil.getUserFromRequest(request);
		
		if(null==currpage){
			currpage=1;
		}
		if("0".equals(u.getRole())){
			modelMap.addAttribute("userdiable", true);
			search.setUserid(u.getId());
		}
		if(StringUtil.isEmpty(search.getDate())){
			search.setDate(DateUtil.toStirngDate(new DateUtil().add(Calendar.DAY_OF_MONTH, 1), DateUtil.DATE));
		}
		if(StringUtil.isEmpty(search.getEnddate())){
			search.setEnddate(DateUtil.toStirngDate(new DateUtil().add(Calendar.DAY_OF_MONTH, 1), DateUtil.DATE));
		}
		modelMap.addAttribute("userlist", userService.getcommUser());
		PageView<UserSchedule>pageView=scheduleService.getPageView(search, currpage);
		modelMap.addAttribute("search", search);
		modelMap.addAttribute("pageView", pageView);
		return "/schedule/daylist"; 
	}
	@RequestMapping(value="/schedule/daydataCheck")
	@ResponseBody
	public String daydataCheck(HttpServletRequest request){
		String p=request.getParameter("p");
		if(!StringUtil.isEmpty(p)){
			this.scheduleService.daydatacheck(p);
		}
		return null;
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
