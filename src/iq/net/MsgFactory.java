package iq.net;

import iq.assist.Tools;
import iq.event.InetListener;
import iq.event.RecverManager;

import java.io.IOException;

public class MsgFactory {
	private MsgFactory(){}
	private static int port;
	
	/**
	 * ��ʼ����Ϣ����
	 */
	public static void init() throws IOException {
		port = creatMsgRecver(
				Tools.getLocalPort(), getRecverManager()).getPort();
		getMsgSender();
	}
	
	private static MsgSender send = null;
	private static MsgRecver recv = null;
	private static RecverManager remanager = null;
	
	/**
	 * ���ط�����
	 * @return MsgSender
	 * @throws IOException - ������ܽ����������ӣ��ܳ�����쳣
	 */
	public static MsgSender getMsgSender() throws IOException {
		if (send==null) {
			send = new MsgSender(port);
		}
		return send;
	}	
	
	public static void send(String msg) {
		try {
			send.send(msg);
		} catch (IOException e) {
			Tools.pl("�������ݴ���"+e);
			Tools.error(e);
		}
	}
	
	/**
	 * ������Ϣ������
	 */
	public static RecverManager getRecverManager() {		
		if (remanager==null) {
			remanager = new RecverManager();
		}
		return remanager;
	}
	
	// �ڲ�ʵ��
	private static MsgRecver creatMsgRecver(final int port, InetListener recverManager) 
	throws IOException
	{
		final int tautology = 100;
		int p = port;
		while (p<port+tautology) {
			try {
				recv = new MsgRecver(p, recverManager);
				send = new MsgSender(p);
				return recv;
			} catch(IOException e) {
				Tools.pl(e.getMessage()+' '+p);
				if (recv!=null) recv.close();
				if (send!=null) send.close();
				++p;
			}
		}
		throw new IOException();
	}

}
