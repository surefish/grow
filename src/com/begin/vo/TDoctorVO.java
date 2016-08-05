package com.begin.vo;

public class TDoctorVO {
	
	    private String fuID;//主键

	    private String fname;//医生名称

	    private String fgender;//性别

	    private String fphone;//电话

	    private String faccount;//通行证

	    private String fpw;//密码
	    
	    private String tHfname;//医院名称
	    
	    

		public String gettHfname() {
			return tHfname;
		}

		public void settHfname(String tHfname) {
			this.tHfname = tHfname;
		}

		public String getFuID() {
			return fuID;
		}

		public void setFuID(String fuID) {
			this.fuID = fuID;
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getFgender() {
			return fgender;
		}

		public void setFgender(String fgender) {
			this.fgender = fgender;
		}

		public String getFphone() {
			return fphone;
		}

		public void setFphone(String fphone) {
			this.fphone = fphone;
		}

		public String getFaccount() {
			return faccount;
		}

		public void setFaccount(String faccount) {
			this.faccount = faccount;
		}

		public String getFpw() {
			return fpw;
		}

		public void setFpw(String fpw) {
			this.fpw = fpw;
		}
	    
	    
	    


}
