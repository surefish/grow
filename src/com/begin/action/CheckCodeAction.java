package com.begin.action;

import java.io.ByteArrayInputStream;



import com.begin.util.RandomNumUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CheckCodeAction extends ActionSupport {
	
	private static final long serialVersionUID = -7193209177116825032L;  
    private ByteArrayInputStream inputStream;   
      
    //private int width;     
    //private int height;     
    //private int fontSize;     
    //private int codeLength;   
    //private int disturbType;  
      
    public String CheckCodeGenerate() throws Exception{  
    	
        RandomNumUtil rdnu=RandomNumUtil.Instance();      
        this.setInputStream(rdnu.getImage());//取得带有随机字符串的图片      
        ActionContext.getContext().getSession().put("CHECK_CODE", rdnu.getString());//取得随机字符串放入HttpSession    
        System.out.println("生成验证码执行--"+rdnu.getString());
        return SUCCESS;      
    }   
      
      
    @Override
    public String execute() throws Exception {
    	// TODO Auto-generated method stub
    	return super.execute();
    }
    public void setInputStream(ByteArrayInputStream inputStream) {      
        this.inputStream = inputStream;      
    }     
      
    public ByteArrayInputStream getInputStream() {      
        return inputStream;      
    } 
}
