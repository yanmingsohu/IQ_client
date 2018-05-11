package iq.net;

import iq.assist.Tools;

import java.net.*;
import java.io.*;


public class MsgSender {
	// 客户端的发送线程比接受线程 大1
	private final static int PORTOFFSITE = 500;
	private DatagramSocket socket = null;
	
	public MsgSender(int p) throws IOException
	{
		socket = new DatagramSocket(p+PORTOFFSITE);
	}

	protected void send(UdpPackage msg) throws IOException
	{
		DatagramPacket packet = new DatagramPacket(	
				msg.getMsg().getBytes(), 
				msg.getMsg().getBytes().length, 
				msg.getRemoteIP(),
				msg.getPort() );
		
		socket.send(packet);
	}
	
	/**
	 * 发送消息
	 * @param msg - 消息字符串
	 * @throws IOException - 如果网络出错，抛出这个异常
	 */
	public void send(String msg) throws IOException {
		send( new UdpPackage
				(msg, Tools.getServerAddress(), Tools.getServerPort()) );
	}
	
	public void close() {
		socket.close();
	}
}