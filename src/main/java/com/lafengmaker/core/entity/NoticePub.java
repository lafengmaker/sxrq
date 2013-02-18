package com.lafengmaker.core.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class NoticePub {
	private Long id;
	private Long userid;
	private Long touser;
	private String  adduser;	
	private String title;
	private Date createtime;
	private Date enddate;
	private Integer showindex;
	private String content;
	private Integer deleteflag;
	private List<VFile>vfList;
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id",  nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAdduser() {
		return adduser;
	}
	public void setAdduser(String adduser) {
		this.adduser = adduser;
	}
	@Column(length=500)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Lob
	@Basic(fetch = FetchType.EAGER) 
	//@Column(name="REMARK", columnDefinition="CLOB", nullable=true) 
	@Column(name="REMARK", columnDefinition="LONGTEXT", nullable=true) 
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public Integer getShowindex() {
		return showindex;
	}
	public void setShowindex(Integer showindex) {
		this.showindex = showindex;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Integer getDeleteflag() {
		return deleteflag;
	}
	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}
	public Long getTouser() {
		return touser;
	}
	public void setTouser(Long touser) {
		this.touser = touser;
	}
	@OneToMany(mappedBy="noticePub",targetEntity=VFile.class,fetch=FetchType.LAZY)
	public List<VFile> getVfList() {
		return vfList;
	}
	public void setVfList(List<VFile> vfList) {
		this.vfList = vfList;
	}
}
