// CatfoOD 2008-6-9 下午03:28:35

package iq.gui.other;

import iq.assist.Tools;

import java.awt.*;

import javax.swing.JDialog;

/**
 * 显示一个等待对话框，但不阻塞消息线程
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
	 * 关闭等待对话框
	 */
	public void stop() {
		new Thread() {
			public void run() {
				jin.setVisible(false);
			}
		}.start();
	}
	
	/**
	 * 开启等待对话框，阻塞用户输入
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
