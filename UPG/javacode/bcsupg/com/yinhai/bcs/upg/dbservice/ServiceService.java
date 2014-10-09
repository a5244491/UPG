package com.yinhai.bcs.upg.dbservice;

import java.util.Map;

import com.yinhai.bcs.entity.domain.BcsupgServiceInterfaceDomain;
import com.yinhai.bcs.upg.common.service.BaseUPGService;
import com.yinhai.bcs.upg.common.util.IConstants;
import com.yinhai.sysframework.util.ValidateUtil;

public class ServiceService extends BaseUPGService {
	
	
	/**
	 * 获取支付结果处理类
	 * @param payRecordMap 过滤参数
	 * @return 结果处理类类名
	 */
	public Object getResultProcessClass(Map<String,Object> payRecordMap){
		return null;
	}
	
	/**
	 * 获取当前服务的支付标识
	 * @param serveId
	 * @return
	 */
	public Integer getPayId (Integer serveId){
		return 0;
	}
	
	/**
	 * 获取服务domain
	 * @param serveID
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public BcsupgServiceInterfaceDomain getServiceInterfaceDomain(Integer serveID){
		//根据serveID查询ServiceInterface
		java.util.Map<String, Object> params = new java.util.HashMap<String, Object>();
		params.put("service_id", serveID);
		java.util.Map<String, Object> serve = (java.util.Map<String, Object>)getBcsupgDao().queryForObject("bcsupgServiceInterface.queryServiceInterface", params);
		if(ValidateUtil.isEmpty(serve)){
			return null;
		}
		if(IConstants.UPG_DATA_STATUS_0 == Integer.parseInt(serve.get("status").toString())){
			return null;
		}
		//构造BcsupgServiceInterfaceDomain对象
		BcsupgServiceInterfaceDomain serviceInterface = new BcsupgServiceInterfaceDomain();
		serviceInterface.setService_id(serveID);
		serviceInterface.setService_name(serve.get("service_name").toString());
		serviceInterface.setPayway_id(Integer.parseInt(serve.get("payway_id").toString()));
		serviceInterface.setInterface_model(Integer.parseInt(serve.get("interface_model").toString()));
		serviceInterface.setPay_result_process_class(serve.get("pay_result_process_class").toString());
		serviceInterface.setStatus(Integer.parseInt(serve.get("status").toString()));
		return serviceInterface;
	}
	
}
