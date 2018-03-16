package com.zhidi.test;

public class Person extends Thread{
	
	private Account account;
	private double money;
	
	public Person(Account account, double money) {
		super();
		this.account = account;
		this.money = money;
	}



	@Override
	public void run() {
	  
	  account.draw(money);
	}

}
