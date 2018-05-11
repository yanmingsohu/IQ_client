// CatfoOD 2008-6-13 下午09:12:14

package iq.gui.main;

import iq.assist.Tools;
import iq.history.ChatHisInfo;
import iq.history.HistoryFactory;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.JEditorPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class InformationManager extends JFrame {
	private static boolean isVisible = false;
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JSplitPane jSplitPane = null;
	private JTree jTree = null;
	private JEditorPane jEditorPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu jMenu = null;
	private JMenuItem jMenuItem = null;

	/**
	 * This is the default constructor
	 */
	public InformationManager() {
		super();
		if (isVisible) {
			dispose();
			return;
		}
		isVisible = true;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(640, 480);
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("iQ 2008 聊天消息管理器");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				close();
			}
		});
		Tools.ComponentMoveCenter(this);
		this.setAlwaysOnTop(true);
		this.setAlwaysOnTop(false);
	}
	
	private void close() {
		setVisible(false);
		dispose();
		isVisible = false;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJSplitPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jSplitPane	
	 * 	
	 * @return javax.swing.JSplitPane	
	 */
	private JSplitPane getJSplitPane() {
		if (jSplitPane == null) {
			jSplitPane = new JSplitPane();
			jSplitPane.setLeftComponent(getJTree());
			jSplitPane.setResizeWeight(0.2D);
			jSplitPane.setRightComponent(getJEditorPane());
		}
		return jSplitPane;
	}

	/**
	 * This method initializes jTree	
	 * 	
	 * @return javax.swing.JTree	
	 */
	private JTree getJTree() {
		if (jTree == null) {
			DefaultMutableTreeNode dmt = new DefaultMutableTreeNode("我的好友");
			ChatHisInfo c[] = HistoryFactory.getHistory().getAllHistory();
			for (int i=0; i<c.length; ++i) {
				dmt.add(new DefaultMutableTreeNode(c[i]));
			}
			
			jTree = new JTree(dmt);
			jTree.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					TreePath tp = jTree.getSelectionPath();
					if (tp!=null) {
						DefaultMutableTreeNode def = 
							(DefaultMutableTreeNode)tp.getLastPathComponent();
						if (def!=null) {
							Object o = def.getUserObject();
							if (o!=null && o instanceof ChatHisInfo) {
								ChatHisInfo chi = (ChatHisInfo)o;
								jEditorPane.setText(chi.read());
							}
						}
					}
				}
			});
		}
		return jTree;
	}

	/**
	 * This method initializes jEditorPane	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getJEditorPane() {
		if (jEditorPane == null) {
			jEditorPane = new JEditorPane("text/html","");
		}
		return jEditorPane;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getJMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getJMenu() {
		if (jMenu == null) {
			jMenu = new JMenu();
			jMenu.setText("文件");
			jMenu.add(getJMenuItem());
		}
		return jMenu;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getJMenuItem() {
		if (jMenuItem == null) {
			jMenuItem = new JMenuItem();
			jMenuItem.setText("退出消息管理");
			jMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					close();
				}
			});
		}
		return jMenuItem;
	}

}
