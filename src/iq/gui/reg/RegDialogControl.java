// CatfoOD 2008-6-9 ����01:19:17

package iq.gui.reg;

import java.io.IOException;

import iq.assist.MessageThread;
import iq.assist.StringTool;
import iq.assist.Tools;
import iq.gui.other.JWaitDialog;
import iq.net.MsgFactory;

public class RegDialogControl {
	private RegFrame f;
	private String aid = null;
	
	public RegDialogControl(RegFrame f) {
		this.f = f;
	}
	
	/**
	 * �رհ�ť
	 */
	public void close() {
		f.setVisible(false);
	}
	
	private JWaitDialog waitd = new JWaitDialog(null);
	/**
	 * ע�ᰴť
	 */
	public void reg() {
		try {
//			f.setEnabled(false);
			check();
			waitd.start();
			sendToServer();
		} catch (Exception e) {
			waitd.stop();
			f.setEnabled(true);
			Tools.show(e.toString());
		}
	}
	
	/** ���سɹ�ע����ID */
	public String getLastID() {
		return aid;
	}
	
	private void check() throws Exception {
		if (f.getUName().length()<=0) {
			throw new Ex("����д�û���");
		}
		if (f.getUPass().length()<=4) {
			throw new Ex("���������5λ����");
		}
		if (!f.getUPass().equals(f.getURePass())) {
			throw new Ex("�������������Ƿ���ȷ");
		}
	}
	
	private void sendToServer()  {
		final String ENTER = "\n";
		StringBuffer buff = new StringBuffer();
		String name = f.getUName();
		String pass = f.getUPass();
		
		buff.append("age="+		f.getUAge()+ENTER);
		buff.append("city="+	f.getUcity()+ENTER);
		buff.append("country="+	f.getUcountry()+ENTER);
		buff.append("email="+	f.getUEmail()+ENTER);
		buff.append("province="+f.getUprovince()+ENTER);
		buff.append("sex="+		f.getUSex()+ENTER);
		
		String regSendMsg = "$REG.$N"+name+".$P"+pass+".$INFO"+buff.toString();
		new registerThread(regSendMsg);
	}
	
	private class registerThread extends MessageThread {
		public registerThread(String msg) {
			// ���ó�ʱ
			this.start(10);
			try {
				MsgFactory.getMsgSender().send(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void complete(String msgpack) {
			waitd.stop();
			if (StringTool.haveSign(msgpack, "$OK")) {
				String id = StringTool.getSign(msgpack, "$ID");
				Tools.show("�����˺ųɹ������˺���: "+id+"\n��ӭ����iQ�����磡��");
				aid = id;
				close();
			} else {
				String info = StringTool.getSign(msgpack, "$NO");
				Tools.show("ע��ʧ��.\n"+info);
				f.setEnabled(true);
			}
		}

		public void overTime() {
			waitd.stop();
			Tools.show("���ӷ�������ʱ�����Ժ�����.");
			f.setEnabled(true);
		}

		public String getCodex() {
			return "$REG";
		}
	}
	
	private class Ex extends Exception {
		private String s;
		public Ex(String s) {
			this.s = s;
		}
		public String toString() {
			return s;
		}
	}
}
