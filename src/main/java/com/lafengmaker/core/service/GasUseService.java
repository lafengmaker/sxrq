package com.lafengmaker.core.service;

import com.lafengmaker.core.entity.GasUse;
import com.lafengmaker.view.gasuse.GasUseSearch;
import com.lafengmaker.view.gasuse.GasUseView;
import com.lafengmaker.view.page.PageView;

public interface GasUseService {
	public void addGasuse(GasUse gasUse);
	public PageView<GasUse> getGesUsePageView(GasUseSearch gasUse,int currpage);
	public GasUseView findgasUseViewById(String id);
	
}
