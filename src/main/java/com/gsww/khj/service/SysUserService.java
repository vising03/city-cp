/**
 * 閻ゅ墽姊炬０鍕Щ閹貉冨煑娣団剝浼呯化鑽ょ埠
 * 妞ゅ湱娲�  city-CP 
 * 閸掓稑缂撻弮鍫曟？  2018楠烇拷3閺堬拷26閺冿拷 娑撳宕�8:01:02 
 * Copyright (c) 2018, 娑擃厼娴楅悽鍏镐繆閻㈡鍊戞稉鍥╂樊閸忣剙寰� All rights reserved.
 * 娑擃厼娴楅悽鍏镐繆閻㈡鍊戞稉鍥╂樊閸忣剙寰� 娑撴挻婀�/娣囨繂鐦戝┃鎰敩閻拷,閺堫亞绮＄拋绋垮讲缁備焦顒涙禒璁崇秿娴滄椽锟芥俺绻冩禒璁崇秿* 濞撶娀浜炬担璺ㄦ暏閵嗕椒鎱ㄩ弨瑙勭爱娴狅絿鐖�.
 */

package com.gsww.khj.service;

import java.util.List;

import com.gsww.khj.entity.CPUser;
import com.gsww.khj.entity.SysUser;

/**
 * 缁鎮�: SysUserService <br/> 
 * 閸旂喕鍏�: ADD FUNCTION. <br/> 
 * 閸掓稑缂撻弮銉︽埂: 2018楠烇拷3閺堬拷26閺冿拷 娑撳宕�8:01:02 <br/> 
 *
 * @author Administrator
 * @version V3.0
 * @since Jdk 1.8
 * @see       
 *
 */
public interface SysUserService {

	void save(SysUser user);

	SysUser getUser(String userId);

	List<SysUser> findAll();

	List<SysUser> findAllP();

	SysUser PiPeiUser(String id, String city, String sex, String xueli, String zhiye, String dfxl, String dfzy,String nick_name);

	List<CPUser> findAllCP();

	




}
