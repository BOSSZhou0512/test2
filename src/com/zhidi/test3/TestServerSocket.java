package com.zhidi.test3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestServerSocket {
	
	public static void main(String[] args) {
		
		ServerSocket server = null ;
		Scanner sc = new Scanner(System.in);
		try {
			//创建一个服务端套接字对象
			server = new ServerSocket(6666);
			System.out.println("服务端已启动，等待连接中......");
			
				//等待连接
				Socket client = server.accept();
				//获得客户端传输的数据流
				InputStream in = client.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				while(true){
					
					System.out.print(client.getInetAddress().getHostAddress()+"说：");
					//字节输入流,只要连接存在，那么read方法，永远不会返回-1
					String msg = reader.readLine();
					if(msg== null){
						break;
					}
					System.out.println(msg);
					
					//回信息给客户端，需要获得输出流
					OutputStream out = client.getOutputStream();
					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
					//提示服务端要回信息
					System.out.print("请输入您回复的内容：");
					//等待输入
					String s = sc.next();
					System.out.println("s--->"+s);
					writer.write(s);
					writer.newLine();
					writer.flush();
				}
			
			//System.out.println("读取数据结束");
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			if(server != null){
				try {
					server.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
	}

}
