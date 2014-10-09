package com.yinhai.bcs.upg.netService.pay.job;

import java.util.ArrayList;
import java.util.List;

import com.yinhai.bcs.entity.domain.BcsupgPayRecordsDomain;
import com.yinhai.bcs.upg.common.util.IConstants;
import com.yinhai.bcs.upg.common.util.ServerHelpUtil;
import com.yinhai.bcs.upg.dbservice.PayRecordsService;

import com.yinhai.sysframework.util.DateUtil;



/**
 * 交易结果通知类
 * 定时循环执行 每10秒通知一次 最高通知8次（包含失败或成功）
 * @author Administrator
 *
 */
public class PayResultNoticeOnceJob {

	private PayRecordsService payRecordsService = null;
	

	public PayRecordsService getPayRecordsService() {
		return payRecordsService;
	}


	public void setPayRecordsService(PayRecordsService payRecordsService) {
		this.payRecordsService = payRecordsService;
	}


	public void execute()  {
		
		List<Integer> taskl = new ArrayList<Integer>(NoticeOnceTaskQueue.getTaskList());
		
		System.out.println("["+DateUtil.getCurDateTime()+"]当前待通知支付记录数："+taskl.size()+"个 循环执行异步消息通知");
		
		BcsupgPayRecordsDomain domain = null;
		
		for(Integer i : taskl){
			
			domain = payRecordsService.getPayRecordDetailById(i);
			
			if(domain != null){
				
				String postData = "";
				postData += "clientId="+domain.getClient_id()+"&";
				postData += "serviceId="+domain.getService_id()+"&";
				postData += "signData=pwipws;lfja90jasi-aafda3&";
				postData += "opSn="+domain.getOpt_sn()+"&";
				postData += "trade_sn="+domain.getTrade_sn()+"&";
				postData += "pay_deal_status="+domain.getPay_deal_status()+"&";
				postData += "pay_result="+domain.getPay_result()+"&";
				postData += "biz_back_params="+domain.getBiz_back_params()+"&";
				postData += "notify_time="+DateUtil.getCurDateTime();
				
				
				try{
					String data = ServerHelpUtil.post(domain.getNotify_url(), postData);
					data = data.replaceAll(" ", "");
					data = data.replaceAll("\r","");
					data = data.replaceAll("\n","");
					data = data.toLowerCase();
					if(IConstants.UPG_NOTICE_STATUS_SUCCESS.equals(data)){
						payRecordsService.updateNoticeStatus(i, IConstants.PAY_NOTICE_STATUS_SUCCESS);
						payRecordsService.updateNoticeCount (i, IConstants.UPG_NOTICE_COUNT_PARAM);
						//通知成功后不在通知,移除任务消息
						NoticeOnceTaskQueue.removeTask(i);
					}else{
						payRecordsService.updateNoticeStatus(i, IConstants.PAY_NOTICE_STATUS_FAILURE);
						payRecordsService.updateNoticeCount (i, IConstants.UPG_NOTICE_COUNT_PARAM);
					}
				}catch (Exception e) {
					e.printStackTrace();
					try{
						payRecordsService.updateNoticeStatus(i, IConstants.PAY_NOTICE_STATUS_FAILURE);
						payRecordsService.updateNoticeCount (i, IConstants.UPG_NOTICE_COUNT_PARAM);
					}catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// 通知次数超过8次移除任务消息
				int count_i = domain.getPay_notice_count();
				if( count_i > IConstants.UPG_NOTICE_COUNT_MAXLI){
					NoticeOnceTaskQueue.removeTask(i);
				}
			}else{
				// 不能获取指定的支付记录值 此记录编号无效
				NoticeOnceTaskQueue.removeTask(i);
			}
		}
	}
	
	
}

