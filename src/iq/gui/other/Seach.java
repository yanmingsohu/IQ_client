package iq.gui.other;

import iq.assist.ImagesFactory;
import iq.assist.Tools;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Seach extends JFrame {
	private static Seach s = new Seach();
	/** 显示查找窗口 */
	public static void display() {
		s.remove();
	}
	
	// ---------------- instance ------------------
	private SeachControl ctrl = new SeachControl(this);

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel image = null;
	private JTabbedPane jTabbedPane = null;
	private JPanel seach = null;
	private JPanel Mseach = null;
	private JLabel images1 = null;
	private JLabel images2 = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;
	private JTextField jTextField = null;
	private JTextField jTextField1 = null;
	private JTextField jTextField2 = null;
	private JComboBox jComboBox = null;
	private JRadioButton jRadioButton = null;
	private JRadioButton jRadioButton1 = null;
	private JLabel jLabel6 = null;
	private JLabel jLabel7 = null;
	private JTextField jTextField3 = null;
	private JTextField jTextField4 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;

	private JPanel jPanel = null;
	private JScrollPane jScrollPane = null;
	private JTable jTable = null;
	
	private Seach() {
		super();
		initialize();
	}

	private void initialize() {
		this.setSize(545, 324);
		this.setContentPane(getJContentPane());
		this.setTitle("查找好友");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setResizable(false);
	}
	
	private void remove() {
		Tools.ComponentMoveCenter(this);
		this.setVisible(true);
		
		this.setAlwaysOnTop(true);
		this.setAlwaysOnTop(false);
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			image = new JLabel();
			image.setBounds(new Rectangle(1, 0, 124, 294));
			image.setText("image");
			image.setIcon(ImagesFactory.creatIcon("images/seach.jpg"));
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(image, null);
			jContentPane.add(getJTabbedPane(), null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
		}
		return jContentPane;
	}

	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.setBounds(new Rectangle(137, 3, 385, 256));
			jTabbedPane.addTab("普通查找", null, getSeach(), null);
			jTabbedPane.addTab("高级查找", null, getMseach(), null);
			jTabbedPane.addTab("查找结果", null, getJPanel(), null);
			jTabbedPane.setEnabledAt(2, false);
		}
		return jTabbedPane;
	}

	private JPanel getSeach() {
		if (seach == null) {
			jLabel7 = new JLabel();
			jLabel7.setBounds(new Rectangle(45, 175, 76, 25));
			jLabel7.setText("对方昵称:");
			jLabel6 = new JLabel();
			jLabel6.setBounds(new Rectangle(45, 135, 78, 25));
			jLabel6.setText("对方帐号:");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(75, 20, 291, 26));
			jLabel.setText("在此，您可以设置精确的查询条件来查找用户。");
			images1 = new JLabel();
			images1.setBounds(new Rectangle(16, 10, 39, 38));
//			images1.setText("image");
			images1.setIcon(ImagesFactory.creatIcon(ImagesFactory.icon1));
			seach = new JPanel();
			seach.setLayout(null);
			seach.setName("");
			seach.add(images1, null);
			seach.add(jLabel, null);
			seach.add(getJRadioButton(), null);
			seach.add(getJRadioButton1(), null);
			seach.add(jLabel6, null);
			seach.add(jLabel7, null);
			seach.add(getJTextField3(), null);
			seach.add(getJTextField4(), null);
			ButtonGroup bg = new ButtonGroup();
			bg.add(jRadioButton);
			bg.add(jRadioButton1);
		}
		return seach;
	}

	private JPanel getMseach() {
		if (Mseach == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("性别:");
			jLabel5.setBounds(new Rectangle(80, 190, 48, 23));
			jLabel4 = new JLabel();
			jLabel4.setPreferredSize(new Dimension(30, 18));
			jLabel4.setBounds(new Rectangle(80, 150, 48, 23));
			jLabel4.setText("年龄:");
			jLabel3 = new JLabel();
			jLabel3.setBounds(new Rectangle(80, 110, 48, 23));
			jLabel3.setPreferredSize(new Dimension(30, 18));
			jLabel3.setText("城市:");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(80, 70, 48, 23));
			jLabel2.setPreferredSize(new Dimension(30, 18));
			jLabel2.setText("昵称:");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(75, 20, 169, 26));
			jLabel1.setText("请设置您要查找的用户类别：");
			images2 = new JLabel();
			images2.setBounds(new Rectangle(16, 10, 39, 38));
			images2.setText("image");
			images2.setIcon(ImagesFactory.creatIcon(ImagesFactory.icon2));
			Mseach = new JPanel();
			Mseach.setLayout(null);
			Mseach.add(images2, null);
			Mseach.add(jLabel1, null);
			Mseach.add(jLabel2, null);
			Mseach.add(jLabel3, null);
			Mseach.add(jLabel4, null);
			Mseach.add(jLabel5, null);
			Mseach.add(getJTextField(), null);
			Mseach.add(getJTextField1(), null);
			Mseach.add(getJTextField2(), null);
			Mseach.add(getJComboBox(), null);
		}
		return Mseach;
	}

	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(135, 70, 150, 25));
		}
		return jTextField;
	}

	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(135, 110, 150, 25));
		}
		return jTextField1;
	}

	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(135, 150, 150, 25));
		}
		return jTextField2;
	}

	private JComboBox getJComboBox() {
		if (jComboBox == null) {
			jComboBox = new JComboBox();
			jComboBox.setBounds(new Rectangle(135, 190, 65, 25));
			jComboBox.addItem("男");
			jComboBox.addItem("女");
		}
		return jComboBox;
	}

	private JRadioButton getJRadioButton() {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton();
			jRadioButton.setBounds(new Rectangle(90, 60, 127, 20));
			jRadioButton.setText("看谁在线上");
			jRadioButton.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					jLabel6.setEnabled(false);
					jLabel7.setEnabled(false);
					jTextField3.setEnabled(false);
					jTextField4.setEnabled(false);
				}
			});
		}
		return jRadioButton;
	}

	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setBounds(new Rectangle(90, 90, 110, 20));
			jRadioButton1.setText("精确查找");
			jRadioButton1.setSelected(true);
			jRadioButton1.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					jLabel6.setEnabled(true);
					jLabel7.setEnabled(true);
					jTextField3.setEnabled(true);
					jTextField4.setEnabled(true);
				}
			});
		}
		return jRadioButton1;
	}

	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setBounds(new Rectangle(130, 135, 150, 25));
		}
		return jTextField3;
	}

	private JTextField getJTextField4() {
		if (jTextField4 == null) {
			jTextField4 = new JTextField();
			jTextField4.setEnabled(false);
			jTextField4.setBounds(new Rectangle(130, 175, 150, 25));
		}
		return jTextField4;
	}

	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(355, 265, 75, 25));
			jButton.setText("查找");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ctrl.seachButton(jTabbedPane.getSelectedIndex());
				}
			});
		}
		return jButton;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(440, 265, 75, 25));
			jButton1.setText("关闭");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Seach.this.setVisible(false);
					Seach.this.dispose();
				}
			});
		}
		return jButton1;
	}

	public String getName() {
		return jTextField.getText();
	}
	
	public String getCity() {
		return jTextField1.getText();
	}
	
	public String getAge() {
		return jTextField2.getText();
	}
	
	public String getSex() {
		return jComboBox.getSelectedItem().toString();
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.BOTH;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.weighty = 1.0;
			gridBagConstraints.gridx = 0;
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(getJScrollPane(), gridBagConstraints);
		}
		return jPanel;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTable	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
			jTable.addMouseListener(new inMouseEven());
			jTable.setShowGrid(false);
		}
		return jTable;
	}
	
	public String getId() {
		return jTextField3.getText();
	}
	
	// 使用取得的好友列表初始化表格
	public void setTable(String[] s) {
		if (s==null||s.length<1) {
			Tools.show("没有找到.");
		} else {
			FriendTableModel ftm = new FriendTableModel(s);
			if (ftm.getRowCount()>0) {
				jTable.setModel(ftm);
				jTabbedPane.setEnabledAt(2, true);
				jTabbedPane.setSelectedIndex(2);
			}
		}
	}
	
	// 用户点击表格事件
	private class inMouseEven extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (e.getClickCount()<1) return;
			int r = jTable.getSelectedRow();
			if (r>=0) {
				FriendTableModel ftm = 
					(FriendTableModel)jTable.getModel();
				
				String id = ftm.getValueAt(r, 0).toString();
				String name = ftm.getValueAt(r, 1).toString();
				
				Helpf h = new Helpf(name, id, "添加好友.", 
						"在这里输入验证消息，比如：我是...", true);
				if (h.getSelect()) {
					ctrl.addFriendThread(id, h.getResultText());
				}
			}
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
