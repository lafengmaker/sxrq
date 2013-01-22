package com.lafengmaker.core.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Digits;

import org.hibernate.annotations.GenericGenerator;
@Entity
public class  UserSchedule {
	private Long id;
	private Long userid;
	private Date cdate;
	private Double weekforecast;
	private Double weekplan;
	private Double monthforecast;
	private Double monthplan;
	@Digits(integer=6,fraction=2,message="指定气量输入格式不对，小数点前最多{integer}位，小数点后最多{fraction}位")
	private Double dayVol;
	@Digits(integer=6,fraction=2,message="变更格式不对，小数点前最多{integer}位，小数点后最多{fraction}位")
	private Double changeVol;
	private Double accVol;
	private String description;
	private String changedesc;
	private String status;//0 提交待审核
	private User buser;
	private Date createtime;
	private Date lastmodifytime;
	private String weeknum;
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
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	@JoinColumn(insertable=false,updatable=false, name="userid")
	public User getBuser() {
		return buser;
	}
	public void setBuser(User buser) {
		this.buser = buser;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getChangedesc() {
		return changedesc;
	}
	public void setChangedesc(String changedesc) {
		this.changedesc = changedesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getWeekforecast() {
		return weekforecast;
	}
	public void setWeekforecast(Double weekforecast) {
		this.weekforecast = weekforecast;
	}
	public Double getWeekplan() {
		return weekplan;
	}
	public void setWeekplan(Double weekplan) {
		this.weekplan = weekplan;
	}
	public Double getMonthforecast() {
		return monthforecast;
	}
	public void setMonthforecast(Double monthforecast) {
		this.monthforecast = monthforecast;
	}
	public Double getMonthplan() {
		return monthplan;
	}
	public void setMonthplan(Double monthplan) {
		this.monthplan = monthplan;
	}
	public Double getDayVol() {
		return dayVol;
	}
	public void setDayVol(Double dayVol) {
		this.dayVol = dayVol;
	}
	public Double getChangeVol() {
		return changeVol;
	}
	public void setChangeVol(Double changeVol) {
		this.changeVol = changeVol;
	}
	public Double getAccVol() {
		return accVol;
	}
	public void setAccVol(Double accVol) {
		this.accVol = accVol;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Column(length=10)
	public String getWeeknum() {
		return weeknum;
	}
	public void setWeeknum(String weeknum) {
		this.weeknum = weeknum;
	}
	public Date getLastmodifytime() {
		return lastmodifytime;
	}
	public void setLastmodifytime(Date lastmodifytime) {
		this.lastmodifytime = lastmodifytime;
	}
	
}
