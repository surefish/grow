package com.begin.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.begin.dao.BaseDAO;
import com.begin.service.BaseService;
import com.begin.util.page.ListInfo;



public abstract class BaseServiceImpl<T, ID extends Serializable> implements
		BaseService<T, ID> {

	private BaseDAO<T, ID> baseDAO;

	@Override
	public int createOrEdit(T entity) {
		return baseDAO.insertOrUpdate(entity);
	}

	@Override
	public int createOrEditEntities(T[] entities) {
		return baseDAO.insertOrUpdateEntities(entities);
	}

	@Override
	public List<T> searchAll() {
		return baseDAO.findAll();
	}

	@Override
	public ListInfo<T> searchAll(int currentPage, int pageSize) {
		ListInfo<T> listInfo = new ListInfo<T>(currentPage, pageSize);
		listInfo.setCurrentList(baseDAO.findAll(listInfo.getFirst(),
				listInfo.getMax()));
		listInfo.setSizeOfTotalList(baseDAO.countAll());
		return listInfo;
	}

	@Override
	public int deleteByID(ID id) {
		return baseDAO.deleteByID(id);
	}

	@Override
	public int deleteByIDs(ID[] ids) {
		return baseDAO.deleteByIDs(ids);
	}

	public T searchByID(ID id) {
		return baseDAO.findByID(id);
	}

	public T searchByID(ID id, String[] fetchNames) {
		return baseDAO.findByID(id, fetchNames);
	}

	public ListInfo<T> searchByMap(Map<String, Object> map,
			String[] fetchNames, int currentPage, int pageSize) {
		ListInfo<T> listInfo = new ListInfo<T>(currentPage, pageSize);
		listInfo.setCurrentList(baseDAO.findByMap(map, fetchNames,
				listInfo.getFirst(), listInfo.getMax()));
		listInfo.setSizeOfTotalList(baseDAO.countByMap(map));
		return listInfo;
	}

	public BaseDAO<T, ID> getBaseDAO() {
		return baseDAO;
	}

	public void setBaseDAO(BaseDAO<T, ID> baseDAO) {
		this.baseDAO = baseDAO;
	}

}
