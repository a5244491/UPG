package com.yinhai.bcs.upg.common.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yinhai.bcs.upg.pay3Interface.llpay.LLPayUtil;

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
		if(map.isEmpty()) {
			// 连连支付使用的异步传输方式，同步用的是上面那种
			String reqStr = LLPayUtil.readReqStr(request);
			System.out.println(reqStr);
			if(reqStr == null || reqStr.length() < 1) {
				return map;
			}
			JSONObject reqObj = JSON.parseObject(reqStr);
			if(reqObj != null){
				for(String key : reqObj.keySet()){
					if(reqObj.get(key) != null){
						//if(reqObj.get(key).length > 0){
							map.put(key, (String) reqObj.get(key));
						//}
					}
				}
			}
		}
		return map;
	}
}
