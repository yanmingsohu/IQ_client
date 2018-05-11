// CatfoOD 2008-6-11 ����01:51:04

package iq.event;

import iq.assist.SoundEffect;
import iq.assist.StringTool;
import iq.assist.Tools;
import iq.gui.other.Helpf;
import iq.net.MsgFactory;

public class AddFriendEventThread {
	private static AddFriendEventThread ate = 
							new AddFriendEventThread();
	
	public static void init() {
		// do nothing
	}
	
	// ------------------- instance ----------------------
	private AddFriendEventThread() {
		MsgFactory.getRecverManager().regListen(new requestThread());
		MsgFactory.getRecverManager().regListen(new responsionThread());
	}
	
	// ������һ���ͻ��ĺ�������
	private class requestThread implements InetListener{

		public String getCodex() {
			return "$FRI.$REQU";
		}

		public void information(final Object o) {
			new Thread() {
				public void run() {
					String msg = o.toString();
					String code 	= StringTool.getSign(msg, "$REQU");
					String sysinfo 	= StringTool.getSign(msg, "$SYS");
					String userinfo	= StringTool.getSign(msg, "$INFO");
					// �����Ի���
					SoundEffect.playSE("����");
					Helpf h = new Helpf("", "", sysinfo, userinfo, true);
					String end = null;
					
					String id = FriendList.getMainUser().getID();
					String name = FriendList.getMainUser().getName();
					if (h.getSelect()) {
						sysinfo = name+" ("+id+") ͬ�����Ϊ����";
						end = "$OK";
					} else {
						sysinfo = name+" ("+id+") �ܾ�����Ϊ����";
						end = "$NO";
					}
					String info = h.getResultText();
					String s = "$FRI.$RESP"+code+"."+end+".$SYS"+sysinfo+".$INFO"+info;
					MsgFactory.send(s);
					try {
						sleep(1000);
					} catch (InterruptedException e) {}
					FriendList.requestList();
				}
			}.start();
		}
	}
	
	// ������һ�������Ӧ��
	private class responsionThread implements InetListener{

		public String getCodex() {
			return "$FRI.$FID";
		}

		public void information(Object o) {
			String src = o.toString();
			String sysinfo 	= StringTool.getSign(src, "$SYS");
			String userinfo	= StringTool.getSign(src, "$INFO");
			String uid	= StringTool.getSign(src, "$ID");
			
			FriendList.requestList();
			SoundEffect.playSE("����");
			Helpf h = new Helpf("", "", sysinfo, userinfo, false);
		}
	}
}
