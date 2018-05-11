// CatfoOD 2008-6-10 上午09:26:52

package iq.gui;

import iq.assist.SoundEffect;
import iq.assist.StringTool;
import iq.assist.Tools;
import iq.event.FriendList;
import iq.event.IMessage;
import iq.event.IMessageAdmit;
import iq.event.ISystemIconMessage;
import iq.event.InetListener;
import iq.event.UserEntity;
import iq.gui.other.UserInfoPopPanel;
import iq.gui.talk.Talk;
import iq.gui.talk.TalkFactory;
import iq.net.MsgFactory;

import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.util.ArrayDeque;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

public class JUserDisplay extends JUserEntityTemplet 
implements ISystemIconMessage, IMessage {
	private static final long serialVersionUID = -6055187504024552353L;
	
	private ImageIcon img = null;
	private UserEntity user;
	private UserInfoPopPanel popinfo;
	private MsgRecvThread msgThread = null;
	
	private IMessageAdmit msgRecver = new DefaultMessage();
	
	public JUserDisplay(UserEntity user) {
		user.getInfo().registerNameChangeListener(this);
		this.user = user;
		this.msg("init.");
		
		if (user==FriendList.getMainUser()) {
			this.setBorder(new EmptyBorder(1, 3, 1, 1));
		} else {
			msgThread = new MsgRecvThread();
		}
	}
	
	/**
	 * 开启聊天对话框
	 */
	public void openMsgDialog() {
		flicker(false);
		Talk t = TalkFactory.creatTalk(this, user, msgRecver);
		if (t!=null) {
			msgRecver = t;
		}
	}
	
	/**
	 * 移除聊天对话框，并返回原先的消息缓存
	 * @param i - 原先的消息缓存
	 */
	public void removeDialog(IMessageAdmit i) {
		msgRecver = i;
		if (i==null) throw new IllegalArgumentException("i cannot null!");
	}

	// 当用户双击系统图标，这个方法被执行
	public void callbackOpenEvent() {
		openMsgDialog();
	}

	public Image getUserIcon() {
		return img.getImage();
	}

	public String getUserName() {
		return user.getName();
	}
	
	public void mouseTwoClick() {
		mouseExited();
		// 如果是本机用户就不接受双击事件
		if (user==FriendList.getMainUser()) return;
		openMsgDialog();
		SystemIcon.getInstance().removeMessage(this);
	}
	
	protected void mouseExited() {
		if (popinfo!=null) {
			popinfo.close();
		}
	}
	
	public void mouseStasis(int x, int y) {
		showInfoPane(x, y);
		this.setText(user.getName()+" ("+user.getID()+")");
		this.setIcon(user.getInfo().getIcon());
	}
	
	private void showInfoPane(int x, int y) {
		if (popinfo==null) {
			popinfo = new UserInfoPopPanel(user);
		}
		Container c = getParentRoot(this);
		if (c!=null) {
			popinfo.show(c.getX(), c.getX()+c.getWidth(), y, c.getY());
		} else {
			popinfo.show(x, x, y, y);
		}
	}
	
	private Container getParentRoot(Component c) {
		Container con = c.getParent();
		Container before = con;
		while (con!=null) {
			before = con;
			con = con.getParent();
		}
		return before;
	}
	
	public void setIcon(ImageIcon icon) {
		super.setIcon(icon);
		img = icon;
	}
	
	public void setIcon(Icon icon) {
		super.setIcon(icon);
		if (icon instanceof ImageIcon) {
			setIcon((ImageIcon)icon);
		}
	}
	
	public void flicker(boolean f) {
		super.flicker(f);
		if (f) {
			SystemIcon.getInstance().addMessage(this);
			SoundEffect.playSE("消息");
		}
	}
	
	/** 
	 * 重写，只比较字符串的id是否相等
	 * 对好友列表判断指定用户是否在列表中起决定作用 
	 */
	public boolean equals(Object o) {
		return user.getID().equals(o.toString());
	}
	
	/** 
	 * 重写返回用户ID,格式重要 
	 * 对好友列表判断指定用户是否在列表中起决定作用
	 */
	public String toString() {
		return user.getID();
	}

	// 接口方法实现
	public void msg(Object o) {
		setText(user.getName()+" ("+user.getID()+")");
		setIcon(user.getInfo().getIcon());
		if (this.getParent()!=null) {
			this.getParent().validate();
		}
	}
	
	// 接收消息
	private class MsgRecvThread implements InetListener {
		public MsgRecvThread() {
			MsgFactory.getRecverManager().regListen(this);
		}
		
		public String getCodex() {
			return "$MSG.$S"+user.getID();
		}

		public void information(Object o) {
			if (msgRecver!=null) {
				msgRecver.msg(o);
			} else {
				throw new RuntimeException("接收监听器此时不能为null");
			}
		}
	}
	
	// 默认的消息监听器
	private class DefaultMessage implements IMessageAdmit {
		private ArrayDeque<String> msgQue = new ArrayDeque<String>();
		
		public void msg(Object o) {
			String msg = StringTool.getSign((String)o, "$UM");
			if (msg!=null && msg.trim().length()>0) {
				msgQue.add((String)o);
				flicker(true);
			}
		}
		
		public Object admit() {
			return msgQue.poll();
		}
	}
	
	/** 删除用户时必须调用的方法 */
	public void removeUser() {
		MsgFactory.getRecverManager().releaseListen(msgThread);
	}
}