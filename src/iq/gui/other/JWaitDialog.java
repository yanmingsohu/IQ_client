// CatfoOD 2008-6-9 ����03:28:35

package iq.gui.other;

import iq.assist.Tools;

import java.awt.*;

import javax.swing.JDialog;

/**
 * ��ʾһ���ȴ��Ի��򣬵���������Ϣ�߳�
 */
public class JWaitDialog {
	private JINDialog jin;
	private final Frame f;
	
	public JWaitDialog(final Frame f) {
		this.f = f;
		jin = new JINDialog(f);
	}
	
	private class JINDialog extends JDialog {
		public JINDialog(Frame f) {
			super(f,"Wait..",true);
			this.add(new JWaitPane());
			this.setSize(280, 150);
			this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			Tools.ComponentMoveCenter(this);
		}
	}
	
	/**
	 * �رյȴ��Ի���
	 */
	public void stop() {
		new Thread() {
			public void run() {
				jin.setVisible(false);
			}
		}.start();
	}
	
	/**
	 * �����ȴ��Ի��������û�����
	 */
	public void start() {
		new Thread() {
			public void run() {
				Tools.ComponentMoveCenter(jin);
				jin.setVisible(true);
			}
		}.start();
	}
	
	public static void main(String[]s) {
		new JWaitDialog(null);
	}
}
