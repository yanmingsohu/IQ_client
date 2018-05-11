// CatfoOD 2008-6-13 下午01:43:04

package iq.gui.talk;

import iq.event.UserEntity;
import iq.event.UserInfo;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

public class TalkInfoPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JEditorPane jEditorPane = null;
	private JScrollPane jScrollPane = null;

	/**
	 * This is the default constructor
	 */
	public TalkInfoPane(UserEntity user) {
		super();
		initialize();
		setText(user);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setLayout(new BorderLayout());
		this.add(getJScrollPane(), BorderLayout.CENTER);
	}

	/**
	 * This method initializes jEditorPane	
	 * 	
	 * @return javax.swing.JEditorPane	
	 */
	private JEditorPane getJEditorPane() {
		if (jEditorPane == null) {
			jEditorPane = new JEditorPane("text/html", "");
		}
		return jEditorPane;
	}
	
	private void setText(UserEntity u) {
		UserInfo i = u.getInfo();
		String s = 
			"<font color='#66CCFF' size='3'>iQ:"+u.getID()+"</font>"+
			"<p>"+
			"<font color='#66CCFF' size='3'>性别:"+i.get("sex")+"</font>"+
			"<p>"+
			"<font color='#66CCFF' size='3'>昵称:"+i.getName()+"</font>"+
			"<p>"+
			"<font color='#66CCFF' size='3'>年龄:"+i.get("age")+"</font>"+
			"<p>"+
			"<font color='#66CCFF' size='3'>个性签名:<br>"+i.get("signing")+"</font>";
		jEditorPane.setText(s);
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
			jScrollPane.setViewportView(getJEditorPane());
		}
		return jScrollPane;
	}
}

