package com.shi;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
	public static void main(String[] args) {
		ServerSocket sc=null;
		try {
			
			sc=new ServerSocket(6666);
			Socket client= sc.accept();
			OutputStream out= client.getOutputStream();
			byte[]bytes=new byte[1024];
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
