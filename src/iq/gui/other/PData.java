package iq.gui.other;

import iq.assist.ImagesFactory;
import iq.assist.MouseAutoColor;
import iq.assist.Tools;
import iq.event.UserEntity;
import iq.event.UserInfo;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;

public class PData extends JFrame {
	private PDataControl ctrl = new PDataControl(this);

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel Limage = null;
	private JLabel LPname = null;
	private JTextField TPname = null;
	private JLabel LID = null;
	private JTextField TID = null;
	private JLabel LCimage = null;
	private JLabel LCimageT = null;
	private JLabel Lsignature = null;
	private JCheckBox Cshow = null;
	private JLabel Lsex = null;
	private JComboBox Csex = null;
	private JLabel Lage = null;
	private JTextField Tage = null;
	private JLabel Lname = null;
	private JTextField Tname = null;
	private JLabel Lbelong = null;
	private JComboBox Cbelong = null;
	private JLabel Lblood = null;
	private JComboBox Cblood = null;
	private JLabel Lbrithday = null;
	private JComboBox Cmonth = null;
	private JLabel Lmonth = null;
	private JComboBox Cday = null;
	private JLabel Lday = null;
	private JLabel Lemail = null;
	private JTextField Temail = null;
	private JLabel Lhoroscope = null;
	private JComboBox Choroscope = null;
	private JLabel Lworld = null;
	private JTextField Tworld = null;
	private JLabel Lprovince = null;
	private JTextField Tprovince = null;
	private JLabel Lcity = null;
	private JLabel Lexplain = null;
	private JButton Byes = null;
	private JButton Bno = null;
	private JTextField Tcity = null;
	private JScrollPane Ssignasture = null;
	private JTextArea Asignasgture = null;
	private JScrollPane Sexplain = null;
	private JTextArea Texplain = null;

	private JButton UpdataButton = null;
	/**
	 * This is the default constructor
	 */
	public PData(UserEntity user) {
		super();
		initialize();
		ctrl.setUserEntity(user);
		updataInfo();
		this.setTitle("iQ 2008 / "+user.getID()+ "查看资料.");
		this.setAlwaysOnTop(true);
		this.setAlwaysOnTop(false);
		this.setVisible(true);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(431, 430);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Tools.ComponentMoveCenter(this);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	protected JPanel getJContentPane() {
		if (jContentPane == null) {
			Lexplain = new JLabel();
			Lexplain.setBounds(new Rectangle(20, 207, 80, 20));
			Lexplain.setText("个人说明：");
			Lcity = new JLabel();
			Lcity.setBounds(new Rectangle(244, 314, 50, 20));
			Lcity.setText("城市：");
			Lprovince = new JLabel();
			Lprovince.setBounds(new Rectangle(134, 314, 50, 20));
			Lprovince.setText("省份：");
			Lworld = new JLabel();
			Lworld.setBounds(new Rectangle(19, 314, 50, 20));
			Lworld.setText("国家：");
			Lhoroscope = new JLabel();
			Lhoroscope.setBounds(new Rectangle(244, 339, 50, 20));
			Lhoroscope.setText("星座：");
			Lemail = new JLabel();
			Lemail.setBounds(new Rectangle(19, 339, 62, 20));
			Lemail.setText("E-mail：");
			Lday = new JLabel();
			Lday.setBounds(new Rectangle(396, 289, 15, 20));
			Lday.setText("日");
			Lmonth = new JLabel();
			Lmonth.setBounds(new Rectangle(334, 289, 15, 20));
			Lmonth.setText("月");
			Lbrithday = new JLabel();
			Lbrithday.setBounds(new Rectangle(244, 289, 50, 20));
			Lbrithday.setText("生日：");
			Lblood = new JLabel();
			Lblood.setBounds(new Rectangle(134, 289, 50, 20));
			Lblood.setText("血型：");
			Lbelong = new JLabel();
			Lbelong.setBounds(new Rectangle(19, 289, 50, 20));
			Lbelong.setText("生肖：");
			Lname = new JLabel();
			Lname.setBounds(new Rectangle(244, 264, 50, 20));
			Lname.setText("姓名：");
			Lage = new JLabel();
			Lage.setBounds(new Rectangle(134, 264, 50, 20));
			Lage.setText("年龄：");
			Lsex = new JLabel();
			Lsex.setBounds(new Rectangle(19, 264, 50, 20));
			Lsex.setText("性别：");
			Lsignature = new JLabel();
			Lsignature.setBounds(new Rectangle(20, 130, 80, 20));
			Lsignature.setText("个性签名：");
			LCimageT = new JLabel();
			LCimageT.setBounds(new Rectangle(353, 106, 64, 20));
			LCimageT.setText("更改头像");
			LCimageT.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					HeadChooseDialog hcd = new HeadChooseDialog(PData.this);
					if (hcd.getSelectIcon()!=null) {
						LCimage.setIcon(hcd.getSelectIcon());
					}
				}
			});
			new MouseAutoColor(LCimageT);
			
			LCimage = new JLabel();
			LCimage.setBounds(new Rectangle(358, 63, 42, 42));
			LCimage.setText("");
			LID = new JLabel();
			LID.setBounds(new Rectangle(20, 70, 80, 20));
			LID.setText("用户帐号：");
			LPname = new JLabel();
			LPname.setBounds(new Rectangle(20, 100, 80, 20));
			LPname.setText("用户昵称：");
			Limage = new JLabel();
			Limage.setBounds(new Rectangle(20, 10, 384, 40));
			Limage.setText("");
			Limage.setIcon(ImagesFactory.creatIcon("images/info.jpg"));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.setFont(new Font("Dialog", Font.PLAIN, 12));
			jContentPane.add(Limage, null);
			jContentPane.add(LPname, null);
			jContentPane.add(getTPname(), null);
			jContentPane.add(LID, null);
			jContentPane.add(getTID(), null);
			jContentPane.add(LCimage, null);
			jContentPane.add(LCimageT, null);
			jContentPane.add(Lsignature, null);
			jContentPane.add(getCshow(), null);
			jContentPane.add(Lsex, null);
			jContentPane.add(getCsex(), null);
			jContentPane.add(Lage, null);
			jContentPane.add(getTage(), null);
			jContentPane.add(Lname, null);
			jContentPane.add(getTname(), null);
			jContentPane.add(Lbelong, null);
			jContentPane.add(getCbelong(), null);
			jContentPane.add(Lblood, null);
			jContentPane.add(getCblood(), null);
			jContentPane.add(Lbrithday, null);
			jContentPane.add(getCmonth(), null);
			jContentPane.add(Lmonth, null);
			jContentPane.add(getCday(), null);
			jContentPane.add(Lday, null);
			jContentPane.add(Lemail, null);
			jContentPane.add(getTemail(), null);
			jContentPane.add(Lhoroscope, null);
			jContentPane.add(getChoroscope(), null);
			jContentPane.add(Lworld, null);
			jContentPane.add(getTworld(), null);
			jContentPane.add(Lprovince, null);
			jContentPane.add(getTprovince(), null);
			jContentPane.add(Lcity, null);
			jContentPane.add(Lexplain, null);
			jContentPane.add(getByes(), null);
			jContentPane.add(getBno(), null);
			jContentPane.add(getTcity(), null);
			jContentPane.add(getSsignasture(), null);
			jContentPane.add(getSexplain(), null);
			jContentPane.add(getUpdataButton(), null);
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
			TPname.setEditable(false);
			TPname.setBounds(new Rectangle(100, 100, 245, 20));
		}
		return TPname;
	}

	/**
	 * This method initializes TID	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTID() {
		if (TID == null) {
			TID = new JTextField();
			TID.setEditable(false);
			TID.setBounds(new Rectangle(100, 70, 245, 20));
		}
		return TID;
	}

	/**
	 * This method initializes Cshow	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getCshow() {
		if (Cshow == null) {
			Cshow = new JCheckBox();
			Cshow.setBounds(new Rectangle(111, 186, 153, 17));
			Cshow.setText("始终显示个性签名");
		}
		return Cshow;
	}

	/**
	 * This method initializes Csex	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCsex() {
		if (Csex == null) {
			Csex = new JComboBox();
			Csex.setBounds(new Rectangle(69, 264, 50, 20));
			Csex.addItem("");
			Csex.addItem("男");
			Csex.addItem("女");
			Csex.setEditable(false);
		}
		return Csex;
	}

	/**
	 * This method initializes Tage	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTage() {
		if (Tage == null) {
			Tage = new JTextField();
			Tage.setBounds(new Rectangle(184, 264, 50, 20));
		}
		return Tage;
	}

	/**
	 * This method initializes Tname	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTname() {
		if (Tname == null) {
			Tname = new JTextField();
			Tname.setBounds(new Rectangle(294, 264, 110, 20));
		}
		return Tname;
	}

	/**
	 * This method initializes Cbelong	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCbelong() {
		if (Cbelong == null) {
			Cbelong = new JComboBox();
			Cbelong.addItem("");
			Cbelong.addItem("鼠");
			Cbelong.addItem("牛");
			Cbelong.addItem("虎");
			Cbelong.addItem("兔");
			Cbelong.addItem("龙");
			Cbelong.addItem("蛇");
			Cbelong.addItem("马");
			Cbelong.addItem("羊");
			Cbelong.addItem("猴");
			Cbelong.addItem("鸡");
			Cbelong.addItem("狗");
			Cbelong.addItem("猪");
			Cbelong.setEditable(false);
			Cbelong.setBounds(new Rectangle(69, 289, 50, 20));
		}
		return Cbelong;
	}

	/**
	 * This method initializes Cblood	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCblood() {
		if (Cblood == null) {
			Cblood = new JComboBox();
			Cblood.addItem("");
			Cblood.addItem("A");
			Cblood.addItem("B");
			Cblood.addItem("AB");
			Cblood.addItem("O");
			Cblood.setEditable(false);
			Cblood.setBounds(new Rectangle(184, 289, 50, 20));
		}
		return Cblood;
	}

	/**
	 * This method initializes Cmonth	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCmonth() {
		if (Cmonth == null) {
			Cmonth = new JComboBox();
			Cmonth.addItem("");
			Cmonth.addItem("1");
			Cmonth.addItem("2");
			Cmonth.addItem("3");
			Cmonth.addItem("4");
			Cmonth.addItem("5");
			Cmonth.addItem("6");
			Cmonth.addItem("7");
			Cmonth.addItem("8");
			Cmonth.addItem("9");
			Cmonth.addItem("10");
			Cmonth.addItem("11");
			Cmonth.addItem("12");
			Cmonth.setEditable(false);
			Cmonth.setBounds(new Rectangle(294, 289, 40, 20));
		}
		return Cmonth;
	}

	/**
	 * This method initializes Cday	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCday() {
		if (Cday == null) {
			Cday = new JComboBox();
			Cday.addItem("");
			Cday.addItem("1");
			Cday.addItem("2");
			Cday.addItem("3");
			Cday.addItem("4");
			Cday.addItem("5");
			Cday.addItem("6");
			Cday.addItem("7");
			Cday.addItem("8");
			Cday.addItem("9");
			Cday.addItem("10");
			Cday.addItem("11");
			Cday.addItem("12");
			Cday.addItem("13");
			Cday.addItem("14");
			Cday.addItem("15");
			Cday.addItem("16");
			Cday.addItem("17");
			Cday.addItem("18");
			Cday.addItem("19");
			Cday.addItem("20");
			Cday.addItem("21");
			Cday.addItem("22");
			Cday.addItem("23");
			Cday.addItem("24");
			Cday.addItem("25");
			Cday.addItem("26");
			Cday.addItem("27");
			Cday.addItem("28");
			Cday.addItem("29");
			Cday.addItem("30");
			Cday.addItem("31");
			Cday.setEditable(false);
			Cday.setBounds(new Rectangle(349, 289, 48, 20));
		}
		return Cday;
	}

	/**
	 * This method initializes Temail	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTemail() {
		if (Temail == null) {
			Temail = new JTextField();
			Temail.setBounds(new Rectangle(81, 339, 153, 20));
		}
		return Temail;
	}
	
	protected void setLCimageTVisiable(boolean b) {
		LCimageT.setVisible(b);
	}

	/**
	 * This method initializes Choroscope	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getChoroscope() {
		if (Choroscope == null) {
			Choroscope = new JComboBox();
			Choroscope.addItem("");
			Choroscope.addItem("白羊座");
			Choroscope.addItem("金牛座");
			Choroscope.addItem("双子座");
			Choroscope.addItem("巨蟹座");
			Choroscope.addItem("狮子座");
			Choroscope.addItem("处女座");
			Choroscope.addItem("天平座");
			Choroscope.addItem("天蝎座");
			Choroscope.addItem("射手座");
			Choroscope.addItem("摩羯座");
			Choroscope.addItem("水瓶座");
			Choroscope.addItem("双鱼座");
			Choroscope.setBounds(new Rectangle(294, 339, 110, 20));
		}
		return Choroscope;
	}

	/**
	 * This method initializes Tworld	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTworld() {
		if (Tworld == null) {
			Tworld = new JTextField();
			Tworld.setBounds(new Rectangle(69, 314, 50, 20));
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
			Tprovince.setBounds(new Rectangle(184, 314, 50, 20));
		}
		return Tprovince;
	}

	/**
	 * This method initializes Byes	
	 * 	
	 * @return javax.swing.JButton	
	 */
	protected JButton getByes() {
		if (Byes == null) {
			Byes = new JButton();
			Byes.setBounds(new Rectangle(259, 365, 70, 20));
			Byes.setEnabled(true);
			Byes.setText("更新");
			Byes.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ctrl.getUserEntity().getInfo().updata();
					updataInfo();
				}
			});
		}
		return Byes;
	}

	/**
	 * This method initializes Bno	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBno() {
		if (Bno == null) {
			Bno = new JButton();
			Bno.setBounds(new Rectangle(335, 365, 70, 20));
			Bno.setText("关闭");
			Bno.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					PData.this.setVisible(false);
					PData.this.dispose();
				}
			});
		}
		return Bno;
	}

	/**
	 * This method initializes Tcity	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTcity() {
		if (Tcity == null) {
			Tcity = new JTextField();
			Tcity.setBounds(new Rectangle(294, 314, 110, 20));
		}
		return Tcity;
	}

	/**
	 * This method initializes Ssignasture	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getSsignasture() {
		if (Ssignasture == null) {
			Ssignasture = new JScrollPane();
			Ssignasture.setBounds(new Rectangle(100, 130, 305, 50));
			Ssignasture.setViewportView(getAsignasgture());
		}
		return Ssignasture;
	}

	/**
	 * This method initializes Asignasgture	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getAsignasgture() {
		if (Asignasgture == null) {
			Asignasgture = new JTextArea();
			Asignasgture.setColumns(1);
			Asignasgture.setRows(0);
			Asignasgture.setLineWrap(true);
		}
		return Asignasgture;
	}

	/**
	 * This method initializes Sexplain	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getSexplain() {
		if (Sexplain == null) {
			Sexplain = new JScrollPane();
			Sexplain.setBounds(new Rectangle(100, 207, 305, 50));
			Sexplain.setViewportView(getTexplain());
		}
		return Sexplain;
	}

	/**
	 * This method initializes Texplain	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTexplain() {
		if (Texplain == null) {
			Texplain = new JTextArea();
			Texplain.setColumns(1);
			Texplain.setRows(0);
			Texplain.setLineWrap(true);
		}
		return Texplain;
	}

	/**
	 * This method initializes UpdataButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	protected JButton getUpdataButton() {
		if (UpdataButton == null) {
			UpdataButton = new JButton();
			UpdataButton.setText("修改");
			UpdataButton.setBounds(new Rectangle(259, 365, 70, 20));
			UpdataButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					modifierInfo();
				}
			});
		}
		return UpdataButton;
	}
	
	protected void modifierInfo() {
		UserInfo info = ctrl.getUserEntity().getInfo();
		info.set("icon", LCimage.getIcon().toString());
		info.set("sex", Csex.getSelectedItem().toString());
		info.set("age", Tage.getText());
		info.set("tname", Tname.getText());
		info.set("belong", Cbelong.getSelectedItem().toString());
		info.set("blood", Cblood.getSelectedItem().toString());
		info.set("brithm", Cmonth.getSelectedItem().toString());
		info.set("brithd", Cday.getSelectedItem().toString());
		info.set("email", Temail.getText());
		info.set("horo", Choroscope.getSelectedItem().toString());
		info.set("country", Tworld.getText());
		info.set("province", Tprovince.getText());
		info.set("city", Tcity.getText());
		info.set("signing", Asignasgture.getText().replace('\n', ' '));
		info.set("explain", Texplain.getText().replace('\n', ' '));
		info.modifierInfo();
		Tools.show("修改成功");
	}
	
	protected void updataInfo() {
		UserInfo info = ctrl.getUserEntity().getInfo();
		TPname.setText(info.getName());
		TID.setText(info.getID());
		LCimage.setIcon(info.getIcon());
		Csex.setSelectedItem(info.get("sex"));
		Tage.setText(info.get("age"));
		Tname.setText(info.get("tname"));
		Cbelong.setSelectedItem(info.get("belong"));
		Cblood.setSelectedItem(info.get("blood"));
		Cmonth.setSelectedItem(info.get("brithm"));
		Cday.setSelectedItem(info.get("brithd"));
		Temail.setText(info.get("email"));
		Choroscope.setSelectedItem(info.get("horo"));
		Tworld.setText(info.get("country"));
		Tprovince.setText(info.get("province"));
		Tcity.setText(info.get("city"));
		
		Texplain.setText(info.get("explain"));
		Asignasgture.setText(info.get("signing"));
	}

}  //  @jve:decl-index=0:visual-constraint="69,-10"
