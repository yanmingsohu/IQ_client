package iq.event;

import iq.assist.CodexMaker;
import iq.assist.StringTool;
import iq.assist.Tools;
import iq.net.MsgFactory;

import java.io.IOException;
import java.net.DatagramPacket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;

public class RecverManager implements InetListener {
	private ArrayList<InetListener> listens = new ArrayList<InetListener>();
	private EventQueueThread eqt;
	
	public RecverManager() {
		releseAllListen();
		eqt = new EventQueueThread();
	}
	
	/** 释放所有监听器 */
	public void releseAllListen() {
		listens.removeAll(listens);
	}
	
	/** 释放一个监听器 */
	public boolean releaseListen(InetListener o) {
		return listens.remove(o);
	}
	
	/** 注册一个监听器 */
	public boolean regListen(InetListener i) {
		return listens.contains(i)? false: listens.add(i);
	}
	
	/** 消息管理自动去掉头32字节的数据，并自动回应它 */
	public void information(Object o) {
		DatagramPacket packet = (DatagramPacket)o;
		
		String msg = new String(packet.getData(), 
				packet.getOffset(), packet.getLength());

		int end = msg.indexOf("\n");
		end = end<=0? end=msg.length(): end;
		Tools.pl("recv: "+msg.substring(0, end)); ////
		// 回应消息
		msg = affirmResponses(msg);
		
		eqt.add(msg);
	}
	
	// 回应消息
	private String affirmResponses(String s) {
		String respon;
		if (s.startsWith(CodexMaker.RESPONSES)) {
			respon = CodexMaker.RESPONSES +
							StringTool.getSign(s, CodexMaker.RESPONSES);
			
			if ( respon.length()==Tools.getCodesLength() ) {
				MsgFactory.send("$ASK."+respon);
				return StringTool.getDot(s, 1);
			}
		}
		return s;
	}
	
	private void dispose(String strMsg) {
		for (int i=0; i<listens.size(); ++i) {
			InetListener liser = listens.get(i);
			if ( strMsg.startsWith( liser.getCodex() ) ) {
				liser.information(strMsg);
			}
		}
	}
	
	// 消息队列线成
	private class EventQueueThread extends Thread {
		private Queue<String> queue; 
		public EventQueueThread() {
			queue = new ArrayDeque<String>();
			start();
		}
		
		public void run() {
			while (true) {
				String mp = queue.poll();
				if (mp!=null) {
					dispose(mp);
				} else {
					try {
						sleep(100);
					} catch (InterruptedException e) {}
				}
			}
		}
		
		public synchronized void add(String p) {
			queue.add(p);
		}
	}

	/** 消息管理器的这个方法总是返回null */
	public String getCodex() {
		return null;
	}
}
