package com.zhidi.test;

public class Account {

	double money;

	public Account(double money) {
		super();
		this.money = money;
	}
	
	/**
	 * 取款的方法
	 */
	public void draw(double money){
		//获取当前运行线程的对象
		Thread t=Thread.currentThread();
		//获取当前线程对象的名称
		String name=t.getName();
		System.out.println(name+"取款前的账户余额we："+this.money);
		this.money-=money;
		System.out.println(name+"取款后--->的账户余额we："+this.money);
	}
	
}
