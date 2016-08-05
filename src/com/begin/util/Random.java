package com.begin.util;
import java.io.*;
import java.util.HashSet;
import java.util.Set;
public class Random{


	
	    public int rand(){
	       Set<Integer> m = new HashSet<Integer>();
	       for(int i=0;i<100;i++){
	           int a;
	           do{
	            a = (int)(Math.random()*1000000);
	           }while(m.contains(a));
	           m.add(a);
	           return a;
	       }
		return 0;
	    }
}

