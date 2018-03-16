package com.zhidi.test3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestSocket {
	
	public static void main(String[] args) {
		//创建Socket对象
		Socket socket = null ;
		Scanner sc = new Scanner(System.in);
		try {
			 socket = new Socket("127.0.0.1", 6666);
			 //获得输出流
			 OutputStream out = socket.getOutputStream();
			 
			 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
			 while(true){
				//提示用户输入数据
				 System.out.print("请输入您要对服务端说的话：");
				 //等待用户输入：
				 String s = sc.next();
				 //输出数据
				 writer.write(s);
				 writer.newLine();
				 writer.flush();
				 
				 //获得输入流，等待服务端返回信息
				 InputStream in = socket.getInputStream();
				 BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				 String msg= reader.readLine();
				 System.out.println("服务端说:"+msg); 
				 if(msg.equals("886")){
					 break;
				 }
			 }
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
