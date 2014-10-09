package com.yinhai.bcs.upg.common.service;

import com.yinhai.sysframework.persistence.ibatis.IDao;
import com.yinhai.sysframework.service.Service;

public interface UPGService extends Service {

	 public IDao getBcsupgDao();
	 
	 public void setBcsupgDao(IDao bcsupgDao);
	 
	 public IDao getBcsDao();

	 public void setBcsDao(IDao bcsDao);
}
