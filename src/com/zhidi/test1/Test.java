package com.zhidi.test1;

public class Test {
	
	public static void main(String[] args) {
		Account account = new Account(10000);
		PersonThread p1 = new PersonThread(account, 200);
		PersonThread p2 = new PersonThread(account, 1000);
		PersonThread p3 = new PersonThread(account, 5000);
		PersonThread p4 = new PersonThread(account, 3000);
		//为线程设置线程名称
		p1.setName("张三");
		p2.setName("张三爹");
		p3.setName("张三媳妇");
		p4.setName("张三妈");
		p1.start();
		p2.start();
		p3.start();
		p4.start();
		
		
	}

}
