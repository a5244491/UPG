package com.yinhai.bcs.upg.dbservice;

import java.util.Map;

import com.yinhai.bcs.entity.domain.BcsupgPayResultNoticeLogDomain;
import com.yinhai.sysframework.service.BaseService;

public class PayMessageService extends BaseService {
	
	
	/**
	 * 持久化已完成支付消息日志
	 * @param payRecordMap 支付记录信息
	 * @return Object 当前插入值的唯一标识号
	 */
	public Object insert(Map<String,Object> payRecordMap){
		return null;
	}
	
	/**
	 * 
	 * @param payResultDomain
	 * @return
	 */
	public BcsupgPayResultNoticeLogDomain getPayResultDoamin (Integer payResultDomain){
		return new BcsupgPayResultNoticeLogDomain();
	}
	
}
