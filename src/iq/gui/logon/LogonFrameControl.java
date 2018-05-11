// CatfoOD 2008-6-9 下午01:07:42

package iq.gui.logon;

import java.io.File;
import java.io.IOException;

import javax.swing.JComboBox;

import iq.assist.MessageThread;
import iq.assist.StringTool;
import iq.assist.Tools;
import iq.event.LogonProcess;
import iq.gui.other.JWaitDialog;
import iq.gui.reg.RegFrame;
import iq.net.MsgFactory;

public class LogonFrameControl {
	private LogonFrame f;
	
	protected LogonFrameControl(LogonFrame f) {
		this.f = f;
	}
	
	public void initComboBox(JComboBox box) {
		File file = new File("iq\\");
		File[] files = file.listFiles();
		for (int i=0; i<files.length; ++i) {
			if (files[i].isDirectory()) {
				box.addItem(files[i].getName());
			}
		}
	}
	
	/**
	 * 当用户点击注册按钮
	 */
	public void register() {
		RegFrame rf = new RegFrame(f);
		String id = rf.getLastID();
		if (id!=null) {
			f.setAIqnumber(id);
		}
	}
	
	/**
	 * 关闭按钮
	 */
	public void close() {
		Tools.exit();
	}
	
	/**
	 * 登陆按钮
	 */
	public void logon(JComboBox box) {
		String id = box.getSelectedItem().toString();
		if (id==null || id.trim().length()<=0) {
			Tools.show("请输入iQ号.");
			return;
		}
		String pw = f.getPassword();
		if (pw==null || pw.trim().length()<=1) {
			Tools.show("请输入密码.");
			return;
		}
		new LogonThread(id, pw);
	}
	
	private LogonWaitingFrame waitd = new LogonWaitingFrame();
	
	// 登陆线程
	private class LogonThread extends MessageThread {
		private String id = null;
		
		public LogonThread(String id, String pw) {
			f.setVisible(false);
			waitd.setVisible(true);
			start();
			try {
				String s = "$LOGON.$ID"+id+".$P"+pw;
				MsgFactory.getMsgSender().send(s);
				this.id = id;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void complete(String src) {
			if (StringTool.haveSign(src, "$OK")) {
				f.dispose();
				LogonProcess.init(id, waitd);
			} else {
				waitd.setVisible(false);
				String info = StringTool.getSign(src, "$NO");
				Tools.show("登陆失败: "+info);
				f.setVisible(true);
			}
		}

		public void overTime() {
			waitd.setVisible(false);
			Tools.show("登陆到服务器超时，请重试..");
			f.setVisible(true);
		}

		public String getCodex() {
			return "$LOGON";
		}
		
	}
}



