package com.yinhai.tcas.model;

import java.io.Serializable;
import java.util.List;

import com.yinhai.tcas.util.CasUtil;

public class PageWebBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int currentPage;
	private int pageSize;
	private int totalCount;
	private int totalPageCount;
	private List<MapConvertor> recordList;

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public List<MapConvertor> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<MapConvertor> recordList) {
		this.recordList = recordList;
	}

	public List getList() {
		if (recordList != null && recordList.size() > 0) {
			return CasUtil.toMapInList(recordList);
		}
		return null;
	}
}
