package iq.gui.main;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Cursor;

import iq.assist.ImagesFactory;
import iq.assist.MouseAutoColor;
import iq.assist.Tools;
import iq.event.FriendList;
import iq.gui.JAHideFrame;
import iq.gui.other.*;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.BoxLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
public class MainUI extends JAHideFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JButton menu = null;
	private JLabel seach = null;
	private JPanel jPanel2 = null;
	private JPanel jPanel3 = null;
	private JPanel jPanel6 = null;
	private JButton MsgBimage = null;
	private JButton image1 = null;
	private JButton image2 = null;
	private JButton image3 = null;
	private JPanel jPanel7 = null;
	private JButton image4 = null;
	private JButton image5l = null;
	private JPanel iimage = null;
	private JPanel jPanel4 = null;
	private JPanel jPanel5 = null;
	private JPanel friendjp = null;
	
	public MainUI() {
		super();
		initialize();
	}

	private void initialize() {
		this.setContentPane(getJContentPane());
		this.setTitle("IQ2008");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				MainUI.this.setVisible(false);
				Tools.exit();
			}
		});
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			seach = new JLabel();
			seach.setText("查找");
			new MouseAutoColor(seach);
			seach.setPreferredSize(new Dimension(61, 23));
			seach.setBorder(new EmptyBorder(0,5,0,0));
			seach.setIcon(ImagesFactory.creatIcon("images/SearchButton.PNG"));
			seach.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					Seach.display();
				}
			});
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel3(), BorderLayout.CENTER);
			jContentPane.add(getJPanel1(), BorderLayout.SOUTH);
			jContentPane.add(getJPanel(), BorderLayout.NORTH);
		}
		return jContentPane;
	}

	private JPanel getJPanel() {
		if (jPanel == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setAlignment(java.awt.FlowLayout.LEFT);
			
			jPanel = new JPanel();
			jPanel.setLayout(flowLayout);
			FriendList.getInstance().setMainuserPanel(jPanel);
		}
		return jPanel;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			FlowLayout flowLayout1 = new FlowLayout();
			flowLayout1.setAlignment(FlowLayout.LEFT);
			flowLayout1.setVgap(5);
			flowLayout1.setHgap(0);
			jPanel1 = new JPanel();
			jPanel1.setPreferredSize(new Dimension(108, 28));
			jPanel1.setLayout(flowLayout1);
			jPanel1.add(getJPanel2(), null);
		}
		return jPanel1;
	}

	private JButton getMenu() {
		if (menu == null) {
			menu = new JButton();
			menu.setText("菜单");
			menu.setPreferredSize(new Dimension(60, 18));
			menu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Point p = MainUI.this.getLocation();
					new MenuUI(p.x, p.y+MainUI.this.getHeight());
				}
			});
		}
		return menu;
	}

	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.insets = new Insets(0, 0, 0, 10);
			MsgBimage = new JButton();
			MsgBimage.setIcon(ImagesFactory.creatIcon("images/ia/1.png"));
			MsgBimage.setToolTipText("消息管理器");
			MsgBimage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new InformationManager();
				}
			});
			
			MsgBimage.setText("");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = -1;
			gridBagConstraints1.gridheight = 1;
			gridBagConstraints1.gridy = -1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.insets = new Insets(0, 0, 0, 10);
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.gridwidth = 1;
			gridBagConstraints.gridheight = 1;
			gridBagConstraints.fill = GridBagConstraints.NONE;
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
			jPanel2.setPreferredSize(new Dimension(165,23));
			jPanel2.add(getMenu(), gridBagConstraints);
			jPanel2.add(MsgBimage, gridBagConstraints11);
			jPanel2.add(seach, gridBagConstraints1);
		}
		return jPanel2;
	}

	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setLayout(new BorderLayout());
			jPanel3.add(getJPanel4(), BorderLayout.SOUTH);
			jPanel3.add(getJPanel5(), BorderLayout.CENTER);
		}
		return jPanel3;
	}

	private JPanel getJPanel6() {
		if (jPanel6 == null) {
			image5l = new JButton();
			image5l.setBorder(new EmptyBorder(10,10,10,10));
			image5l.setIcon(ImagesFactory.creatIcon("images/ia/6.png"));
			image5l.setToolTipText("网络硬盘");
			image5l.setText("");
			
			image4 = new JButton();
			image4.setIcon(ImagesFactory.creatIcon("images/ia/2.png"));
			image4.setBorder(new EmptyBorder(10,10,10,10));
			image4.setToolTipText("IQ聊天室");
			image4.setText("");
			image3 = new JButton();
			image3.setBorder(new EmptyBorder(10,10,10,10));
			image3.setIcon(ImagesFactory.creatIcon("images/ia/4.png"));
			image3.setToolTipText("IQ宠物");
			image3.setText("");
			image2 = new JButton();
			image2.setText("");
			image2.setIcon(ImagesFactory.creatIcon("images/ia/3.png"));
			image2.setToolTipText("短信超人");
			image2.setBorder(new EmptyBorder(10,10,10,10));
			image1 = new JButton();
			image1.setBorder(new EmptyBorder(10,10,10,10));
			image1.setIcon(ImagesFactory.creatIcon("images/ia/5.png"));
			image1.setToolTipText("IQ播放器");
			image1.setText("");
			image1.addActionListener(al);
			image2.addActionListener(al);
			image3.addActionListener(al);
			image4.addActionListener(al);
			image5l.addActionListener(al);
			
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(1);
			gridLayout1.setHgap(0);
			gridLayout1.setVgap(0);
			jPanel6 = new JPanel();
			jPanel6.setPreferredSize(new Dimension(145, 60));
			jPanel6.setLayout(gridLayout1);
			jPanel6.add(image1, null);
			jPanel6.add(image2, null);
			jPanel6.add(image3, null);
			jPanel6.add(image4, null);
			jPanel6.add(image5l, null);
		}
		return jPanel6;
	}

	private JPanel getJPanel7() {
		if (jPanel7 == null) {
			GridLayout gridLayout2 = new GridLayout();
			gridLayout2.setColumns(1);
			gridLayout2.setRows(0);
			jPanel7 = new JPanel();
			jPanel7.setPreferredSize(new Dimension(180, 28));
			jPanel7.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel7.setLayout(gridLayout2);
			jPanel7.add(getJPanel6(), null);
		}
		return jPanel7;
	}

	// 右侧的按钮面板
	private JPanel getIimage() {
		if (iimage == null) {
			
			iimage = new JPanel();
			iimage.setPreferredSize(new Dimension(30, 144));
			iimage.setLayout(new BoxLayout(getIimage(), BoxLayout.Y_AXIS));
			
			String[] tipname = new String[]{
					"股票","交友中心","IQ书城","IQ爱墙",
					"IQ娱乐","IQ音乐","IQ绑定","IQ拍拍"};
			
			for (int i=0; i<tipname.length; ++i) {
				JButton b = new JButton();
				b.setBorder(new EmptyBorder(5,5,5,5));
				b.setIcon(ImagesFactory.creatIcon("images/iimages/"+(i+1)+".gif"));
				b.setToolTipText(tipname[i]);
				b.setHorizontalAlignment(SwingConstants.CENTER);
				b.addActionListener(al);
				iimage.add(b);
			}
		}
		return iimage;
	}

	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			FlowLayout flowLayout2 = new FlowLayout();
			flowLayout2.setAlignment(FlowLayout.LEFT);
			jPanel4 = new JPanel();
			jPanel4.setLayout(flowLayout2);
			jPanel4.add(getJPanel7(), null);
		}
		return jPanel4;
	}

	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(0);
			borderLayout.setVgap(0);
			jPanel5 = new JPanel();
			jPanel5.setLayout(borderLayout);
			jPanel5.add(getIimage(), BorderLayout.WEST);
			jPanel5.add(getFriendjp(), BorderLayout.CENTER);
		}
		return jPanel5;
	}

	private JPanel getFriendjp() {
		if (friendjp == null) {
			friendjp = new JPanel();
			friendjp.setLayout(new BorderLayout());
		}
		return friendjp;
	}
	
	/**
	 * 设置窗口主面板为in
	 * @param in
	 */
	public void setMainPane(JPanel in) {
		friendjp.add(in);
	}
	
	private AL al = new AL();
	private class AL implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			TeachWindow.start();
		}
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
