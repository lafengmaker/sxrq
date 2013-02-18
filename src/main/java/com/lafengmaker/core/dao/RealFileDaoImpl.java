package com.lafengmaker.core.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lafengmaker.core.dao.impl.BaseDaoImpl;
import com.lafengmaker.core.entity.RealFile;
@Repository
public class RealFileDaoImpl extends BaseDaoImpl<RealFile> implements RealFileDao {
	@Autowired
	public void setMySessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public RealFile getFileByMD5(String md5) {
		RealFile r =new RealFile();
		r.setMd5str(md5);
		List<RealFile>rl=this.getHibernateTemplate().findByExample(r);
		if(null!=rl&&rl.size()>0){
			return rl.get(0);
		}
		return null;
	}
	
}
