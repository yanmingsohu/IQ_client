package iq.gui.other;

import iq.assist.ImagesFactory;
import iq.assist.Tools;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;

public class Helpf extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JLabel jLabel = null;
	private JLabel jLabel2 = null;
	private JButton jButton = null;
	private JButton jButton1 = null;
	private JTextArea jTextArea = null;
	private JPanel jPanel = null;
	private JLabel jLabel1 = null;
	
	private boolean OK = false;
	private String resultText = null;

	/**
	 * 新建一个对话框
	 * @param name - 用户姓名
	 * @param id - 用户ID
	 * @param info - 要显示的消息类型
	 * @param text - 文本框中的文本
	 * @param editable - 是否可以编辑
	 */
	public Helpf(String name, String id, 
			String info, String text, boolean editable) 
	{
		super();
		initialize();
		
		ot = text;
		jLabel1.setText(name+" "+id);
		jLabel.setText(info);
		jTextArea.setText(text);
		jTextArea.setEditable(editable);

		Tools.ComponentMoveCenter(this);
		this.setModal(editable);
		this.setVisible(true);
	}
	
	private String ot = null;

	/**
	 * 返回用户点击的按钮
	 * @return - 确定返回true
	 */
	public boolean getSelect() {
		return OK;
	}
	
	/**
	 * 返回最后用户输入的文本
	 * @return - 如果点击取消返回null;
	 */
	public String getResultText() {
		return resultText;
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 178);
		this.setContentPane(getJContentPane());
		this.setTitle("iQ2008 添加/查找 好友.");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		
		int i = (int)(Math.random()*134);
		jLabel2.setIcon(ImagesFactory.creatIcon("face/"+i+".GIF"));
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabel1 = new JLabel();
			jLabel1.setBounds(new Rectangle(80, 40, 150, 20));
			jLabel1.setText("name(id)");
			jLabel2 = new JLabel();
			jLabel2.setBounds(new Rectangle(30, 15, 45, 45));
			jLabel2.setIcon(ImagesFactory.creatIcon("face/130.GIF"));
			jLabel2.setText("image");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(80, 15, 175, 20));
			jLabel.setText("您将添加XXX为好友");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabel, null);
			jContentPane.add(jLabel2, null);
			jContentPane.add(getJButton(), null);
			jContentPane.add(getJButton1(), null);
			jContentPane.add(getJTextArea(), null);
			jContentPane.add(jLabel1, null);
			jContentPane.add(getJPanel(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(100, 120, 85, 20));
			jButton.setText("是");
			jButton.setName("");
			jButton.setFocusable(true);
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					OK = true;
					Helpf.this.setVisible(false);
					resultText = jTextArea.getText();
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jButton1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setBounds(new Rectangle(190, 120, 85, 20));
			jButton1.setText("否");
			jButton1.setName("");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					OK = false;
					resultText = jTextArea.getText();
					Helpf.this.setVisible(false);
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setLineWrap(true);
			jTextArea.setBounds(new Rectangle(27, 66, 239, 40));
		}
		return jTextArea;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel.setBounds(new Rectangle(19, 5, 253, 110));
		}
		return jPanel;
	}

}  //  @jve:decl-index=0:visual-constraint="45,16"
