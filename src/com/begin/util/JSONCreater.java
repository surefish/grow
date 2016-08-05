package com.begin.util;
import java.util.List;

import com.google.gson.Gson;

public class JSONCreater {
	static Gson gson = new Gson();
	
	public static String toJSON(List<?> arr){
		return gson.toJson(arr);
	}
	public static String toJSON(Object arr){
		return gson.toJson(arr);
	}

	
}
