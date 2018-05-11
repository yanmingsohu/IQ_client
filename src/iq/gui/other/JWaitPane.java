// CatfoOD 2008-6-9 ÏÂÎç03:20:09

package iq.gui.other;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import java.awt.Insets;
import java.awt.BorderLayout;

public class JWaitPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel jPanel = null;
	private JPanel jPanel1 = null;
	private JPanel jPanel2 = null;
	private JLabel jLabel = null;
	private JProgressBar jProgressBar = null;
	private JPanel jPanel3 = null;
	private JPanel jPanel4 = null;
	private JPanel jPanel5 = null;
	private JLabel jLabel1 = null;

	/**
	 * This is the default constructor
	 */
	public JWaitPane() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(getJPanel(), null);
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(new BoxLayout(getJPanel(), BoxLayout.Y_AXIS));
			jPanel.add(getJPanel1(), null);
			jPanel.add(getJPanel2(), null);
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
			jLabel = new JLabel();
			jLabel.setText("ÇëÉÔµÈÆ¬¿Ì...");
			jPanel1 = new JPanel();
			jPanel1.setLayout(new BorderLayout());
			jPanel1.add(getJPanel4(), BorderLayout.SOUTH);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setLayout(new BorderLayout());
			jPanel2.add(getJPanel5(), BorderLayout.NORTH);
		}
		return jPanel2;
	}

	/**
	 * This method initializes jProgressBar	
	 * 	
	 * @return javax.swing.JProgressBar	
	 */
	private JProgressBar getJProgressBar() {
		if (jProgressBar == null) {
			jProgressBar = new JProgressBar();
			jProgressBar.setIndeterminate(true);
			//jProgressBar.setBorder(new EmptyBorder(0,0,0,0));
		}
		return jProgressBar;
	}

	/**
	 * This method initializes jPanel3	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel3() {
		if (jPanel3 == null) {
			jPanel3 = new JPanel();
			jPanel3.setLayout(new GridBagLayout());
		}
		return jPanel3;
	}

	/**
	 * This method initializes jPanel4	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			jPanel4 = new JPanel();
			jPanel4.setLayout(new FlowLayout());
			jPanel4.add(jLabel, null);
		}
		return jPanel4;
	}

	/**
	 * This method initializes jPanel5	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 1;
			jLabel1 = new JLabel();
			jLabel1.setText(" ");
			jPanel5 = new JPanel();
			jPanel5.setLayout(new GridBagLayout());
			jPanel5.add(getJProgressBar(), new GridBagConstraints());
			jPanel5.add(jLabel1, gridBagConstraints);
		}
		return jPanel5;
	}

}
