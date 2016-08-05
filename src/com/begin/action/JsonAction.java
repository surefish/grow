package com.begin.action;

import java.util.List;

import javax.annotation.Resource;

import com.begin.bean.SysMenu;
import com.begin.service.SysMenuService;
import com.begin.util.JSONCreater;
import com.begin.vo.MenuTree;
import com.begin.vo.Passport;

import flex.messaging.io.ArrayList;

@SuppressWarnings("unchecked")
public class JsonAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private SysMenuService sysMenuService;
	private List<SysMenu> sysMenus;

	public List<SysMenu> getSysMenus() {
		return sysMenus;
	}

	public void setSysMenus(List<SysMenu> sysMenus) {
		this.sysMenus = sysMenus;
	}

	public String MenuJson() {

		Passport ps = (Passport) getHttpSession().getAttribute("xqdPassport");

		sysMenus = sysMenuService.searchByRole(ps.getRolefuID());// 查询当前角色所有拥有的菜单

		List<MenuTree> list = new ArrayList();
		for (SysMenu s : sysMenus) {
			MenuTree mTree = new MenuTree();
			mTree.setMenuid(s.getFmenuId());
			mTree.setMenuname(s.getFmenuname());
			mTree.setIcon(s.getFicon());
			mTree.setUrl(s.getFurl());
			List<MenuTree> mlist = new ArrayList();
			if(null!=s.getChildren()){
				for (SysMenu c : s.getChildren()){
					MenuTree mTree1 = new MenuTree();
					mTree1.setMenuid(c.getFmenuId());
					mTree1.setMenuname(c.getFmenuname());
					mTree1.setIcon(c.getFicon());
					mTree1.setUrl(c.getFurl());
					mlist.add(mTree1);
				}
			}
			mTree.setMenus(mlist);
			list.add(mTree);
		}
		json = JSONCreater.toJSON(list);
		System.out.println(JSONCreater.toJSON(list));
		System.out.println("左菜单加载");
		return "json";
	}
}
