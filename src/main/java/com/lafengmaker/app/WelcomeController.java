package com.lafengmaker.app;

import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lafengmaker.core.entity.User;
import com.lafengmaker.core.entity.VFile;
import com.lafengmaker.core.service.NoticePubService;
import com.lafengmaker.core.util.SessionUtil;
import com.lafengmaker.core.util.StringUtil;
@Controller
public class WelcomeController {
	private NoticePubService noticePubService;
	@RequestMapping(value="welcomeinfo")
	public String showWelcomeInfo(HttpServletRequest request,ModelMap modelMap){
		User u=SessionUtil.getUserFromRequest(request);
		modelMap.addAttribute("pubs", this.noticePubService.showNoticeOnWelcome(u.getId()));
		return "welcome";
	}
	@RequestMapping(value="shownoticeinfo")
	public String showNotice(HttpServletRequest request,ModelMap modelMap){
		String ids=request.getParameter("id");
		Long id=StringUtil.getLong(ids);
		modelMap.addAttribute("pub",this.noticePubService.getNoticePubById(id));
		return "noticeinfo";
	}
    @RequestMapping("download")
    public void download(HttpServletResponse res,HttpServletRequest request) throws Exception {
        OutputStream os = res.getOutputStream();
        try {
            res.reset();
            VFile vf=this.noticePubService.getFileByvfile(StringUtil.getLong(request.getParameter("id")));
            String fileName = URLEncoder.encode(vf.getRealFile().getName(), "UTF-8"); 
            if (fileName.length() > 150) { 
                String guessCharset = "gb2312"; /*根据request的locale 得出可能的编码，中文操作系统通常是gb2312*/ 
                fileName = new String(vf.getRealFile().getName().getBytes(guessCharset), "ISO8859-1");  
            } 
            res.setHeader("Content-Disposition", "attachment; filename="+fileName);
            res.setContentType("application/octet-stream; charset=utf-8");
            os.write(FileUtils.readFileToByteArray(new File(vf.getRealFile().getFiledir())));
            os.flush();
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }

	public NoticePubService getNoticePubService() {
		return noticePubService;
	}
	@Autowired
	public void setNoticePubService(NoticePubService noticePubService) {
		this.noticePubService = noticePubService;
	}
	
}
