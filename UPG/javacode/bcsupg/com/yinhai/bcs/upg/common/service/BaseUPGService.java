package com.yinhai.bcs.upg.common.service;

import com.yinhai.sysframework.persistence.ibatis.IDao;
import com.yinhai.sysframework.service.BaseService;

public class BaseUPGService extends BaseService implements UPGService {
	private IDao bcsDao;
    private IDao bcsupgDao;

	public IDao getBcsDao() {
		return bcsDao;
	}

	public void setBcsDao(IDao bcsDao) {
		this.bcsDao = bcsDao;
	}

	@Override
	public IDao getBcsupgDao() {
		return this.bcsupgDao;
	}

	@Override 
	public void setBcsupgDao(IDao bcsupgDao) {
		this.bcsupgDao=bcsupgDao;
		
	}
}
