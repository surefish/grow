package com.begin.action.web;

import java.util.Date;

import javax.annotation.Resource;

import com.begin.action.BaseAction;
import com.begin.bean.TBookType;
import com.begin.bean.TPhoto;
import com.begin.bean.TPhotoType;
import com.begin.service.TPhotoService;
import com.begin.service.TPhotoTypeService;


//照片action
public class TPhotoAction extends BaseAction{
	
	@Resource
	private TPhotoService tPhotoService;
	@Resource
	private TPhotoTypeService tPhotoTypeService;
	
	private TPhoto tPhoto;
	
	private TPhotoType tPhotoType;
	
	
	public String my(){
		/*
		TPhotoType tPhotoType=new TPhotoType();
		tPhotoType.setFuID(null);
		tPhotoType.setFstatusCode(TBookType.NORMAL_STATUS);
		tPhotoType.setFstatusDesc(TBookType.NORMAL_STATUS_DESC);
		tPhotoType.setFcreateBy("ysh");
		tPhotoType.setFcreateTime(new Date());
		tPhotoType.setFupdateTime(new Date());
		tPhotoType.setFupdateBy("ysh");
		tPhotoType.setFname("班级相册");
		tPhotoTypeService.createOrEdit(tPhotoType);
		
		TPhotoType tPhotoType1=new TPhotoType();
		tPhotoType1.setFuID(null);
		tPhotoType1.setFstatusCode(TBookType.NORMAL_STATUS);
		tPhotoType1.setFstatusDesc(TBookType.NORMAL_STATUS_DESC);
		tPhotoType1.setFcreateBy("ysh");
		tPhotoType1.setFcreateTime(new Date());
		tPhotoType1.setFupdateTime(new Date());
		tPhotoType1.setFupdateBy("ysh");
		tPhotoType1.setFname("个人相册");
		tPhotoTypeService.createOrEdit(tPhotoType1);*/
		//班级相册 402881e453ea831b0153ea83bae00000
		//个人相册 402881e453ea831b0153ea83bb0c0001
		TPhotoType tPhotoType1=new TPhotoType();
		tPhotoType1.setFuID(null);
		tPhotoType1.setFstatusCode(TBookType.NORMAL_STATUS);
		tPhotoType1.setFstatusDesc(TBookType.NORMAL_STATUS_DESC);
		tPhotoType1.setFcreateBy("ysh");
		tPhotoType1.setFcreateTime(new Date());
		tPhotoType1.setFupdateTime(new Date());
		tPhotoType1.setFupdateBy("ysh");
		tPhotoType1.setFname("荣誉榜");
		tPhotoTypeService.createOrEdit(tPhotoType1);
		
		/*TPhoto tPhoto=new TPhoto();
		tPhoto.setFuID(null);
		tPhoto.setFstatusCode(TBookType.NORMAL_STATUS);
		tPhoto.setFstatusDesc(TBookType.NORMAL_STATUS_DESC);
		tPhoto.setFcreateBy("ysh");
		tPhoto.setFcreateTime(new Date());
		tPhoto.setFupdateTime(new Date());
		tPhoto.setFupdateBy("ysh");
		tPhoto.setFstudentFuid(null);//班级
		tPhoto.setFname("班级");
		tPhoto.setFurl("/newbegin/upload/photo_01.jpg");
		tPhoto.setFtype("402881e453ea831b0153ea83bae00000");
		tPhotoService.createOrEdit(tPhoto);*/
		
		
		
		return null;
	}
	
	
	

	public TPhoto gettPhoto() {
		return tPhoto;
	}

	public void settPhoto(TPhoto tPhoto) {
		this.tPhoto = tPhoto;
	}

	public TPhotoType gettPhotoType() {
		return tPhotoType;
	}

	public void settPhotoType(TPhotoType tPhotoType) {
		this.tPhotoType = tPhotoType;
	}
	
	
	

}
