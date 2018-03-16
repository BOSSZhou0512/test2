package com.shi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class test {
	
	public static void main(String[] args) {
		Socket sc=null;
		try {
			 sc=new Socket("192.168.10.250", 6666);
			OutputStream out= sc.getOutputStream();
			out.write(new String("我是舒腾，王杰").getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
			
		}finally{
			if(sc!=null){
				try {
					sc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}






