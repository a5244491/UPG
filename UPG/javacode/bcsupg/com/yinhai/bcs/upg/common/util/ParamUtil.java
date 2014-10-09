package com.yinhai.bcs.upg.common.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class ParamUtil {
	/**
	 * 获取HttpServletRequest中的请求信息拼装成字符串
	 * @param request
	 * @return
	 */
	public static String coverRequestMapToStr(HttpServletRequest request){
		String paramStr = "";
		Map<String, String[]> requsetMap=request.getParameterMap();
		if(requsetMap!=null){
			for(String key:requsetMap.keySet()){
				if(requsetMap.get(key) != null){
					if(requsetMap.get(key).length > 0){
						paramStr+=key+"="+requsetMap.get(key)[0]+"&";
					}
				}
			}
			
		}
		return paramStr;
	}
	/**
	 * 获取HttpServletRequest中的请求信息拼装成集合
	 * @param request
	 * @return
	 */
	public static Map<String, String> coverRequestMapToMap(HttpServletRequest request){
		Map<String,String> map = new HashMap<String, String>();
		if(request == null){
			return null;
		}else{
			Map<String, String[]> requsetMap = request.getParameterMap();
			if(requsetMap != null){
				for(String key : requsetMap.keySet()){
					if(requsetMap.get(key) != null){
						if(requsetMap.get(key).length > 0){
							map.put(key, requsetMap.get(key)[0]);
						}
					}
				}
			}
		}
		return map;
	}
}
