package com.lafengmaker.core.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lafengmaker.core.dao.NoticePubDao;
import com.lafengmaker.core.dao.RealFileDao;
import com.lafengmaker.core.dao.VFileDao;
import com.lafengmaker.core.entity.NoticePub;
import com.lafengmaker.core.entity.RealFile;
import com.lafengmaker.core.entity.VFile;
import com.lafengmaker.core.exception.UserException;
import com.lafengmaker.core.util.DateUtil;
import com.lafengmaker.core.util.FileUtil;
import com.lafengmaker.core.util.MD5Util;
import com.lafengmaker.core.util.StringUtil;
import com.lafengmaker.view.page.PageView;
import com.lafengmaker.view.page.QueryMap;
@Service
public class NoticePubServiceImpl implements NoticePubService {
	Logger logger=Logger.getLogger(NoticePubServiceImpl.class);
	private NoticePubDao noticePubDao;
	private RealFileDao realFileDao;
	private VFileDao vFileDao;
	@Transactional
	public void insertOrupdateNoticePub(NoticePub noticePub, List<MultipartFile> files,String [] vfid) throws Exception {
		List<VFile >rfl=null;
		if(null!=files&&files.size()>0){
			rfl=new ArrayList<VFile>();
			logger.info("filesize:"+files.size());
			for(MultipartFile mf:files){
				if(mf.getSize()>0){
					String md5=MD5Util.getStreamHash(mf.getInputStream());
				RealFile rf=realFileDao.getFileByMD5(md5);
				VFile vf =new VFile();
				if(null==rf){
					String filedir=StringUtil.readProperty("filedir", this);
					String sp=StringUtil.readProperty("dirspilt", this);
					filedir=filedir+new DateUtil().today()+sp+md5+ mf.getOriginalFilename();
					FileOutputStream fs = new FileOutputStream(FileUtil.getFile(filedir));  
					byte[] buffer = new byte[1024 * 1024];  
					int byteread = 0;  
					InputStream in=mf.getInputStream();
					while ((byteread = in.read(buffer)) != -1) { 
						fs.write(buffer, 0, byteread);  
						fs.flush();  
					}  
					fs.close();  
					mf.getInputStream().close();  
					RealFile r=new RealFile();
					r.setFiledir(filedir);
					r.setMd5str(md5);
					if(mf.getOriginalFilename().indexOf(".")!=-1){
						r.setFiletype(mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf(".")+1));
					}
					r.setName(mf.getOriginalFilename());
					this.realFileDao.insertEntity(r);
					vf.setRfileid(r.getId());
				}else{
					vf.setRfileid(rf.getId());
				}
				if(rfl.contains(vf)){
					
				}
				rfl.add(vf);
				}
			}
		}
		if(null!=noticePub){
			if(null!=noticePub.getId()){
				NoticePub nb=	this.noticePubDao.queryEnetityById(NoticePub.class, noticePub.getId());
				nb.setContent(noticePub.getContent());
				nb.setAdduser(noticePub.getAdduser());
				nb.setEnddate(noticePub.getEnddate());
				nb.setShowindex(noticePub.getShowindex());
				nb.setTitle(noticePub.getTitle());
				nb.setDeleteflag(0);
				if(null!=nb.getVfList()){
					Set<Long>idl=null;
					if(null!=vfid&&vfid.length>0){
						idl=new HashSet<Long>();
						for(String id:vfid){
							logger.info("idls"+id);
							idl.add(StringUtil.getLongnull(id));
						}
					}
					for(VFile v:nb.getVfList()){
						logger.info(v.getId());
						if(null!=idl&&idl.contains(v.getId())){
							continue;
						}
						this.vFileDao.deleteT(v);
					}
				}
				this.noticePubDao.updateEntity(nb);
			}else{
				noticePub.setCreatetime(new Date());
				this.noticePubDao.insertEntity(noticePub);
			}
			if(null!=rfl&&rfl.size()>0){
				for(VFile vv:rfl){
					vv.setPubid(noticePub.getId());
					List<VFile> vfs=this.vFileDao.queryEnetityByT(vv);
					if(null!=vfs&&vfs.size()>0){
						continue;
					}
					this.vFileDao.insertEntity(vv);
				}
			}
		}
		
	}

	public PageView<NoticePub> getNotcePub(Integer currpage,NoticePub noticePub) {
		PageView<NoticePub>pv=new PageView<NoticePub>(currpage);
		QueryMap q=new QueryMap();
		if(!StringUtil.isEmpty(noticePub.getContent())){
			q.addlike("content", "%"+StringUtil.trim(noticePub.getContent())+"%");
		}
		if(!StringUtil.isEmpty(noticePub.getTitle())){
			q.addlike("title", "%"+StringUtil.trim(noticePub.getTitle())+"%");
		}
		q.addeq("deleteflag", 0);
		List<NoticePub>ul=this.noticePubDao.quertByQueryMap(NoticePub.class, q);
		Long t=this.noticePubDao.queryPageCountByQueryMap(NoticePub.class, q);
		pv.setRecords(ul);pv.setTotalrecord(t);
		return pv;
	}
	
	public List<NoticePub> showNoticeOnWelcome(Long userid) {
		QueryMap q=new QueryMap();
		q.setFirst(0);
		q.addgt("enddate",  new DateUtil().getDayEnd());
		q.addNullMap("enddate");
		q.addNullMap("touser");
		q.setOrder("showindex");
		q.setOrder("createtime");
		q.addeq("deleteflag", 0);
		q.addeq("touser", userid);
		List<NoticePub>bl=this.noticePubDao.quertByQueryMap(NoticePub.class, q);
		return bl;
	}
	@Transactional
	public NoticePub getNoticePubById(Long id) {
		NoticePub noticePub=this.noticePubDao.queryEnetityById(NoticePub.class,id);
		for(VFile v:noticePub.getVfList()){
			System.out.println(v.getRealFile().getName());
		}
		return noticePub;
	}
	@Transactional
	public void delNoticePub(Long id) throws UserException {
		NoticePub nb= this.noticePubDao.queryEnetityById(NoticePub.class, id);
		if(null==nb){
			throw new UserException("id 不存在");
		}
		nb.setDeleteflag(1);
		this.noticePubDao.updateEntity(nb);
		
	}
	@Override
	public VFile getFileByvfile(Long id) {
		VFile vf=this.vFileDao.queryEnetityById(VFile.class, id);
		return vf;
	}

	public NoticePubDao getNoticePubDao() {
		return noticePubDao;
	}
	@Autowired
	public void setNoticePubDao(NoticePubDao noticePubDao) {
		this.noticePubDao = noticePubDao;
	}
	
	public RealFileDao getRealFileDao() {
		return realFileDao;
	}
	@Autowired
	public void setRealFileDao(RealFileDao realFileDao) {
		this.realFileDao = realFileDao;
	}

	public VFileDao getvFileDao() {
		return vFileDao;
	}
	@Autowired
	public void setvFileDao(VFileDao vFileDao) {
		this.vFileDao = vFileDao;
	}
}
