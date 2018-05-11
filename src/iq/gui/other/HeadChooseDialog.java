// CatfoOD 2008-6-13 下午03:24:21

package iq.gui.other;

import iq.assist.Tools;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.io.File;

import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;

public class HeadChooseDialog extends JDialog {
	private JScrollPane jScrollPane = null;
	private JPanel jPanel = null;

	public HeadChooseDialog(JFrame f) {
		super(f, true);
		initialize();
		this.setAlwaysOnTop(true);
		this.setVisible(true);
	}

	/**
	 * This method initializes this
	 * 
	 */
	private void initialize() {
        this.setSize(new Dimension(585, 350));
        this.setMinimumSize(getSize());
        this.setContentPane(getJScrollPane());
        this.setTitle("iQ 2008 选择你喜欢的头像");
        Tools.ComponentMoveCenter(this);
        creatIcon();
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			jScrollPane.setViewportView(getJPanel());
			jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(new FlowLayout());
		}
		return jPanel;
	}
	
	private void creatIcon() {
		File f = new File("face");
		File[] fs = f.listFiles();
		
		int w = 0;
		JPanel inp = new JPanel();
		inp.setLayout(new GridLayout(0,12));
		for (int i=0; i<fs.length; ++i) {
			if (fs[i].isFile()) {
				ImageIcon icon = new ImageIcon("face/"+fs[i].getName());
				if (icon!=null && icon.getIconHeight()>0) {
					JButton b = new JButton();
					b.setIcon(icon);
					b.addActionListener(BL);
					inp.add(b);
				}
			}
		}
		jPanel.add(inp);
	}
	
	private Icon selectIcon;
	
	/**
	 * 返回用户选择的图标
	 * @return Icon - 如果没有选择返回null
	 */
	public Icon getSelectIcon() {
		return selectIcon;
	}
	
	private ActionListener BL = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			selectIcon = ((JButton)e.getSource()).getIcon();
			setVisible(false);
		}
	};
}  //  @jve:decl-index=0:visual-constraint="10,10"


