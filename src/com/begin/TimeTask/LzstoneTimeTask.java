package com.begin.TimeTask;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.begin.weiixn.util.AccessTokenVO;
import com.begin.weiixn.util.ParamesAPI;
import com.begin.weiixn.util.WeixinUtil;

/**
 * 定时任务类
 * @author
 *
 */
public class LzstoneTimeTask extends TimerTask {

	private WeixinUtil wx=new WeixinUtil();
	private HttpSession ht=ServletActionContext.getRequest().getSession();
	private AccessTokenVO avo=new AccessTokenVO();
	
	@Override
	public void run() {
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("获取access_token--"+sf.format(new Date()));
		String access_token = WeixinUtil.getAccessToken(ParamesAPI.corpId, ParamesAPI.secret).getToken();
		avo.setToken(access_token);
		ht.setAttribute("MYACTOKEN", avo);//放入session
	}

}
