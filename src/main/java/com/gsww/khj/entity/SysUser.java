package com.gsww.khj.entity;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_user")

public class SysUser implements java.io.Serializable {
	
	/** 
	 * serialVersionUID :(用一句换描述这个变量的作用)
	 */
	private static final long serialVersionUID = 1584070188708253917L;

	// Fields
	private String userId;
	private String userName;
	private String telphone;
	private String weixin;
	private String nickName;
	private String sex;
	private String province;
	private String city;
	private String birthday;
	private String xingzuo;
	private String school;
	private String xueli;
	private String zhiye;

	private String czjl;
	private String qd;
	private String xhsw;
	private String lxjl;
	private String zwbq;
	private String yyah;
	private String xhcw;
	private String dylx;
	private String ppcp;
	private String dfzy;
	private String dfnld;
	private String dfnlx;
	private String dfxl;
	private String dfxz;
	private String createTime;
	private String state;
	private String bstate;
	
	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** minimal constructor */
	public SysUser(String userId) {
		this.userId = userId;
	}

	/** full constructor */
	public SysUser(String userId, String userName, String telphone, String weixin, String nickName, String sex,
			String province, String city, String birthday, String xingzuo, String school, String xueli, String zhiye,
			String czjl, String qd, String xhsw, String lxjl, String zwbq, String yyah, String xhcw, String dylx,
			String ppcp, String dfzy, String dfnld, String dfnlx, String dfxl, String dfxz, String createTime,
			String state,String bstate) {
		this.userId = userId;
		this.userName = userName;
		this.telphone = telphone;
		this.weixin = weixin;
		this.nickName = nickName;
		this.sex = sex;
		this.province = province;
		this.city = city;
		this.birthday = birthday;
		this.xingzuo = xingzuo;
		this.school = school;
		this.xueli = xueli;
		this.zhiye = zhiye;
		this.czjl = czjl;
		this.qd = qd;
		this.xhsw = xhsw;
		this.lxjl = lxjl;
		this.zwbq = zwbq;
		this.yyah = yyah;
		this.xhcw = xhcw;
		this.dylx = dylx;
		this.ppcp = ppcp;
		this.dfzy = dfzy;
		this.dfnld = dfnld;
		this.dfnlx = dfnlx;
		this.dfxl = dfxl;
		this.dfxz = dfxz;
		this.createTime = createTime;
		this.state = state;
		this.bstate=bstate;
		
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "USER_ID", unique = true, nullable = false, length = 32)

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "USER_NAME", length = 64)

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "TELPHONE", length = 20)

	public String getTelphone() {
		return this.telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	@Column(name = "WEIXIN", length = 64)

	public String getWeixin() {
		return this.weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	@Column(name = "NICK_NAME", length = 64)

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "SEX", length = 1)

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "PROVINCE", length = 32)

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name = "CITY", length = 32)

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "BIRTHDAY", length = 20)

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Column(name = "XINGZUO", length = 8)

	public String getXingzuo() {
		return this.xingzuo;
	}

	public void setXingzuo(String xingzuo) {
		this.xingzuo = xingzuo;
	}

	@Column(name = "SCHOOL", length = 64)

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Column(name = "XUELI", length = 64)

	public String getXueli() {
		return this.xueli;
	}

	public void setXueli(String xueli) {
		this.xueli = xueli;
	}

	@Column(name = "ZHIYE", length = 64)

	public String getZhiye() {
		return zhiye;
	}

	public void setZhiye(String zhiye) {
		this.zhiye = zhiye;
	}

	@Column(name = "CZJL", length = 512)

	public String getCzjl() {
		return this.czjl;
	}

	public void setCzjl(String czjl) {
		this.czjl = czjl;
	}

	@Column(name = "QD", length = 512)
	public String getQd() {
		return qd;
	}
	
	public void setQd(String qd) {
		this.qd = qd;
	}

	@Column(name = "XHSW", length = 512)
	public String getXhsw() {
		return xhsw;
	}
	
	public void setXhsw(String xhsw) {
		this.xhsw = xhsw;
	}

	@Column(name = "LXHL", length = 512)
	public String getLxjl() {
		return lxjl;
	}
	
	public void setLxjl(String lxjl) {
		this.lxjl = lxjl;
	}

	@Column(name = "ZWBQ", length = 32)

	public String getZwbq() {
		return this.zwbq;
	}

	public void setZwbq(String zwbq) {
		this.zwbq = zwbq;
	}

	@Column(name = "YYAH", length = 32)

	public String getYyah() {
		return this.yyah;
	}

	public void setYyah(String yyah) {
		this.yyah = yyah;
	}

	@Column(name = "XHCW", length = 32)

	public String getXhcw() {
		return this.xhcw;
	}

	public void setXhcw(String xhcw) {
		this.xhcw = xhcw;
	}

	@Column(name = "DYLX", length = 32)

	public String getDylx() {
		return this.dylx;
	}

	public void setDylx(String dylx) {
		this.dylx = dylx;
	}

	@Column(name = "PPCP", length = 32)

	public String getPpcp() {
		return this.ppcp;
	}

	public void setPpcp(String ppcp) {
		this.ppcp = ppcp;
	}

	@Column(name = "DFZY", length = 32)

	public String getDfzy() {
		return this.dfzy;
	}

	public void setDfzy(String dfzy) {
		this.dfzy = dfzy;
	}

	@Column(name = "DFNLD", length = 8)

	public String getDfnld() {
		return this.dfnld;
	}

	public void setDfnld(String dfnld) {
		this.dfnld = dfnld;
	}

	@Column(name = "DFNLX", length = 8)

	public String getDfnlx() {
		return this.dfnlx;
	}

	public void setDfnlx(String dfnlx) {
		this.dfnlx = dfnlx;
	}

	@Column(name = "DFXL", length = 32)

	public String getDfxl() {
		return this.dfxl;
	}

	public void setDfxl(String dfxl) {
		this.dfxl = dfxl;
	}

	@Column(name = "DFXZ", length = 32)

	public String getDfxz() {
		return this.dfxz;
	}

	public void setDfxz(String dfxz) {
		this.dfxz = dfxz;
	}

	@Column(name = "CREATE_TIME", length = 19)

	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Column(name = "STATE", length = 1)

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "BSTATE", length = 1)
	public String getBstate() {
		return this.bstate;
	}

	public void setBstate(String bstate) {
		this.bstate = bstate;
	}

	

}