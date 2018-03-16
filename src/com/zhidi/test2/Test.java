package com.zhidi.test2;

public class Test {

	public static void main(String[] args) {
		new TcpServerThread().start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new TcpClientThread().start();
		
	}
}
