package com.zhidi.test1;

public class DrawThread extends Thread{
	
	private Account account ;
	
	public DrawThread(Account account) {
		super();
		this.account = account;
	}



	@Override
	public  void run() {
		int i = 0 ;
		while(true){
			if(i%2 == 0){
				account.draw(500);
			}else{
				account.draw(1000);
			}
			i++;
		}
	}

}
