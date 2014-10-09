package com.yinhai.bcs.upg.message.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TestThread implements Runnable {
	Random random = new Random();
	static int temp = 0; // 全局控制，只要其中一个线程取数重了 就马上停止
	public void run() {
		while (temp == 0) {
			String s = MessageUtil.getSerial();
			if(MyMap.getInstance().put(s)) {
				temp++;
			}
			System.out.println(s);
			try {
				Thread.sleep(random.nextInt(100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("thread all stop!");
	}

	public static void main(String[] args) {
		int num = 100;
		Object[] th = new Object[num];
		for (int i = 0; i < num; i++) {
			th[i] = new TestThread();
		}
		for (int i = 0; i < num; i++) {
			new Thread((Runnable) th[i]).start();
		}
	}
}

class MyMap {
	private Map<String, String> map = new HashMap<String, String>();
	private static MyMap mymap = null;

	private MyMap() {
	}

	public static MyMap getInstance() {
		if (mymap == null) {
			synchronized (MyMap.class) {
				if (mymap == null) {
					mymap = new MyMap();
				}
			}
		}
		return mymap;
	}

	public boolean put(String s) {
		if (map.containsKey(s)) {
			System.out.println("ERROR ! Allready has added!");
			return false;
		} else {
			map.put(s, s);
			// System.out.println("OK!");
			return true;
		}
	}
}
