package com.begin.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDAO<T, ID extends Serializable> {
	/**
	 * 根据主键查询实体
	 * 
	 * @param id
	 *            实体主键
	 * @return 实体对象
	 */
	T findByID(ID id);

	/**
	 * 根据主键查询实体，并带关联
	 * 
	 * @param id
	 *            实体主键
	 * @param fetchNames
	 *            关联对象数组
	 * @return 实体对象
	 */
	T findByID(ID id, String[] fetchNames);

	/**
	 * 统计总记录数
	 * 
	 * @return
	 */
	Integer countAll();

	/**
	 * 条件查询的记录数
	 * 
	 * @param map
	 * @return
	 */
	Integer countByMap(Map<String, Object> map);

	/**
	 * 多条件查询的记录数
	 * 
	 * @param equalMap
	 *            相等查询的参数集合
	 * @param likeMap
	 *            模糊查询的参数集合
	 * @param inMap
	 *            集合查询的参数集合
	 * @return
	 */
	Integer countByMap(Map<String, Object> equalMap,
			Map<String, String> likeMap, Map<String, Object[]> inMap);

	/**
	 * 查出所有实体
	 * 
	 * @return
	 */
	List<T> findAll();

	/**
	 * 分页查询所有实体
	 * 
	 * @param start
	 *            起始记录
	 * @param limit
	 *            总记录数
	 * @return
	 */
	List<T> findAll(int start, int limit);

	/**
	 * 根据主键数组查询实体
	 * 
	 * @param ids
	 *            主键数组
	 * @return
	 */
	List<T> findByIDs(String[] ids);

	/**
	 * 根据主键数组查询实体
	 * 
	 * @param ids
	 *            主键数组
	 * @param fetchName
	 *            关联对象数组
	 * @return
	 */
	List<T> findByIDs(String[] ids, String[] fetchName);

	/**
	 * 条件查询实体
	 * 
	 * @param map
	 *            相等查询的参数集合
	 * @return
	 */
	List<T> findByMap(Map<String, Object> map);
	/**
	 * 条件查询实体
	 * 
	 * @param map
	 *            相等查询的参数集合
	 * @return
	 */
	List<T> findByMap1(Map<String, Object> map);

	/**
	 * 条件查询实体
	 * 
	 * @param map
	 *            相等查询的参数集合
	 * @param fetchNames
	 *            关联对象数组
	 * @return
	 */
	List<T> findByMap(Map<String, Object> map, String[] fetchNames);

	/**
	 * 条件分页查询实体
	 * 
	 * @param map
	 *            相等查询的参数集合
	 * @param fetchNames
	 *            关联对象数组
	 * @param start
	 *            起始记录
	 * @param limit
	 *            总记录数
	 * @return
	 */
	List<T> findByMap(Map<String, Object> map, String[] fetchNames, int start,
			int limit);

	/**
	 * 多条件动态查询
	 * 
	 * @param equalMap
	 *            相等查询的参数集合
	 * @param likeMap
	 *            模糊查询的参数集合
	 * @param inMap
	 *            集合查询的参数集合
	 * @param fetchNames
	 *            关联对象数组
	 * @param start
	 *            起始记录
	 * @param limit
	 *            总记录数
	 * @return
	 */
	List<T> findByMap(Map<String, Object> equalMap,
			Map<String, String> likeMap, Map<String, Object[]> inMap,
			String[] fetchNames, int start, int limit);

	/**
	 * 保存或修改实体
	 * 
	 * @param entity
	 *            实体对象
	 * @return
	 */
	int insertOrUpdate(T entity);

	/**
	 * 批量保存少量实体
	 * 
	 * @param entities
	 * @return
	 */
	int insertOrUpdateEntities(T[] entities);

	/**
	 * 删除实体
	 * 
	 * @param id
	 *            实体主键
	 * @return
	 */
	int deleteByID(ID id);

	/**
	 * 批量删除实体
	 * 
	 * @param ids
	 *            实体主键数组
	 * @return
	 */
	int deleteByIDs(ID[] ids);

	/**
	 * 根据ID物理删除
	 * 
	 * @param ids
	 * @return int
	 */
	int delete(ID[] ids);
}
