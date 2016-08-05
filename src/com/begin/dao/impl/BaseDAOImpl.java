package com.begin.dao.impl;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Id;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.begin.bean.BaseEntity;
import com.begin.dao.BaseDAO;


@SuppressWarnings("unchecked")
public abstract class BaseDAOImpl<T, ID extends Serializable> implements
		BaseDAO<T, ID> {

	/**
	 * 更新操作
	 */
	static final String UPDATE = "UPDATE";

	/**
	 * 删除操作
	 */
	static final String DELETE = "DELETE";

	protected Class<T> entityClass;

	protected String entityID;

	private SessionFactory sessionFactory;

	public BaseDAOImpl() {
		entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		for (Field field : entityClass.getDeclaredFields()) {
			Annotation id = field.getAnnotation(Id.class);
			if (null != id) {
				entityID = field.getName();
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Integer countAll() {
		return ((Long) getSession().createCriteria(entityClass)
				.add(Restrictions.eq("fstatusCode", BaseEntity.NORMAL_STATUS))
				.setProjection(Projections.count(entityID)).uniqueResult())
				.intValue();
	}

	@Override
	public Integer countByMap(Map<String, Object> map) {
		Criteria criteria = getSession().createCriteria(entityClass).add(
				Restrictions.eq("fstatusCode", BaseEntity.NORMAL_STATUS));
		for (String key : map.keySet()) {
			criteria = criteria.add(Restrictions.eq(key, map.get(key)));
		}
		return ((Long) criteria.setProjection(
				Projections.countDistinct(entityID)).uniqueResult()).intValue();
	}

	@Override
	public Integer countByMap(Map<String, Object> equalMap,
			Map<String, String> likeMap, Map<String, Object[]> inMap) {
		Criteria criteria = getSession().createCriteria(entityClass);
		if (equalMap != null) {
			for (String key : equalMap.keySet()) {
				criteria = criteria
						.add(Restrictions.eq(key, equalMap.get(key)));
			}
		}
		if (likeMap != null) {
			for (String key : likeMap.keySet()) {
				criteria = criteria.add(Restrictions.like(key,
						likeMap.get(key), MatchMode.ANYWHERE));
			}
		}
		if (inMap != null) {
			for (String key : inMap.keySet()) {
				criteria = criteria.add(Restrictions.in(key, inMap.get(key)));
			}
		}
		return ((Long) criteria.setProjection(
				Projections.countDistinct(entityID)).uniqueResult()).intValue();
	}

	@Override
	public T findByID(ID id) {
		return (T) getSession().get(entityClass, id);
	}

	@Override
	public T findByID(ID id, String[] fetchNames) {
		Criteria criteria = getSession().createCriteria(entityClass);
		if (fetchNames != null) {
			for (String fetchName : fetchNames) {
				criteria = criteria.setFetchMode(fetchName, FetchMode.JOIN);
			}
		}
		return (T) criteria.add(Restrictions.eq(entityID, id)).uniqueResult();
	}

	@Override
	public List<T> findAll() {
		return (List<T>) getSession().createCriteria(entityClass)
				.add(Restrictions.eq("fstatusCode", BaseEntity.NORMAL_STATUS))
				.addOrder(Order.desc("fupdateTime")).list();
	}

	@Override
	public List<T> findAll(int start, int limit) {
		return (List<T>) getSession().createCriteria(entityClass)
				.add(Restrictions.eq("fstatusCode", BaseEntity.NORMAL_STATUS))
				.addOrder(Order.desc("fupdateTime")).setFirstResult(start)
				.setMaxResults(limit).list();
	}

	@Override
	public List<T> findByIDs(String[] ids) {
		return (List<T>) getSession().createCriteria(entityClass)
				.add(Restrictions.in(entityID, ids)).list();
	}

	@Override
	public List<T> findByIDs(String[] ids, String[] fetchNames) {
		Criteria criteria = getSession().createCriteria(entityClass);
		if (fetchNames != null) {
			for (String fetchName : fetchNames) {
				criteria = criteria.setFetchMode(fetchName, FetchMode.JOIN);
			}
		}
		return (List<T>) criteria.add(Restrictions.in(entityID, ids)).list();
	}

	@Override
	public List<T> findByMap(Map<String, Object> map) {
		Criteria criteria = getSession().createCriteria(entityClass).addOrder(
				Order.desc("fupdateTime"));
		for (String key : map.keySet()) {
			criteria = criteria.add(Restrictions.eq(key, map.get(key)));
		}
		return (List<T>) criteria.list();
	}
	@Override
	public List<T> findByMap1(Map<String, Object> map) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (String key : map.keySet()) {
			criteria = criteria.add(Restrictions.eq(key, map.get(key)));
		}
		return (List<T>) criteria.list();
	}

	@Override
	public List<T> findByMap(Map<String, Object> map, String[] fetchNames) {
		Criteria criteria = getSession().createCriteria(entityClass).addOrder(
				Order.desc("fupdateTime"));
		if (fetchNames != null) {
			for (String fetchName : fetchNames) {
				criteria = criteria.setFetchMode(fetchName, FetchMode.JOIN);
			}
		}
		for (String key : map.keySet()) {
			criteria = criteria.add(Restrictions.eq(key, map.get(key)));
		}
		return (List<T>) criteria.list();
	}

	@Override
	public List<T> findByMap(Map<String, Object> map, String[] fetchNames,
			int start, int limit) {
		Criteria criteria = getSession().createCriteria(entityClass).addOrder(
				Order.desc("fupdateTime"));
		if (fetchNames != null) {
			for (String fetchName : fetchNames) {
				criteria = criteria.setFetchMode(fetchName, FetchMode.JOIN);
			}
		}
		for (String key : map.keySet()) {
			criteria = criteria.add(Restrictions.eq(key, map.get(key)));
		}

		return (List<T>) criteria.setFirstResult(start).setMaxResults(limit)
				.list();
	}

	@Override
	public List<T> findByMap(Map<String, Object> equalMap,
			Map<String, String> likeMap, Map<String, Object[]> inMap,
			String[] fetchNames, int start, int limit) {
		Criteria criteria = getSession().createCriteria(entityClass).addOrder(
				Order.desc("fupdateTime"));
		if (equalMap != null) {
			for (String key : equalMap.keySet()) {
				criteria = criteria
						.add(Restrictions.eq(key, equalMap.get(key)));
			}
		}
		if (likeMap != null) {
			for (String key : likeMap.keySet()) {
				criteria = criteria.add(Restrictions.like(key,
						likeMap.get(key), MatchMode.ANYWHERE));
			}
		}
		if (inMap != null) {
			for (String key : inMap.keySet()) {
				criteria = criteria.add(Restrictions.in(key, inMap.get(key)));
			}
		}
		if (fetchNames != null) {
			for (String fetchName : fetchNames) {
				criteria = criteria.setFetchMode(fetchName, FetchMode.JOIN);
			}
		}
		return (List<T>) criteria.setFirstResult(start).setMaxResults(limit)
				.list();
	}

	@Override
	public int insertOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
		return 0;
	}

	@Override
	public int insertOrUpdateEntities(T[] entities) {
		for (T t : entities) {
			getSession().saveOrUpdate(t);
		}
		return 0;
	}

	@Override
	public int deleteByID(ID id) {
		return getSession()
				.createQuery(
						"delete from " + entityClass.getSimpleName()
								+ " where " + entityID + "=:id")
				.setParameter("id", id).executeUpdate();
	}

	@Override
	public int deleteByIDs(ID[] ids) {
		return getSession()
				.createQuery(
						"delete from " + entityClass.getSimpleName()
								+ " where " + entityID + " in (:id)")
				.setParameterList("id", ids).executeUpdate();
	}

	@Override
	public int delete(ID[] ids) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put(entityID, ids);

		return getCommand(getSession(), entityClass, null, params, DELETE)
				.executeUpdate();
	}

	/**
	 * 获取Query接口用于批量执行Update或Delete操作
	 * 
	 * @param session
	 *            可用的Session接口
	 * @param cls
	 *            实体类的Class
	 * @param values
	 *            当commandType为UPDATE时有效设置更新后的字段值(键值字段名，值新的字段值)
	 * @param params
	 *            条件(键值字段名，值为条件 支持Collection或数组条件)
	 * @param commandType
	 *            操作类型使用UPDATE或DELETE表示否则会发生不可预料的错误
	 * @return Query接口
	 */
	protected Query getCommand(Session session,
			@SuppressWarnings("rawtypes") Class cls,
			Map<String, Object> values, Map<String, Object> params,
			String commandType) {
		if (null == session || null == cls || null == commandType) {
			throw new RuntimeException("无法获取Query接口！必要参数为空！");
		}
		StringBuffer command = new StringBuffer(
				DELETE.equals(commandType) ? "DELETE FROM " : "UPDATE ")
				.append(cls.getSimpleName()).append(
						DELETE.equals(commandType) ? "" : " AS entity SET ");

		if (null != values && !values.isEmpty()) {
			int index = 0;
			for (String key : values.keySet()) {
				command.append(index == (values.keySet().size() - 1) ? "entity."
						+ key + "=:" + key
						: "entity." + key + "=:" + key + ", ");
				index++;
			}
		}
		if (null != params && !params.isEmpty()) {
			int index = 0;
			command.append(" WHERE ");
			for (String propName : params.keySet()) {
				boolean isCollection = params.get(propName) instanceof Collection
						|| params.get(propName).getClass().isArray();

				command.append(index == (params.keySet().size() - 1) ? DELETE
						.equals(commandType) ? propName
						+ (isCollection ? " IN (:" + propName + ")" : "=:"
								+ propName) : " entity."
						+ propName
						+ (isCollection ? " IN (:" + propName + ")" : "=:"
								+ propName)
						: DELETE.equals(commandType) ? propName
								+ (isCollection ? " IN (:" + propName + ")"
										: "=:" + propName) + " AND "
								: " entity."
										+ propName
										+ (isCollection ? " IN (:" + propName
												+ ")" : "=:" + propName));
				index++;
			}
		}

		Query query = session.createQuery(command.toString());
		if (null != values && !values.isEmpty()) {
			for (String key : values.keySet()) {
				query.setParameter(key, values.get(key));
			}
		}
		if (null != params && !params.isEmpty()) {
			for (String propName : params.keySet()) {
				Object value = params.get(propName);
				if (value instanceof Collection) {
					query.setParameterList(propName,
							Collection.class.cast(value));
				} else if (value.getClass().isArray()) {
					query.setParameterList(propName, (Object[]) value);
				} else {
					query.setParameter(propName, value);
				}
			}
		}
		return query;
	}
}
