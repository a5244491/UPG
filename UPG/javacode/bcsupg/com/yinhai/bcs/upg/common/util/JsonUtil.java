package com.yinhai.bcs.upg.common.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;



public class JsonUtil {
	
	
	/**
     * 对象转换成JSON字符串
     * @param obj 
     * @return 
     */
    public static String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /**
     * JSON字符串转成对象
     * @param str  
     * @param type
     * @return 
     */
    public static <T> T fromJson(String str, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }

    /**
     * JSON字符串转成对象
     * @param str  
     * @param type 
     * @return 
     */
    public static <T> T fromJson(String str, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }

}
