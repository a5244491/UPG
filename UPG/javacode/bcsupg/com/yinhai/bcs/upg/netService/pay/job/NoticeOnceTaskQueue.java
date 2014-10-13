package com.yinhai.bcs.upg.netService.pay.job;

import java.util.ArrayList;
import java.util.List;

public class NoticeOnceTaskQueue {
	private static List<Integer> noticeTaskList=new ArrayList<Integer>();
	public  static void putTask(int recordsId) {
		synchronized (NoticeOnceTaskQueue.class) {
			System.out.println(" 当前队列任务数目： " + noticeTaskList.size());
			noticeTaskList.add(recordsId);
		}
	}
	public  static void removeTask(int recordsId) {
		synchronized (NoticeOnceTaskQueue.class) {
			noticeTaskList.remove(new Integer(recordsId));
		}
	}
	public  static List<Integer> getTaskList(){
		return noticeTaskList;
	}
}
