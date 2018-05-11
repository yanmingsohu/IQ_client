package iq.gui.main;

import iq.assist.ImagesFactory;
import iq.assist.Tools;
import iq.event.FriendList;
import iq.gui.LookandfeelFactory;
import iq.gui.other.PData;

import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.MouseInfo;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JWindow;

import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import javax.swing.border.TitledBorder;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuUI extends JWindow {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel userimage = null;
	private JLabel username = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JButton jButton3 = null;
	private JButton jButton4 = null;
	private JButton jButton5 = null;
	private JButton jButton6 = null;
	private JButton jButton7 = null;
	private JPanel jPanel = null;

	private final int w = 290;
	private final int h = 190;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	
	public MenuUI(int x, int y) {
		super();
		initialize();
		this.setLocation(x-w, y-h);
		showEffect(x-w, y-h);
	}
	
	private void showEffect(final int x, final int y) {
		this.setVisible(true);
		new Thread() {
			public void run() {
				int x1=x+w;
				while (x1>x) {
					setSize(x-x1, h);
					setLocation(x1, y);
					x1-=5;
					repaint();
				}
				setBounds(x, y, w, h);
			}
		}.start();
	}

	private void initialize() {
//		this.setSize(290, 190);
		this.setSize(w, h);
		this.setContentPane(getJContentPane());
		userimage.setIcon(FriendList.getMainUser().getInfo().getIcon());
		username.setText(FriendList.getMainUser().getName());
		this.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseExited(java.awt.event.MouseEvent e) {
				close();
			}
		});
		close();
	}

	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("");
			jLabel1.setBounds(new Rectangle(197, 10, 68, 125));
			jLabel1.setIcon(ImagesFactory.creatIcon("images/menu.jpg"));
			username = new JLabel();
			username.setBounds(new Rectangle(66, 15, 151, 31));
			username.setText("username");
			userimage = new JLabel();
			userimage.setBounds(new Rectangle(22, 15, 32, 31));
			userimage.setText("image");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(userimage, null);
			jContentPane.add(username, null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJButton2(), null);
			jContentPane.add(getJButton3(), null);
			jContentPane.add(getJButton4(), null);
			jContentPane.add(getJButton5(), null);
			jContentPane.add(getJButton6(), null);
			jContentPane.add(getJButton7(), null);
			jContentPane.add(getJPanel(), null);
		}
		return jContentPane;
	}

	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(21, 60, 80, 18));
			jButton.setText("IQ空间");
		}
		return jButton;
	}

	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(111, 60, 90, 18));
			jButton1.setText("消息查看");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new InformationManager();
				}
			});
		}
		return jButton1;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setBounds(new Rectangle(21, 90, 80, 18));
			jButton2.setText("访问主页");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						String path = Tools.getIQnet();
						Runtime.getRuntime().exec(
								"cmd /c start iexplore.exe \""+path+"\"");
					} catch (IOException e1) {
						Tools.error(e1);
					}
					setVisible(false);
				}
			});
		}
		return jButton2;
	}

	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.setBounds(new Rectangle(111, 90, 90, 18));
			jButton3.setText("更换皮肤");
			jButton3.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ChangeSkinDialog.display();
					setVisible(false);
				}
			});
			
		}
		return jButton3;
	}
	

	private JButton getJButton4() {
		if (jButton4 == null) {
			jButton4 = new JButton();
			jButton4.setBounds(new Rectangle(21, 120, 80, 18));
			jButton4.setText("IQ会员");
		}
		return jButton4;
	}

	private JButton getJButton5() {
		if (jButton5 == null) {
			jButton5 = new JButton();
			jButton5.setBounds(new Rectangle(111, 120, 90, 18));
			jButton5.setText("个人设置");
			jButton5.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					new PData(FriendList.getMainUser());
					setVisible(false);
				}
			});
		}
		return jButton5;
	}

	private JButton getJButton6() {
		if (jButton6 == null) {
			jButton6 = new JButton();
			jButton6.setBounds(new Rectangle(106, 155, 90, 25));
			jButton6.setHorizontalTextPosition(SwingConstants.LEADING);
			jButton6.setActionCommand("");
			jButton6.setText("更改用户");
			jButton6.setEnabled(false);
			jButton6.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		}
		return jButton6;
	}

	private JButton getJButton7() {
		if (jButton7 == null) {
			jButton7 = new JButton();
			jButton7.setBounds(new Rectangle(196, 155, 75, 25));
			jButton7.setText("退出");
			jButton7.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
			jButton7.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Tools.exit();
				}
			});
		}
		return jButton7;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("JLabel");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.setBounds(new Rectangle(9, 5, 274, 181));
			jPanel.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
			jPanel.add(jLabel1, null);
		}
		return jPanel;
	}
	
	/**
	 * 关闭窗口
	 */
	public void close() {
		new Thread() {
			public void run() {
				while (true) {
					try {
						sleep(2500);
					} catch (InterruptedException e) {}
					if (!getBounds().contains(
							MouseInfo.getPointerInfo().getLocation()) ) 
					{
						setVisible(false);
						dispose();
						break;
					}
				}
			}
		}.start();
	}
}
