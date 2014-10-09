package com.yinhai.bcs.upg.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncodeSpecStrUtil {
	
	/**
	 * 过滤特殊字符
	 * 
	 * @param str
	 * @return
	 */
	public static String removeSpecString(String str){
		// 只允许字母和数字
		// String regEx = "[^a-zA-Z0-9]";
		// 清除掉所有特殊字符
		if(str == null)
		{
			return str;
		}
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}

}
