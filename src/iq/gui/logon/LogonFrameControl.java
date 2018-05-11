// CatfoOD 2008-6-9 ����01:07:42

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
	 * ���û����ע�ᰴť
	 */
	public void register() {
		RegFrame rf = new RegFrame(f);
		String id = rf.getLastID();
		if (id!=null) {
			f.setAIqnumber(id);
		}
	}
	
	/**
	 * �رհ�ť
	 */
	public void close() {
		Tools.exit();
	}
	
	/**
	 * ��½��ť
	 */
	public void logon(JComboBox box) {
		String id = box.getSelectedItem().toString();
		if (id==null || id.trim().length()<=0) {
			Tools.show("������iQ��.");
			return;
		}
		String pw = f.getPassword();
		if (pw==null || pw.trim().length()<=1) {
			Tools.show("����������.");
			return;
		}
		new LogonThread(id, pw);
	}
	
	private LogonWaitingFrame waitd = new LogonWaitingFrame();
	
	// ��½�߳�
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
				Tools.show("��½ʧ��: "+info);
				f.setVisible(true);
			}
		}

		public void overTime() {
			waitd.setVisible(false);
			Tools.show("��½����������ʱ��������..");
			f.setVisible(true);
		}

		public String getCodex() {
			return "$LOGON";
		}
		
	}
}



