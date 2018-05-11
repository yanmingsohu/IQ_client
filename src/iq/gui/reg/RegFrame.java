package iq.gui.reg;

import iq.assist.ImagesFactory;
import iq.assist.Tools;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Rectangle;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import java.awt.Point;
import javax.swing.JButton;

public class RegFrame extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel LPname = null;
	private JTextField TPname = null;
	private JLabel Lpwd = null;
	private JTextField Tpwd = null;
	private JLabel Lrepwd = null;
	private JTextField Trepwd = null;
	private JLabel Lage = null;
	private JTextField Tage = null;
	private JLabel Lsex = null;
	private JLabel LEmail = null;
	private JRadioButton Rman = null;
	private JRadioButton Rwoman = null;
	private JTextField TEmail = null;
	private JLabel Lworld = null;
	private JTextField Tworld = null;
	private JLabel Lprovince = null;
	private JTextField Tprovince = null;
	private JLabel Lcity = null;
	private JTextField Tcity = null;
	private JButton Blogon = null;
	private JButton Bexit = null;
	private JLabel Limage = null;

	private RegDialogControl ctrl;
	private JLabel jLabel = null;
	/**
	 * This is the default constructor
	 */
	public RegFrame(Frame f) {
		super(f, "iQ 2008 用户注册", true);
		ctrl = new RegDialogControl(this);
		initialize();
		Tools.ComponentMoveCenter(this);
		this.setVisible(true);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(499, 355);
		this.setIconImage(ImagesFactory.ICON2);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(181, 277, 100, 34));
			jLabel.setText("* 代表必填内容");
			Limage = new JLabel();
			Limage.setBounds(new Rectangle(21, 12, 140, 303));
			Limage.setIcon(ImagesFactory.creatIcon("images/reg.jpg"));
			//Limage.setText("image");
			
			Lcity = new JLabel();
			Lcity.setBounds(new Rectangle(180, 240, 40, 20));
			Lcity.setText("城市：");
			Lprovince = new JLabel();
			Lprovince.setBounds(new Rectangle(180, 210, 40, 20));
			Lprovince.setText("省份：");
			Lworld = new JLabel();
			Lworld.setBounds(new Rectangle(180, 180, 45, 20));
			Lworld.setText("国家：");
			LEmail = new JLabel();
			LEmail.setBounds(new Rectangle(180, 150, 70, 20));
			LEmail.setText("邮箱地址：");
			Lsex = new JLabel();
			Lsex.setBounds(new Rectangle(180, 125, 40, 20));
			Lsex.setText("性别：");
			Lage = new JLabel();
			Lage.setBounds(new Rectangle(180, 95, 40, 20));
			Lage.setText("年龄：");
			Lrepwd = new JLabel();
			Lrepwd.setBounds(new Rectangle(180, 65, 100, 20));
			Lrepwd.setText("* 重新输入密码：");
			Lpwd = new JLabel();
			Lpwd.setBounds(new Rectangle(180, 40, 50, 20));
			Lpwd.setText("* 密码：");
			LPname = new JLabel();
			LPname.setBounds(new Rectangle(180, 15, 50, 20));
			LPname.setPreferredSize(new Dimension(47, 18));
			LPname.setText("* 昵称：");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(LPname, null);
			jContentPane.add(getTPname(), null);
			jContentPane.add(Lpwd, null);
			jContentPane.add(getTpwd(), null);
			jContentPane.add(Lrepwd, null);
			jContentPane.add(getTrepwd(), null);
			jContentPane.add(Lage, null);
			jContentPane.add(getTage(), null);
			jContentPane.add(Lsex, null);
			jContentPane.add(LEmail, null);
			jContentPane.add(getRman(), null);
			jContentPane.add(getRwoman(), null);
			jContentPane.add(getTEmail(), null);
			jContentPane.add(Lworld, null);
			jContentPane.add(getTworld(), null);
			jContentPane.add(Lprovince, null);
			jContentPane.add(getTprovince(), null);
			jContentPane.add(Lcity, null);
			jContentPane.add(getTcity(), null);
			jContentPane.add(getBlogon(), null);
			jContentPane.add(getBexit(), null);
			jContentPane.add(Limage, null);
			jContentPane.add(jLabel, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes TPname	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTPname() {
		if (TPname == null) {
			TPname = new JTextField();
			TPname.setBounds(new Rectangle(300, 15, 170, 20));
		}
		return TPname;
	}

	/**
	 * This method initializes Tpwd	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTpwd() {
		if (Tpwd == null) {
			Tpwd = new JPasswordField();
			Tpwd.setBounds(new Rectangle(300, 40, 170, 20));
		}
		return Tpwd;
	}

	/**
	 * This method initializes Trepwd	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTrepwd() {
		if (Trepwd == null) {
			Trepwd = new JPasswordField();
			Trepwd.setBounds(new Rectangle(300, 65, 170, 20));
		}
		return Trepwd;
	}

	/**
	 * This method initializes Tage	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTage() {
		if (Tage == null) {
			Tage = new JTextField();
			Tage.setBounds(new Rectangle(300, 95, 170, 20));
		}
		return Tage;
	}

	/**
	 * This method initializes Rman	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRman() {
		if (Rman == null) {
			Rman = new JRadioButton();
			Rman.setBounds(new Rectangle(320, 120, 40, 20));
			Rman.setText("男");
		}
		return Rman;
	}

	/**
	 * This method initializes Rwoman	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRwoman() {
		if (Rwoman == null) {
			Rwoman = new JRadioButton();
			Rwoman.setBounds(new Rectangle(405, 120, 40, 20));
			Rwoman.setText("女");
		}
		return Rwoman;
	}

	/**
	 * This method initializes TEmail	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTEmail() {
		if (TEmail == null) {
			TEmail = new JTextField();
			TEmail.setBounds(new Rectangle(300, 150, 170, 20));
		}
		return TEmail;
	}

	/**
	 * This method initializes Tworld	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTworld() {
		if (Tworld == null) {
			Tworld = new JTextField();
			Tworld.setBounds(new Rectangle(300, 180, 170, 20));
		}
		return Tworld;
	}

	/**
	 * This method initializes Tprovince	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTprovince() {
		if (Tprovince == null) {
			Tprovince = new JTextField();
			Tprovince.setBounds(new Rectangle(300, 210, 170, 20));
		}
		return Tprovince;
	}

	/**
	 * This method initializes Tcity	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTcity() {
		if (Tcity == null) {
			Tcity = new JTextField();
			Tcity.setBounds(new Rectangle(300, 240, 170, 20));
		}
		return Tcity;
	}

	/**
	 * This method initializes Blogon	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBlogon() {
		if (Blogon == null) {
			Blogon = new JButton();
			Blogon.setBounds(new Rectangle(300, 285, 75, 25));
			Blogon.setText(" 注册");
			Blogon.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ctrl.reg();
				}
			});
		}
		return Blogon;
	}

	/**
	 * This method initializes Bexit	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBexit() {
		if (Bexit == null) {
			Bexit = new JButton();
			Bexit.setBounds(new Rectangle(390, 285, 75, 25));
			Bexit.setText("取消");
			Bexit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ctrl.close();
				}
			});
		}
		return Bexit;
	}

	protected String getUName() {
		return TPname.getText().trim();
	}
	
	protected String getUPass() {
		return Tpwd.getText().trim();
	}
	
	protected String getURePass() {
		return Trepwd.getText().trim();
	}
	
	protected int getUAge() {
		int age;
		try {
			age = Integer.parseInt( Tage.getText().trim() );
		} catch(Exception e) {
			age = 0;
		}
		return age;
	}
	
	protected String getUSex() {
		if (Rman.isSelected()) {
			return "男";
		} else {
			return "女";
		}
	}
	
	protected String getUEmail() {
		return TEmail.getText().trim();
	}
	
	protected String getUcountry() {
		return Tworld.getText().trim();
	}
	
	protected String getUprovince() {
		return Tprovince.getText().trim();
	}
	
	protected String getUcity() {
		return Tcity.getText().trim();
	}
	
	/** 返回成功注册后的ID */
	public String getLastID() {
		return ctrl.getLastID();
	}
}  //  @jve:decl-index=0:visual-constraint="-17,-6"
