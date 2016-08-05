package com.begin.vo;

public class THospitalVO {
	 private String fuID;//主键

	    private String fname;//医院名称

	    private String faccount;//账号

	    private String fpw;//密码

	    //private Date fcreatetime;//创建时间

	    //private Date fmodifytime;//修改时间

	    private String fareacode;//行政区域代码

	    private String fintro;//介绍

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

		public String getFareacode() {
			return fareacode;
		}

		public void setFareacode(String fareacode) {
			this.fareacode = fareacode;
		}

		public String getFintro() {
			return fintro;
		}

		public void setFintro(String fintro) {
			this.fintro = fintro;
		}
	    

}
