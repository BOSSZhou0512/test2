package com.zhidi.test1;



public class Test01 {
	
	public static void main(String[] args) {
		
		
		
		Account account = new Account(0);
		
		DepositThread dt = new DepositThread(account);
		dt.setName("张三");
		
		DepositThread dt1 = new DepositThread(account);
		dt.setName("张三爹");
		
		DrawThread drawt = new DrawThread(account);
		drawt.setName("张三媳妇");
		
		DrawThread drawt1 = new DrawThread(account);
		drawt1.setName("张三妈");
		
		dt.start();
		dt1.start();
		drawt.start();
		drawt1.start();
		/**
		 * 1，将等待唤醒机制练习一次
		 * 2，在练习等待唤醒机制的基础上，创建两个存款线程 张三，张三爹
		 * 	创建两个取款线程 张三媳妇，张三妈
		 * 并解决出现的问题，搞明白为甚么？
		 */
		
	}

}
