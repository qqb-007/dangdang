package com.baizhi.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import com.baizhi.service.AdminServiceImpl;
import com.baizhi.util.SecurityCodeUtil;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport{
	private AdminService adminService = new AdminServiceImpl();
	private String username;
	private String password;
	private String code;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest(); 
 	    HttpSession session = request.getSession(); 
 	    String fcode =(String) session.getAttribute("fcode");
 	    System.out.println(fcode);
 	    if (fcode.equalsIgnoreCase(code)){
 	    	 Admin admin =adminService.queryAdmin(username, password);
 	    	 
  			if (admin!=null) {
  				return "adminLoginSuccess";
  			}else {
  				message = "用户名或密码错误";
  				return "adminLoginRrror";
  			}
		}else {
			message = "验证码错误";
			return "adminLoginRrror";
		}
 	   
 	 
 	   
		
		}
	
	public void codeImg() throws Exception{
		//生成验证码随机字符(位数)
    	String generateVerifyCode = SecurityCodeUtil.generateVerifyCode(4);
    	System.out.println("生成的验证码"+generateVerifyCode);
    	//HttpServletRequest request = ServletActionContext.getRequest(); 
    	   HttpSession session = ServletActionContext.getRequest().getSession(); 
    	   session.setAttribute("fcode", generateVerifyCode);
    	//生成图片(宽度，高度，随即字符)
    	BufferedImage image = SecurityCodeUtil.getImage(255, 80, generateVerifyCode);
    	HttpServletResponse response = ServletActionContext.getResponse();
    	
    	response.setContentType("image/png");
    	
    	//将生成的验证码图片保存到本地
    	ImageIO.write(image, "png",response.getOutputStream());
		//return null;
	}
}
