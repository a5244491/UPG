package com.yinhai.bcs.upg.netService.test;

import com.yinhai.bcs.upg.message.util.MessageUtil;

public class TestMail11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String clientId="1001";
		String serviceId="9001";
		
		String aaaa=MessageUtil.createSN(serviceId, clientId);
		System.out.println("aaaa="+aaaa+","+aaaa.length());
		
		System.out.println("verifyOPSN="+MessageUtil.verifyOPSN(serviceId, clientId, aaaa));
	}

}
