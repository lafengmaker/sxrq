package com.lafengmaker.view.gasuse;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.lafengmaker.core.entity.GasUse;
import com.lafengmaker.core.util.DateUtil;
public class GasUseView {
	private Long id;
	private Long userid;
	private Double gasvol;
	private String description;
	private String addtime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Min(value=1,message="用户不能为空")
	@NotNull(message="用户不能为空")
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	@Min(value=0, message="用气量不能小于0")
	@Digits(fraction=2,integer=6,message="用气量数据格式不正确")
	public Double getGasvol() {
		return gasvol;
	}
	public void setGasvol(Double gasvol) {
		this.gasvol = gasvol;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@NotEmpty(message="时间不能为空")
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	public GasUse toGasUse(){
		GasUse gu=new GasUse();
		gu.setDescription(description);
		gu.setAddtime(DateUtil.formatStringTodate(addtime, DateUtil.DATE));
		gu.setUserid(userid);
		gu.setId(id);
		gu.setGasvol(gasvol);
		return gu;
	}
	public GasUseView toGasUseView(GasUse gu){
		this.description=gu.getDescription();
		this.addtime=DateUtil.toStirngDate(gu.getAddtime(), DateUtil.DATE);
		this.gasvol=gu.getGasvol();
		this.id=gu.getId();
		this.userid=gu.getUserid();
		return this;
	}
}
