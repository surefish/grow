package com.begin.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import com.begin.bean.SysOrg;
import com.begin.dao.SysOrgDAO;
import com.begin.service.SysOrgService;



public class SysOrgServiceImpl extends BaseServiceImpl<SysOrg, String> implements
SysOrgService{

	
	private SysOrgDAO sysOrgDAO;

	public SysOrgDAO getSysOrgDAO() {
		return sysOrgDAO;
	}

	public void setSysOrgDAO(SysOrgDAO sysOrgDAO) {
		this.sysOrgDAO = sysOrgDAO;
	}

	@Override
	public List<SysOrg> searchAllOrgs() {
     
	 Map<String, List<SysOrg>> menuMap = new HashMap<String, List<SysOrg>>();
		
		List<SysOrg> menus = new ArrayList<SysOrg>();
		
		List<SysOrg> allMenus =sysOrgDAO.findAll();
		
		for (SysOrg menu : allMenus) {
			if (menu.getFparentId() != null) {
				
				List<SysOrg> childMenus;//子菜单
				if (menuMap.containsKey(menu.getFparentId())) {
					childMenus = menuMap.get(menu.getFparentId());
				} else {
					childMenus = new ArrayList<SysOrg>();
				}
				childMenus.add(menu);
				menuMap.put(menu.getFparentId(), childMenus);
			} else {
				menus.add(menu);
			}
		}
		for (SysOrg menu : menus) {
			
			menu.setChildren(menuMap.get(menu.getFuID()));
		}
		return menus;
	}

	
	@Override
	public List<SysOrg> findParentOrgs(String forgId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteParentOrgs(String forgId) {
		int result1 = sysOrgDAO.deleteByParentID(forgId);
		int result2 = sysOrgDAO.deleteByID(forgId);
		return result1 == -1 || result2 == -1 ? -1 : 0;
	}
	
	
	
	
}
