package com.yinhai.bcs.upg.netService.pay.dealProcess;

import java.util.Map;
import com.yinhai.bcs.upg.common.util.IConstants;
import com.yinhai.bcs.upg.pay3Interface.common.msg.OutFPayResultMsg;

public class LlPaySettleTradeProcess implements PayDealProcess {

	@Override
	public int deal(OutFPayResultMsg outPayResultMsg,
			Map<String, Object> payRecord) {
		// 支付成功后的处理动作
		// 调用核心系统AB交易处理操作
		if (outPayResultMsg != null && payRecord != null) {
			System.out.println("支付异步通知数据接收处理成功");
			return IConstants.PAY_DEAL_STATUS_SUCCESS;
		} else {
			return IConstants.DEAL_STATUS_0;
		}
	}
}
