/*
-- Query: SELECT * FROM bcsupg.bcsupg_client_pay_privileges where SERVICE_ID=1023
LIMIT 0, 1000

-- Date: 2014-10-08 14:38
*/
INSERT INTO `bcsupg_client_pay_privileges` (`ID`,`CLIENT_ID`,`SERVICE_ID`,`PUBLIC_KEY`,`START_DATE`,`END_DATE`,`ADD_DATE`) VALUES (78,9001,1023,'','2014-09-21 00:00:00','2019-09-21 00:00:00','2014-09-22 00:00:00');

/*
-- Query: SELECT * FROM bcsupg.bcsupg_service_interface where SERVICE_ID=1023
LIMIT 0, 1000

-- Date: 2014-10-08 14:35
*/
INSERT INTO `bcsupg_service_interface` (`SERVICE_ID`,`SERVICE_NAME`,`PAYWAY_ID`,`INTERFACE_MODEL`,`PAY_RESULT_PROCESS_CLASS`,`STATUS`) VALUES (1023,'连连支付平台',2008,2,'com.yinhai.bcs.upg.netService.pay.dealProcess.LlPaySettleTradeProcess',1);


/*
-- Query: SELECT * FROM bcsupg.bcsupg_pay_interface where PAYWAY_ID=2008
LIMIT 0, 1000

-- Date: 2014-10-08 14:37
*/
INSERT INTO `bcsupg_pay_interface` (`PAYWAY_ID`,`PAYWAY_NAME`,`PAY_INTERFACE_URL`,`RECEIVE_ACCOUNT`,`PARTNER_ID`,`KEY_TYPE`,`CERT_PATH1`,`CERT_PATH2`,`USER_KEY`,`PAY_PROCESS_CLASS`,`STATUS`,`RETURN_URL`,`NOTIFY_URL`,`ERROR_NOTIFY_URL`) VALUES (2008,'连连支付平台','https://yintong.com.cn/payment/bankgateway.htm','liukaiy@yinhai.com','201306031000001013',2,'123',NULL,'user_key','com.yinhai.bcs.upg.pay3Interface.llpay.LlPay',1,'http://182.92.99.226:9080/upg/test/payResultReturnListener.do','http://182.92.99.226:9080/upg/test/payResultNoticeListener.do',NULL);
