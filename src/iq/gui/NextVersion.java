// CatfoOD 2008-6-11 下午04:19:17

package iq.gui;

import iq.assist.ImagesFactory;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JProgressBar;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class NextVersion extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JPanel jPanel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JPanel jPanel1 = null;

	/**
	 * This is the default constructor
	 */
	public NextVersion() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints1.gridy = 2;
		jLabel = new JLabel();
		jLabel.setText("此功能将在下一版本实现");
		jLabel.setName("jLabel");
		this.setSize(186, 200);
		this.setLayout(new GridBagLayout());
		this.add(getJPanel(), gridBagConstraints1);
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(2);
			jLabel2 = new JLabel();
			jLabel2.setText("");
			jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel2.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabel2.setIcon(ImagesFactory.creatIcon("images/iqlogo.png"));
			jLabel1 = new JLabel();
			jLabel1.setText("敬请期待...");
			jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel1.setHorizontalTextPosition(SwingConstants.LEADING);
			jLabel1.setName("jLabel1");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = -1;
			gridBagConstraints.gridy = -1;
			jPanel = new JPanel();
			jPanel.setLayout(gridLayout);
			jPanel.add(jLabel2, null);
			jPanel.add(getJPanel1(), null);
		}
		return jPanel;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(2);
			jPanel1 = new JPanel();
			jPanel1.setLayout(gridLayout1);
			jPanel1.add(jLabel, null);
			jPanel1.add(jLabel1, null);
		}
		return jPanel1;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
