package com.begin.vo;

import java.util.Date;

public class THomeWorkVO {
	 private String fuID;//主键
		
		
		private String ftitle;//作业标题
		
		private String fcontent;//作业内容
		
		private String furl;//图片
		
		private String fnamejpg;//照片名
		
		private String fdminfuid;//布置人主键
		
		private String ftype;//作业类型
		
		private String flastTime;//失效时间
		private String fcreateTime;
		public String getFuID() {
			return fuID;
		}
		public void setFuID(String fuID) {
			this.fuID = fuID;
		}
		public String getFtitle() {
			return ftitle;
		}
		public void setFtitle(String ftitle) {
			this.ftitle = ftitle;
		}
		public String getFcontent() {
			return fcontent;
		}
		public void setFcontent(String fcontent) {
			this.fcontent = fcontent;
		}
		public String getFurl() {
			return furl;
		}
		public void setFurl(String furl) {
			this.furl = furl;
		}
		public String getFnamejpg() {
			return fnamejpg;
		}
		public void setFnamejpg(String fnamejpg) {
			this.fnamejpg = fnamejpg;
		}
		public String getFdminfuid() {
			return fdminfuid;
		}
		public void setFdminfuid(String fdminfuid) {
			this.fdminfuid = fdminfuid;
		}
		public String getFtype() {
			return ftype;
		}
		public void setFtype(String ftype) {
			this.ftype = ftype;
		}
		
		public String getFlastTime() {
			return flastTime;
		}
		public void setFlastTime(String flastTime) {
			this.flastTime = flastTime;
		}
		public String getFcreateTime() {
			return fcreateTime;
		}
		public void setFcreateTime(String fcreateTime) {
			this.fcreateTime = fcreateTime;
		}
		
		

}
