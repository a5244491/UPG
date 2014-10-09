package com.yinhai.bcs.upg.dbservice;

import java.util.Map;

import com.yinhai.bcs.entity.domain.BcsupgPayInterfaceDomain;
import com.yinhai.bcs.upg.common.service.BaseUPGService;
import com.yinhai.bcs.upg.common.util.IConstants;
import com.yinhai.sysframework.util.ValidateUtil;

public class Pay3Service extends BaseUPGService {
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> getPay3Interface (Map<String,Object> params) {
		//根据serveID查询ServiceInterface
		java.util.Map<String, Object> payInterface = (java.util.Map<String, Object>)getBcsupgDao().queryForObject("bcsupgPayInterface.queryPayInterface", params);
		if(ValidateUtil.isEmpty(payInterface)){
			return null;
		}
		if(IConstants.UPG_DATA_STATUS_1 == Integer.parseInt(payInterface.get("status").toString())){
			return payInterface;
		}else{
			return null;
		}
	}
	
	public String getProtocolClass (Map<String,Object> params){
		return null;
	}
	
	/**
	 * 获取一个三方/银行支付domain
	 * @param pay3InterfaceID
	 * @return
	 */
	public BcsupgPayInterfaceDomain getPay3InterfaceDomain (Integer pay3InterfaceID){
		return new BcsupgPayInterfaceDomain();
	}
	
}
