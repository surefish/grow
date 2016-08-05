package com.begin.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DataParse {
	/**
	 * 将集合转换成数组
	 * 
	 * @param <T>
	 *            泛型参数
	 * @param collection
	 *            需要转换的集合
	 * @return 长度和collection的size相等并包含collection内元素的数组
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] collectionToArray(Collection<T> collection) {
		if (null == collection || 0 == collection.size()) {
			throw new RuntimeException("无法转换空集合！");
		}

		T[] array = (T[]) Array.newInstance(collection.iterator().next()
				.getClass(), collection.size());

		int index = 0;
		for (T item : collection) {
			array[index] = item;
			index++;
		}

		return array;
	}

	/**
	 * 将数组转换成Collection
	 * 
	 * @param <T>
	 *            泛型参数
	 * @param array
	 *            需要转换的数组
	 * @return size和数组长度相等并包含有array内元素的ArrayList
	 */
	public static <T> Collection<T> arrayToCollection(T[] array) {
		Collection<T> collection = new ArrayList<T>();
		for (T t : array) {
			collection.add(t);
		}
		return collection;
	}

	/**
	 * 将一个实体解析成JSONObject
	 * 
	 * @param <T>
	 *            泛型参数
	 * @param entity
	 *            需要解析的实体
	 * @param excludes
	 *            不需要列入JSONObject的属性集合可以为空
	 * @return 具有entity属性名属性值键值对待JSONObject
	 */
	public static <T> JSONObject entityToJSON(T entity, String... excludes) {
		try {
			JSONObject jsonObject = new JSONObject();

			Collection<Field> fields = arrayToCollection(entity.getClass()
					.getDeclaredFields());
			fields.addAll(arrayToCollection(entity.getClass().getSuperclass()
					.getDeclaredFields()));

			Collection<String> exclueProps = null == excludes ? new ArrayList<String>()
					: arrayToCollection(excludes);
			for (Field field : fields) {
				if (exclueProps.contains(field.getName())) {
					continue;
				}
				if (!Modifier.isPublic(field.getModifiers())) {
					field.setAccessible(true);
				}
				jsonObject.put(field.getName(), field.get(entity));
			}

			return jsonObject;
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将集合解析成JSONArray
	 * 
	 * @param <T>
	 *            泛型参数
	 * @param collection
	 *            需要解析的集合
	 * @param excludes
	 *            不需要列入JSONObject的属性集合可以为空
	 * @return 具有entity属性名属性值键值对待JSONObject的数组
	 */
	public static <T> JSONArray collectionToJSON(Collection<T> collection,
			String... excludes) {
		JSONArray jsonArray = new JSONArray();
		for (T t : collection) {
			jsonArray.add(entityToJSON(t, excludes));
		}
		return jsonArray;
	}

	/**
	 * 将JSONObject 转换成entity
	 * 
	 * @param json
	 *            json对象
	 * @return 返回实体泛型
	 */
	public static <T> Object jsonToEntity(JSONObject json, Class<?> cl) {
		return null == json ? null : JSONObject.toBean(json, cl);
	}

	/**
	 * 将JSONArray 转换成entity list
	 * 
	 * @param jsonArray
	 * @return 实体list
	 */
	public static <T> List<Object> jsonArrayToEntityList(JSONArray jsonArray,
			Class<?> cl) {
		if (null == jsonArray || null == cl) {
			return null;
		}

		List<Object> list = new ArrayList<Object>();

		for (Object object : jsonArray) {
			list.add(jsonToEntity((JSONObject) object, cl));
		}
		return list;
	}

	/**
	 * Map to List 将Map的值放于List
	 * 
	 * @param Map
	 * @return List
	 */
	public static <T> List<T> mapToList(Map<T, T> map) {

		if (null == map || map.isEmpty()) {
			return null;
		}

		List<T> list = new ArrayList<T>();

		for (Entry<T, T> entry : map.entrySet()) {
			list.add(entry.getKey());
		}

		return list;
	}

	/**
	 *	List to Set
	 *	@param	List
	 *	@return Set 
	 */
	public static <T> Set<T> listToSet(List<T> list){
		
		if(null == list || list.isEmpty()){
			return null;
		}
			
		Set<T> set = new HashSet<T>();
		
		for(T t : list){
			set.add(t);
		}
		
		return set;
	}
}
