package com.lafengmaker.core.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class VFile {
	private Long id;
	private RealFile realFile;
	private Long rfileid;
	private Long pubid;
	private  NoticePub noticePub;
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},fetch=FetchType.EAGER)
	@JoinColumn( name="rfileid",insertable=false,updatable=false)
	public RealFile getRealFile() {
		return realFile;
	}
	public void setRealFile(RealFile realFile) {
		this.realFile = realFile;
	}
	public Long getRfileid() {
		return rfileid;
	}
	public void setRfileid(Long rfileid) {
		this.rfileid = rfileid;
	}
	public Long getPubid() {
		return pubid;
	}
	public void setPubid(Long pubid) {
		this.pubid = pubid;
	}
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinColumn(insertable=false,updatable=false, name="pubid")
	public NoticePub getNoticePub() {
		return noticePub;
	}
	public void setNoticePub(NoticePub noticePub) {
		this.noticePub = noticePub;
	}
}
