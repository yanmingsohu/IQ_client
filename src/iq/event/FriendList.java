// CatfoOD 2008-6-10 ����08:48:43

package iq.event;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import iq.assist.StringTool;
import iq.assist.Tools;
import iq.gui.JLabelPanel;
import iq.gui.JUserDisplay;
import iq.net.MsgFactory;

/**
 * ά�������б�ȫ��Ψһ
 */
public class FriendList implements InetListener{
	private static FriendList list;
	private static UserEntity user;
	private static IMessage listChangeListener;
	
	public static void init(UserEntity user) {
		if (user==null) {
			throw new IllegalArgumentException("user����Ϊnull.");
		}
		if (list!=null) {
			MsgFactory.getRecverManager().releaseListen(list);
		}
		list = new FriendList(user);
		FriendList.user = user;
	}
	
	public static FriendList getInstance() {
		return list;
	}
	
	public static FriendList getList() {
		if (list==null) {
			throw new IllegalStateException("�����б�δ����ʼ��.");
		}
		return list;
	}
	
	public static UserEntity getMainUser() {
		return user;
	}
	
	public static void registerListChangeListener(IMessage i) {
		listChangeListener = i;
	}
	
	/**
	 * ����������������б���Ϣ
	 */
	public static void requestList() {
		MsgFactory.send("$LIST");
	}
	// --------------- instance ------------------
	private ArrayList<JUserDisplay> userDisps;
	
	private FriendList(UserEntity user) {
		userDisps = new ArrayList<JUserDisplay>();
		MsgFactory.getRecverManager().regListen(this);
		requestList();
	}

	public String getCodex() {
		return "$LIST";
	}
	
	/**
	 * ���б��е����к������õ������
	 * @param fpane
	 */
	public void setListFriendPane(JLabelPanel fpane) {
		fpane.removeAll();
		fpane.addAComponent(new JUserDisplay(user));
		for (int j=0; j<userDisps.size(); ++j) {
			fpane.addAComponent(userDisps.get(j));
		}
		if (fpane.getParent()!=null) {
			fpane.getParent().validate();
		}
	}
	
	
	/**
	 * ����������Ϸ��û�ͼ��
	 * @param p - ������еĵ�ǰ�û�ͼ�����
	 */
	public void setMainuserPanel(JPanel p) {
		p.add(new JUserDisplay(user));
	}

	public void information(Object o) {
		String msg = (String)o;
		msg = StringTool.getSign(msg, "$UL");
		String[] list_s = msg.split(":");
		for (int i=0; i<list_s.length; ++i) {
			if (list_s[i].trim().length()>0) {
				UserEntity u = new UserEntity(list_s[i]);
				if (!userDisps.contains(u)) {
					userDisps.add(new JUserDisplay(u));
				}
			}
		}
		if (listChangeListener!=null) {
			listChangeListener.msg("friend list changed: "+o);
		}
	}
}


