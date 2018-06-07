package com.gsww.khj.util;


/**
*Generator ID
*
*
*/
public class Dbid{
	
	/**
	static IDGenerator IDG=null;
	
	static{
		try{
			String format[]=new String[]{"UA5","AN4","N4","AN4"};
			IDG=new IDGenerator(format,"-");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	**/
	
	/**
	*Usage sample:
	*String yourID=Faimis.getID();
	*/
	public static String getID(){
		UUIDHexGenerator uuidHex=new UUIDHexGenerator();
		return uuidHex.generate().toString();
		 
		//return IDG.generateID();
	} 
	
	public static String getLongID(int size) {
		return GeneratorRondom.getId(size);
	}
}