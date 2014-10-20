package com.yinhai.bcs.upg.netService.pay.job;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.yinhai.bcs.entity.domain.BcsupgPayRecordsDomain;
import com.yinhai.bcs.upg.common.util.IConstants;
import com.yinhai.bcs.upg.common.util.ServerHelpUtil;
import com.yinhai.bcs.upg.dbservice.PayRecordsService;

import com.yinhai.sysframework.util.DateUtil;

/**
 * 交易结果通知类 定时循环执行 每10秒通知一次 最高通知8次（包含失败或成功）
 * 
 * @author Administrator
 * 
 */
public class PayResultNoticeOnceJob {
	protected final Log log = LogFactory.getLog(getClass());
	private PayRecordsService payRecordsService = null;

	public PayRecordsService getPayRecordsService() {
		return payRecordsService;
	}

	public void setPayRecordsService(PayRecordsService payRecordsService) {
		this.payRecordsService = payRecordsService;
	}

	public void execute() {
		List<Integer> recordIdList = new ArrayList<Integer>(NoticeOnceTaskQueue.getTaskList());
		System.out.println("[" + DateUtil.getCurDateTime() + "]当前待通知支付记录数：" + recordIdList.size() + "个 循环执行异步消息通知");
		log.debug("[" + DateUtil.getCurDateTime() + "]当前待通知支付记录数：" + recordIdList.size() + "个 循环执行异步消息通知");
		BcsupgPayRecordsDomain domain = null;
		for (Integer recordId : recordIdList) {
			domain = payRecordsService.getPayRecordDetailById(recordId);
			if (domain != null) {
				String postData = "";
				postData += "client_id=" + domain.getClient_id() + "&";
				postData += "service_id=" + domain.getService_id() + "&";
				postData += "sign_type=RSA&";//add bq CQ
				postData += "sign=pwipws;lfja90jasi-aafda3&";
				postData += "opt_sn=" + domain.getOpt_sn() + "&";
				postData += "trade_sn=" + domain.getTrade_sn() + "&";
				postData += "pay_deal_status=" + domain.getPay_deal_status() + "&";
				postData += "pay_result=" + domain.getPay_result() + "&";
				postData += "biz_back_params=" + domain.getBiz_back_params() + "&";
				postData += "notify_time=" + DateUtil.getCurDateTime();
				int count_i = domain.getPay_notice_count();
				try {
					log.debug("向商户" + domain.getClient_id() + "_地址:"  + domain.getNotify_url() + "发送异步通知消息" + postData);
					String data = ServerHelpUtil.post(domain.getNotify_url(), postData);
					data = data.replaceAll(" ", "");
					data = data.replaceAll("\r", "");
					data = data.replaceAll("\n", "");
					data = data.toLowerCase();
					log.debug("商户得到异步消息后响应消息：" + data);
					if (IConstants.UPG_NOTICE_STATUS_SUCCESS.equals(data)) {
						payRecordsService.updateNoticeStatus(recordId, IConstants.PAY_NOTICE_STATUS_SUCCESS);
						payRecordsService.updateNoticeCount(recordId, IConstants.UPG_NOTICE_COUNT_PARAM);
						// 通知成功后不在通知,移除任务消息
						NoticeOnceTaskQueue.removeTask(recordId);
						log.debug("第" + count_i+ "次通知成功，移除任务号:" + recordId + "__对应发送的消息:" + postData);
					} else {
						log.debug("第" + count_i+ "次通知失败，任务号:" + recordId + "__对应发送的消息:" + postData +" __对应响应消息:" + data);
						payRecordsService.updateNoticeStatus(recordId, IConstants.PAY_NOTICE_STATUS_FAILURE);
						payRecordsService.updateNoticeCount(recordId, IConstants.UPG_NOTICE_COUNT_PARAM);
					}
				} catch (Exception e) {
					e.printStackTrace();
					try {
						payRecordsService.updateNoticeStatus(recordId, IConstants.PAY_NOTICE_STATUS_FAILURE);
						payRecordsService.updateNoticeCount(recordId, IConstants.UPG_NOTICE_COUNT_PARAM);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
				// 通知次数超过制定的次数移除任务消息
				if (count_i > IConstants.UPG_NOTICE_COUNT_MAXLI) {
					NoticeOnceTaskQueue.removeTask(recordId);
					log.debug("通知次数超过" + IConstants.UPG_NOTICE_COUNT_MAXLI + "次移除任务消息" + postData);
				}
			} else {
				// 不能获取指定的支付记录值 此记录编号无效
				NoticeOnceTaskQueue.removeTask(recordId);
				log.debug("不能获取指定的支付记录值 此记录编号无效" + recordId);
			}
		}
	}
}
