// CatfoOD 2008-6-8 下午01:52:24

package iq.assist;

import java.io.IOException;

import iq.event.InetListener;
import iq.net.MsgFactory;

public abstract class MessageThread extends Thread implements InetListener{
	/** 如果有回应返回true; */
	private volatile boolean responed = false;
	/** 如果线程结束（超时，或者完成）为true */
	private volatile boolean threadReturned = false;
	/** 默认的超时值,毫秒 */
	private long TIMEOUT = 15000;
	private long starttime;
	protected String msg;
	
	/**
	 * 建立一个需要应答的数据发送线程，简化编程
	 * @param sendMsg
	 * @throws IOException
	 */
	public MessageThread()  {
		if ( false==MsgFactory.getRecverManager().regListen(this) ) {
			Tools.pl("注册消息失败:"+this);
		}
		starttime = System.currentTimeMillis();
	}
	
	/**
	 * 开始线程，并设置一个超时
	 * @param timeout - 超时的秒 s
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
	 * 等待，直到线程从网络接受到消息，或者服务器超时
	 */
	public void waiting() {
		while (!threadReturned) {
			try {
				sleep(200);
			} catch (InterruptedException e) {}
		}
	}
	
	/**
	 * 是否收到服务器的应答，收到返回true
	 */
	public boolean isResponsioned() {
		return responed;
	}
	
	/**
	 * 子类重写的方法,在超时后会被调用,默认的方法为空
	 */
	public abstract void overTime();
	
	/**
	 * 子类重写的方法，在有效的时间内得到了应答的消息，被调用
	 */
	public abstract void complete(String msgpack);
	
}
