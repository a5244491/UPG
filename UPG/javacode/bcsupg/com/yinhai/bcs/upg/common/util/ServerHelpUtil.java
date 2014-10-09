package com.yinhai.bcs.upg.common.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletResponse;

import com.yinhai.bcs.upg.message.common.RspUPGMessage;


public class ServerHelpUtil {

	/**
	 * 向客户端端返回JSON
	 * 
	 * @param result
	 * @throws Exception
	 */
	public static void printStrToHttpRsp(HttpServletResponse response,RspUPGMessage rspMsg) throws Exception {
		if(rspMsg.getRspMsgHeader() != null){
			rspMsg.getRspMsgHeader().setSignData("");
		}
		String result = JsonUtil.toJson(rspMsg);
		response.setContentType("text/plain; chartset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter writer = response.getWriter();
		writer.print(result);
	}
	
	/**
	 * 向指定地址发送数据
	 * 
	 * @param postUrl
	 * @param postData
	 * @return
	 * @throws Exception
	 */
	public static String post(String postUrl,String postData) throws Exception {

		URL url = new URL(postUrl);
		StringBuilder sb = new StringBuilder();
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);// 打开写入属性
		conn.setDoInput(true);// 打开读取属性
		conn.setRequestMethod("POST");// 设置提交方法
		conn.setConnectTimeout(20*1000);// 连接超时时间
		conn.setReadTimeout(20*1000);
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setRequestProperty("Content-Length", postData.getBytes().length+ "");
		conn.connect();
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
		out.write(postData);
		out.flush();
		out.close();
		// 提交数据完成后，收取数据
		if (conn.getResponseCode() == 200) {
			// 读取post之后的返回值
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String line = null;
			while ((line = in.readLine()) != null) {
				sb.append(line + "\r\n");
			}
			in.close();
		} else {
			// 相应数据失败
		}
		conn.disconnect(); // 断开连接
		return sb.toString();
	}
}
