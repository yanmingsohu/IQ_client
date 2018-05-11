// CatfoOD 2008-6-10 上午07:17:32

package iq.gui.logon;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Color;
import java.sql.Date;
import java.util.Calendar;

import javax.swing.JProgressBar;

public class JNILwaitPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JProgressBar jProgressBar = null;
	private JLabel jLabel3 = null;

	/**
	 * This is the default constructor
	 */
	public JNILwaitPane() {
		super();
		initialize();
		setDay();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(49, 174, 111, 29));
		jLabel3.setText("正在登陆请稍后...");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(119, 83, 69, 40));
		jLabel2.setFont(new Font("Dialog", Font.BOLD, 14));
		jLabel2.setText("天");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(65, 71, 50, 52));
		jLabel1.setFont(new Font("Dialog", Font.BOLD, 36));
		jLabel1.setForeground(Color.red);
		jLabel1.setText("55");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(21, 36, 170, 36));
		jLabel.setFont(new Font("\u9ed1\u4f53", Font.BOLD, 18));
		jLabel.setText("距离北京奥运还有");
		this.setSize(211, 233);
		this.setMaximumSize(getSize());
		this.setMinimumSize(getSize());
		this.setLayout(null);
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(jLabel2, null);
		this.add(getJProgressBar(), null);
		this.add(jLabel3, null);
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
			jProgressBar.setBounds(new Rectangle(24, 145, 146, 19));
		}
		return jProgressBar;
	}

	/**
	 * 设置奥运时间
	 * @param day
	 */
	public void setDay() {
		Calendar now = Calendar.getInstance();
		Calendar aoyun = Calendar.getInstance();
		aoyun.set(2008, 8-1, 8, 1, 1, 1);// 59 90
		int day = aoyun.get(Calendar.DAY_OF_YEAR)-
					now.get(Calendar.DAY_OF_YEAR);
		
		if (day<=0) {
			jLabel.setText(" 北京奥运开始第");
			day = Math.abs(day);
		}
		jLabel1.setText(day+"");
	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
