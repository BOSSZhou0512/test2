package com.zhidi.test2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

class TcpClientThread extends Thread{


    @Override
    public void run() {

        Socket socket = null;
        Scanner scanner = new Scanner(System.in);

        try {
//          * 创建Socket连接服务端(指定ip地址,端口号)通过ip地址找对应的服务器
            socket = new Socket("192.168.10.143", 8888);
//          * 调用Socket的getInputStream()和getOutputStream()方法获取和服务端相连的IO流
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            while(true) {
                String inputStr = scanner.nextLine();
                if("quit".equals(inputStr)) {
                    break;
                }
//              * 输出流可以写出数据到服务端的输入流
                outputStream.write(inputStr.getBytes());
//              * 输入流可以读取服务端输出流写出的数据
                byte[] bys = new byte[1024];
                int len = inputStream.read(bys);
                String str = new String(bys, 0, len);
                System.out.println("客户端接收到 : "+str);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }


    }
}