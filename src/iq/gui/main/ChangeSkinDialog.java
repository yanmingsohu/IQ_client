// CatfoOD 2008-6-13 下午07:40:13

package iq.gui.main;

import iq.assist.MouseAutoColor;
import iq.gui.LookandfeelFactory;
import iq.gui.other.JWaitDialog;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;

public class ChangeSkinDialog extends JDialog {
	private static ChangeSkinDialog csd = null;
	
	public static void display() {
		if (csd==null) {
			csd = new ChangeSkinDialog();
		}
	}

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;

	/**
	 * @param owner
	 */
	private ChangeSkinDialog() {
		super((JFrame)null);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJScrollPane());
		this.setTitle("iQ 2008 Skin");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				setVisible(false);
				dispose();
				csd = null;
			}
		});
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setBounds(0, 0, 180, d.height);
		creatButton();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BoxLayout(getJContentPane(), BoxLayout.Y_AXIS));
		}
		return jContentPane;
	}

	private void creatButton() {
		this.setVisible(true);
		this.setAlwaysOnTop(true);
		final JMenuItem[] menus = 
			LookandfeelFactory.getLookandFeelMenuItem();
		
		final JButton bu = new JButton();
		bu.setText("保存当前外观为默认外观");
		bu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				LookandfeelFactory.saveConfig();
			}
		});

		new Thread() {
			public void run() {
				for (int i=0; i<menus.length; ++i) {
					getJContentPane().add(menus[i]);
					menus[i].addActionListener(ML);
					new MouseAutoColor(menus[i]);
					validate();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {}
				}
				getJContentPane().add(bu);
				validate();
			}
		}.start();
	}

	private ActionListener ML = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String feelname = e.getSource().toString();
			LookandfeelFactory.setStanceFeel(feelname);
		}
	};
	private JScrollPane jScrollPane = null;

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			jScrollPane.setViewportView(getJContentPane());
		}
		return jScrollPane;
	}

}
