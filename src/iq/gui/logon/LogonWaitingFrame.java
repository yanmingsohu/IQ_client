// CatfoOD 2008-6-10 上午07:15:40

package iq.gui.logon;

import iq.assist.Tools;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BoxLayout;

public class LogonWaitingFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JNILwaitPane JNILwaitPane = null;

	/**
	 * This is the default constructor
	 */
	public LogonWaitingFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(211, 449);
		this.setContentPane(getJContentPane());
		this.setTitle("登陆中..");
		this.setResizable(false);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BoxLayout(getJContentPane(), BoxLayout.X_AXIS));
			jContentPane.add(getJNILwaitPane(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes JNILwaitPane	
	 * 	
	 * @return iq.gui.logon.JNILwaitPane	
	 */
	private JNILwaitPane getJNILwaitPane() {
		if (JNILwaitPane == null) {
			JNILwaitPane = new JNILwaitPane();
			JNILwaitPane.setName(null);
		}
		return JNILwaitPane;
	}
	
	/**
	 * 显示这个窗口,自动安排位置
	 */
	public void setVisible(boolean b) {
		Tools.setMainFrameBounds(this);
		super.setVisible(b);
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
