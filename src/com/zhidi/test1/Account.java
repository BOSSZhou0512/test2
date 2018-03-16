package com.zhidi.test1;

public class Account {
	
	private double money ;
	//Object obj = new Object();

	public Account(double money) {
		super();
		this.money = money;
	}
	
	
	
	public double getMoney() {
		return money;
	}



	/**
	 * 取款的方法
	 * @param money  取出的钱
	 */
	/*public synchronized void draw(double money){
		//获得正在执行当前方法的线程对象
		Thread t = Thread.currentThread();
		//获得线程对象的名称
		String name = t.getName();
		System.out.println(name+"取款前查询余额为："+this.money);
		this.money -= money ;
		System.out.println(name+"取款后余额为:"+this.money);
	}*/
	
	public  void draw(double money){
		//获得正在执行当前方法的线程对象
		Thread t = Thread.currentThread();
		//获得线程对象的名称
		String name = t.getName();
		synchronized (this) {
			//判断钱是不是<=0
			if(this.money<=0){
				notify();
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(name+"取款前查询余额为："+this.money);
			this.money -= money ;
			System.out.println(name+"取款后余额为:"+this.money);
		}
		
	}
	
	/**
	 * 存款的方法
	 * @param money 存上的钱
	 */
	public void deposit(double money){
		//获得正在执行当前方法的线程对象
		Thread t = Thread.currentThread();
		//获得线程对象的名称
		String name = t.getName();
		synchronized (this) {
			if(this.money>0){
				//通知取款线程，进行取款
				notify();
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(name+"存款前查询余额为："+this.money);
			this.money += money;
			System.out.println(name+"存款后余额为："+this.money);
		}
		
	}
	
	

}
