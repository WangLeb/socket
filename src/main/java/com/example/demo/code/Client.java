package com.example.demo.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
	public static Socket createClient() throws IOException {

		Socket socket = new Socket();
		// 设置超时时间
		socket.setSoTimeout(3000);
		
		// 连接本地端口2000 ,设置超时时间3000
		socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(), 2000), 300);
		
		System.out.println("已经发起服务连接");
		System.out.println("客户端信息" + socket.getLocalAddress() + "p:" + socket.getPort());
		System.out.println("服务器信息" + socket.getInetAddress() + "p" + socket.getPort());
		return socket;
	}
	
	public static void todo(Socket client) throws IOException {
		
		//构建键盘输入流
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in,"GBK"));

	}

	public static void main(String[] args) throws IOException {

		// 调用封装的Socket方法
		Socket socket = createClient();
		try {
			// 发送接收数据
			todo(socket);
		} catch (Exception e) {
			System.out.println("客户端异常关闭");
		}

		// 释放资源
		socket.close();
		System.out.println("客户端已退出");
	}



	

}
