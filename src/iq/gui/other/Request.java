package iq.gui.other;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Point;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

public class Request extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel framelink = null;
	private JButton Yes = null;
	private JButton No = null;
	private JCheckBox addfriend = null;
	private JLabel ToPerson = null;
	public Request() {
		super();
		initialize();
	}

	private void initialize() {
		this.setSize(360, 140);
		this.setContentPane(getJContentPane());
		this.setTitle("IQ2008查找/添加好友");
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			ToPerson = new JLabel();
			ToPerson.setBounds(new Rectangle(220, 24, 102, 42));
			ToPerson.setText("ToPerson image");
			framelink = new JLabel();
			framelink.setBounds(new Rectangle(15, 15, 315, 61));
			framelink.setVerticalAlignment(SwingConstants.TOP);
			framelink.setText("对方IQ+将您列入好友名单");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(framelink, null);
			jContentPane.add(getYes(), null);
			jContentPane.add(getNo(), null);
			jContentPane.add(getAddfriend(), null);
			jContentPane.add(ToPerson, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes Yes	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getYes() {
		if (Yes == null) {
			Yes = new JButton();
			Yes.setPreferredSize(new Dimension(34, 10));
			Yes.setLocation(new Point(165, 85));
			Yes.setText("确定");
			Yes.setSize(new Dimension(80, 20));
		}
		return Yes;
	}

	/**
	 * This method initializes No	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getNo() {
		if (No == null) {
			No = new JButton();
			No.setSize(new Dimension(80, 20));
			No.setText("取消");
			No.setLocation(new Point(252, 85));
		}
		return No;
	}

	/**
	 * This method initializes addfriend	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getAddfriend() {
		if (addfriend == null) {
			addfriend = new JCheckBox();
			addfriend.setBounds(new Rectangle(14, 88, 123, 15));
			addfriend.setText("添加对方为好友");
		}
		return addfriend;
	}
}
