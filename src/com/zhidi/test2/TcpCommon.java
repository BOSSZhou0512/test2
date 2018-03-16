package com.zhidi.test2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpCommon {

	
	public static void main(String[] args) {
		new ServerThread().start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new ClientThread().start();
	}
}


class ClientThread extends Thread{
	
	@Override
	public void run() {

		// String message = "i fuck you";
		Socket socket = null;
		try {
			Scanner scanner = new Scanner(System.in);
			while (true) {

				System.out.println("请输入消息");
				String message = scanner.next();

				// 创建Socket连接服务端(指定ip地址,端口号)通过ip地址找对应的服务器
				socket = new Socket(InetAddress.getByName("192.168.10.29"), 6688);
				// 调用Socket的getInputStream()和getOutputStream()方法获取和服务端相连的IO流
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
				// 输入流可以读取服务端输出流写出的数据
				// 输出流可以写出数据到服务端的输入流
				outputStream.write(message.getBytes());
				if("quit".equals(message)){
					break;
				}
				
				byte[] bys = new byte[1024];
				int len = inputStream.read(bys);
				System.out.println("客户端接收到的消息 : "+new String(bys,0,len));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	
	}
	
	
}
class ServerThread extends Thread{
	
	@Override
	public void run() {

		ServerSocket serverSocket = null;
		try {
			// 创建ServerSocket(需要指定端口号)
			serverSocket = new ServerSocket(6688);
			while (true) {

				// 调用ServerSocket的accept()方法接收一个客户端请求，得到一个Socket
				Socket socket = serverSocket.accept();
				// 调用Socket的getInputStream()和getOutputStream()方法获取和客户端相连的IO流
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
				// 输入流可以读取客户端输出流写出的数据
				byte[] bys = new byte[1024];
				int len = inputStream.read(bys);
				String data = new String(bys,0,len);
				if("quit".equals(data.trim())){
					break;
				}
				System.out.println("服务端接收到消息 : "+data);
				String newData = data+"!!!";
				// 输出流可以写出数据到客户端的输入流
				outputStream.write(newData.getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
		
	}
	
	
}
