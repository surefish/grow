package com.begin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.begin.bean.TMessages;
import com.begin.bean.TPhoto;
import com.begin.dao.TPhotoDAO;
import com.begin.service.TPhotoService;
import com.begin.util.page.ListInfo;


public class TPhotoServiceImpl extends BaseServiceImpl<TPhoto, String> implements TPhotoService{
	
	private TPhotoDAO tPhotoDAO;

	public TPhotoDAO gettPhotoDAO() {
		return tPhotoDAO;
	}

	public void settPhotoDAO(TPhotoDAO tPhotoDAO) {
		this.tPhotoDAO = tPhotoDAO;
	}

	@Override
	public ListInfo<TPhoto> searchByfType(String furl,String ftype, String fstatusCode,String fstudentFuid,
			Integer currentPageNO, Integer pageSize) {
		ListInfo<TPhoto> listInfo = new ListInfo<TPhoto>(currentPageNO,pageSize);
		Map<String, Object> equalMap=new HashMap<String, Object>();
		Map<String,String> likeMap = new HashMap<String,String>();
		
		equalMap.put("fstatusCode", TMessages.NORMAL_STATUS);
		if(!"".equals(furl)&&null!=furl){
			equalMap.put("fnamejpg",furl.toString());
		}
		
		
		if(!"".equals(ftype)&&null!=ftype){
			equalMap.put("ftype",ftype.toString());
		}
		
		if(!"".equals(fstudentFuid)&&null!=fstudentFuid){
			equalMap.put("fstudentFuid",fstudentFuid.toString());
		}
		
		List<TPhoto> entityList=tPhotoDAO.findByMap(equalMap, null,null,null, 
				listInfo.getFirst(),listInfo.getMax());
		listInfo.setCurrentList(entityList);
		listInfo.setSizeOfTotalList(tPhotoDAO.countByMap(equalMap,null,null));
		
		return listInfo;
	}
	
	

}
