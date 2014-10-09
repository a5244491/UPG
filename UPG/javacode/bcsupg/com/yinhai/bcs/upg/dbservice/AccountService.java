package com.yinhai.bcs.upg.dbservice;

import java.util.Map;

import com.yinhai.sysframework.service.BaseService;

public class AccountService extends BaseService {
	
	/**
	 * 获取某个客户端的详细
	 * @param clientId 客户端唯一标识
	 * @return 客户端配置信息对象
	 */
	public Object getDetail(Integer accountId){
		return null;
	}
	
	/**
	 * 开通一个账户
	 * @param account
	 * @return
	 */
	public Object insertAccount (Object account){
		return null;
	}
	
	/**
	 * 修改一个账户
	 * @param params
	 */
	public void modifyAccount (Map<String,Object> params){
		
	}
	
	
	/**
	 * 删除一个账户
	 * @param accountId
	 */
	public void deleteAccount (Integer accountId){
		
	}
}
