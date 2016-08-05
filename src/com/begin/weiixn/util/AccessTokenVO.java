package com.begin.weiixn.util;

/** 
 * 微信通用接口凭证 
 *  
 * @author Engineer-Jsp 
 * @date 2014.06.23 
 */  
public class AccessTokenVO {  
    // 获取到的凭证  
    private String token;  
    
    private String code;
    
    private String UserID;
    
    
    
    // 凭证有效时间，单位：秒  
    private int expiresIn;  
    
    
    
  
    public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getToken() {  
        return token;  
    }  
  
    public void setToken(String token) {  
        this.token = token;  
    }  
  
    public int getExpiresIn() {  
        return expiresIn;  
    }  
  
    public void setExpiresIn(int expiresIn) {  
        this.expiresIn = expiresIn;  
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	} 
    
    
}  