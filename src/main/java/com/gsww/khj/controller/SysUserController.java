/**
 * 闁汇倕澧藉鐐紣閸曨垱些闁硅矇鍐ㄧ厬濞ｅ洠鍓濇导鍛寲閼姐倗鍩�
 * 濡炪倕婀卞ú锟�  city-CP 
 * 闁告帗绋戠紓鎾诲籍閸洘锛�  2018妤犵儑鎷�3闁哄牞鎷�26闁哄喛鎷� 濞戞挸顑呭畷锟�8:04:11 
 * Copyright (c) 2018, 濞戞搩鍘煎ù妤呮偨閸忛晲绻嗛柣銏☆焾閸婃垶绋夐崶鈺傛▕闁稿浚鍓欏锟� All rights reserved.
 * 濞戞搩鍘煎ù妤呮偨閸忛晲绻嗛柣銏☆焾閸婃垶绋夐崶鈺傛▕闁稿浚鍓欏锟� 濞戞挻鎸诲﹢锟�/濞ｅ洦绻傞惁鎴濃攦閹邦亜鏁╅柣顕嗘嫹,闁哄牜浜炵划锛勬媼缁嬪灝璁茬紒鍌欑劍椤掓稒绂掔拋宕囩Э濞存粍妞介敓鑺ヤ亢缁诲啯绂掔拋宕囩Э* 婵炴挾濞�娴滅偓鎷呯捄銊︽殢闁靛棔妞掗幈銊╁绩鐟欏嫮鐖卞ù鐙呯悼閻栵拷.
 */

package com.gsww.khj.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gsww.khj.entity.CPUser;
import com.gsww.khj.entity.CpFile;
import com.gsww.khj.entity.SysUser;
import com.gsww.khj.service.FileService;
import com.gsww.khj.service.SysUserService;
import com.gsww.khj.util.Dbid;
import com.gsww.khj.util.TimeHelper;

/**
 * 缂侇偉顕ч幃锟�: SysUserController <br/> 
 * 闁告梻鍠曢崗锟�: ADD FUNCTION. <br/> 
 * 闁告帗绋戠紓鎾诲籍閵夛附鍩�: 2018妤犵儑鎷�3闁哄牞鎷�26闁哄喛鎷� 濞戞挸顑呭畷锟�8:04:11 <br/> 
 *
 * @author weix
 * @version V3.0
 * @since Jdk 1.8
 * @see       
 *
 */
@Controller
@RequestMapping("/user")
public class SysUserController {
	
	protected Logger logger = LoggerFactory.getLogger(SysUserController.class);
	
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private FileService fileService;
	
@RequestMapping(value="/list",method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest request, HttpServletResponse response){
	List<SysUser> list = sysUserService.findAll();
	model.addAttribute("list", list);
	return "/user/list";
}
	
	
	@RequestMapping(value="/PiPei",method = RequestMethod.GET)
	public String listB(Model model, HttpServletRequest request, HttpServletResponse response){
		
		List<SysUser> list = sysUserService.findAllP();
	
		model.addAttribute("PiPei", list);
		return "/user/PiPei";
	}

	@RequestMapping(value="/sign",method = RequestMethod.GET)
	public String sign(Model model, HttpServletRequest request, HttpServletResponse response){
		String userId = request.getParameter("userId");
		SysUser user = new SysUser();
		if(StringUtils.isNotBlank(userId)){
			user = sysUserService.getUser(userId);
		}
		model.addAttribute("user", user);
		return "/user/sign";
	}
	
	
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public void save(SysUser user, Model model, HttpServletRequest request, HttpServletResponse response){
		if(StringUtils.isBlank(user.getUserId())){
			user.setUserId(Dbid.getID());
		}
		user.setState("1");
		user.setBstate("1");
		sysUserService.save(user);
	}
	
	@RequestMapping(value="/index",method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request, HttpServletResponse response){
		return "/user/index";
	}
	
	@ResponseBody
	@RequestMapping(value="/delUser",method = RequestMethod.GET)
	public Map<String, Object> delUser(String userId, Model model, HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
 		if(StringUtils.isNotBlank(userId)){
			SysUser user = sysUserService.getUser(userId);
			user.setState("9");
			sysUserService.save(user);
			map.put("isSusccess", true);
		}else{
			map.put("isSusccess", false);
		}
 		return map;
	}
		
	@ResponseBody
	@RequestMapping(value="/PiPeiUser",method = RequestMethod.GET)
	public Map<String, Object> PiPeiUser(String userId, Model model, HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> map = new HashMap<String, Object>();
 		if(StringUtils.isNotBlank(userId)){
 		
			SysUser user = sysUserService.getUser(userId);
			SysUser CP = sysUserService.PiPeiUser(user.getUserId(),user.getCity(),user.getSex(),user.getXueli(),user.getZhiye(),user.getDfxl(),user.getDfzy(),user.getNickName());
		    user.setBstate("0");
		    sysUserService.save(user);
			map.put("isSusccess", true);
		}else{
			map.put("isSusccess", false);
		}
 		return map;
	}

	
	@RequestMapping(value="/CPlist",method = RequestMethod.GET)
    public String list3(Model model, HttpServletRequest request, HttpServletResponse response){
	List<CPUser> cplist = sysUserService.findAllCP();
    model.addAttribute("CPlist", cplist);
	return "/user/CPlist";
}
	
	
	@RequestMapping(value="/RenWu",method = RequestMethod.GET)
	public String RenWu(Model model, HttpServletRequest request, HttpServletResponse response){
		String vid = request.getParameter("vid");
		SysUser user = new SysUser();
		 if(StringUtils.isNotBlank(vid)){
			user = sysUserService.getUser(vid);
		    String birthday=user.getBirthday();
		    
		   
		}
		model.addAttribute("user", user);
		
		
		return "/user/RenWu";
	}
	

	@RequestMapping(value="/MyRenWu",method = RequestMethod.GET)
	public String MyRenWu(Model model, HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("userId");
		 System.out.println("wwwwwwwww"+id);
		 List<CpFile> fileList = fileService.getFileList("cpid");
		 model.addAttribute("flist", fileList);
		//SysUser user = new SysUser();
		// if(StringUtils.isNotBlank(id)){
			
			//user = sysUserService.getUser(id);
		   // String birthday=user.getBirthday();
		    
		   
		//}
		//model.addAttribute("user", user);
		
		
		return "/user/MyRenWu";
	}
	
	@ResponseBody
	@RequestMapping(value="/upload",method = RequestMethod.POST)
	public CpFile upload(@RequestParam(value = "multipartFile", required = false) MultipartFile multipartFile, HttpServletRequest request) throws Exception {
		if (multipartFile.isEmpty() || StringUtils.isBlank(multipartFile.getOriginalFilename())) {
	           throw new Exception("请上传图片");
	        }
	        String contentType = multipartFile.getContentType();
	        if (!contentType.contains("")) {
	        	throw new Exception("请上传图片");
	        }
	        String root_fileName = multipartFile.getOriginalFilename();
	        CpFile cpFile = new CpFile();
	        cpFile.setId(Dbid.getID());
	        cpFile.setBizId("cpId");
	        cpFile.setFileName(root_fileName);
	        cpFile.setFileSize(String.valueOf(multipartFile.getSize()));
	        cpFile.setFileContent(multipartFile.getBytes());
	        cpFile.setUpTime(TimeHelper.getCurrentTime());
	        cpFile = fileService.save(cpFile);
	        return cpFile;
	}
	
	@RequestMapping(value="/getfile", method = RequestMethod.GET)
    public void goUploadImg(String id, HttpServletResponse response) {
		CpFile cpfile = fileService.getFile(id);
		if(cpfile!=null){
			try {
				byte[] fileContent=cpfile.getFileContent();
				if(fileContent!=null&&fileContent.length>0) {
					OutputStream out = response.getOutputStream();
					out.write(fileContent);
				}
			} catch (IOException e) {
				logger.info("获取附件错误");
			}
		}
    }

	private static String[] IEBrowserSignals = {"MSIE", "Trident", "Edge"};
	public static boolean isMSBrowser(String userAgent) {
        for (String signal : IEBrowserSignals) {
            if (userAgent.contains(signal))
                return true;
        }
        return false;
    }
    //处理文件上传
    @RequestMapping(value="/testuploadimg", method = RequestMethod.POST)
    public @ResponseBody String uploadImg(@RequestParam("file") MultipartFile file,
            HttpServletRequest request) {
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        /*System.out.println("fileName-->" + fileName);
        System.out.println("getContentType-->" + contentType);*/
        String filePath = request.getSession().getServletContext().getRealPath("imgupload/");
        try {
//            FileUtil.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        //返回json
        return "uploadimg success";
    }
}
