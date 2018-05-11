package iq.net;

import iq.assist.Tools;

import java.net.*;
import java.io.*;


public class MsgSender {
	// �ͻ��˵ķ����̱߳Ƚ����߳� ��1
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
	 * ������Ϣ
	 * @param msg - ��Ϣ�ַ���
	 * @throws IOException - �����������׳�����쳣
	 */
	public void send(String msg) throws IOException {
		send( new UdpPackage
				(msg, Tools.getServerAddress(), Tools.getServerPort()) );
	}
	
	public void close() {
		socket.close();
	}
}