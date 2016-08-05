package com.begin.dao;

import java.util.List;

import com.begin.bean.TMessages;

public interface TMessagesDAO extends BaseDAO<TMessages, String>{
	/**
	 * 根据学生主键
	 * 消息类型
	 * 查询
	 * */
	List<Object[]> gettopMessages(String studentID,String fcaalog); 
	/**
	 * 根据学生主键
	 * 消息类型
	 * 查询所有消息
	 * */
	List<Object[]> gettopMessagesAll(String studentID,String fcaalog); 
	
}
