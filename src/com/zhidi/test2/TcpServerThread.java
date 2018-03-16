package com.zhidi.test2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class TcpServerThread extends Thread{


    @Override
    public void run() {


        Socket socket = null;
        try {
//          * 创建ServerSocket(需要指定端口号)
            ServerSocket server = new ServerSocket(8888);
//          * 调用ServerSocket的accept()方法接收一个客户端请求，得到一个Socket
            socket = server.accept();
//          * 调用Socket的getInputStream()和getOutputStream()方法获取和客户端相连的IO流
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            while(true) {

//          * 输入流可以读取客户端输出流写出的数据
                byte[] bys = new byte[1024];
                int len = inputStream.read(bys);
                String str = new String(bys, 0, len);
                System.out.println("服务端收到 : "+str);
                if("quit".equals(str)) {
                    break;
                }
//          * 输出流可以写出数据到客户端的输入流
                String newStr = str+"亲爱的,我也是这么想的...";
                outputStream.write(newStr.getBytes());

            }

        } catch (IOException e) {
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