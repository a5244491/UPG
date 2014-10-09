package com.yinhai.bcs.upg.netService.pay.action;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.yinhai.bcs.entity.domain.BcsupgServiceInterfaceDomain;
import com.yinhai.bcs.upg.dbservice.ClientService;
import com.yinhai.bcs.upg.dbservice.Pay3Service;
import com.yinhai.bcs.upg.dbservice.PayRecordsService;
import com.yinhai.bcs.upg.dbservice.ServiceService;
import com.yinhai.bcs.upg.message.common.ReqUPGMsgHeader;
import com.yinhai.bcs.upg.message.common.RspUPGMessage;
import com.yinhai.bcs.upg.message.common.RspUPGMsgHeader;
import com.yinhai.bcs.upg.message.pay.PayUPGReqMsg;
import com.yinhai.bcs.upg.message.pay.PayUPGRspMsg;
import com.yinhai.bcs.upg.message.util.MessageUtil;
import com.yinhai.bcs.upg.netService.pay.dealProcess.PayDealProcess;
import com.yinhai.bcs.upg.pay3Interface.Pay3Interface;
import com.yinhai.bcs.upg.pay3Interface.common.msg.OutFPayResultMsg;
import com.yinhai.webframework.BaseAction;


/**
 * 
 * 功能名称 ： 支付Action -后台模式
 * 实现目标 ： 业务系统请求此Action完成后台支付操作
 * 入口数据 ： 业务系统的请求数据包data_package
 * 出口数据 ： 支付结果状态码-success 支付成功  -failure 支付失败
 * ---------------------------------------------------------------------------------------
 * 数据流程 ： 
 * 1 获取业务端/客户端请求数据包（data_package）
 * 2 解析data_package a 获取消息头data_package_header  b 获取消息体data_package_body
 * 3 使用data_package_header中的客户端ID与服务ID验证客户端使用权限
 * 4 权限验证通过 使用data_package_header中的signData验证客户端数据签名
 * 5 签名验证通过   
 *            a 生成支付接口协议报文
 *            b 向支付记录表中新增一条支付记录（状态为 '待支付'）
 *            c 使用服务携带的支付通道ACCEPT_PAY_ID获取支付接口接入信息
 *              1 调用支付接口信息中的协议转化类实现对生成的支付接口协议报文,本身的支付信息进行转化为支付接口的请求数据包
 *            d 使用对应的支付接口完成支付操作（调用支付合作平台的支付接口完成支付操作）
 *            e 使用服务携带的PAY_RESULT_PROCESS_CLASS完成支付结果处理操作
 *            f 在当前事务中,对新增的支付记录信息进行更新操作（状态为 '支付成功'）
 * 6 返回支付状态值  
 * 			  'success'-调用当前支付动作支付成功
 * 			  'failure'-调用当前支付动作支付失败
 * @author kai
 *
 */

public class PayNetServiceBModeAction extends BaseAction {

	private ClientService   clientService  = (ClientService) getService("clientService");
	private PayRecordsService payRecordsService=  (PayRecordsService)getService("payRecordsService");
	private Pay3Service     pay3Service    = (Pay3Service) getService("pay3Service");
	private ServiceService   serveService   = (ServiceService) getService("serviceService");
	
	public String service() throws Exception {

		// dataMap 取出整个协议包
		java.util.Map<String, String[]> dataMap = request.getParameterMap();

		// 解析报文
		PayUPGReqMsg reqMsg = MessageUtil.createPayReqMsg(dataMap);

		// 解析请求消息头&消息体
		ReqUPGMsgHeader reqHeadMsg = reqMsg.getMsgHeader();
	
		String returnMsg = "";//MessageUtil.createErrorRspMsg("BCS_E_000001").toJSONStr();// 同步返回消息结果(默认消息)

		// 验证客户权限
		if (clientService.checkClientRight(reqHeadMsg.getClient_id(),
				reqHeadMsg.getService_id()) == 1) {

			// 验证请求报文签名
			if (MessageUtil.verifyFPaySign(null, "signData", "clientPubKey")) {
				
				
				//写入支付记录（待成功支付记录）
				Map<String, Object> payRecordMap = MessageUtil.payReqMsgBody2Map(reqMsg);
				payRecordMap.put("trade_time", new Timestamp(System.currentTimeMillis()));
				payRecordsService.insert(payRecordMap);
				
				// 调用支付接口
				//0获取支付服务domain
				BcsupgServiceInterfaceDomain bcsServiceDomian = serveService.getServiceInterfaceDomain(reqHeadMsg.getService_id());
				Integer payway_id = bcsServiceDomian.getPayway_id();
				//0获取接入支付domain
//				BcsupgPayInterfaceDomain bcsPayIntegerDomian = pay3Service.getPay3InterfaceDomain(payway_id);
				//1参数
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("accept_pay_id", payway_id);

				//3获取支付方法
				String  payClassName = pay3Service.getPay3Interface(params).toString();
				Pay3Interface pay3Interface = (Pay3Interface)(Class.forName(payClassName).newInstance());
				
				//4进行支付操作
				OutFPayResultMsg outPayResultMsg  = pay3Interface.payBMode(reqMsg);
				
				
				// 调用交易结果处理类
				String payDealClassName = bcsServiceDomian.getPay_result_process_class();
				PayDealProcess payDealProcess = (PayDealProcess)(Class.forName(payDealClassName).newInstance());
				payDealProcess.deal(outPayResultMsg,payRecordMap);
				
				
				// 更新支付记录(独立于支付流程之外)
				Map<String, Object> returnProtMsg = new HashMap<String, Object>();
				returnProtMsg.put("tradeStatus", outPayResultMsg.getOpSn());
				//put 其它字段
				//payRecordsService.updateStatus(returnProtMsg);

				
				// 进行响应消息的签名操作
				RspUPGMessage rspMsg=new RspUPGMessage();
				RspUPGMsgHeader rspMsgHeader=new RspUPGMsgHeader();
				PayUPGRspMsg payRspMsgBody=new PayUPGRspMsg();
				rspMsg.setRspMsgHeader(rspMsgHeader);
				rspMsg.setObjBody(payRspMsgBody);
				//MessageUtil.signMessage(rspMsg);
				
				
				// 同步返回支付成功消息
				returnMsg = MessageUtil.coverObject2Jason(rspMsg);
				
			} else {
				// 验证报文签名失败
				returnMsg = "";//MessageUtil.createErrorRspMsg("BCS_E_000002").toJSONStr();
			}
		} else {
			// 验证客户权限失败
			returnMsg = "";//MessageUtil.createErrorRspMsg("BCS_E_000003").toJSONStr();;
		}
		return returnMsg;// 返回支付结果
	}
}
