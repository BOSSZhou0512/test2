package com.zhidi.test1;

public class DepositThread extends Thread{
	
	private Account account ;
	
	public DepositThread(Account account) {
		super();
		this.account = account;
	}

	@Override
	public  void run() {
		int i = 0 ; //当i是奇数时存1000，当i是偶数时存500
		while(true){
			if(i%2 == 0){
				account.deposit(500);
			}else{
				account.deposit(1000);
			}
			i++;
		}
	}

}
