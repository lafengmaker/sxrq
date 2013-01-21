package com.lafengmaker.core.service;

import java.util.List;

import com.lafengmaker.core.entity.NoticePub;
import com.lafengmaker.view.page.PageView;

public interface NoticePubService {
	public void insertOrupdateNoticePub(NoticePub noticePub);
	public PageView<NoticePub> getNotcePub(Integer currpage,NoticePub noticePub);
	public List<NoticePub> showNoticeOnWelcome();
	public NoticePub getNoticePubById(Long id);
}
