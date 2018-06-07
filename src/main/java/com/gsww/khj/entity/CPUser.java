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
@Table(name = "cp_user")

public class CPUser implements java.io.Serializable {
	
	/** 
	 * serialVersionUID :(用一句换描述这个变量的作用)
	 */
	private static final long serialVersionUID = 1584070188708253917L;

	// Fields
	private String cp_id;
	private String nid;
	private String vid;
	private String ncs;
	private String vcs;
	private String nxl;
	private String vxl;
	private String nzy;
	private String vzy;
	private String nnick_name;
	private String vnick_name;
   

	private String cjsj;

	// Constructors

	/** default constructor */
	public CPUser() {
	}

	/** minimal constructor */
	public CPUser(String cp_id) {
		this.cp_id = cp_id;
	}

	/** full constructor */
	public CPUser(String cp_id,String nid,String vid,String ncs,String vcs,String nxl,String vxl,String nzy,String vzy,String nnick_name,String vnick_name,String cjsj)
	 {
		this.nid=nid;
		this.vid=vid;
		this.ncs=ncs;
		this.vcs=vcs;
	    this.nxl=nxl;
		this.vxl=vxl;
		this.nzy=nzy;
	    this.vzy=vzy;
		this.nnick_name=nnick_name;
		this.vnick_name=vnick_name;
        this.cjsj=cjsj;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "assigned")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CP_ID", unique = true, nullable = false, length = 32)

	public String getCp_id() {
		return cp_id;
	}

	public void setCp_id(String cp_id) {
		this.cp_id = cp_id;
	}
 
	@Column(name = "NID", length = 64)
	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}
	@Column(name = "VID", length = 64)
	public String getVid() {
		return vid;
	}

	public void setVid(String vid) {
		this.vid = vid;
	}
	@Column(name = "NCS", length = 64)
	public String getNcs() {
		return ncs;
	}

	public void setNcs(String ncs) {
		this.ncs = ncs;
	}
	@Column(name = "VCS", length = 64)
	public String getVcs() {
		return vcs;
	}

	public void setVcs(String vcs) {
		this.vcs = vcs;
	}
	@Column(name = "NXL", length = 64)
	public String getNxl() {
		return nxl;
	}

	public void setNxl(String nxl) {
		this.nxl = nxl;
	}
	@Column(name = "VXL", length = 64)
	public String getVxl() {
		return vxl;
	}

	public void setVxl(String vxl) {
		this.vxl = vxl;
	}
	@Column(name = "NZY", length = 64)
	public String getNzy() {
		return nzy;
	}
	
	public void setNzy(String nzy) {
		this.nzy = nzy;
	}
@Column(name = "VZY", length = 64)
	public String getVzy() {
		return vzy;
	}

	public void setVzy(String vzy) {
		this.vzy = vzy;
	}
	@Column(name = "NNICK_NAME", length = 64)
	public String getNnick_name() {
		return nnick_name;
	}

	public void setNnick_name(String nnick_name) {
		this.nnick_name = nnick_name;
	}
	@Column(name = "VNICK_NAME", length = 64)
	public String getVnick_name() {
		return vnick_name;
	}

	public void setVnick_name(String vnick_name) {
		this.vnick_name = vnick_name;
	}
	@Column(name = "cjsj", length = 64)

	 public String getCjsj() {
			return cjsj;
		}

		public void setCjsj(String cjsj) {
			this.cjsj = cjsj;
		}
	

}