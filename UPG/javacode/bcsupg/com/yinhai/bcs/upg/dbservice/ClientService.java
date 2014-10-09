package com.yinhai.bcs.upg.dbservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yinhai.bcs.entity.domain.BcsClientInfosDomain;
import com.yinhai.bcs.upg.common.service.BaseUPGService;
import com.yinhai.bcs.upg.common.util.IConstants;
import com.yinhai.sysframework.dto.ParamDTO;

public class ClientService extends BaseUPGService {
	/**
	 * 获取某个客户端的详细
	 * @param clientId 客户端唯一标识
	 * @return 客户端配置信息对象
	 */
	public BcsClientInfosDomain getDetail(int clientId){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("client_id", clientId);
		BcsClientInfosDomain domain = (BcsClientInfosDomain)getBcsDao().queryForObject("bcs_client_infos.get", paramMap);
		if(domain != null){
			if(IConstants.UPG_DATA_STATUS_0 == domain.getStatus()){
				domain = null;
			}
		}
		return domain;
	}
	
	/**
	 * 验证客户端是否可以使用此服务
	 * @param clientId 客户端唯一标识
	 * @param serviceId 使用的服务唯一标识
	 * @return 1 -- 验证成功    0 --验证失败
	 */
	public int checkClientRight(int clientId,int serviceId){
		ParamDTO dto = new ParamDTO();
		dto.put("client_id", clientId);
		dto.put("service_id", serviceId);
		
		List<?> list = getBcsupgDao().queryForList("bcsupgClientPayPrivileges.queryClientPrivileges", dto);
		//if(true) return 1; // add by CQ for test
		if(list.size() > 0){
			return 1;
		}else{
			return 0;
		}
	}
	
	/**
	 * 获取所有的账单信息
	 * @param params 过滤参数
	 * @return List
	 */
	public List<Object> getAllBillings (Map<String,Object> params){
		
		return new ArrayList<Object>();
	}
	
	/**
	 * 获取某类型的账单信息
	 * @param params 过滤参数
	 * @return Object
	 */
	public Object getBillingsByType (Map<String,Object> params){
		
		return new Object();
	}
	
	
	/**
	 * 获取客户端的domain
	 * @param ClientID 
	 * @return
	 */
//	public BcsupgClientPayPrivillegesDomain getClientDomain (Integer ClientID){
//		return new BcsupgClientPayPrivillegesDomain();
//	}
}
