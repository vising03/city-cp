 package com.gsww.khj.util;

import java.util.Random;
/**
 * 类名: GeneratorRondom <br/> 
 * 功能:  产生指定位数的随机数 <br/> 
 * 创建日期: 2014-3-5 下午2:06:06 <br/> 
 *
 * @author 
 * @version V3.0
 * @since Jdk 1.6
 * @see       
 *
 */

public class GeneratorRondom 
{
	public GeneratorRondom()
	{}
	
	/**
	 * 产生指定位数的随机数
	 * @param num
	 * @return 产生的随级数
	 */
	public static String geteratorRondom(int num)
	{
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<num;i++)
		{ 
			sb.append(random.nextInt(10)); 
		}
		
		return sb.toString();
	}
	
	
	/**
	 * 获得第一位数不是0的随机数
	 * @return
	 */
	public static String getId(int num)
	{
		String s = geteratorRondom(num);
		if(s.charAt(0) == '0')
		{
			s = "1" + s.substring(1);
		}
		return s;
	}
}
