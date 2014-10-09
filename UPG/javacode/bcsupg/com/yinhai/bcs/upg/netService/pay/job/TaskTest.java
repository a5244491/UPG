package com.yinhai.bcs.upg.netService.pay.job;

import java.util.ArrayList;
import java.util.List;

public class TaskTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NoticeOnceTaskQueue.putTask(1);
		NoticeOnceTaskQueue.putTask(1);
		
		List<Integer> list2=new ArrayList<Integer>(NoticeOnceTaskQueue.getTaskList());
		
		NoticeOnceTaskQueue.removeTask(1);
		
		for(Integer i:NoticeOnceTaskQueue.getTaskList()){
			System.out.println(i);
		}
		System.out.println("============");
		for(Integer i:list2){
			System.out.println(i);
		}
	}

}
