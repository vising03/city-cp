/**
 * 闁汇倕澧藉鐐紣閸曨垱些闁硅矇鍐ㄧ厬濞ｅ洠鍓濇导鍛寲閼姐倗鍩�
 * 濡炪倕婀卞ú锟�  city-CP 
 * 闁告帗绋戠紓鎾诲籍閸洘锛�  2018妤犵儑鎷�3闁哄牞鎷�26闁哄喛鎷� 濞戞挸顑呭畷锟�8:01:27 
 * Copyright (c) 2018, 濞戞搩鍘煎ù妤呮偨閸忛晲绻嗛柣銏☆焾閸婃垶绋夐崶鈺傛▕闁稿浚鍓欏锟� All rights reserved.
 * 濞戞搩鍘煎ù妤呮偨閸忛晲绻嗛柣銏☆焾閸婃垶绋夐崶鈺傛▕闁稿浚鍓欏锟� 濞戞挻鎸诲﹢锟�/濞ｅ洦绻傞惁鎴濃攦閹邦亜鏁╅柣顕嗘嫹,闁哄牜浜炵划锛勬媼缁嬪灝璁茬紒鍌欑劍椤掓稒绂掔拋宕囩Э濞存粍妞介敓鑺ヤ亢缁诲啯绂掔拋宕囩Э* 婵炴挾濞�娴滅偓鎷呯捄銊︽殢闁靛棔妞掗幈銊╁绩鐟欏嫮鐖卞ù鐙呯悼閻栵拷.
 */

package com.gsww.khj.service.impl;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.boot.model.source.spi.JdbcDataType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.gsww.khj.entity.SysUser;
import com.gsww.khj.repository.SysUserRepository;
import com.gsww.khj.service.SysUserService;
import com.gsww.khj.util.TimeHelper;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import com.gsww.khj.entity.CPUser;
import groovyjarjarasm.asm.commons.Remapper;

/**
 * 缂侇偉顕ч幃锟�: SysUserServiceImpl <br/> 
 * 闁告梻鍠曢崗锟�: ADD FUNCTION. <br/> 
 * 闁告帗绋戠紓鎾诲籍閵夛附鍩�: 2018妤犵儑鎷�3闁哄牞鎷�26闁哄喛鎷� 濞戞挸顑呭畷锟�8:01:27 <br/> 
 *
 * @author Administrator
 * @version V3.0
 * @since Jdk 1.8
 * @see       
 *
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
	
	@Autowired
	private SysUserRepository sysUserRepository;

	@Override
	public void save(SysUser user) {
		user.setCreateTime(TimeHelper.getCurrentTime());
		sysUserRepository.save(user);
	}

	@Override
	public SysUser getUser(String userId) {
		return sysUserRepository.findOne(userId);
	}
     
	@Override
	public List<SysUser> findAll() {
		return sysUserRepository.findByState("1");
		
	}

	@Override
	public SysUser PiPeiUser(String id,String city, String sex, String xueli, String zhiye, String dfxl, String dfzy,String nick_name) {
	
		  Connection conn=null;
	try {
		
		conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/khj","root", "khj123");
		String sql="select * from  sys_user where state=1 and bstate=1 and city='"+city+"'and sex!='"+sex+"'limit 0,1";
		Statement st=(Statement)((java.sql.Connection) conn).createStatement();
		ResultSet  rs=st.executeQuery(sql);
		while(rs.next()) {
			String vid=rs.getString("user_id");
			String vcity=rs.getString("city");
			String vxl=rs.getString("xueli");
		    String vzy=rs.getString("zhiye"); 
		   String vnc=rs.getString("nick_name");
		    String sql1="insert into cp_user (nid,vid,ncs,vcs,nxl,vxl,nzy,vzy,nnick_name,vnick_name,cjsj) values('"+id+"','"+vid+"','"+city+"','"+vcity+"','"+xueli+"','"+vxl+"','"+zhiye+"','"+vzy+"','"+nick_name+"','"+vnc+"',now())";
		    
		  
		    
		Statement st1=(Statement)((java.sql.Connection) conn).createStatement();
		boolean  rs1=st1.execute(sql1);
			
		String sql2="update sys_user set bstate=0 where user_id='"+vid+"'";	    

		Statement st2=(Statement)((java.sql.Connection) conn).createStatement();
	
		int  rs2=st2.executeUpdate(sql2);

		}   
	
		conn.close();
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
		   
		return null;
		
	
	}

	@Override
	public List<SysUser> findAllP() {
		  Connection conn=null;
		  List<SysUser> list=null;
			try {
				
				conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/khj","root", "khj123");
				String sql="select * from  sys_user where bstate=1";
				Statement st=(Statement)((java.sql.Connection) conn).createStatement();
				ResultSet  rs=st.executeQuery(sql);			
	
						 list= new ArrayList<SysUser>(); 
						 while (rs.next()) {  
							 SysUser user = new SysUser();  
					         user.setUserId(rs.getString("user_id"));  
					         user.setNickName(rs.getString("nick_name"));
					         user.setSex(rs.getString("sex"));
					         user.setBirthday(rs.getString("birthday"));
					         user.setXueli(rs.getString("xueli"));
					         user.setSchool(rs.getString("school"));
					         user.setCity(rs.getString("city"));
					        
					         user.setZhiye(rs.getString("zhiye"));
					         user.setXingzuo(rs.getString("xingzuo"));
					        list.add(user);  
					 }
					
						 return list;
	
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			return null;
				   			
	}

	@Override

		public List<CPUser> findAllCP() {
			  Connection conn=null;
			  List<CPUser> cplist=null;
				try {
					
					conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/khj","root", "khj123");
					String sql="select * from  cp_user";
					Statement st=(Statement)((java.sql.Connection) conn).createStatement();
					ResultSet  rs=st.executeQuery(sql);			
		
							 cplist= new ArrayList<CPUser>(); 
							 while (rs.next()) {  
								 CPUser user = new CPUser();  
						       user.setCp_id(rs.getString("cp_id"));
						       user.setNid(rs.getString("nid"));
						       user.setVid(rs.getString("vid"));
						       user.setNcs(rs.getString("ncs"));
						       user.setVcs(rs.getString("vcs"));
						       user.setNxl(rs.getString("nxl"));
						       user.setVxl(rs.getString("vxl"));
						       user.setNzy(rs.getString("nzy"));
						       user.setVzy(rs.getString("vzy"));
						       user.setNnick_name(rs.getString("nnick_name"));
						       user.setVnick_name(rs.getString("vnick_name"));
						       user.setCjsj(rs.getString("cjsj"));
						        cplist.add(user);  
						     
						 }
						
							 return cplist;
		
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
				return null;
	
	}
	

}
