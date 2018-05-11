// CatfoOD 2008-6-12 обнГ10:33:16

package iq.gui.other;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.text.JTextComponent;

import iq.event.FriendList;
import iq.event.UserEntity;

public class PDataControl {
	private PData f;
	private UserEntity u;
	protected PDataControl(PData pd) {
		f = pd;
	}
	
	protected void setUserEntity(UserEntity u) {
		this.u = u;
		if (u!=FriendList.getMainUser()) {
			Component[] cs = f.getJContentPane().getComponents();
			for (int i=0; i<cs.length; ++i) {
				if (cs[i] instanceof JTextComponent) {
					((JTextComponent)(cs[i])).setEditable(false);
				}
				else if (cs[i] instanceof JComboBox) {
					((JComboBox)cs[i]).setEnabled(false);
				}
			}
			f.getByes().setVisible(true);
			f.getUpdataButton().setVisible(false);
			f.setLCimageTVisiable(false);
		} else {
			f.getByes().setVisible(false);
			f.getUpdataButton().setVisible(true);
		}
	}
	
	protected UserEntity getUserEntity() {
		return u;
	}
}
