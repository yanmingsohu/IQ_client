package iq.gui.logon;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;

import iq.assist.ImagesFactory;
import iq.assist.MouseAutoColor;
import iq.assist.Tools;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Point;
import java.awt.Dimension;

public class LogonFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel LuserID = null;
	private JLabel Luserpwd = null;
	private JTextField Tuserpwd = null;
	private JCheckBox Autologin = null;
	private JCheckBox Conceallogin = null;
	private JButton BLogin = null;
	private JLabel LLogon = null;
	private JLabel Image = null;
	
	private LogonFrameControl ctrl;
	private JButton jButton = null;
	private JComboBox jComboBox = null;
	public LogonFrame() {
		super();
		ctrl = new LogonFrameControl(this);
		initialize();
	}

	private void initialize() {
		this.setContentPane(getJContentPane());
		this.setSize(320, 218);
		this.setTitle("iQ 2008 ÓÃ»§µÇÂ¼");
		Tools.ComponentMoveCenter(this);
		this.setIconImage(ImagesFactory.ICON2);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		this.setAlwaysOnTop(false);
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			Image = new JLabel();
			Image.setBounds(new Rectangle(1, 1, 318, 70));
			Image.setBackground(Color.black);
			Image.setIcon(ImagesFactory.creatIcon("images/main.jpg"));
			Image.setText("");
			
			LLogon = new JLabel();
			LLogon.setBounds(new Rectangle(244, 77, 58, 22));
			LLogon.setText("ÉêÇëÕËºÅ");
			Luserpwd = new JLabel();
			Luserpwd.setText("IQÃÜÂë£º");
			Luserpwd.setSize(new Dimension(55, 24));
			Luserpwd.setLocation(new Point(24, 105));
			
			LuserID = new JLabel();
			LuserID.setBounds(new Rectangle(24, 75, 55, 24));
			LuserID.setText("IQÕËºÅ£º");
			
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(LuserID, null);
			jContentPane.add(Luserpwd, null);
			jContentPane.add(getTuserpwd(), null);
			jContentPane.add(getAutologin(), null);
			jContentPane.add(getConceallogin(), null);
			jContentPane.add(getBLogin(), null);
			jContentPane.add(LLogon, null);
			jContentPane.add(Image, null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJComboBox(), null);
		}
		
		LLogon.setCursor(new Cursor(Cursor.HAND_CURSOR));
		LLogon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				ctrl.register();
			}
		});

		new MouseAutoColor(LLogon);
		return jContentPane;
	}

	private JTextField getTuserpwd() {
		if (Tuserpwd == null) {
			Tuserpwd = new JPasswordField();
			Tuserpwd.setLocation(new Point(87, 105));
			Tuserpwd.setSize(new Dimension(151, 24));
			Tuserpwd.addKeyListener(new java.awt.event.KeyAdapter() {
				public void keyPressed(java.awt.event.KeyEvent e) {
					if (e.getKeyCode()==KeyEvent.VK_ENTER) {
						ctrl.logon(jComboBox);
					}
				}
			});
		}
		return Tuserpwd;
	}

	private JCheckBox getAutologin() {
		if (Autologin == null) {
			Autologin = new JCheckBox();
			Autologin.setBounds(new Rectangle(84, 130, 78, 20));
			Autologin.setText("×Ô¶¯µÇÂ½");
		}
		return Autologin;
	}

	private JCheckBox getConceallogin() {
		if (Conceallogin == null) {
			Conceallogin = new JCheckBox();
			Conceallogin.setBounds(new Rectangle(167, 129, 93, 22));
			Conceallogin.setText("ÒþÉíµÇÂ½");
		}
		return Conceallogin;
	}

	private JButton getBLogin() {
		if (BLogin == null) {
			BLogin = new JButton();
			BLogin.setBounds(new Rectangle(59, 154, 96, 25));
			BLogin.setText("µÇÂ½");
			BLogin.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ctrl.logon(jComboBox);
				}
			});
		}
		return BLogin;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("¹Ø±Õ");
			jButton.setBounds(new Rectangle(165, 154, 95, 25));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ctrl.close();
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jComboBox	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setBounds(new Rectangle(87, 75, 150, 23));
			jComboBox.setEditable(true);
			ctrl.initComboBox(jComboBox);
		}
		return jComboBox;
	}
	
	protected void setAIqnumber(String id) {
		jComboBox.addItem(id);
		jComboBox.setSelectedItem(id);
	}
	
	protected String getPassword() {
		return Tuserpwd.getText();
	}
}  //  @jve:decl-index=0:visual-constraint="33,29"
