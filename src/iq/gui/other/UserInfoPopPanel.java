package iq.gui.other;

import iq.assist.MouseAutoColor;
import iq.event.UserEntity;

import javax.swing.JWindow;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.BorderFactory;
import java.awt.SystemColor;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.border.TitledBorder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;


public class UserInfoPopPanel extends JWindow {
	private static final int w = 252;
	private static final int h = 158;
	private UserEntity user;
	
    public UserInfoPopPanel() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public UserInfoPopPanel(UserEntity user) {
    	this();
    	this.user = user;
    	jTextArea.setLineWrap(true);
    	this.setAlwaysOnTop(true);
    }
    
    public void show(int rx, int lx, int y, int wy) {
    	int x = rx-w<0? lx: rx-w;
    	y-=h/2;
    	y = y<wy? wy: y;
    	y = y<0? 0: y;
    	this.setLocation(x, y);
    	jLabel.setText(user.getName());
    	jLabel1.setText(user.getID());
    	jTextArea.setText(user.getInfo().get("signing"));
    	limage.setIcon(user.getInfo().getIcon());
    	this.setVisible(true);
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        setSize(252,158);
        setSize(w, h);
        this.setContentPane(getJPanel());
        jButton1.setIcon(emg1);
        jButton1.setToolTipText("关闭");
        jButton1.setBounds(new Rectangle(236, 3, 36, 24));
        jButton1.addActionListener(
        		new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						close();
					}
        		} );
        jPanel1.setBackground(new Color(226, 197, 107));
        jPanel1.setLayout(null);
        jPanel1.setBounds(new Rectangle(-41, 124, 325, 64));
        jPanel1.setForeground(new Color(194, 176, 50));
        jPanel1.add(jButton1, null);
    }

    Border border1 = BorderFactory.createLineBorder(new Color(171, 210, 255), 2);
    JPanel jPanel1 = new JPanel();
    JButton jButton1 = new JButton();
    Icon emg1=new ImageIcon("images\\p32a.jpg");
	private JPanel jPanel = null;
	private JLabel limage = null;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JTextArea jTextArea = null;
	private JPanel jPanel2 = null;
	private JScrollPane jScrollPane = null;
	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(73, 40, 279, 18));
			jLabel2.setForeground(new Color(255, 210, 51));
			jLabel2.setText("__________________________");
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(85, 30, 130, 22));
			jLabel1.setText("iQ");
			jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					openParticular();
				}
			});
			jLabel = new JLabel();
			new MouseAutoColor(jLabel1);
			jLabel.setBounds(new Rectangle(85, 14, 127, 21));
			jLabel.setText("iQ");
			jLabel.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					openParticular();
				}
			});
			new MouseAutoColor(jLabel);
			limage = new JLabel();
			limage.setBounds(new Rectangle(13, 5, 53, 54));
			limage.setText("");
			jPanel = new JPanel();
			jPanel.setLayout(null);
			jPanel.add(jPanel1, null);
			jPanel.add(limage, null);
			jPanel.add(jLabel, null);
			jPanel.add(jLabel1, null);
			jPanel.add(jLabel2, null);
			jPanel.add(getJPanel2(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setEnabled(false);
			jTextArea.setEditable(false);
		}
		return jTextArea;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.weighty = 1.0;
			gridBagConstraints1.weightx = 1.0;
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
			jPanel2.setBounds(new Rectangle(7, 61, 238, 59));
			jPanel2.setBorder(BorderFactory.createTitledBorder(
					null, "", TitledBorder.CENTER, TitledBorder.TOP, 
					new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			
			jPanel2.add(getJScrollPane(), gridBagConstraints1);
		}
		return jPanel2;
	}
	
	/**
	 * 关闭窗口
	 */
	public void close() {
		new Thread() {
			public void run() {
				while (true) {
					try {
						sleep(300);
					} catch (InterruptedException e) {}
					if (!getBounds().contains(
							MouseInfo.getPointerInfo().getLocation()) ) 
					{
						setVisible(false);
						break;
					}
				}
			}
		}.start();
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setHorizontalScrollBarPolicy(
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			jScrollPane.setViewportView(getJTextArea());
		}
		return jScrollPane;
	}
	
	/**
	 * 开启详细信息对话框
	 */
	private void openParticular() {
		setVisible(false);
		new PData(user);
	}
}  //  @jve:decl-index=0:visual-constraint="58,10"
