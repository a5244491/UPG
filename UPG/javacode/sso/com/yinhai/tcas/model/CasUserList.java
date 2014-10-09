package com.yinhai.tcas.model;

import java.util.ArrayList;
import java.util.Map;

public class CasUserList {  
	private ArrayList<Map<String, Object>> list;  // 不要用List类型   
	public ArrayList<Map<String, Object>> getList() {
		return list;
	}
	public void setList(ArrayList<Map<String, Object>> list) {
		this.list = list;
	}
}  
