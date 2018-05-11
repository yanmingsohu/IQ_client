// CatfoOD 2008-6-10 上午08:48:43

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
 * 维护好友列表，全局唯一
 */
public class FriendList implements InetListener{
	private static FriendList list;
	private static UserEntity user;
	private static IMessage listChangeListener;
	
	public static void init(UserEntity user) {
		if (user==null) {
			throw new IllegalArgumentException("user不能为null.");
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
			throw new IllegalStateException("好友列表未被初始化.");
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
	 * 向服务器发送请求列表消息
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
	 * 把列表中的所有好友设置到面板中
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
	 * 设置主面板上方用户图标
	 * @param p - 主面板中的当前用户图标面板
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


