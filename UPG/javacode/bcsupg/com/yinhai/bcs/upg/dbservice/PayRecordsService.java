package com.yinhai.bcs.upg.dbservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yinhai.bcs.entity.domain.BcsupgPayRecordsDomain;
import com.yinhai.bcs.upg.common.service.BaseUPGService;
import com.yinhai.sysframework.util.ValidateUtil;

public class PayRecordsService extends BaseUPGService {
	
	
	/**
	 * 持久化已完成支付记录
	 * @param payRecordMap 支付记录信息
	 * @return Object 当前插入值的唯一标识号
	 */
	public Integer insert(Map<String,Object> payRecordMap) throws Exception{
		Integer records_id = null;
		try{
			records_id = (Integer)getBcsupgDao().insert("bcsupgPayRecords.insert", payRecordMap);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return records_id;
	}
	
	/**
	 * 根据流水号获取支付记录信息
	 * @param params 参数信息Map
	 * @return List 待通知的支付记录信息
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPayRecordByOptSN (Map<String,Object> params){
		Map<String, Object> result = (Map<String, Object>)getBcsupgDao().queryForObject("bcsupgPayRecords.queryPayRecordByOptSN", params);
		if(ValidateUtil.isEmpty(result)){
			return null;
		}
		return result;
	}
	
	
	/**
	 * 根据流水号获取支付记录信息
	 * @param params 参数信息Map
	 * @return List 待通知的支付记录信息
	 */
	public BcsupgPayRecordsDomain getPayRecordDetailById(int recordsId){
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("records_id", recordsId);
		Object object = getBcsupgDao().queryForObject("bcsupg_pay_records.get", params);
		if(object != null){
			return (BcsupgPayRecordsDomain)object;
		}else{
			return null;
		}
	}
	
	
	/**
	 * 更新待完成支付记录
	 * @param payRecordMap 支付记录信息
	 * @return Object 当前插入值的唯一标识号
	 */
	public int updatePayResult(int recordsId,int payResult){
		int result=0;
		Map<String,Object> payRecordMap=new HashMap<String, Object>();
		
		payRecordMap.put("records_id", recordsId);
		payRecordMap.put("pay_result", payResult);
		result = getBcsupgDao().update("bcsupgPayRecords.updateNotEmpty",payRecordMap);
		
		return result;
	}
	
	/**
	 * payDealStatus 1-未处理，2-处理完成，3-处理失败
	 * @param payRecordMap 支付记录信息
	 * @return Object 当前插入值的唯一标识号
	 */
	public int updatePayDealStatus(int recordsId,int payResult){
		int result=0;
		Map<String,Object> payRecordMap=new HashMap<String, Object>();
		
		payRecordMap.put("records_id", recordsId);
		payRecordMap.put("pay_deal_status", payResult);
		result = getBcsupgDao().update("bcsupgPayRecords.updateNotEmpty",payRecordMap);
		
		return result;
	}
	
	/**
	 * 更新记录通知状态
	 * @param payRecordMap 支付记录信息
	 * @return Object 当前插入值的唯一标识号
	 */
	public int updateNoticeStatus(int recordsId,int payNoticeStatus){
		int result = 0;
		Map<String,Object> payRecordMap=new HashMap<String, Object>();
		payRecordMap.put("records_id", recordsId);
		payRecordMap.put("pay_notice_status", payNoticeStatus);
		result = getBcsupgDao().update("bcsupgPayRecords.updateNotEmpty",payRecordMap);
		return result;
	}
	 
	
	/**
	 * 更新记录通知次数
	 * @param payRecordMap 支付记录信息
	 * @return Object 当前插入值的唯一标识号
	 */
	public int updateNoticeCount(int recordsId,int noticeCount){
		int result=0;
		Map<String,Object> payRecordMap=new HashMap<String, Object>();
		
		payRecordMap.put("records_id", recordsId);
		payRecordMap.put("pay_notice_count", noticeCount);
		
		
		result = getBcsupgDao().update("bcsupgPayRecords.updatePayNoticeCount",payRecordMap);
		
		return result;
	}
	
	/**
	 * 获取待通知并且未完成的支付记录信息
	 * @param params 过滤支付记录表的的参数信息Map
	 * @return List 待通知的支付记录信息
	 */
	public List<Object> getPayRecords (Map<String,Object> params){
		
		List<Object> waitNotice = new ArrayList<Object>();
		
		return waitNotice;
	}
	
	
}
