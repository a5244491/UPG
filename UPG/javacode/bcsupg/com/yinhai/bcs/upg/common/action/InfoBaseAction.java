package com.yinhai.bcs.upg.common.action;

import com.yinhai.sysframework.persistence.ibatis.IDao;
import com.yinhai.sysframework.service.ServiceLocator;
import com.yinhai.webframework.BaseAction;

public class InfoBaseAction extends BaseAction {
	
	 /**
	  * 获取业务系统的DAO
	  * @return
	  */
	 protected IDao getInfoDao()
     {
       return ((IDao)ServiceLocator.getService("bcsupgDao"));
     }
}
