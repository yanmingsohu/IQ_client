// CatfoOD 2008-6-12 ионГ08:24:45

package iq.gui.main;

import javax.swing.JLabel;

import iq.assist.Tools;
import iq.event.FriendList;
import iq.event.IMessage;
import iq.gui.JLabelPanel;


public class JFriendPanel extends JLabelPanel implements IMessage{
	private static final long serialVersionUID = 180735081978007093L;

	public JFriendPanel() {
		FriendList.registerListChangeListener(this);
		msg("first init.");
	}

	public void msg(Object o) {
		FriendList.getInstance().setListFriendPane(this);
		this.validate();
	}
}
