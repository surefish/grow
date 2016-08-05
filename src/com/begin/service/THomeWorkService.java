package com.begin.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.begin.bean.THomeWork;



public interface THomeWorkService extends BaseService<THomeWork, String>{
	
	     @Transactional(propagation = Propagation.REQUIRED)
         List<THomeWork> seachbywork(String ftype);
}
