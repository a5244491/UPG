package com.yinhai.bcs.upg.netService.pay.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.yinhai.webframework.BaseAction;

@Namespace("/test")
@Action(value = "payTest", 
			results = { @Result(name = "success", location = "/test/test.jsp"),
						@Result(name = "failure", location = "/test/failure.jsp")
			})
public class TestAction extends BaseAction {
	
	public String execute() throws Exception {
		return SUCCESS;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
