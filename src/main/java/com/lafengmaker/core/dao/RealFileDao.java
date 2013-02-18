package com.lafengmaker.core.dao;

import com.lafengmaker.core.entity.RealFile;

public interface RealFileDao extends BaseDao<RealFile> {
	public RealFile getFileByMD5(String md5);

}
