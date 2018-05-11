// CatfoOD 2008-6-8 ����01:52:24

package iq.assist;

import java.io.IOException;

import iq.event.InetListener;
import iq.net.MsgFactory;

public abstract class MessageThread extends Thread implements InetListener{
	/** ����л�Ӧ����true; */
	private volatile boolean responed = false;
	/** ����߳̽�������ʱ��������ɣ�Ϊtrue */
	private volatile boolean threadReturned = false;
	/** Ĭ�ϵĳ�ʱֵ,���� */
	private long TIMEOUT = 15000;
	private long starttime;
	protected String msg;
	
	/**
	 * ����һ����ҪӦ������ݷ����̣߳��򻯱��
	 * @param sendMsg
	 * @throws IOException
	 */
	public MessageThread()  {
		if ( false==MsgFactory.getRecverManager().regListen(this) ) {
			Tools.pl("ע����Ϣʧ��:"+this);
		}
		starttime = System.currentTimeMillis();
	}
	
	/**
	 * ��ʼ�̣߳�������һ����ʱ
	 * @param timeout - ��ʱ���� s
	 */
	public void start(long timeout) {
		TIMEOUT = timeout*1000;
		super.start();
	}
	
	public void run() {
		while (!responed) {
			try {
				if (starttime+TIMEOUT<System.currentTimeMillis()) {
					threadReturned = true;
					overTime();
					return;
				}
				sleep(200);
			} catch (InterruptedException e) {}
		}
		threadReturned = true;
		MsgFactory.getRecverManager().releaseListen(this);
		if (responed) complete(msg);
	}

	public void information(Object o) {
		msg = (String)o;
		responed = true;
	}
	
	/**
	 * �ȴ���ֱ���̴߳�������ܵ���Ϣ�����߷�������ʱ
	 */
	public void waiting() {
		while (!threadReturned) {
			try {
				sleep(200);
			} catch (InterruptedException e) {}
		}
	}
	
	/**
	 * �Ƿ��յ���������Ӧ���յ�����true
	 */
	public boolean isResponsioned() {
		return responed;
	}
	
	/**
	 * ������д�ķ���,�ڳ�ʱ��ᱻ����,Ĭ�ϵķ���Ϊ��
	 */
	public abstract void overTime();
	
	/**
	 * ������д�ķ���������Ч��ʱ���ڵõ���Ӧ�����Ϣ��������
	 */
	public abstract void complete(String msgpack);
	
}
