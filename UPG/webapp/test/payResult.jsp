<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>支付完成</title>
  </head>
  <body>
      测试地址： http://127.0.0.1:8808/UPG/test/payResultReturnListener!goReturnPage.do?&buyer_email=lklk0%40163.com&buyer_id=2088002190665739&exterface=create_direct_pay_by_user&extra_common_param=%40yhpay%401001900120140519163234355371&is_success=T¬ify_id=RqPnCoPT3K9%252Fvwbh3InR8UVNSFLVLZS%252Bw2xsYoZMdnCgmSYjw7FJwYAGAj7aC98GNl5L¬ify_time=2014-05-19+11%3A01%3A02¬ify_type=trade_status_sync&out_trade_no=1001900120140519105735830042&payment_type=1&seller_email=liukaiy%40yinhai.com&seller_id=2088411579626674&subject=%E5%8F%AF%E5%8F%A3%E5%8F%AF%E4%B9%90&total_fee=0.01&trade_no=2014051941665573&trade_status=TRADE_SUCCESS&sign=4db5c10632f00764d7f492ff69df793a&sign_type=MD5
        <br/><br/><br/><br/><br/><br/>
    	支付成功！<BR>
  		支付流水(opSn)：<%=request.getParameter("opSn") %><BR>
        clientId：<%=request.getParameter("clientId") %><BR>
       	serviceId：<%=request.getParameter("serviceId") %><BR>
       	signData：<%=request.getParameter("signData") %><BR>
       	trade_sn：<%=request.getParameter("trade_sn") %><BR>
       	pay_deal_status：<%=request.getParameter("pay_deal_status") %><BR> 
       	pay_result：<%=request.getParameter("pay_result") %><BR>
       	biz_back_params：<%=request.getParameter("biz_back_params") %>
       <BR>
  </body>
</html>
