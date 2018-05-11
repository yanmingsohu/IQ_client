// CatfoOD 2008-6-9 下午01:19:17

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
	 * 关闭按钮
	 */
	public void close() {
		f.setVisible(false);
	}
	
	private JWaitDialog waitd = new JWaitDialog(null);
	/**
	 * 注册按钮
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
	
	/** 返回成功注册后的ID */
	public String getLastID() {
		return aid;
	}
	
	private void check() throws Exception {
		if (f.getUName().length()<=0) {
			throw new Ex("请填写用户名");
		}
		if (f.getUPass().length()<=4) {
			throw new Ex("密码必须在5位以上");
		}
		if (!f.getUPass().equals(f.getURePass())) {
			throw new Ex("请检查密码输入是否正确");
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
			// 设置超时
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
				Tools.show("申请账号成功您的账号是: "+id+"\n欢迎来到iQ的世界！！");
				aid = id;
				close();
			} else {
				String info = StringTool.getSign(msgpack, "$NO");
				Tools.show("注册失败.\n"+info);
				f.setEnabled(true);
			}
		}

		public void overTime() {
			waitd.stop();
			Tools.show("连接服务器超时，请稍后在试.");
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
