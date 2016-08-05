package com.begin.util;

import java.util.Comparator;

import com.begin.bean.TExercise;

public class SortByX implements Comparator{   
	

public int compare(Object obj1,Object obj2){   
	TExercise point1=(TExercise)obj1;   
	TExercise point2=(TExercise)obj2;   
  if(point1.getFcount()>point2.getFcount())   
   return 1;   
  else  
   return 0;   
 }   
}