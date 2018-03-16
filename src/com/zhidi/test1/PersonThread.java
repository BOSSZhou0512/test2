package com.zhidi.test1;

public class PersonThread extends Thread{

	private Account account ;
	private double money ;
	
	public PersonThread(Account account,double money) {
		super();
		this.account = account;
		this.money = money ;
	}

	@Override
	public void run() {
		//取款
		account.draw(money);
	}
}
