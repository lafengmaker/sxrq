package com.lafengmaker.core.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.lafengmaker.core.entity.NoticePub;
import com.lafengmaker.core.entity.VFile;
import com.lafengmaker.core.exception.UserException;
import com.lafengmaker.view.page.PageView;

public interface NoticePubService {
	public void insertOrupdateNoticePub(NoticePub noticePub, List<MultipartFile> files,String [] vfid) throws Exception;
	public PageView<NoticePub> getNotcePub(Integer currpage,NoticePub noticePub);
	public List<NoticePub> showNoticeOnWelcome(Long userid);
	public NoticePub getNoticePubById(Long id);
	public void delNoticePub(Long id) throws UserException;
	public VFile getFileByvfile(Long id);
}
