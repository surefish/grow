package com.begin.bean;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity<ID extends Serializable> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5596156197111617523L;

	// 正常状态代码
	public static final String NORMAL_STATUS = "normal";

	// 删除状态代码
	public static final String DELETE_STATUS = "delete";

	// 正常状态代码描述
	public static final String NORMAL_STATUS_DESC = "正常";

	// 删除状态代码描述
	public static final String DELETE_STATUS_DESC = "删除";

	/**
	 * @return 返回主键名
	 */
	public String getIDName() {

		for (Field field : getClass().getDeclaredFields()) {

			Annotation id = field.getAnnotation(Id.class);

			if (null != id) {
				return field.getName();
			}
		}
		throw new RuntimeException("实体类：" + getClass().getName() + "中无法找到主键属性！");
	}

	/**
	 * @return 返回主键值
	 */
	@SuppressWarnings("unchecked")
	public ID getIDValue() {
		try {
			Field id = getClass().getDeclaredField(getIDName());
			if (!Modifier.isPublic(id.getModifiers())) {
				id.setAccessible(true);
			}
			return (ID) id.get(this);
		} catch (Throwable t) {
			throw new RuntimeException(t.getMessage());
		}
	}

	public final boolean hasIDValue() {
		return null != getIDValue() && !"".equals(getIDValue())
				&& !"null".equals(getIDValue())
				&& !"undefined".equals(getIDValue());
	}
}
